package com.project.om.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.project.IdAuditingEntity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Tom01
 *
 * @author YYDGQJ
 * 创建日期  2026/4/19
 * 描述  合同表
 */
@Data
@TableName(value = "pm.tom01")
public class Tom01 extends IdAuditingEntity {

    @TableField("rec_deletor_id")
    private String recDeletorId;

    @TableField("rec_deletor_name")
    private String recDeletorName;

    @TableField("rec_delete_time")
    private String recDeleteTime;

    @TableField("company_name")
    private String companyName;

    @TableField("order_recv_time")
    private String orderRecvTime;

    @TableField("order_type_code")
    private String orderTypeCode;

    @TableField("export_flag")
    private String exportFlag;

    @TableField("delivy_date_accu")
    private String delivyDateAccu;

    @TableField("apn_desc")
    private String apnDesc;

    @TableField("fin_user_code")
    private String finUserCode;

    @TableField("fin_user_name")
    private String finUserName;

    @TableField("msc")
    private String msc;

    @TableField("sg_sign")
    private String sgSign;

    @TableField("prod_code")
    private String prodCode;

    @TableField("prod_cname")
    private String prodCname;

    @TableField("prod_alias_cname")
    private String prodAliasCname;

    @TableField("std_sg_code")
    private String stdSgCode;

    @TableField("surface_accu_class_code")
    private String surfaceAccuClassCode;

    @TableField("surface_accu")
    private String surfaceAccu;

    @TableField("surface_accu_code")
    private String surfaceAccuCode;

    @TableField("cust_std_code")
    private String custStdCode;

    @TableField("prod_dif_desc")
    private String prodDifDesc;

    @TableField("delivy_wt_flag")
    private String delivyWtFlag;

    @TableField("pack_wt_min")
    private BigDecimal packWtMin;

    @TableField("pack_wt_max")
    private BigDecimal packWtMax;

    @TableField("pack_bl")
    private BigDecimal packBl;

    @TableField("spray_print_req")
    private BigDecimal sprayPrintReq;

    @TableField("trim_flag")
    private String trimFlag;

    @TableField("order_thick_tol_max")
    private BigDecimal orderThickTolMax;

    @TableField("order_width_tol_max")
    private BigDecimal orderWidthTolMax;

    @TableField("order_width_max")
    private BigDecimal orderWidthMax;

    @TableField("order_len")
    private BigDecimal orderLen;

    @TableField("order_len_max")
    private BigDecimal orderLenMax;

    @TableField("nom_tim_len")
    private BigDecimal nomTimLen;

    @TableField("order_short_rate")
    private BigDecimal orderShortRate;

    @TableField("order_inner_dia")
    private BigDecimal orderInnerDia;

    @TableField("order_wal_thick")
    private BigDecimal orderWalThick;

    @TableField("cross_code")
    private String crossCode;

    @TableField("len_tol_code")
    private String lenTolCode;

    @TableField("order_piece_aim_wt")
    private BigDecimal orderPieceAimWt;

    @TableField("delivy_tol_max")
    private BigDecimal delivyTolMax;

    @TableField("delivy_tol_min")
    private BigDecimal delivyTolMin;

    @TableField("delivy_num_tol_minus")
    private BigDecimal delivyNumTolMinus;

    @TableField("order_qty")
    private BigDecimal orderQty;

    @TableField("contract_confirm_time")
    private String contractConfirmTime;

    @TableField("sale_order_no")
    private String saleOrderNo;

    @TableField("order_cust_code")
    private String orderCustCode;

    @TableField("order_cust_cname")
    private String orderCustCname;

    @TableField("consignee_code")
    private String consigneeCode;

    @TableField("consignee_cname")
    private String consigneeCname;

    @TableField("consignee_addr")
    private String consigneeAddr;

    @TableField("settle_user_cname")
    private String settleUserCname;

    @TableField("trans_mode_code")
    private String transModeCode;

    @TableField("trans_mode_name")
    private String transModeName;

    @TableField("delivy_site_name")
    private String delivySiteName;

