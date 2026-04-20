package com.project.menuConfig.query;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * MenuAddQuery
 *
 * @author YYDGQJ
 * 创建日期  2026/4/20
 * 描述  新增菜单请求
 */
@Data
public class MenuAddQuery {

    @NotBlank(message = "label不能为空")
    private String label;

    @NotBlank(message = "path不能为空")
    private String path;

    @NotBlank(message = "name不能为空")
    private String name;

    @NotBlank(message = "component不能为空")
    private String component;

    private Boolean enabled = true;

    private String description;

    private String category;

    private Integer orderNum;
}

