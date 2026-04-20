package com.project.dapr.query;

import lombok.Data;

/**
 * DaprAddDetailQuery
 *
 * @author YYDGQJ
 * 创建日期  2026/4/18
 * 描述
 */
@Data
public class DaprAddDetailQuery {

    /**
     * 父级值集编码（对应值集codeClass）
     */
    private String parentCode;

    private String codeValue;

    private String codeDesc1;

    private String codeDesc2;

    private String codeDesc3;

    private String codeDesc4;

    private String codeDesc5;

    private String codeAuth;
}


