package com.project.utils;


import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5Util
 *
 * @author YYDGQJ
 * 创建日期  2026/4/14 11:41
 * 描述
 *
 */
@Component
public class MD5Util {

    /**
     * 将字符串进行 MD5 加密（返回 32 位小写十六进制字符串）
     * @param input 原始字符串
     * @return MD5 加密后的字符串，如果输入为 null 则返回 null
     */
    public static String encryptToMD5(String input) {
        if (input == null) {
            return null;
        }
        try {
            // 获取 MD5 算法实例
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算哈希值，得到字节数组
            byte[] digest = md.digest(input.getBytes());
            // 将字节数组转换为十六进制字符串
            return bytesToHex(digest);
        } catch (NoSuchAlgorithmException e) {
            // MD5 算法一定存在，不会进入这里
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }

    /**
     * 字节数组转十六进制字符串（小写）
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            // 将每个字节转为两位十六进制数
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }


    // 使用示例
//    public static void main(String[] args) {
//        String original = "11";
//        String md5 = encryptToMD5(original);
//        System.out.println("原文: " + original);
//        System.out.println("MD5: " + md5);
//        // 输出: e10adc3949ba59abbe56e057f20f883e
//    }
}