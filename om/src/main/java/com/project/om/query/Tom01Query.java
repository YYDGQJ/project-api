package com.project.om.query;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Tom01Query 合同查询请求
 *
 * @author YYDGQJ
 * 创建日期  2026/4/19
 * 描述
 */
@Data
public class Tom01Query {

    /** 合同号 */
    private String orderNo;

    /** 销售合同号 */
    private String saleOrderNo;

    /** 合约号 */
    private String contractNo;

    /** 订货用户代码 */
    private String orderCustCode;

    /** 订货用户中文名称 */
    private String orderCustCname;

    /** 合同状态 */
    private String orderStatus;

    /** 合同性质代码 */
    private String orderTypeCode;

    /** 产品大类代码 */
    private String prodClassCode;

    /** 品名代码 */
    private String prodCode;

    /** 账套代码 */
    private String companyCode;

    /** 销售组织机构代码 */
    private String saleOrgCode;

    /** 查询开始时间（合同创建时间起） */
    private LocalDateTime startTime;

    /** 查询结束时间（合同创建时间止） */
    private LocalDateTime endTime;
}

