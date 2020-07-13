//package com.example.demo;
//
//import com.sugar.creditda.cust.test.common.AbstractTestNG;
//import com.sugarboot.spring.SpringSugarConfiguration;
//import org.apache.commons.dbcp2.BasicDataSource;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.testng.annotations.Test;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.SQLException;
//
//@SpringBootTest(classes = SpringSugarConfiguration.class)
//public class DataSourceTestCase extends AbstractTestNG {
//
//    @Resource
//    private DataSource dataSourceSec;
//
//    @Test
//    public void test01() throws SQLException {
//        //一、实例化BasicDataSource
//        BasicDataSource bs = new BasicDataSource();
//        //二、设置BasicDataSource属性
//        //1、设置四个属性
//        bs.setDriverClassName("com.mysql.jdbc.Driver");
//        bs.setUrl("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF8");
//        bs.setUsername("root");
//        bs.setPassword("123456");
//        //2、设置连接是否默认自动提交
//        bs.setDefaultAutoCommit(true);
//        //3、设置初始化后连接数
//        bs.setInitialSize(1);
//        //4、设置最大的连接数
//        bs.setMaxTotal(2);
//        //5、设置空闲等待时间，获取连接后没有操作开始计时，到达时间后没有操作回收链接
//        bs.setMaxIdle(3000);
//
//        //三、测试获取连接
//        Connection c1 = bs.getConnection();
//        System.out.println(c1.getMetaData().getURL());
//        System.out.println("888888888888888888888");
//        JdbcTemplate template = new JdbcTemplate(bs);
//        System.out.println(template.queryForMap("SELECT * FROM user WHERE id = 1").get("name"));
//        c1.close();
//        bs.close();
//    }
//
//    @Test
//    public void test02() throws SQLException {
//        System.out.println(dataSourceSec);
//        System.out.println(dataSourceSec.getConnection().getMetaData().getURL());
//        System.out.println("999999999999999999");
//        JdbcTemplate template = new JdbcTemplate(dataSourceSec);
//        System.out.println(template.queryForMap("SELECT * FROM user WHERE id = 1").get("name"));
//    }
//}
