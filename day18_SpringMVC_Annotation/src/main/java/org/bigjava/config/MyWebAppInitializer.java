package org.bigjava.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @ProjectName: JavaEE
 * @ClassName: MyWebAppInitializer
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-19 13:44
 * @Version v1.0
 * web容器启动时创建对象，调用方法来初始化容器以及前端控制器
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 获取根容器的配置类；（Spring的配置文件） 父容器
     * @data: 2020-08-19-13:45
     * @method: getRootConfigClasses
     * @params: []
     * @return: java.lang.Class<?>[]
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }
    /**
     * 获取web容器的配置类（SpringMVC的配置文件） 子容器
     * @data: 2020-08-19-13:47
     * @method: getServletConfigClasses
     * @params: []
     * @return: java.lang.Class<?>[]
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }
    /**
     * 获取DispatcherServlet的映射信息
     * /: 拦截所有请求（包括*.js，*.png），但不包括*.jsp
     * /* ：拦截所有请求，连*.jsp都拦截；jsp页面是tomcat的jsp引擎解析的
     * @data: 2020-08-19-13:47
     * @method: getServletMappings
     * @params: []
     * @return: java.lang.String[]
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
