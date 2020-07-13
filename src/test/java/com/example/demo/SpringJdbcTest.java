package com.example.demo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class SpringJdbcTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringJdbcTest.class);

    @Test
    public void test01(){
        LOGGER.info("xxxx");
    }
}
