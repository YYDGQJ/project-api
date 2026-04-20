package com.project.tableConfig.service;

import com.project.ResultBean;
import com.project.tableConfig.query.TableConfigQuery;
import com.project.tableConfig.vo.TableConfigVO;

/**
 * TableConfigService
 *
 * @author YYDGQJ
 * 创建日期  2026/4/20
 * 描述  表格个性化配置服务接口
 */
public interface TableConfigService {

    /**
     * 加载表格配置
     */
    TableConfigVO load(TableConfigQuery query);

    /**
     * 保存表格配置
     */
    TableConfigVO save(TableConfigQuery query);
}

