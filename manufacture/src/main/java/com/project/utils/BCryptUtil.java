package com.project.utils;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;

/**
 * BCryptUtil
 *
 * @author YYDGQJ
 * 创建日期  2026/4/14 12:12
 * 描述
 *
 */
@Component
public class BCryptUtil {

    private static StringEncryptor staticStringEncryptor;

    @Resource
    private StringEncryptor stringEncryptor;

    @PostConstruct
    public void init() {
        staticStringEncryptor = this.stringEncryptor;
    }

    /**
     * 加密明文密码
     * @param plainText 用户输入的明文密码
     * @return
     */
    public static String encrypt(String plainText) {
        return staticStringEncryptor.encrypt(plainText);
    }

    /**
     * 解密加密密码
     * @param encryptedText 储存的加密密码
     * @return
     */
    public static String decrypt(String encryptedText) {
        return staticStringEncryptor.decrypt(encryptedText);
    }
}
