package com.app.dependency.dependency;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CodingTests {

    @Autowired
    private Coding coding;

    @Test
    public void codingTest(){
        log.info(coding.getComputer().toString());
    }

}
