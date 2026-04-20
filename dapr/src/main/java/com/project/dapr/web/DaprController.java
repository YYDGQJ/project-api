package com.project.dapr.web;

import com.project.ResultBean;
import com.project.dapr.query.DaprAddQuery;
import com.project.dapr.query.DaprAddDetailQuery;
import com.project.dapr.query.DaprDeleteQuery;
import com.project.dapr.query.DaprDeleteDetailQuery;
import com.project.dapr.query.DaprDetailQuery;
import com.project.dapr.query.DaprUpdateQuery;
import com.project.dapr.query.DaprUpdateDetailQuery;
import com.project.dapr.query.DaprValueSetQuery;
import com.project.dapr.service.DaprService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DaprController
 *
 * @author YYDGQJ
 * 创建日期  2026/4/18
 * 描述
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/dapr")
@Slf4j
public class DaprController {

    private final DaprService daprService;

    @PostMapping("/add")
    public ResultBean<?> add(@RequestBody DaprAddQuery query) {
        try {
            return daprService.add(query);
        } catch (Exception e) {
            log.error("add dapr failed", e);
            return ResultBean.error("系统异常");
        }
    }

    @PostMapping("/update")
    public ResultBean<?> update(@RequestBody DaprUpdateQuery query) {
        try {
            return daprService.update(query);
        } catch (Exception e) {
            log.error("update dapr failed", e);
            return ResultBean.error("系统异常");
        }
    }

    @PostMapping("/delete")
    public ResultBean<?> delete(@RequestBody DaprDeleteQuery query) {
        try {
            return daprService.delete(query);
        } catch (Exception e) {
            log.error("delete dapr failed", e);
            return ResultBean.error("系统异常");
        }
    }

    @PostMapping("/addDetail")
    public ResultBean<?> addDetail(@RequestBody DaprAddDetailQuery query) {
        try {
            return daprService.addDetail(query);
        } catch (Exception e) {
            log.error("add detail failed", e);
            return ResultBean.error("系统异常");
        }
    }

    @PostMapping("/updateDetail")
    public ResultBean<?> updateDetail(@RequestBody DaprUpdateDetailQuery query) {
        try {
            return daprService.updateDetail(query);
        } catch (Exception e) {
            log.error("update detail failed", e);
            return ResultBean.error("系统异常");
        }
    }

    @PostMapping("/deleteDetail")
    public ResultBean<?> deleteDetail(@RequestBody DaprDeleteDetailQuery query) {
        try {
            return daprService.deleteDetail(query);
        } catch (Exception e) {
            log.error("delete detail failed", e);
            return ResultBean.error("系统异常");
        }
    }

    @PostMapping("/queryValueSet")
    public ResultBean<?> queryValueSet(@RequestBody(required = false) DaprValueSetQuery query) {
        try {
            return daprService.queryValueSet(query);
        } catch (Exception e) {
            log.error("query value set failed", e);
            return ResultBean.error("系统异常");
        }
    }

    @PostMapping("/queryDetail")
    public ResultBean<?> queryDetail(@RequestBody DaprDetailQuery query) {
        try {
            return daprService.queryDetail(query);
        } catch (Exception e) {
            log.error("query detail failed", e);
            return ResultBean.error("系统异常");
        }
    }
}

