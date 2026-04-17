package com.project;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * IdAuditingEntity
 *
 * @author YYDGQJ
 * 创建日期  2026/4/14 10:16
 * 描述
 *
 */
public class IdAuditingEntity extends AbstractAuditingEntity{
     @TableField(
        fill = FieldFill.INSERT
    )
    private String createdByName;
    @TableField(
        fill = FieldFill.INSERT_UPDATE
    )
    private String lastModifiedByName;
    @TableId(
        value = "ID",
        type = IdType.ASSIGN_ID
    )
    @JsonSerialize(
        using = ToStringSerializer.class
    )
    protected Long id;

    public String getCreatedByName() {
        return this.createdByName;
    }

    public String getLastModifiedByName() {
        return this.lastModifiedByName;
    }

    public Long getId() {
        return this.id;
    }

    public void setCreatedByName(final String createdByName) {
        this.createdByName = createdByName;
    }

    public void setLastModifiedByName(final String lastModifiedByName) {
        this.lastModifiedByName = lastModifiedByName;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String toString() {
        String var10000 = this.getCreatedByName();
        return "IdAuditingEntity(createdByName=" + var10000 + ", lastModifiedByName=" + this.getLastModifiedByName() + ", id=" + this.getId() + ")";
    }
}