    @TableField("freight_inv_title_desc")
    private String freightInvTitleDesc;

    @TableField("private_railway_code")
    private String privateRailwayCode;

    @TableField("private_railway_name")
    private String privateRailwayName;

    @TableField("sale_network_code")
    private String saleNetworkCode;

    @TableField("demand_cust_code")
    private String demandCustCode;

    @TableField("demand_cust_name")
    private String demandCustName;

    @TableField("spec_trans_req_desc")
    private String specTransReqDesc;

    @TableField("order_modi_type")
    private String orderModiType;

    @TableField("order_modi_resp_id")
    private String orderModiRespId;

    @TableField("order_modi_num")
    private BigDecimal orderModiNum;

    @TableField("order_change_time")
    private String orderChangeTime;

    @TableField("order_modi_put_dept_code")
    private String orderModiPutDeptCode;

    @TableField("order_modi_put_dept_desc")
    private String orderModiPutDeptDesc;

    @TableField("mark_pos_desc")
    private String markPosDesc;

    @TableField("order_proc_resp_id")
    private String orderProcRespId;

    @TableField("std_version")
    private String stdVersion;

    @TableField("order_thick_eng")
    private String orderThickEng;

    @TableField("order_width_eng")
    private String orderWidthEng;

    @TableField("order_indm_eng")
    private BigDecimal orderIndmEng;

    @TableField("order_high_eng")
    private BigDecimal orderHighEng;

    @TableField("order_confirm_time")
    private String orderConfirmTime;

    @TableField("order_type_desc")
    private String orderTypeDesc;

    @TableField("shcedule_date_f")
    private String shceduleDateF;

    @TableField("shcedule_date_s")
    private String shceduleDateS;

    @TableField("band_prod_code")
    private String bandProdCode;

    @TableField("gather_flag")
    private String gatherFlag;

    @TableField("trans_mat_flag")
    private String transMatFlag;

    @TableField("cust_order_status")
    private String custOrderStatus;

    @TableField("merg_order_no")
    private String mergOrderNo;

    @TableField("product_class")
    private String productClass;

    @TableField("product_class_desc")
    private String productClassDesc;

    @TableField("sign_code")
    private String signCode;

    @TableField("order_thick_max")
    private BigDecimal orderThickMax;

    @TableField("speed_class_code")
    private String speedClassCode;

    @TableField("speed_class_desc")
    private String speedClassDesc;

    @TableField("slab_pos_req_desc")
    private String slabPosReqDesc;

    @TableField("delivy_week_flag")
    private String delivyWeekFlag;

    @TableField("delivy_priority")
    private String delivyPriority;

    @TableField("order_launch_resp_name")
    private String orderLaunchRespName;

    @TableField("engi_project_name")
    private String engiProjectName;

    @TableField("trapezium_type")
    private String trapeziumType;

    @TableField("len_aim_eng")
    private String lenAimEng;

    @TableField("pack_sheet_num")
    private BigDecimal packSheetNum;

    @TableField("prms_welding_dot")
    private BigDecimal prmsWeldingDot;

    @TableField("accp_mode_code")
    private String accpModeCode;

    @TableField("lace_type")
    private String laceType;

    @TableField("mark_2")
    private String mark2;

    @TableField("eng_label_flag")
    private String engLabelFlag;

    @TableField("color_sign")
    private String colorSign;

    @TableField("label_format_code")
    private String labelFormatCode;

    @TableField("dest_prod")
    private String destProd;

    @TableField("apply_plan_no")
    private String applyPlanNo;

    @TableField("come_proc_agree_no")
    private String comeProcAgreeNo;

    @TableField("spec_thick_1")
    private BigDecimal specThick1;

    @TableField("spec_thick_3")
    private BigDecimal specThick3;

    @TableField("spec_thick_5")
    private BigDecimal specThick5;

    @TableField("special_len_1")
    private BigDecimal specialLen1;

    @TableField("special_len_4")
    private BigDecimal specialLen4;

    @TableField("special_len_5")
    private BigDecimal specialLen5;

