package com.project.dapr.query;

import lombok.Data;

/**
 * DaprAddQuery
 *
 * @author YYDGQJ
 * 创建日期  2026/4/18
 * 描述
 */
@Data
public class DaprAddQuery {

    private String codeClass;

    private String codeValue;

    private String codeDesc1;

    private String codeDesc2;

    private String codeDesc3;

    private String codeDesc4;

    private String codeDesc5;

    private String codeAuth;

    /**
     * 值集为空，详细编码填写父级值集codeClass
     */
    private String parentCode;
}

