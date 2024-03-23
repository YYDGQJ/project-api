package com.project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectApplicationTests {

    @Test
    void contextLoads() {
        int i = 1;
        int r = 2;
        int num = i+r;
        System.out.println(num);
    }

}
