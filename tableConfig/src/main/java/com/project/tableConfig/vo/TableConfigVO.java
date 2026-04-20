package com.project.tableConfig.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * TableConfigVO
 *
 * @author YYDGQJ
 * 创建日期  2026/4/20
 * 描述  表格个性化配置响应VO
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TableConfigVO {

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