    @TableField("special_thick_2_eng")
    private String specialThick2Eng;

    @TableField("special_thick_6_eng")
    private String specialThick6Eng;

    @TableField("special_thick_7_eng")
    private String specialThick7Eng;

    @TableField("special_thick_1_eng")
    private String specialThick1Eng;

    @TableField("special_thick_3_eng")
    private String specialThick3Eng;

    @TableField("special_thick_5_eng")
    private String specialThick5Eng;

    @TableField("special_len_2_eng")
    private String specialLen2Eng;

    @TableField("special_len_5_eng")
    private String specialLen5Eng;

    @TableField("color_1")
    private String color1;

    @TableField("color_2")
    private String color2;

    @TableField("color_4")
    private String color4;

    @TableField("color_5")
    private String color5;

    @TableField("color_width")
    private String colorWidth;

    @TableField("shipping_mark_1")
    private String shippingMark1;

    @TableField("shipping_mark_3")
    private String shippingMark3;

    @TableField("shipping_mark_4")
    private String shippingMark4;

    @TableField("shipping_mark_5")
    private String shippingMark5;

    @TableField("give_sample_len")
    private BigDecimal giveSampleLen;

    @TableField("band_origin_code2")
    private String bandOriginCode2;

    @TableField("band_prod_code2")
    private String bandProdCode2;

    @TableField("thick_accu_grade")
    private String thickAccuGrade;

    @TableField("trapezoid_left_bottom_angle")
    private BigDecimal trapezoidLeftBottomAngle;

    @TableField("box_bat_hpsm")
    private String boxBatHpsm;

    @TableField("give_sample_flag")
    private String giveSampleFlag;

    @TableField("car_machine_desc")
    private String carMachineDesc;

    @TableField("self_product_desc")
    private String selfProductDesc;

    @TableField("key_prod_desc")
    private String keyProdDesc;

    @TableField("ord_card_no")
    private String ordCardNo;

    @TableField("upmarket_leader_flag")
    private String upmarketLeaderFlag;

    @TableField("evi_no")
    private String eviNo;

    @TableField("vehicle_desc")
    private String vehicleDesc;

    @TableField("label_pos_desc")
    private String labelPosDesc;

    @TableField("inquiry_code")
    private String inquiryCode;

    @TableField("cross_desc")
    private String crossDesc;

    @TableField("supervision_unit")
    private String supervisionUnit;

    @TableField("slab_clean_flag")
    private String slabCleanFlag;

    @TableField("density_value")
    private BigDecimal densityValue;

    @TableField("resource_factory_div_code")
    private String resourceFactoryDivCode;

    @TableField("apply_flag")
    private String applyFlag;

    @TableField("tim_width")
    private BigDecimal timWidth;

    @TableField("add_sling_flag")
    private String addSlingFlag;

    @TableField("label_print_linkman")
    private String labelPrintLinkman;

    @TableField("fix_status_desc")
    private String fixStatusDesc;

    @TableField("delivy_trans_mode_code")
    private String delivyTransModeCode;

    @TableField("cover_flag")
    private String coverFlag;

    @TableField("shipping_mark_6")
    private String shippingMark6;

    @TableField("band_origin_code7")
    private String bandOriginCode7;

    @TableField("metric_or_eng_flag")
    private String metricOrEngFlag;

    @TableField("output_area")
    private String outputArea;

    @TableField("band_origin_code")
    private String bandOriginCode;

    @TableField("order_unit_cname")
    private String orderUnitCname;

    @TableField("wt_mode_name")
    private String wtModeName;

    @TableField("settle_mode_code")
    private String settleModeCode;

    @TableField("deliy_date")
    private String deliyDate;

    @TableField("fix_flag")
    private String fixFlag;

    @TableField("sur_quality_code")
    private String surQualityCode;

    @TableField("order_thick_min")
    private BigDecimal orderThickMin;

    @TableField("last_charge_ship_date")
    private String lastChargeShipDate;

    @TableField("width_divi")
    private String widthDivi;

    @TableField("certi_print_copies")
    private BigDecimal certiPrintCopies;

