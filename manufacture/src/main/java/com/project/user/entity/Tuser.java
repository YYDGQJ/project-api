package com.project.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.project.IdAuditingEntity;
import lombok.Data;

/**
 * Tuser
 *
 * @author YYDGQJ
 * 创建日期  2026/4/14 09:54
 * 描述
 *
 */
@Data
@TableName(value = "pm.tuser")
public class Tuser extends IdAuditingEntity {

    @TableField("user_id")
    private String userId;
    @TableField("user_name")
    private String userName;
    @TableField("user_phone")
    private String userPhone;
    @TableField("dept")
    private String dept;
    @TableField("position")
    private String position;
    @TableField("user_pass_word")
    private String userPassWord;
    @TableField("status")
    private Integer status;
    @TableField("role")
    private String role;
    @TableField("error_number")
    private Integer errorNumber;
}
