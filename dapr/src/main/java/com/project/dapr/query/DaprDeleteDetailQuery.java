package com.project.dapr.query;

import lombok.Data;

/**
 * DaprDeleteDetailQuery
 *
 * @author YYDGQJ
 * 创建日期  2026/4/18
 * 描述
 */
@Data
public class DaprDeleteDetailQuery {

    /**
     * 父级值集编码（对应值集codeClass）
     */
    private String parentCode;

    private String codeValue;
}