    @TableField("spec_thick_4")
    private BigDecimal specThick4;

    @TableField("order_plan_send_time")
    private String orderPlanSendTime;

    @TableField("order_delivy_flag")
    private String orderDelivyFlag;

    @TableField("hole_wt")
    private BigDecimal holeWt;

    @TableField("sale_org_name")
    private String saleOrgName;

    @TableField("delivy_wt_tol_plus")
    private BigDecimal delivyWtTolPlus;

    @TableField("send_num")
    private BigDecimal sendNum;

    @TableField("lp_type")
    private String lpType;

    @TableField("trapezium_toplength_eng")
    private String trapeziumToplengthEng;

    @TableField("trapezium_bottomlength_eng")
    private String trapeziumBottomlengthEng;

    @TableField("order_confirm_resp_id")
    private String orderConfirmRespId;

    @TableField("ingot_code")
    private String ingotCode;

    @TableField("settle_user_ename_all")
    private String settleUserEnameAll;

    @TableField("prod_alias_ename")
    private String prodAliasEname;

    @TableField("prod_dif")
    private String prodDif;

    @TableField("pack_bl_min")
    private BigDecimal packBlMin;

    @TableField("len_tol_plus")
    private BigDecimal lenTolPlus;

    @TableField("multiple_num")
    private BigDecimal multipleNum;

    @TableField("cust_pur_order_no")
    private String custPurOrderNo;

    @TableField("band_prod_code5")
    private String bandProdCode5;

    @TableField("archive_flag")
    private String archiveFlag;

    @TableField("slab_lowest_quality_grade")
    private String slabLowestQualityGrade;

    @TableField("car_machine_flag")
    private String carMachineFlag;

    @TableField("vehicle_mode_no")
    private String vehicleModeNo;

    @TableField("label_pos")
    private String labelPos;

    @TableField("order_unit_min_wt")
    private BigDecimal orderUnitMinWt;

    @TableField("ship_delivy_date")
    private String shipDelivyDate;

    @TableField("pack_type_code")
    private String packTypeCode;

    @TableField("special_len_4_eng")
    private String specialLen4Eng;

    @TableField("order_create_time")
    private String orderCreateTime;

    @TableField("length_divi")
    private String lengthDivi;

    @TableField("order_month")
    private String orderMonth;

    @TableField("width_tol_code")
    private String widthTolCode;

    @TableField("thick_method_desc")
    private String thickMethodDesc;

    @TableField("delivy_wt_tol_minus")
    private BigDecimal delivyWtTolMinus;

    @TableField("exp_lot_no")
    private String expLotNo;

    @TableField("order_cust_ename")
    private String orderCustEname;

    @TableField("new_test_no")
    private String newTestNo;

    @TableField("order_hold_flag")
    private String orderHoldFlag;

    @TableField("hold_resp_id")
    private String holdRespId;

    @TableField("len_tol_minus")
    private BigDecimal lenTolMinus;

    @TableField("special_thick_4_eng")
    private String specialThick4Eng;

    @TableField("thick_accu_grade_code")
    private String thickAccuGradeCode;

    @TableField("steel_scrap_proc")
    private String steelScrapProc;

    @TableField("supplier_id")
    private String supplierId;

    @TableField("prod_config_code")
    private String prodConfigCode;

    @TableField("sign_code_3")
    private String signCode3;

    @TableField("outer_plate_o5_desc")
    private String outerPlateO5Desc;

    @TableField("come_proc_type")
    private String comeProcType;

    @TableField("sale_mode")
    private String saleMode;

    @TableField("delivy_status_code")
    private String delivyStatusCode;

    @TableField("order_thick")
    private BigDecimal orderThick;

    @TableField("order_width_min")
    private BigDecimal orderWidthMin;

    @TableField("band_origin_code5")
    private String bandOriginCode5;

    @TableField("band_prod_code4")
    private String bandProdCode4;

    @TableField("archive_stamp_no")
    private String archiveStampNo;

    @TableField("cth_measure_method")
    private String cthMeasureMethod;

