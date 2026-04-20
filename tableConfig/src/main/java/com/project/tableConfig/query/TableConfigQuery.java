package com.project.tableConfig.query;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * TableConfigQuery
 *
 * @author YYDGQJ
 * 创建日期  2026/4/20
 * 描述  前台表格个性化配置请求实体
 */
@Data
public class TableConfigQuery {

    /** 当前登录用户ID */
    private String userId;

    /** 当前路由路径 */
    private String routePath;

    /** 唯一标识 */
    private String key;

    /** 表格配置 */
    private Config config;

    @Data
    public static class Config {

        /** 可见列Key列表 */
        private List<String> visibleColumnKeys;

        /** 列顺序Key列表 */
        private List<String> columnOrderKeys;

        /** 启用筛选的列Key列表 */
        private List<String> filterEnabledKeys;

        /** 启用排序的列Key列表 */
        private List<String> sortEnabledKeys;

        /** 列宽（key -> width） */
        private Map<String, Integer> resizedColumnWidths;

        /** 每页条数 */
        private Integer pageSize;
    }
}

