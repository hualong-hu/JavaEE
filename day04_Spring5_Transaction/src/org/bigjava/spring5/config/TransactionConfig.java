package org.bigjava.spring5.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @ProjectName: JavaEE
 * @ClassName: Transaction
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-12 18:14
 * @Version v1.0
 */
//配置类
@Configuration
//组件扫描
@ComponentScan(basePackages = "org.bigjava.spring5")
//开启事务
@EnableTransactionManagement
public class TransactionConfig {
    /**
     * 创建数据库连接池
     * @data: 2020-07-12-18:19
     * @method: getDruidDataSource
     * @params: []
     * @return: com.alibaba.druid.pool.DruidDataSource
     */
    @Bean
    public DruidDataSource getDruidDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql:///3306/test");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setName("root");
        dataSource.setPassword("123456");
        return dataSource;
    }
    /**
     * 创建JdbcTemplate对象
     * @data: 2020-07-12-18:23
     * @method: getJdbcTemplate
     * @params: [dataSource]
     * @return: org.springframework.jdbc.core.JdbcTemplate
     */
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //注入datasource
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
    /**
     * 创建事务管理器
     * @data: 2020-07-12-18:25
     * @method: getDataSourceTransactionManager
     * @params: [dataSource]
     * @return: org.springframework.jdbc.datasource.DataSourceTransactionManager
     */
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
