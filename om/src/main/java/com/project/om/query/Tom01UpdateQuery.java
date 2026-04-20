package com.project.om.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Tom01UpdateQuery 合同修改请求
 *
 * @author YYDGQJ
 * 创建日期  2026/4/19
 * 描述
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Tom01UpdateQuery extends Tom01AddQuery {

    private Long id;
}

