package com.project;

import com.project.common.util.Sysutil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectApplicationTest {
    @Test
    void idTest(){
        System.out.println(Sysutil.iD());
        System.out.println(Sysutil.uuid());
    }

    @Test
    void contextLoads() {
        int i = 1;
        int r = 2;
        int num = i+r;
        System.out.println(num);
    }

}