    @TableField("order_ready_date")
    private String orderReadyDate;

    @TableField("order_launch_time")
    private String orderLaunchTime;

    @TableField("order_eng_len_max")
    private String orderEngLenMax;

    @TableField("exchange_mat_flag")
    private String exchangeMatFlag;

    @TableField("order_classification_society_desc")
    private String orderClassificationSocietyDesc;

    @TableField("fix_status_code")
    private String fixStatusCode;

    @TableField("order_num")
    private String orderNum;

    @TableField("special_len_3_eng")
    private String specialLen3Eng;

    @TableField("section_no")
    private String sectionNo;

    @TableField("product_order_no")
    private String productOrderNo;

    @TableField("order_outer_dia")
    private BigDecimal orderOuterDia;

    @TableField("settle_user_code")
    private String settleUserCode;

    @TableField("freight_inv_title_code")
    private String freightInvTitleCode;

    @TableField("sale_prod_code")
    private String saleProdCode;

    @TableField("order_len_min")
    private BigDecimal orderLenMin;

    @TableField("thick_repair_flag")
    private String thickRepairFlag;

    @TableField("surf_status_code")
    private String surfStatusCode;

    @TableField("trapezoid_right_bottom_angle")
    private BigDecimal trapezoidRightBottomAngle;

    @TableField("company_code")
    private String companyCode;

    @TableField("accp_dept_id")
    private String accpDeptId;

    @TableField("special_len_3")
    private BigDecimal specialLen3;

    @TableField("order_force_modi_flag")
    private String orderForceModiFlag;

    @TableField("order_width_eng_max")
    private String orderWidthEngMax;

    @TableField("delivy_num_tol_plus")
    private BigDecimal delivyNumTolPlus;

    @TableField("delivery_place_name")
    private String deliveryPlaceName;

    @TableField("prod_class_code")
    private String prodClassCode;

    @TableField("urg_order_flag")
    private String urgOrderFlag;

    @TableField("hope_delivy_date")
    private String hopeDelivyDate;

    @TableField("pick_delivy_flag")
    private String pickDelivyFlag;

    @TableField("band_origin_code4")
    private String bandOriginCode4;

    @TableField("order_launch_times")
    private BigDecimal orderLaunchTimes;

    @TableField("sample_req_code")
    private String sampleReqCode;

    @TableField("sg_sign_class")
    private String sgSignClass;

    @TableField("prod_class_desc")
    private String prodClassDesc;

    @TableField("shipping_mark_a")
    private String shippingMarkA;

    @TableField("shipping_mark_7")
    private String shippingMark7;

    @TableField("band_prod_code7")
    private String bandProdCode7;

    @TableField("scien_project_no")
    private String scienProjectNo;

    @TableField("ep_contract_version_no")
    private BigDecimal epContractVersionNo;

    @TableField("order_width_eng_min")
    private String orderWidthEngMin;

    @TableField("print_type")
    private String printType;

    @TableField("thick_method_code")
    private String thickMethodCode;

    @TableField("order_unit_max_wt")
    private BigDecimal orderUnitMaxWt;

    @TableField("pack_type_cname")
    private String packTypeCname;

    @TableField("trim_mode")
    private String trimMode;

    @TableField("short_size_min")
    private BigDecimal shortSizeMin;

    @TableField("band_origin_code3")
    private String bandOriginCode3;

    @TableField("order_launch_resp_id")
    private String orderLaunchRespId;

    @TableField("spec_thick_2")
    private BigDecimal specThick2;

    @TableField("special_req_flag")
    private String specialReqFlag;

    @TableField("order_confirm_flag")
    private String orderConfirmFlag;

    @TableField("sign_code_1")
    private String signCode1;

    @TableField("new_prod_year")
    private String newProdYear;

    @TableField("auth_project_no")
    private String authProjectNo;

    @TableField("order_unit_code")
    private String orderUnitCode;

    @TableField("delive_date_in")
    private String deliveDateIn;

    @TableField("apn_code")
    private String apnCode;

    @TableField("prod_ename")
    private String prodEname;

