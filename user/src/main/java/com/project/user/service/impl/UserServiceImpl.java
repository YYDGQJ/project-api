package com.project.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.ResultBean;
import com.project.user.entity.Tuser;
import com.project.user.query.LoginQuery;
import com.project.user.query.UserAddQuery;
import com.project.user.query.UserDeleteQuery;
import com.project.user.query.UserUpdateQuery;
import com.project.user.repository.TuserRepositroy;
import com.project.user.service.UserService;
import com.project.utils.BCryptUtil;
import com.project.utils.MD5Util;
import org.jasypt.exceptions.EncryptionOperationNotPossibleException;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import jakarta.annotation.Resource;

/**
 * UserServiceImpl
 *
 * @author YYDGQJ
 * 创建日期  2026/4/14 10:29
 * 描述
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<TuserRepositroy, Tuser> implements UserService {

    private static final int STATUS_ENABLED = 1;
    private static final int STATUS_DISABLED = 0;
    private static final int MAX_LOGIN_RETRY = 5;
    private static final StrongPasswordEncryptor PASSWORD_ENCODER = new StrongPasswordEncryptor();

    @Resource
    private TuserRepositroy tuserRepositroy;

    @Override
    public ResultBean<?> login(LoginQuery query) {
        ResultBean<?> resultBean = new ResultBean<>();
        if (query == null || !StringUtils.hasText(query.getUserId()) || !StringUtils.hasText(query.getPassWord())) {
            return resultBean.error500("用户名或密码不能为空");
        }

        Tuser tuser = tuserRepositroy.selectOne(
                new LambdaQueryWrapper<Tuser>()
                        .eq(Tuser::getUserId, query.getUserId())
        );
        if (tuser == null) {
            resultBean.error500("用户名或密码错误");
            return resultBean;
        }

        if (defaultStatus(tuser.getStatus()) != STATUS_ENABLED) {
            return resultBean.error500("账号已停用");
        }

        if (parseErrorNumber(tuser.getErrorNumber()) >= MAX_LOGIN_RETRY) {
            return resultBean.error500("账号已锁定，请联系管理员");
        }

        if (!checkPasswordWithCompatibility(query.getPassWord(), tuser)) {
            increaseRetryCount(tuser);
            resultBean.error500("用户名或密码错误");
            return resultBean;
        }

        resetRetryCount(tuser);
        resultBean.success("登录成功");
        return resultBean;
    }

    @Override
    public ResultBean<?> addUser(UserAddQuery query) {
        ResultBean<?> resultBean = new ResultBean<>();
        if (query == null || !StringUtils.hasText(query.getUserId()) || !StringUtils.hasText(query.getUserName())
                || !StringUtils.hasText(query.getUserPhone()) || !StringUtils.hasText(query.getPassWord())) {
            return resultBean.error500("必填参数不能为空");
        }

        Tuser exists = tuserRepositroy.selectOne(new LambdaQueryWrapper<Tuser>().eq(Tuser::getUserId, query.getUserId()));
        if (exists != null) {
            return resultBean.error500("账号已存在");
        }

        Tuser tuser = new Tuser();
        tuser.setUserId(query.getUserId().trim());
        tuser.setUserName(query.getUserName().trim());
        tuser.setUserPhone(query.getUserPhone().trim());
        tuser.setUserPassWord(PASSWORD_ENCODER.encryptPassword(query.getPassWord()));
        tuser.setStatus(parseStatus(query.getStatus(), STATUS_ENABLED));
        tuser.setRole(query.getRole());
        tuser.setErrorNumber(0);
        tuserRepositroy.insert(tuser);
        return ResultBean.ok(0, tuser.getId(), "新增成功");
    }

    @Override
    public ResultBean<?> updateUser(UserUpdateQuery query) {
        ResultBean<?> resultBean = new ResultBean<>();
        if (query == null || query.getId() == null) {
            return resultBean.error500("id不能为空");
        }

        Tuser oldUser = tuserRepositroy.selectById(query.getId());
        if (oldUser == null) {
            return resultBean.error500("用户不存在");
        }

        if (StringUtils.hasText(query.getUserId()) && !query.getUserId().trim().equals(oldUser.getUserId())) {
            Tuser exists = tuserRepositroy.selectOne(new LambdaQueryWrapper<Tuser>().eq(Tuser::getUserId, query.getUserId().trim()));
            if (exists != null) {
                return resultBean.error500("账号已存在");
            }
            oldUser.setUserId(query.getUserId().trim());
        }

        if (StringUtils.hasText(query.getUserName())) {
            oldUser.setUserName(query.getUserName().trim());
        }
        if (StringUtils.hasText(query.getUserPhone())) {
            oldUser.setUserPhone(query.getUserPhone().trim());
        }
        if (StringUtils.hasText(query.getStatus())) {
            oldUser.setStatus(parseStatus(query.getStatus(), defaultStatus(oldUser.getStatus())));
        }
        if (query.getRole() != null) {
            oldUser.setRole(query.getRole());
        }
        if (StringUtils.hasText(query.getPassWord())) {
            oldUser.setUserPassWord(PASSWORD_ENCODER.encryptPassword(query.getPassWord()));
            oldUser.setErrorNumber(0);
        }
        tuserRepositroy.updateById(oldUser);
        return resultBean.success("修改成功");
    }

    @Override
    public ResultBean<?> deleteUser(UserDeleteQuery query) {
        ResultBean<?> resultBean = new ResultBean<>();
        if (query == null || query.getId() == null) {
            return resultBean.error500("id不能为空");
        }

        int deleted = tuserRepositroy.deleteById(query.getId());
        if (deleted == 0) {
            return resultBean.error500("用户不存在");
        }
        return resultBean.success("删除成功");
    }

    private boolean checkPasswordWithCompatibility(String inputPassWord, Tuser tuser) {
        String dbPassWord = tuser.getUserPassWord();
        if (!StringUtils.hasText(dbPassWord)) {
            return false;
        }

        try {
            if (PASSWORD_ENCODER.checkPassword(inputPassWord, dbPassWord)) {
                return true;
            }
        } catch (EncryptionOperationNotPossibleException | IllegalArgumentException ignore) {
            // Stored password format is invalid for the current encoder; continue with legacy check.
        }

        try {
            String legacyRaw = BCryptUtil.decrypt(dbPassWord);
            String md5Password = MD5Util.encryptToMD5(inputPassWord);
            if (StringUtils.hasText(legacyRaw) && legacyRaw.equals(md5Password)) {
                tuser.setUserPassWord(PASSWORD_ENCODER.encryptPassword(inputPassWord));
                tuserRepositroy.updateById(tuser);
                return true;
            }
        } catch (Exception ignore) {
            // not a legacy reversible cipher text
        }
        return false;
    }

    private void increaseRetryCount(Tuser tuser) {
        int retry = parseErrorNumber(tuser.getErrorNumber()) + 1;
        tuser.setErrorNumber(retry);
        if (retry >= MAX_LOGIN_RETRY) {
            tuser.setStatus(STATUS_DISABLED);
        }
        tuserRepositroy.updateById(tuser);
    }

    private void resetRetryCount(Tuser tuser) {
        if (parseErrorNumber(tuser.getErrorNumber()) != 0) {
            tuser.setErrorNumber(0);
            tuserRepositroy.updateById(tuser);
        }
    }

    private int parseErrorNumber(Integer errorNumber) {
        if (errorNumber == null) {
            return 0;
        }
        return Math.max(errorNumber, 0);
    }

    private int defaultStatus(Integer status) {
        return status == null ? STATUS_ENABLED : status;
    }

    private int parseStatus(String status, int defaultValue) {
        if (!StringUtils.hasText(status)) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(status.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
