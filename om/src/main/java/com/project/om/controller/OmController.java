package com.project.om.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.ResultBean;
import com.project.om.entity.Tom01;
import com.project.om.query.Tom01AddQuery;
import com.project.om.query.Tom01DeleteQuery;
import com.project.om.query.Tom01Query;
import com.project.om.query.Tom01UpdateQuery;
import com.project.om.service.OmService;
import com.project.om.vo.Tom01InfoVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * OmController
 *
 * @author YYDGQJ
 * 创建日期  2026/4/19
 * 描述
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/om")
@Slf4j
public class OmController {

    private final OmService omService;

    @PostMapping("/add")
    public ResultBean<?> add(@RequestBody Tom01AddQuery query) {
        try {
            return omService.add(query);
        } catch (Exception e) {
            log.error("add om failed", e);
            return ResultBean.error("系统异常");
        }
    }

    @PostMapping("/update")
    public ResultBean<?> update(@RequestBody Tom01UpdateQuery query) {
        try {
            return omService.update(query);
        } catch (Exception e) {
            log.error("update om failed", e);
            return ResultBean.error("系统异常");
        }
    }

    @PostMapping("/delete")
    public ResultBean<?> delete(@RequestBody Tom01DeleteQuery query) {
        try {
            return omService.delete(query);
        } catch (Exception e) {
            log.error("delete om failed", e);
            return ResultBean.error("系统异常");
        }
    }

    @PostMapping("/query")
    public IPage<Tom01InfoVO> query(@RequestBody Page<Tom01> page, Tom01Query query) {
        try {
            return omService.query(page, query);
        } catch (Exception e) {
            log.error("query om failed", e);
            return null;
        }
    }
}

