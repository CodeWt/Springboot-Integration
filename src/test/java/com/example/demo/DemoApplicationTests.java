package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {
//    @Autowired
//    private DataSourceProperties properties;
//
//    @Autowired
//    private DataSourceProperties properties1;

    @Autowired
    private JdbcTemplate template;
//    @TestTwo
//    public void test() {
//        System.out.println(properties.getUrl());
//        properties.setUrl("sbsb...");
//        System.out.println(properties1.getUrl());
//    }

    @Test
    void contextLoads() throws SQLException {
        System.out.println("99999" + template);
    }

}