    @TableField("user_std")
    private String userStd;

    @TableField("hold_time")
    private String holdTime;

    @TableField("pack_bl_max")
    private BigDecimal packBlMax;

    @TableField("order_width_tol_min")
    private BigDecimal orderWidthTolMin;

    @TableField("special_len_1_eng")
    private String specialLen1Eng;

    @TableField("shipping_mark_b")
    private String shippingMarkB;

    @TableField("piece_wt")
    private BigDecimal pieceWt;

    @TableField("trapezium_bottomlength")
    private BigDecimal trapeziumBottomlength;

    @TableField("mark_1")
    private String mark1;

    @TableField("rain_coat_flag")
    private String rainCoatFlag;

    @TableField("mark_type_code")
    private String markTypeCode;

    @TableField("order_status")
    private String orderStatus;

    @TableField("detect_std_code")
    private String detectStdCode;

    @TableField("wt_per_meter")
    private BigDecimal wtPerMeter;

    @TableField("consignee_ename")
    private String consigneeEname;

    @TableField("settle_mode_name")
    private String settleModeName;

    @TableField("trade_mode_code")
    private String tradeModeCode;

    @TableField("sale_org_code")
    private String saleOrgCode;

    @TableField("saler_company_code")
    private String salerCompanyCode;

    @TableField("heat_coat_code")
    private String heatCoatCode;

    @TableField("shipping_mark_2")
    private String shippingMark2;

    @TableField("band_origin_code6")
    private String bandOriginCode6;

    @TableField("special_len_2")
    private BigDecimal specialLen2;

    @TableField("tc_print_mode")
    private String tcPrintMode;

    @TableField("order_eng_len_min")
    private String orderEngLenMin;

    @TableField("order_oudm_eng")
    private BigDecimal orderOudmEng;

    @TableField("outer_plate_o5_flag")
    private String outerPlateO5Flag;

    @TableField("new_product_flag")
    private String newProductFlag;

    @TableField("depth_leader_desc")
    private String depthLeaderDesc;

    @TableField("terminal_country_name")
    private String terminalCountryName;

    @TableField("trim_type")
    private String trimType;

    @TableField("order_thick_tol_min")
    private BigDecimal orderThickTolMin;

    @TableField("color_3")
    private String color3;

    @TableField("order_no")
    private String orderNo;

    @TableField("smoke_flag")
    private String smokeFlag;

    @TableField("order_modi_remark")
    private String orderModiRemark;

    @TableField("mark_type_desc")
    private String markTypeDesc;

    @TableField("org_coil_code")
    private String orgCoilCode;

    @TableField("self_product_flag")
    private String selfProductFlag;

    @TableField("thick_offset_num")
    private BigDecimal thickOffsetNum;

    @TableField("supervision_mode")
    private String supervisionMode;

    @TableField("check_classification_society_code")
    private String checkClassificationSocietyCode;

    @TableField("order_mat_num")
    private BigDecimal orderMatNum;

    @TableField("delivery_place_code")
    private String deliveryPlaceCode;

    @TableField("short_size_max")
    private BigDecimal shortSizeMax;

    @TableField("shot_paint_code")
    private String shotPaintCode;

    @TableField("section_flag")
    private String sectionFlag;

    @TableField("order_proc_flag")
    private BigDecimal orderProcFlag;

    @TableField("stagger_ct")
    private String staggerCt;

    @TableField("order_proc_time")
    private String orderProcTime;

    @TableField("sg_std_with_version")
    private String sgStdWithVersion;

    @TableField("base_div")
    private String baseDiv;

    @TableField("std_code")
    private String stdCode;

    @TableField("order_wt")
    private BigDecimal orderWt;

    @TableField("contract_no")
    private String contractNo;

    @TableField("delivy_site_code")
    private String delivySiteCode;

    @TableField("private_railway_full_name")
    private String privateRailwayFullName;

    @TableField("sg_class_code")
    private String sgClassCode;

    @TableField("sleeve_type")
    private String sleeveType;

