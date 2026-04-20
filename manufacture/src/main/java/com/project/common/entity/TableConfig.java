package com.project.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.project.IdAuditingEntity;
import lombok.Data;

/**
 * TableConfig
 *
 * @author YYDGQJ
 * 创建日期  2026/4/20 01:10
 * 描述
 *
 */
@Data
@TableName(value = "pm.table_config")
public class TableConfig extends IdAuditingEntity {

    @TableField("key")
    private String key;

    @TableField("route_path")
    private String routePath;

    @TableField("user_id")
    private String userId;

    @TableField("visible_column_keys")
    private String visibleColumnKeys;

    @TableField("column_order_keys")
    private String columnOrderKeys;

    @TableField("filterenabledkeys")
    private String filterenabledkeys;

    @TableField("sortenabledkeys")
    private String sortenabledkeys;

    @TableField("resized_column_widths")
    private String resizedColumnWidths;

    @TableField("pagesize")
    private Integer pagesize;
}
