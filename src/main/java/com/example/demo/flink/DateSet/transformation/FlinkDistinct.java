package com.example.demo.flink.DateSet.transformation;

import com.example.demo.flink.entity.User;
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

public class FlinkDistinct {
    public static  void test01() throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        //抽取数据
        DataSet<User> userData =
                env.createInput(
                        JDBCInputFormat.buildJDBCInputFormat()
                                .setDrivername("com.mysql.jdbc.Driver")
                                .setDBUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=PRC")
                                .setUsername("root")
                                .setPassword("123456")
                                .setQuery("select name, pass, age from user")
                                .setRowTypeInfo(new RowTypeInfo(BasicTypeInfo.STRING_TYPE_INFO, BasicTypeInfo.STRING_TYPE_INFO, BasicTypeInfo.INT_TYPE_INFO))
                                .finish()
                ).partitionByHash(0).distinct(0)
                        .filter((FilterFunction<Row>) value -> {
                            if (!"null".equals(String.valueOf(value.getField(0)))) {
                                return true;
                            }
                            return false;
                        }).map((MapFunction<Row, User>) row -> {
                            User user = new User();
                            user.setName((String) row.getField(0));
                            user.setPass((String) row.getField(1));
                            user.setAge((Integer) row.getField(2));
                            return user;
                        }).returns(TypeInformation.of(User.class));
        userData.distinct("pass").filter((FilterFunction<User>) user -> {
            if (user != null) {
                return true;
            }
            return false;
        }).map((MapFunction<User, Row>) user -> {
            user.setAge(user.getAge()+1);
            return Row.of(user.getName(), user.getPass(), user.getAge());
        }).returns(new RowTypeInfo(BasicTypeInfo.STRING_TYPE_INFO, BasicTypeInfo.STRING_TYPE_INFO, BasicTypeInfo.INT_TYPE_INFO))
                .output(JDBCOutputFormat.buildJDBCOutputFormat()
                        .setDrivername("com.mysql.jdbc.Driver")
                        .setDBUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=PRC")
                        .setUsername("root")
                        .setPassword("123456")
                        .setQuery("insert into user1 (name, pass, age) values (?,?,?)")
                        .finish());
        env.execute();
    }
}
