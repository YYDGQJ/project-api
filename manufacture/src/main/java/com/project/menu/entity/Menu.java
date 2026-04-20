package com.project.menu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.project.IdAuditingEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Menu
 *
 * @author YYDGQJ
 * 创建日期  2026/4/20
 * 描述  菜单实体
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "pm.menu_config")
public class Menu extends IdAuditingEntity {

//    @TableField("rec_deletor_id")
//    private String recDeletorId;

//    @TableField("rec_deletor_name")
//    private String recDeletorName;

//    @TableField("rec_delete_time")
//    private String recDeleteTime;

    /** 标签 */
    @TableField("label")
    private String label;

    /** 路径 */
    @TableField("path")
    private String path;

    /** 名字 */
    @TableField("name")
    private String name;

    /** 组件 */
    @TableField("component")
    private String component;

    /** 启用 */
    @TableField("enabled")
    private Boolean enabled;

    /** 描述 */
    @TableField("description")
    private String description;

    /** 类别 */
    @TableField("category")
    private String category;

    /** 顺序 */
    @TableField("order_num")
    private Integer orderNum;
}

