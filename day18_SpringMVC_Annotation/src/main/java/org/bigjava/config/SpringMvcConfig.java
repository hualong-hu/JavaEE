package org.bigjava.config;

import org.bigjava.interceptor.MyFirstInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @ProjectName: JavaEE
 * @ClassName: SpringMvcConfig
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-19 13:54
 * @Version v1.0
 */
//SpringMVC只扫描controller，是个子容器
//useDefaultFilters = false：禁用默认过滤规则
@ComponentScan(value = "org.bigjava",includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
},useDefaultFilters = false)
@Configuration
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {

    /**
     * 配置视图解析器
     *
     * @data: 2020-08-19-14:44
     * @method: configureViewResolvers
     * @params: [registry]
     * @return: void
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //默认所有的页面都从"/WEB-INF/"下开始找 ".jsp"结尾的
        registry.jsp("/WEB-INF/views/",".jsp");
    }
    /**
     * 配置静态资源
     * @data: 2020-08-19-15:17
     * @method: configureDefaultServletHandling
     * @params: [configurer]
     * @return: void
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    /**
     * 配置拦截器
     * @data: 2020-08-19-15:21
     * @method: addInterceptors
     * @params: [registry]
     * @return: void
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyFirstInterceptor()).addPathPatterns("/**");
    }
}
