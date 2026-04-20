package com.project;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * PageHelper
 *
 * @author YYDGQJ
 * 创建日期  2026/4/19
 * 描述  统一处理分页默认值，避免各业务模块重复写current/size兜底逻辑
 */
@Component
public class PageHelper {

    private final long defaultCurrent;
    private final long defaultSize;

    public PageHelper(
            @Value("${project.page.default-current:1}") long defaultCurrent,
            @Value("${project.page.default-size:10}") long defaultSize) {
        this.defaultCurrent = defaultCurrent;
        this.defaultSize = defaultSize;
    }

    public <T> Page<T> buildPage(IPage<?> page) {
        long current = defaultCurrent;
        long size = defaultSize;
        if (page != null) {
            if (page.getCurrent() > 0) {
                current = page.getCurrent();
            }
            if (page.getSize() > 0) {
                size = page.getSize();
            }
        }
        return new Page<>(current, size);
    }
}

