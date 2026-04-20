package com.project.om.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.project.ResultBean;
import com.project.om.entity.Tom01;
import com.project.om.query.Tom01AddQuery;
import com.project.om.query.Tom01DeleteQuery;
import com.project.om.query.Tom01Query;
import com.project.om.query.Tom01UpdateQuery;
import com.project.om.vo.Tom01InfoVO;

/**
 * OmService
 *
 * @author YYDGQJ
 * 创建日期  2026/4/19
 * 描述
 */
public interface OmService extends IService<Tom01> {

    ResultBean<?> add(Tom01AddQuery query);

    ResultBean<?> update(Tom01UpdateQuery query);

    ResultBean<?> delete(Tom01DeleteQuery query);

    IPage<Tom01InfoVO> query(Page<Tom01> page, Tom01Query query);
}

