package com.example.demo.flink.DateSet.transformation;

import com.example.demo.flink.entity.User;
import org.apache.commons.lang.StringUtils;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.operators.base.JoinOperatorBase;
import org.apache.flink.api.common.typeinfo.BasicTypeInfo;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.io.jdbc.JDBCInputFormat;
import org.apache.flink.api.java.io.jdbc.JDBCOutputFormat;
import org.apache.flink.api.java.typeutils.RowTypeInfo;
import org.apache.flink.types.Row;

/**
 * where("0") 表示使用input1的第一个字段连接
 * equalTo("1") 表示使用input2的第二个字段，判断等于input1的第一个字段的值
 * val result = input1.join(input2).where(0).equalTo(1)
 */
public class FlinkOuterJoin {
    public static void test01() throws Exception {
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
                            if (StringUtils.isNotEmpty((String) value.getField(0))) {
                                return true;
                            }
                            return false;
                        }).map(new MapFunction<Row, User>() {
                    @Override
                    public User map(Row row) throws Exception {
                        System.out.println("userData==>> " + row.getField(0) + "\t" + row.getField(1) + "\t" + row.getField(2));
                        User user = new User();
                        user.setName((String) row.getField(0));
                        user.setPass((String) row.getField(1));
                        user.setAge((Integer) row.getField(2));
                        return user;
                    }
                }).returns(TypeInformation.of(User.class));
        DataSet<User> userData1 =
                env.createInput(
                        JDBCInputFormat.buildJDBCInputFormat()
                                .setDrivername("com.mysql.jdbc.Driver")
                                .setDBUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=PRC")
                                .setUsername("root")
                                .setPassword("123456")
                                .setQuery("select name, grade from sc")
                                .setRowTypeInfo(new RowTypeInfo(BasicTypeInfo.STRING_TYPE_INFO, BasicTypeInfo.INT_TYPE_INFO))
                                .finish()
                ).map((MapFunction<Row, User>) row -> {
                    System.out.println("userData1==>> " + row.getField(0) + "\t" + row.getField(1));
                    User user = new User();
                    user.setName((String) row.getField(0));
                    user.setGrade((Integer) row.getField(1));
                    return user;
                }).returns(TypeInformation.of(User.class));

        userData.leftOuterJoin(userData1, JoinOperatorBase.JoinHint.OPTIMIZER_CHOOSES)
                .where("name")
                .equalTo("name")
                .with((JoinFunction<User, User, User>) (first, second) -> {
                    System.out.println("firName : " + first.getName() + "\t secName : " + second.getName());
                    User user = new User();
                    user.setName(first.getName());
                    user.setPass(first.getPass());
                    user.setAge(first.getAge());
                    user.setGrade(second.getGrade());
                    return user;
                }).map(new MapFunction<User, Row>() {
            @Override
            public Row map(User value) throws Exception {
                return Row.of(value.getName(), value.getPass(), value.getAge(), value.getGrade());
            }
        }).returns(new RowTypeInfo(BasicTypeInfo.STRING_TYPE_INFO, BasicTypeInfo.STRING_TYPE_INFO, BasicTypeInfo.INT_TYPE_INFO, BasicTypeInfo.INT_TYPE_INFO))
                .output(JDBCOutputFormat.buildJDBCOutputFormat()
                        .setDrivername("com.mysql.jdbc.Driver")
                        .setDBUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=PRC")
                        .setUsername("root")
                        .setPassword("123456")
                        .setQuery("insert into allx (name, pass, age,grade) values (?,?,?,?)")
                        .finish());
        env.execute();
    }

}
