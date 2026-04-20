package com.project.tableConfig.web;

import com.project.ResultBean;
import com.project.tableConfig.query.TableConfigQuery;
import com.project.tableConfig.service.TableConfigService;
import com.project.tableConfig.vo.TableConfigVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TableConfigController
 *
 * @author YYDGQJ
 * 创建日期  2026/4/20
 * 描述  表格个性化配置接口
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/tableConfig")
@Slf4j
public class TableConfigController {

    private final TableConfigService tableConfigService;

    @PostMapping("/load")
    public TableConfigVO load(@RequestBody @Valid TableConfigQuery query) {
        return tableConfigService.load(query);
    }

    @PostMapping("/save")
    public TableConfigVO save(@RequestBody @Valid TableConfigQuery query) {
        return tableConfigService.save(query);
    }
}

