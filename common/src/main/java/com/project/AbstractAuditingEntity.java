package com.project;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * AbstractAuditingEntity
 *
 * @author YYDGQJ
 * 创建日期  2026/4/14 10:16
 * 描述
 *
 */
public class AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableField(
        fill = FieldFill.INSERT
    )
    @JsonDeserialize(
        using = LocalDateTimeDeserializer.class
    )
    @JsonSerialize(
        using = LocalDateTimeSerializer.class
    )
    @JsonFormat(
        pattern = "yyyy-MM-dd HH:mm:ss",
        timezone = "GMT+8"
    )
    private LocalDateTime createdDate;
    @TableField(
        fill = FieldFill.INSERT
    )
    private String createdBy;
    @TableField(
        fill = FieldFill.INSERT_UPDATE
    )
    @JsonDeserialize(
        using = LocalDateTimeDeserializer.class
    )
    @JsonSerialize(
        using = LocalDateTimeSerializer.class
    )
    @JsonFormat(
        pattern = "yyyy-MM-dd HH:mm:ss",
        timezone = "GMT+8"
    )
    private LocalDateTime lastModifiedDate;
    @TableField(
        fill = FieldFill.INSERT_UPDATE
    )
    private String lastModifiedBy;

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    @JsonDeserialize(
        using = LocalDateTimeDeserializer.class
    )
    @JsonFormat(
        pattern = "yyyy-MM-dd HH:mm:ss",
        timezone = "GMT+8"
    )
    public void setCreatedDate(final LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonDeserialize(
        using = LocalDateTimeDeserializer.class
    )
    @JsonFormat(
        pattern = "yyyy-MM-dd HH:mm:ss",
        timezone = "GMT+8"
    )
    public void setLastModifiedDate(final LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setLastModifiedBy(final String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String toString() {
        LocalDateTime var10000 = this.getCreatedDate();
        return "AbstractAuditingEntity(createdDate=" + var10000 + ", createdBy=" + this.getCreatedBy() + ", lastModifiedDate=" + this.getLastModifiedDate() + ", lastModifiedBy=" + this.getLastModifiedBy() + ")";
    }
}
