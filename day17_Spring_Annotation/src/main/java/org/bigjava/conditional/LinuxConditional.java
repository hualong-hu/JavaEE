package org.bigjava.conditional;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是否是linux系统
 * @ProjectName: JavaEE
 * @ClassName: LinuxConditional
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-16 16:44
 * @Version v1.0
 */
public class LinuxConditional implements Condition {
    /**
     * ConditionContext：判断条件能使用的上下文（环境）
     * AnnotatedTypeMetadata：注释信息
     * @data: 2020-08-16-17:12
     * @method: matches
     * @params: [context, metadata]
     * @return: boolean
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //是否linux系统
        //1、获取到IOC使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2、获取到类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3、获取当前环境信息
        Environment environment = context.getEnvironment();
        //4、获取到bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        String property = environment.getProperty("os.name");
        if (property.contains("Linux")){
            return true;
        }
        return false;
    }
}
