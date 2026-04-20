package com.project.menuConfig.web;

import com.project.ResultBean;
import com.project.menuConfig.query.MenuAddQuery;
import com.project.menuConfig.query.MenuDeleteQuery;
import com.project.menuConfig.query.MenuUpdateQuery;
import com.project.menuConfig.service.MenuConfigService;
import com.project.menuConfig.vo.MenuVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * MenuConfigController
 *
 * @author YYDGQJ
 * 创建日期  2026/4/20
 * 描述  菜单管理接口
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/menu")
@Slf4j
public class MenuConfigController {

    private final MenuConfigService menuConfigService;

    @PostMapping("/add")
    public ResultBean<?> add(@RequestBody @Valid MenuAddQuery query) {
        try {
            return menuConfigService.add(query);
        } catch (Exception e) {
            log.error("add menu failed", e);
            return ResultBean.error("系统异常");
        }
    }

    @PostMapping("/update")
    public ResultBean<?> update(@RequestBody @Valid MenuUpdateQuery query) {
        try {
            return menuConfigService.update(query);
        } catch (Exception e) {
            log.error("update menu failed", e);
            return ResultBean.error("系统异常");
        }
    }

    @PostMapping("/delete")
    public ResultBean<?> delete(@RequestBody @Valid MenuDeleteQuery query) {
        try {
            return menuConfigService.delete(query);
        } catch (Exception e) {
            log.error("delete menu failed", e);
            return ResultBean.error("系统异常");
        }
    }

    @GetMapping("/query")
    public ResultBean<List<MenuVO>> query() {
        try {
            return menuConfigService.queryAll();
        } catch (Exception e) {
            log.error("query menu failed", e);
            return ResultBean.error("系统异常");
        }
    }
}

