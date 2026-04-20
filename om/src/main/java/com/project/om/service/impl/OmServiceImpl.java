package com.project.om.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.ResultBean;
import com.project.om.entity.Tom01;
import com.project.om.query.Tom01AddQuery;
import com.project.om.query.Tom01DeleteQuery;
import com.project.om.query.Tom01Query;
import com.project.om.query.Tom01UpdateQuery;
import com.project.om.repository.Tom01Repository;
import com.project.om.service.OmService;
import com.project.om.vo.Tom01InfoVO;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * OmServiceImpl
 *
 * @author YYDGQJ
 * 创建日期  2026/4/19
 * 描述
 */
@Service
public class OmServiceImpl extends ServiceImpl<Tom01Repository, Tom01> implements OmService {

    @Resource
    private Tom01Repository tom01Repository;

    @Override
    public ResultBean<?> add(Tom01AddQuery query) {
        ResultBean<?> resultBean = new ResultBean<>();
        if (query == null || !StringUtils.hasText(query.getOrderNo())) {
            return resultBean.error500("合同号不能为空");
        }

        Tom01 exists = tom01Repository.selectOne(
                new LambdaQueryWrapper<Tom01>().eq(Tom01::getOrderNo, query.getOrderNo().trim()));
        if (exists != null) {
            return resultBean.error500("合同号已存在");
        }

        Tom01 tom01 = new Tom01();
        BeanUtils.copyProperties(query, tom01);
        tom01Repository.insert(tom01);
        return ResultBean.ok(0, tom01.getId(), "新增成功");
    }

    @Override
    public ResultBean<?> update(Tom01UpdateQuery query) {
        ResultBean<?> resultBean = new ResultBean<>();
        if (query == null || query.getId() == null) {
            return resultBean.error500("id不能为空");
        }

        Tom01 old = tom01Repository.selectById(query.getId());
        if (old == null) {
            return resultBean.error500("合同不存在");
        }

        if (StringUtils.hasText(query.getOrderNo()) && !query.getOrderNo().trim().equals(old.getOrderNo())) {
            Tom01 exists = tom01Repository.selectOne(
                    new LambdaQueryWrapper<Tom01>().eq(Tom01::getOrderNo, query.getOrderNo().trim()));
            if (exists != null) {
                return resultBean.error500("合同号已存在");
            }
        }

        BeanUtils.copyProperties(query, old, "id");
        tom01Repository.updateById(old);
        return resultBean.success("修改成功");
    }

    @Override
    public ResultBean<?> delete(Tom01DeleteQuery query) {
        ResultBean<?> resultBean = new ResultBean<>();
        if (query == null || query.getId() == null) {
            return resultBean.error500("id不能为空");
        }

        int deleted = tom01Repository.deleteById(query.getId());
        if (deleted == 0) {
            return resultBean.error500("合同不存在");
        }
        return resultBean.success("删除成功");
    }

    @Override
    public IPage<Tom01InfoVO> query(Page<Tom01> page, Tom01Query query) {
        LambdaQueryWrapper<Tom01> lqw = new LambdaQueryWrapper<>();

        if (query != null && StringUtils.hasText(query.getOrderNo())) {
            lqw.like(Tom01::getOrderNo, query.getOrderNo().trim());
        }
        if (query != null && StringUtils.hasText(query.getSaleOrderNo())) {
            lqw.like(Tom01::getSaleOrderNo, query.getSaleOrderNo().trim());
        }
        if (query != null && StringUtils.hasText(query.getContractNo())) {
            lqw.like(Tom01::getContractNo, query.getContractNo().trim());
        }
        if (query != null && StringUtils.hasText(query.getOrderCustCode())) {
            lqw.like(Tom01::getOrderCustCode, query.getOrderCustCode().trim());
        }
        if (query != null && StringUtils.hasText(query.getOrderCustCname())) {
            lqw.like(Tom01::getOrderCustCname, query.getOrderCustCname().trim());
        }
        if (query != null && StringUtils.hasText(query.getOrderStatus())) {
            lqw.eq(Tom01::getOrderStatus, query.getOrderStatus().trim());
        }
        if (query != null && StringUtils.hasText(query.getOrderTypeCode())) {
            lqw.eq(Tom01::getOrderTypeCode, query.getOrderTypeCode().trim());
        }
        if (query != null && StringUtils.hasText(query.getProdClassCode())) {
            lqw.eq(Tom01::getProdClassCode, query.getProdClassCode().trim());
        }
        if (query != null && StringUtils.hasText(query.getProdCode())) {
            lqw.like(Tom01::getProdCode, query.getProdCode().trim());
        }
        if (query != null && StringUtils.hasText(query.getCompanyCode())) {
            lqw.eq(Tom01::getCompanyCode, query.getCompanyCode().trim());
        }
        if (query != null && StringUtils.hasText(query.getSaleOrgCode())) {
            lqw.eq(Tom01::getSaleOrgCode, query.getSaleOrgCode().trim());
        }
        if (query != null && query.getStartTime() != null) {
            lqw.ge(Tom01::getOrderCreateTime, query.getStartTime());
        }
        if (query != null && query.getEndTime() != null) {
            lqw.le(Tom01::getOrderCreateTime, query.getEndTime());
        }

        IPage<Tom01> tom01Page = tom01Repository.selectPage(page, lqw);
        return tom01Page.convert(tom01 -> {
            Tom01InfoVO vo = new Tom01InfoVO();
            BeanUtils.copyProperties(tom01, vo);
            return vo;
        });
    }
}

