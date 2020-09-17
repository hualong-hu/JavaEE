package org.bigjava.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @ProjectName: JavaEE
 * @ClassName: SpringConfig
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-19 13:52
 * @Version v1.0
 */
//Spring不扫描controller，是个父容器
@ComponentScan(value = "org.bigjava",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
})
@Configuration
public class SpringConfig {
}
