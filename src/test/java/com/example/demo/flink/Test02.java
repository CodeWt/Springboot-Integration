package com.example.demo.flink;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.typeinfo.BasicTypeInfo;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.io.jdbc.JDBCInputFormat;
import org.apache.flink.api.java.io.jdbc.JDBCOutputFormat;
import org.apache.flink.api.java.typeutils.RowTypeInfo;
import org.apache.flink.types.Row;
import org.junit.Test;

/**
 * input data from mysql and transform it via flink
 * then output these data to another table.
 *
 * flink version : 1.3
 */
public class Test02 {
    @Test
    public void test02() throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        //抽取数据
        DataSet<User> userData =
                env.createInput(
                        JDBCInputFormat.buildJDBCInputFormat()
                                .setDrivername("com.mysql.jdbc.Driver")
                                .setDBUrl("jdbc:mysql://localhost:3306/test")
                                .setUsername("root")
                                .setPassword("123456")
                                .setQuery("select name, pass, age from user")
                                .setRowTypeInfo(new RowTypeInfo(BasicTypeInfo.STRING_TYPE_INFO, BasicTypeInfo.STRING_TYPE_INFO, BasicTypeInfo.INT_TYPE_INFO))
                                .finish()
                ).partitionByHash(0).distinct("f0")
                .filter(new FilterFunction<Row>() {
                    @Override
                    public boolean filter(Row value) throws Exception {
                        if (!"null".equals(String.valueOf(value.getField(0)))) {
                            return true;
                        }
                        return false;
                    }
                })
                .map(new MapFunction<Row, User>() {
                    @Override
                    public User map(Row row) throws Exception {
                        System.out.println("====>> " + row.getField(0) + "\t" + row.getField(1) + "\t" + row.getField(2));
                        User user = new User();
                        user.setName((String) row.getField(0));
                        user.setPass((String) row.getField(1));
                        user.setAge((Integer) row.getField(2));
                        return user;
                    }
                })
                .returns(TypeInformation.of(User.class));

        userData.filter((FilterFunction<User>) user -> {
            if (user != null) {
                return true;
            }
            return false;
        }).map(new MapFunction<User, Row>() {
            @Override
            public Row map(User user) throws Exception {
                return Row.of(user.getName(), user.getPass(), user.getAge());
            }
        })
        .returns(new RowTypeInfo(BasicTypeInfo.STRING_TYPE_INFO, BasicTypeInfo.STRING_TYPE_INFO, BasicTypeInfo.INT_TYPE_INFO))
        .output(JDBCOutputFormat.buildJDBCOutputFormat()
                .setDrivername("com.mysql.jdbc.Driver")
                .setDBUrl("jdbc:mysql://localhost:3306/test")
                .setUsername("root")
                .setPassword("123456")
                .setQuery("insert into user1 (name, pass, age) values (?,?,?)")
                .finish());
        env.execute();
    }
}
