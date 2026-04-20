package com.project.dapr.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.project.IdAuditingEntity;
import lombok.Data;

/**
 * Tep0002
 *
 * @author YYDGQJ
 * 创建日期  2026/4/18
 * 描述
 */
@Data
@TableName(value = "tep0002")
public class Tep0002 extends IdAuditingEntity {

    @TableField("code_class")
    private String codeClass;

    @TableField("code_value")
    private String codeValue;

    @TableField("code_desc_1")
    private String codeDesc1;

    @TableField("code_desc_2")
    private String codeDesc2;

    @TableField("code_desc_3")
    private String codeDesc3;

    @TableField("code_desc_4")
    private String codeDesc4;

    @TableField("code_auth")
    private String codeAuth;

    @TableField("parent_code")
    private String parentCode;

    @TableField("code_desc_5")
    private String codeDesc5;
}

