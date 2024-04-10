package com.project.common.util;

import java.util.UUID;

/**
 * Sysutil
 * 创建人  YYDGQJ
 * 创建日期  2024/3/26 17:23
 * 描述
 */
public class Sysutil {
    public static String uuid(){
        return UUID.randomUUID().toString();
    }
    public static String iD(){
        return uuid().replaceAll("-", "");
    }
}
