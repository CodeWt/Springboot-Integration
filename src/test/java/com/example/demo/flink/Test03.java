package com.example.demo.flink;

import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.io.CsvReader;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class Test03 {
        @Test
    public void test01() throws Exception {
            ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
            try {
                CsvReader csvReader = env.readCsvFile("C:\\Users\\T460\\Desktop\\test.csv");
                csvReader.setCharset("UTF-8");
                csvReader.ignoreFirstLine().types(String.class,String.class,String.class)
                        .print();
            } catch (Exception e) {
                e.printStackTrace();
            }
            env.execute();
        }
}