    @TableField("slab_clean_req")
    private String slabCleanReq;

    @TableField("trapezium_toplength")
    private BigDecimal trapeziumToplength;

    @TableField("part_id")
    private String partId;

    @TableField("sign_code_2")
    private String signCode2;

    @TableField("label_remark_desc")
    private String labelRemarkDesc;

    @TableField("order_classification_society_code")
    private String orderClassificationSocietyCode;

    @TableField("check_classification_society_desc")
    private String checkClassificationSocietyDesc;

    @TableField("wt_mode")
    private String wtMode;

    @TableField("delivy_date_period")
    private String delivyDatePeriod;

    @TableField("nom_tim_len_tol_plus")
    private BigDecimal nomTimLenTolPlus;

    @TableField("nom_tim_len_tol_minus")
    private BigDecimal nomTimLenTolMinus;

    @TableField("shipping_mark_8")
    private String shippingMark8;

    @TableField("band_prod_code3")
    private String bandProdCode3;

    @TableField("band_prod_code6")
    private String bandProdCode6;

    @TableField("settle_user_name")
    private String settleUserName;

    @TableField("cerit_type")
    private String ceritType;

    @TableField("manu_remark")
    private String manuRemark;

    @TableField("check_sign_code")
    private String checkSignCode;

    @TableField("psr_code")
    private String psrCode;

    @TableField("pack_type_ename")
    private String packTypeEname;

    @TableField("order_width")
    private BigDecimal orderWidth;

    @TableField("shipping_pos")
    private String shippingPos;

    @TableField("slab_pos_req_code")
    private String slabPosReqCode;

    @TableField("engi_project_code")
    private String engiProjectCode;

    @TableField("pj_type_code")
    private String pjTypeCode;

    @TableField("order_unit_ename")
    private String orderUnitEname;

    @TableField("sg_std")
    private String sgStd;

    @TableField("delivy_date")
    private String delivyDate;

    @TableField("strateg_prod_code")
    private String strategProdCode;

    @TableField("strateg_prod_desc")
    private String strategProdDesc;

    @TableField("sg_code")
    private String sgCode;

    @TableField("trapezoid_height")
    private BigDecimal trapezoidHeight;

    @TableField("certi_notes")
    private String certiNotes;

    @TableField("prfl_model_id")
    private String prflModelId;

    @TableField("old_order_no")
    private String oldOrderNo;

    @TableField("bt_shot_flag")
    private String btShotFlag;

    @TableField("rh_flag")
    private String rhFlag;

    @TableField("hot_roll_mat_flag")
    private String hotRollMatFlag;

    @TableField("if_cool")
    private String ifCool;

    @TableField("if_straigh")
    private String ifStraigh;

    @TableField("if_inverted")
    private String ifInverted;

    @TableField("separ_pile_fale")
    private String separPileFale;

    @TableField("nmagnet_hoist_flag")
    private String nmagnetHoistFlag;

    @TableField("detect_fale")
    private String detectFale;

    @TableField("settle_method_code")
    private String settleMethodCode;

    @TableField("settle_method_name")
    private String settleMethodName;

    @TableField("days")
    private String days;

    @TableField("spec_short_size_rate_max")
    private BigDecimal specShortSizeRateMax;

    @TableField("order_short_size_rate_max")
    private BigDecimal orderShortSizeRateMax;

    @TableField("one_pack_wt_max")
    private BigDecimal onePackWtMax;

    @TableField("pack_thread_num_special")
    private String packThreadNumSpecial;

    @TableField("one_num_special")
    private String oneNumSpecial;

    @TableField("sbody_paint_mark_color")
    private String sbodyPaintMarkColor;

    @TableField("short_size_flag_pack")
    private String shortSizeFlagPack;

    @TableField("one_label_num")
    private BigDecimal oneLabelNum;

    @TableField("network_code")
    private String networkCode;

    @TableField("network_name")
    private String networkName;

    @TableField("len_div_code")
    private String lenDivCode;

    @TableField("end_time")
    private String endTime;

    @TableField("start_time")
    private String startTime;
}
