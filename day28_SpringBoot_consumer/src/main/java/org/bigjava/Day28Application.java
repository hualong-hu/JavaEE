package org.bigjava;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class Day28Application {

	public static void main(String[] args) {
		SpringApplication.run(Day28Application.class, args);
	}

}
