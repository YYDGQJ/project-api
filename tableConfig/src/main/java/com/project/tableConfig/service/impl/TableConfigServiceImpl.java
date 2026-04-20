package com.project.tableConfig.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.ResultBean;
import com.project.common.entity.TableConfig;
import com.project.common.repository.TableConfigRepository;
import com.project.tableConfig.query.TableConfigQuery;
import com.project.tableConfig.service.TableConfigService;
import com.project.tableConfig.vo.TableConfigVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * TableConfigServiceImpl
 *
 * @author YYDGQJ
 * 创建日期  2026/4/20
 * 描述  表格个性化配置服务实现
 */
@Slf4j
@Service
public class TableConfigServiceImpl extends ServiceImpl<TableConfigRepository, TableConfig>
        implements TableConfigService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public TableConfigVO load(TableConfigQuery query) {
        if (query == null || !StringUtils.hasText(query.getUserId())
                || !StringUtils.hasText(query.getRoutePath())
                || !StringUtils.hasText(query.getKey())) {
            return null;
        }

        TableConfig config = getOne(new LambdaQueryWrapper<TableConfig>()
                .eq(TableConfig::getUserId, query.getUserId())
                .eq(TableConfig::getRoutePath, query.getRoutePath())
                .eq(TableConfig::getKey, query.getKey())
                .last("LIMIT 1"));

        if (config == null) {
            return null;
        }

        TableConfigVO vo = toVO(config);
        return vo;
    }

    @Override
    public TableConfigVO  save(TableConfigQuery query) {
        if (query == null || !StringUtils.hasText(query.getUserId())
                || !StringUtils.hasText(query.getRoutePath())
                || !StringUtils.hasText(query.getKey())) {
            return null;
        }

        TableConfigQuery.Config cfg = query.getConfig();
        if (cfg == null) {
            return null;
        }

        TableConfig existing = getOne(new LambdaQueryWrapper<TableConfig>()
                .eq(TableConfig::getUserId, query.getUserId())
                .eq(TableConfig::getRoutePath, query.getRoutePath())
                .eq(TableConfig::getKey, query.getKey())
                .last("LIMIT 1"));

        if (existing == null) {
            existing = new TableConfig();
            existing.setUserId(query.getUserId());
            existing.setRoutePath(query.getRoutePath());
            existing.setKey(query.getKey());
        }

        fillEntity(existing, cfg);

        saveOrUpdate(existing);
        return null;
    }

    private void fillEntity(TableConfig entity, TableConfigQuery.Config cfg) {
        entity.setVisibleColumnKeys(toJson(cfg.getVisibleColumnKeys()));
        entity.setColumnOrderKeys(toJson(cfg.getColumnOrderKeys()));
        entity.setFilterenabledkeys(toJson(cfg.getFilterEnabledKeys()));
        entity.setSortenabledkeys(toJson(cfg.getSortEnabledKeys()));
        entity.setResizedColumnWidths(toJson(cfg.getResizedColumnWidths()));
        entity.setPagesize(cfg.getPageSize());
    }

    private TableConfigVO toVO(TableConfig config) {
        TableConfigVO vo = new TableConfigVO();
        vo.setVisibleColumnKeys(fromJson(config.getVisibleColumnKeys(), new TypeReference<List<String>>() {}));
        vo.setColumnOrderKeys(fromJson(config.getColumnOrderKeys(), new TypeReference<List<String>>() {}));
        vo.setFilterEnabledKeys(fromJson(config.getFilterenabledkeys(), new TypeReference<List<String>>() {}));
        vo.setSortEnabledKeys(fromJson(config.getSortenabledkeys(), new TypeReference<List<String>>() {}));
        vo.setResizedColumnWidths(fromJson(config.getResizedColumnWidths(), new TypeReference<Map<String, Integer>>() {}));
        vo.setPageSize(config.getPagesize());
        return vo;
    }

    private String toJson(Object obj) {
        if (obj == null) return null;
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("序列化失败", e);
            return null;
        }
    }

    private <T> T fromJson(String json, TypeReference<T> typeRef) {
        if (!StringUtils.hasText(json)) return null;
        try {
            return objectMapper.readValue(json, typeRef);
        } catch (JsonProcessingException e) {
            log.error("反序列化失败: {}", json, e);
            return null;
        }
    }
}

