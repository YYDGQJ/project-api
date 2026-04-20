package com.project.om.query;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Tom01AddQuery 合同新增请求
 *
 * @author YYDGQJ
 * 创建日期  2026/4/19
 * 描述
 */
@Data
public class Tom01AddQuery {

    private String companyCode;
    private String companyName;
    private String orderNo;
    private String orderStatus;
    private String orderTypeCode;
    private String orderTypeDesc;
    private String saleOrderNo;
    private String contractNo;
    private String orderMonth;
    private String orderCustCode;
    private String orderCustCname;
    private String orderCustEname;
    private String custPurOrderNo;
    private String consigneeCode;
    private String consigneeCname;
    private String consigneeEname;
    private String consigneeAddr;
    private String settleUserCode;
    private String settleUserCname;
    private String demandCustCode;
    private String demandCustName;
    private String settleModeCode;
    private String settleModeName;
    private String transModeCode;
    private String transModeName;
    private String delivySiteCode;
    private String delivySiteName;
    private String delivyDate;
    private String hopeDelivyDate;
    private String prodCode;
    private String prodCname;
    private String prodEname;
    private String stdCode;
    private String stdVersion;
    private String sgSign;
    private String sgCode;
    private String signCode;
    private BigDecimal orderThick;
    private BigDecimal orderThickMin;
    private BigDecimal orderThickMax;
    private BigDecimal orderWidth;
    private BigDecimal orderWidthMin;
    private BigDecimal orderWidthMax;
    private BigDecimal orderLen;
    private BigDecimal orderLenMin;
    private BigDecimal orderLenMax;
    private BigDecimal orderQty;
    private BigDecimal orderWt;
    private Integer orderNum;
    private String orderUnitCode;
    private String orderUnitCname;
    private String saleOrgCode;
    private String saleOrgName;
    private String baseDiv;
    private String exportFlag;
    private String trimFlag;
    private String fixFlag;
    private String packTypeCode;
    private String packTypeCname;
    private Integer packBl;
    private BigDecimal packWtMin;
    private BigDecimal packWtMax;
    private String apnCode;
    private String apnDesc;
    private String finUserCode;
    private String finUserName;
    private String specialReqFlag;
    private String manuRemark;
}

