package com.project;

import com.project.common.util.Base64Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base64Test
 * 创建人  YYDGQJ
 * 创建日期  2024/3/26 17:56
 * 描述
 */
@SpringBootTest
public class Base64Test {
    String PassWorld = "test1234";
    @Test
    void encodeTest(){
        String EncodePassWord = Base64Util.encode(PassWorld);
        System.out.println("EncodePassWord = " + EncodePassWord);
    }
    @Test
    void decodeTest(){
        String DecodePassword = Base64Util.decode("dGVzdDEyMzQ=");
        System.out.println("DecodePassword = " + DecodePassword);
    }
}
