//
//import org.apache.commons.dbcp2.BasicDataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DbSourceConfig {
//
//    @Primary
//    @Bean(name = "defaultDataSource")
//    public DataSource dataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");
//        //2、设置连接是否默认自动提交
//        dataSource.setDefaultAutoCommit(true);
//        //3、设置初始化后连接数
//        dataSource.setInitialSize(1);
//        //4、设置最大的连接数
//        dataSource.setMaxTotal(2);
//        //5、设置空闲等待时间，获取连接后没有操作开始计时，到达时间后没有操作回收链接
//        dataSource.setMaxIdle(3000);
//        return dataSource;
//    }
//
//    @Bean(name = "dataSourceSec")
//    public DataSource dataSourceSec() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");
//        //2、设置连接是否默认自动提交
//        dataSource.setDefaultAutoCommit(true);
//        //3、设置初始化后连接数
//        dataSource.setInitialSize(1);
//        //4、设置最大的连接数
//        dataSource.setMaxTotal(2);
//        //5、设置空闲等待时间，获取连接后没有操作开始计时，到达时间后没有操作回收链接
//        dataSource.setMaxIdle(3000);
//        return dataSource;
//    }
//
//}
