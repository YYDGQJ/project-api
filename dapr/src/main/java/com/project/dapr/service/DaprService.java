package com.project.dapr.service;

import com.baomidou.mybatisplus.extension.service.IService;
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

/**
 * DaprService
 *
 * @author YYDGQJ
 * 创建日期  2026/4/18
 * 描述
 */
public interface DaprService extends IService<Tep0002> {

    ResultBean<?> add(DaprAddQuery query);

    ResultBean<?> update(DaprUpdateQuery query);

    ResultBean<?> delete(DaprDeleteQuery query);

    ResultBean<?> addDetail(DaprAddDetailQuery query);

    ResultBean<?> updateDetail(DaprUpdateDetailQuery query);

    ResultBean<?> deleteDetail(DaprDeleteDetailQuery query);

    ResultBean<?> queryValueSet(DaprValueSetQuery query);

    ResultBean<?> queryDetail(DaprDetailQuery query);
}

