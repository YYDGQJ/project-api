package com.project.menuConfig.query;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * MenuUpdateQuery
 *
 * @author YYDGQJ
 * 创建日期  2026/4/20
 * 描述  修改菜单请求
 */
@Data
public class MenuUpdateQuery {

    @NotNull(message = "id不能为空")
    private Long id;

    private String label;
    private String path;
    private String name;
    private String component;
    private Boolean enabled;
    private String description;
    private String category;
    private Integer orderNum;
}

