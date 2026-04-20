package com.project.dapr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.ResultBean;
import com.project.dapr.entity.Tep0002;
import com.project.dapr.query.DaprAddQuery;
import com.project.dapr.query.DaprAddDetailQuery;
import com.project.dapr.query.DaprDeleteQuery;
import com.project.dapr.query.DaprDeleteDetailQuery;
import com.project.dapr.query.DaprDetailQuery;
import com.project.dapr.query.DaprUpdateQuery;
import com.project.dapr.query.DaprUpdateDetailQuery;
import com.project.dapr.query.DaprValueSetQuery;
import com.project.dapr.repository.Tep0002Repository;
import com.project.dapr.service.DaprService;
import com.project.dapr.vo.DaprInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import jakarta.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * DaprServiceImpl
 *
 * @author YYDGQJ
 * 创建日期  2026/4/18
 * 描述
 */
@Service
public class DaprServiceImpl extends ServiceImpl<Tep0002Repository, Tep0002> implements DaprService {

    @Resource
    private Tep0002Repository tep0002Repository;

    @Override
    public ResultBean<?> add(DaprAddQuery query) {
        ResultBean<?> resultBean = new ResultBean<>();
        if (query == null || !StringUtils.hasText(query.getCodeClass()) || !StringUtils.hasText(query.getCodeValue())) {
            return resultBean.error500("codeClass和codeValue不能为空");
        }

        Tep0002 tep0002 = new Tep0002();
        fillCommonFields(query, tep0002);
        tep0002Repository.insert(tep0002);
        return ResultBean.ok(0, tep0002.getId(), "新增成功");
    }

    @Override
    public ResultBean<?> update(DaprUpdateQuery query) {
        ResultBean<?> resultBean = new ResultBean<>();
        if (query == null || query.getId() == null) {
            return resultBean.error500("id不能为空");
        }

        Tep0002 old = tep0002Repository.selectById(query.getId());
        if (old == null) {
            return resultBean.error500("数据不存在");
        }

        if (StringUtils.hasText(query.getCodeClass())) {
            old.setCodeClass(query.getCodeClass().trim());
        }
        if (StringUtils.hasText(query.getCodeValue())) {
            old.setCodeValue(query.getCodeValue().trim());
        }
        if (StringUtils.hasText(query.getCodeDesc1())) {
            old.setCodeDesc1(query.getCodeDesc1().trim());
        }
        if (StringUtils.hasText(query.getCodeDesc2())) {
            old.setCodeDesc2(query.getCodeDesc2().trim());
        }
        if (StringUtils.hasText(query.getCodeDesc3())) {
            old.setCodeDesc3(query.getCodeDesc3().trim());
        }
        if (StringUtils.hasText(query.getCodeDesc4())) {
            old.setCodeDesc4(query.getCodeDesc4().trim());
        }
        if (StringUtils.hasText(query.getCodeDesc5())) {
            old.setCodeDesc5(query.getCodeDesc5().trim());
        }
        if (StringUtils.hasText(query.getCodeAuth())) {
            old.setCodeAuth(query.getCodeAuth().trim());
        }
        if (query.getParentCode() != null) {
            old.setParentCode(StringUtils.hasText(query.getParentCode()) ? query.getParentCode().trim() : null);
        }

        tep0002Repository.updateById(old);
        return resultBean.success("修改成功");
    }

    @Override
    public ResultBean<?> delete(DaprDeleteQuery query) {
        ResultBean<?> resultBean = new ResultBean<>();
        if (query == null || query.getId() == null) {
            return resultBean.error500("id不能为空");
        }

        int deleted = tep0002Repository.deleteById(query.getId());
        if (deleted == 0) {
            return resultBean.error500("数据不存在");
        }
        return resultBean.success("删除成功");
    }

    @Override
    public ResultBean<?> addDetail(DaprAddDetailQuery query) {
        ResultBean<?> resultBean = new ResultBean<>();
        if (query == null || !StringUtils.hasText(query.getParentCode()) || !StringUtils.hasText(query.getCodeValue())) {
            return resultBean.error500("parentCode和codeValue不能为空");
        }

        Tep0002 exists = findDetail(query.getParentCode(), query.getCodeValue());
        if (exists != null) {
            return resultBean.error500("详细编码已存在");
        }

        Tep0002 detail = new Tep0002();
        detail.setCodeClass(query.getParentCode().trim());
        detail.setParentCode(query.getParentCode().trim());
        detail.setCodeValue(query.getCodeValue().trim());
        detail.setCodeDesc1(trimToNull(query.getCodeDesc1()));
        detail.setCodeDesc2(trimToNull(query.getCodeDesc2()));
        detail.setCodeDesc3(trimToNull(query.getCodeDesc3()));
        detail.setCodeDesc4(trimToNull(query.getCodeDesc4()));
        detail.setCodeDesc5(trimToNull(query.getCodeDesc5()));
        detail.setCodeAuth(trimToNull(query.getCodeAuth()));
        tep0002Repository.insert(detail);
        return ResultBean.ok(0, detail.getId(), "新增成功");
    }

