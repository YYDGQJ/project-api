package com.project.menuConfig.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

/**
 * MenuVO
 *
 * @author YYDGQJ
 * 创建日期  2026/4/20
 * 描述  菜单树节点VO
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuVO {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String label;
    private String path;
    private String name;
    private String component;
    private Boolean enabled;
    private String description;
    private String category;
    private Integer order;

    /** 子菜单，叶子节点为null */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MenuVO> children;
}

