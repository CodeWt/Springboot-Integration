package com.example.demo.flink.DateSet.transformation;

import com.example.demo.flink.entity.User;
import org.apache.flink.api.common.typeinfo.BasicTypeInfo;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.io.jdbc.JDBCInputFormat;
import org.apache.flink.api.java.typeutils.RowTypeInfo;

public class WriteCsvTest {
    static void test01() throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        //抽取数据

        env.createInput(
                JDBCInputFormat.buildJDBCInputFormat()
                        .setDrivername("com.mysql.jdbc.Driver")
                        .setDBUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=PRC")
                        .setUsername("root")
                        .setPassword("123456")
                        .setQuery("select name, pass, age from user")
                        .setRowTypeInfo(new RowTypeInfo(BasicTypeInfo.STRING_TYPE_INFO, BasicTypeInfo.STRING_TYPE_INFO, BasicTypeInfo.INT_TYPE_INFO))
                        .finish())
                .writeAsCsv("./xxx.csv");
        env.execute();
    }

    public static void main(String[] args) throws Exception {
        test01();
    }
}