    @Override
    public ResultBean<?> updateDetail(DaprUpdateDetailQuery query) {
        ResultBean<?> resultBean = new ResultBean<>();
        if (query == null || !StringUtils.hasText(query.getParentCode()) || !StringUtils.hasText(query.getCodeValue())) {
            return resultBean.error500("parentCode和codeValue不能为空");
        }

        Tep0002 detail = findDetail(query.getParentCode(), query.getCodeValue());
        if (detail == null) {
            return resultBean.error500("详细编码不存在");
        }

        if (StringUtils.hasText(query.getCodeDesc1())) {
            detail.setCodeDesc1(query.getCodeDesc1().trim());
        }
        if (StringUtils.hasText(query.getCodeDesc2())) {
            detail.setCodeDesc2(query.getCodeDesc2().trim());
        }
        if (StringUtils.hasText(query.getCodeDesc3())) {
            detail.setCodeDesc3(query.getCodeDesc3().trim());
        }
        if (StringUtils.hasText(query.getCodeDesc4())) {
            detail.setCodeDesc4(query.getCodeDesc4().trim());
        }
        if (StringUtils.hasText(query.getCodeDesc5())) {
            detail.setCodeDesc5(query.getCodeDesc5().trim());
        }
        if (StringUtils.hasText(query.getCodeAuth())) {
            detail.setCodeAuth(query.getCodeAuth().trim());
        }
        tep0002Repository.updateById(detail);
        return resultBean.success("修改成功");
    }

    @Override
    public ResultBean<?> deleteDetail(DaprDeleteDetailQuery query) {
        ResultBean<?> resultBean = new ResultBean<>();
        if (query == null || !StringUtils.hasText(query.getParentCode()) || !StringUtils.hasText(query.getCodeValue())) {
            return resultBean.error500("parentCode和codeValue不能为空");
        }

        Tep0002 detail = findDetail(query.getParentCode(), query.getCodeValue());
        if (detail == null) {
            return resultBean.error500("详细编码不存在");
        }
        tep0002Repository.deleteById(detail.getId());
        return resultBean.success("删除成功");
    }

    @Override
    public ResultBean<?> queryValueSet(DaprValueSetQuery query) {
        LambdaQueryWrapper<Tep0002> lqw = new LambdaQueryWrapper<>();
        lqw.and(w -> w.isNull(Tep0002::getParentCode).or().eq(Tep0002::getParentCode, ""));

        if (query != null && StringUtils.hasText(query.getCodeClass())) {
            lqw.like(Tep0002::getCodeClass, query.getCodeClass().trim());
        }
        if (query != null && StringUtils.hasText(query.getCodeValue())) {
            lqw.like(Tep0002::getCodeValue, query.getCodeValue().trim());
        }
        if (query != null && StringUtils.hasText(query.getCodeDesc1())) {
            lqw.like(Tep0002::getCodeDesc1, query.getCodeDesc1().trim());
        }

        List<Tep0002> list = tep0002Repository.selectList(lqw);
        return ResultBean.ok(0, toVOList(list), "查询成功");
    }

    @Override
    public ResultBean<?> queryDetail(DaprDetailQuery query) {
        ResultBean<?> resultBean = new ResultBean<>();
        if (query == null || !StringUtils.hasText(query.getCodeClass())) {
            return resultBean.error500("codeClass不能为空");
        }

        LambdaQueryWrapper<Tep0002> lqw = new LambdaQueryWrapper<>();
        lqw.and(w -> w.isNotNull(Tep0002::getParentCode).ne(Tep0002::getParentCode, ""));
        lqw.eq(Tep0002::getParentCode, query.getCodeClass().trim());

        if (StringUtils.hasText(query.getCodeValue())) {
            lqw.like(Tep0002::getCodeValue, query.getCodeValue().trim());
        }
        if (StringUtils.hasText(query.getCodeDesc1())) {
            lqw.like(Tep0002::getCodeDesc1, query.getCodeDesc1().trim());
        }

        List<Tep0002> list = tep0002Repository.selectList(lqw);
        return ResultBean.ok(0, toVOList(list), "查询成功");
    }

    private void fillCommonFields(DaprAddQuery query, Tep0002 tep0002) {
        tep0002.setCodeClass(query.getCodeClass().trim());
        tep0002.setCodeValue(query.getCodeValue().trim());
        tep0002.setCodeDesc1(trimToNull(query.getCodeDesc1()));
        tep0002.setCodeDesc2(trimToNull(query.getCodeDesc2()));
        tep0002.setCodeDesc3(trimToNull(query.getCodeDesc3()));
        tep0002.setCodeDesc4(trimToNull(query.getCodeDesc4()));
        tep0002.setCodeDesc5(trimToNull(query.getCodeDesc5()));
        tep0002.setCodeAuth(trimToNull(query.getCodeAuth()));
        tep0002.setParentCode(trimToNull(query.getParentCode()));
    }

    private String trimToNull(String value) {
        return StringUtils.hasText(value) ? value.trim() : null;
    }

    private Tep0002 findDetail(String parentCode, String codeValue) {
        return tep0002Repository.selectOne(
                new LambdaQueryWrapper<Tep0002>()
                        .eq(Tep0002::getParentCode, parentCode.trim())
                        .eq(Tep0002::getCodeValue, codeValue.trim())
                        .isNotNull(Tep0002::getParentCode)
                        .ne(Tep0002::getParentCode, "")
        );
    }

    private List<DaprInfoVO> toVOList(List<Tep0002> list) {
        List<DaprInfoVO> voList = new ArrayList<>();
        for (Tep0002 item : list) {
            DaprInfoVO vo = new DaprInfoVO();
            BeanUtils.copyProperties(item, vo);
            voList.add(vo);
        }
        return voList;
    }
}

