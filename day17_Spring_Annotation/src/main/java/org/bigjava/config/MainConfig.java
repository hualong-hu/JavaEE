package org.bigjava.config;

import org.bigjava.bean.Person;
import org.bigjava.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;


/**
 * @ProjectName: JavaEE
 * @ClassName: MainConfig
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-16 12:45
 * @Version v1.0
 */
//配置类 == 配置文件
//告诉Spring这是一个配置类
@Configuration
//ComponentScan   value：指定要扫描的包，
/*
    excludeFilters() = Filter[] 指定扫描的时候按照扫描规则排除组件
    includeFilters() = Filter[] 指定扫描的时候只需要包含哪些组件
    FilterType.ANNOTATION 按照注解
    FilterType.ASSIGNABLE_TYPE 按照给定的类型
 */
@ComponentScan(value = "org.bigjava",includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
},useDefaultFilters = false)
public class MainConfig {

    @Bean(value = "person")
    //给容器中注册一个Bean；类型为返回值类型，id默认是方法名
    //value:给组件取名
    public Person person01(){
        return new Person("云澈", 30);
    }
}
