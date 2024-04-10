package com.project.common.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Base64Util
 * 创建人  YYDGQJ
 * 创建日期  2024/3/26 17:50
 * 描述
 */
public class Base64Util {
    /***
     * BASE64加密
     * @param key
     * return
     */
    public static String decode(String key) {
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(key), StandardCharsets.UTF_8);
    }

    /***
     * BASE64解密
     * @param key
     * return
     */
    public static String encode(String key) {
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(key.getBytes(StandardCharsets.UTF_8));
    }

}
