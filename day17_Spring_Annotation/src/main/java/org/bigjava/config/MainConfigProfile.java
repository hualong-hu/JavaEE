package org.bigjava.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.bigjava.bean.Red;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import java.beans.PropertyVetoException;

/**
 * @ProjectName: JavaEE
 * @ClassName: MainConfigProfile
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-17 17:38
 * @Version v1.0
 *
 * profile:
 *      Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 *
 * @profile :指定组件在哪个环境的情况下才能被注册到容器中，不指定，任何环境下都能注册这个组件
 *
 * 1）、加了环境标识的bean，只有这个环境被激活才能注册到容器中，默认是default环境
 * 2）、写在配置类上，只有是指定的环境的时候，整个配置类里面的所有的配置才能开始生效
 * 3）、没有标注环境标识的bean在任何环境下都是加载的
 *
 */
//@Profile("test")
@PropertySource("classpath:/jdbc.properties")
@Configuration
public class MainConfigProfile {

    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.driverClass}")
    private String driverClass;

    @Bean(value = "red")
    public Red red(){
        return new Red();
    }

    @Profile("test")
    @Bean(value = "testDataSource")
    public ComboPooledDataSource dataSourceTest(@Value("${jdbc.password}") String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306//test");
        return dataSource;
    }
    @Profile("development")
    @Bean(value = "developmentDataSource")
    public ComboPooledDataSource dataSourceTestDevelopment(@Value("${jdbc.password}") String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306//ssm");
        return dataSource;
    }
    @Profile("produce")
    @Bean(value = "produceDataSource")
    public ComboPooledDataSource dataSourceTestProduce(@Value("${jdbc.password}") String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306//student");
        return dataSource;
    }

}
