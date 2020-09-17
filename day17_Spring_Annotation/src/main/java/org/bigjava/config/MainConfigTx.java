package org.bigjava.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @ProjectName: JavaEE
 * @ClassName: MainConfigTx
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-18 16:47
 * @Version v1.0
 *
 * 声明式事务
 *  1、导入相关依赖
 *      数据源、数据库驱动、Spring-jdbc模块
 *  2、配置数据源：JdbcTemplate（Spring提供的简化数据库操作的工具）操作数据库
 *  3、给Service方法上标注@Transactional，表示当前方法是一个事务方法
 *  4、@EnableTransactionManagement  开启一个基于注解的事务管理功能；
 *  5、配置事务管理器控制事务
 *      @Bean
 *     public PlatformTransactionManager transactionManager(){
 *         return new DataSourceTransactionManager(dataSource());
 *     }
 */
@ComponentScan(value = "org.bigjava.tx")
@PropertySource("classpath:/jdbc.properties")
@Configuration
@EnableTransactionManagement
public class MainConfigTx {

    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.driverClass}")
    private String driverClass;
    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        //Spring对@Configuration类会特殊处理，给容器中加组件的方法，多次调用都只是从容器中找组件
        return new JdbcTemplate(dataSource());
    }
    //注册事务管理器
    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}
