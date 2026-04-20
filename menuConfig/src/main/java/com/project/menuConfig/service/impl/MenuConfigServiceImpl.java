package com.project.menuConfig.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.ResultBean;
import com.project.menu.entity.Menu;
import com.project.menu.repository.MenuRepository;
import com.project.menuConfig.query.MenuAddQuery;
import com.project.menuConfig.query.MenuDeleteQuery;
import com.project.menuConfig.query.MenuUpdateQuery;
import com.project.menuConfig.service.MenuConfigService;
import com.project.menuConfig.vo.MenuVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * MenuConfigServiceImpl
 *
 * @author YYDGQJ
 * 创建日期  2026/4/20
 * 描述  菜单管理服务实现
 */
@Slf4j
@Service
public class MenuConfigServiceImpl extends ServiceImpl<MenuRepository, Menu>
        implements MenuConfigService {

    @Override
    public ResultBean<?> add(MenuAddQuery query) {
        long count = count(new LambdaQueryWrapper<Menu>().eq(Menu::getPath, query.getPath()));
        if (count > 0) {
            return ResultBean.error("path已存在: " + query.getPath());
        }
        Menu menu = new Menu();
        BeanUtils.copyProperties(query, menu);
        save(menu);
        return ResultBean.ok(0, menu.getId(), "新增成功");
    }

    @Override
    public ResultBean<?> update(MenuUpdateQuery query) {
        Menu menu = getById(query.getId());
        if (menu == null) {
            return ResultBean.error("菜单不存在");
        }
        if (StringUtils.hasText(query.getPath()) && !query.getPath().equals(menu.getPath())) {
            long count = count(new LambdaQueryWrapper<Menu>().eq(Menu::getPath, query.getPath()));
            if (count > 0) {
                return ResultBean.error("path已存在: " + query.getPath());
            }
            menu.setPath(query.getPath());
        }
        if (StringUtils.hasText(query.getLabel()))       menu.setLabel(query.getLabel());
        if (StringUtils.hasText(query.getName()))        menu.setName(query.getName());
        if (StringUtils.hasText(query.getComponent()))   menu.setComponent(query.getComponent());
        if (query.getEnabled() != null)                  menu.setEnabled(query.getEnabled());
        if (StringUtils.hasText(query.getDescription())) menu.setDescription(query.getDescription());
        if (StringUtils.hasText(query.getCategory()))    menu.setCategory(query.getCategory());
        if (query.getOrderNum() != null)                 menu.setOrderNum(query.getOrderNum());
        updateById(menu);
        return ResultBean.ok("修改成功");
    }

    @Override
    public ResultBean<?> delete(MenuDeleteQuery query) {
        Menu menu = getById(query.getId());
        if (menu == null) {
            return ResultBean.error("菜单不存在");
        }
        // 级联删除所有子菜单
        remove(new LambdaQueryWrapper<Menu>()
                .likeRight(Menu::getPath, menu.getPath() + "/")
                .or()
                .eq(Menu::getPath, menu.getPath()));
        return ResultBean.ok("删除成功");
    }

    @Override
    public ResultBean<List<MenuVO>> queryAll() {
        List<Menu> all = list(new LambdaQueryWrapper<Menu>().orderByAsc(Menu::getOrderNum));
        return ResultBean.ok(0, buildTree(all), "查询成功");
    }

    // ─────────────────────── 树形构建 ───────────────────────

    private List<MenuVO> buildTree(List<Menu> all) {
        Map<String, MenuVO> voMap = new LinkedHashMap<>();
        for (Menu m : all) {
            voMap.put(m.getPath(), toVO(m));
        }
        List<MenuVO> roots = new ArrayList<>();
        for (Menu m : all) {
            String parentPath = getParentPath(m.getPath());
            MenuVO vo = voMap.get(m.getPath());
            if (parentPath == null || !voMap.containsKey(parentPath)) {
                roots.add(vo);
            } else {
                MenuVO parent = voMap.get(parentPath);
                if (parent.getChildren() == null) {
                    parent.setChildren(new ArrayList<>());
                }
                parent.getChildren().add(vo);
            }
        }
        sortChildren(roots);
        return roots;
    }

    private String getParentPath(String path) {
        if (!StringUtils.hasText(path)) return null;
        int idx = path.lastIndexOf('/');
        if (idx <= 0) return null;
        return path.substring(0, idx);
    }

    private void sortChildren(List<MenuVO> nodes) {
        if (nodes == null || nodes.isEmpty()) return;
        nodes.sort(Comparator.comparingInt(v -> v.getOrder() == null ? 0 : v.getOrder()));
        for (MenuVO node : nodes) sortChildren(node.getChildren());
    }

    private MenuVO toVO(Menu m) {
        MenuVO vo = new MenuVO();
        vo.setId(m.getId());
        vo.setLabel(m.getLabel());
        vo.setPath(m.getPath());
        vo.setName(m.getName());
        vo.setComponent(m.getComponent());
        vo.setEnabled(m.getEnabled());
        vo.setDescription(m.getDescription());
        vo.setCategory(m.getCategory());
        vo.setOrder(m.getOrderNum());
        return vo;
    }
}

