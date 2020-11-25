package org.bigjava;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * springboot与dubbo整合的三种方式
 * 	1、导入dubbo-starter，在application.properties配置属性，使用@Service【暴露服务】，
 * 		使用@Reference【引用服务】，一定要添加 @EnableDubbo，开启基于注解的dubbo功能
 * 	2、保留dubbo xml配置文件：导入dubbo-starter，使用@ImportResource导入dubbo的配置文件即可
 * 	3、使用注解API的方式
 *
 */
//开启基于注解的dubbo功能
@EnableDubbo

@SpringBootApplication
public class Day27Application {

	public static void main(String[] args) {
		SpringApplication.run(Day27Application.class, args);
	}

}
