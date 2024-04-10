package com.project;

import com.project.common.constant.FTP;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * FtpTest
 * 创建人  YYDGQJ
 * 创建日期  2024/3/31 15:18
 * 描述
 */
@SpringBootTest
public class FtpTest {

    @Test
    void loginTest(){
        System.out.println(FTP.class);
    }
}
