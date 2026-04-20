package com.project.user.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.ResultBean;
import com.project.user.entity.Tuser;
import com.project.user.query.LoginQuery;
import com.project.user.query.UserAddQuery;
import com.project.user.query.UserDeleteQuery;
import com.project.user.query.UserQuery;
import com.project.user.query.UserUpdateQuery;
import com.project.user.service.UserService;
import com.project.user.vo.UserInfoVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * UserController
 *
 * @author YYDGQJ
 * 创建日期  2026/4/14 10:09
 * 描述
 *
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResultBean<?> login(@RequestBody LoginQuery query) {
        try {
            return userService.login(query);
        }catch (Exception e){
            log.error("login failed", e);
            return ResultBean.error("系统异常");
        }
    }

    @PostMapping("/add")
    public ResultBean<?> addUser(@RequestBody UserAddQuery query) {
        try {
            return userService.addUser(query);
        } catch (Exception e) {
            log.error("add user failed", e);
            return ResultBean.error("系统异常");
        }
    }

    @PostMapping("/update")
    public ResultBean<?> updateUser(@RequestBody UserUpdateQuery query) {
        try {
            return userService.updateUser(query);
        } catch (Exception e) {
            log.error("update user failed", e);
            return ResultBean.error("系统异常");
        }
    }

    @PostMapping("/delete")
    public ResultBean<?> deleteUser(@RequestBody UserDeleteQuery query) {
        try {
            return userService.deleteUser(query);
        } catch (Exception e) {
            log.error("delete user failed", e);
            return ResultBean.error("系统异常");
        }
    }

    @PostMapping("/query")
    public IPage<UserInfoVO> query(Page<Tuser> page, @RequestBody(required = false) UserQuery query) {
        try {
            return userService.query(page, query);
        } catch (Exception e) {
            log.error("query user failed", e);
            return null;
        }
    }

}
