package org.bigjava.config;

import org.bigjava.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ProjectName: JavaEE
 * @ClassName: MainConfigPropertyValue
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-17 15:53
 * @Version v1.0
 */
/*使用@PropertySource读取外部配置文件中的key与value保存到运行的环境变量中
    加载完外部的配置文件以后使用 ${} 取出配置文件的值·
 */
@PropertySource(value = {"classpath:person.properties"})
@Configuration
public class MainConfigPropertyValue {

    @Bean
    public Person person(){
        return new Person();
    }
}
