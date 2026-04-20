package com.project.menuConfig.query;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * MenuDeleteQuery
 *
 * @author YYDGQJ
 * 创建日期  2026/4/20
 * 描述  删除菜单请求
 */
@Data
public class MenuDeleteQuery {

    @NotNull(message = "id不能为空")
    private Long id;
}

