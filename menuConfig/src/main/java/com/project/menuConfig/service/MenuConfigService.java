package com.project.menuConfig.service;

import com.project.ResultBean;
import com.project.menuConfig.query.MenuAddQuery;
import com.project.menuConfig.query.MenuDeleteQuery;
import com.project.menuConfig.query.MenuUpdateQuery;
import com.project.menuConfig.vo.MenuVO;

import java.util.List;

/**
 * MenuConfigService
 *
 * @author YYDGQJ
 * 创建日期  2026/4/20
 * 描述  菜单管理服务接口
 */
public interface MenuConfigService {

    ResultBean<?> add(MenuAddQuery query);

    ResultBean<?> update(MenuUpdateQuery query);

    ResultBean<?> delete(MenuDeleteQuery query);

    /** 查询所有菜单，按 path 组织成树形结构 */
    ResultBean<List<MenuVO>> queryAll();
}

