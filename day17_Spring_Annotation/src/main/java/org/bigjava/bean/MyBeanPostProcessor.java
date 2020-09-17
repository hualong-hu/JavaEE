package org.bigjava.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: JavaEE
 * @ClassName: MyBeanPostProcessor
 * @Description: 后置处理器：初始化前后进行处理工作
 * @Author: 洛笙
 * @Date: 2020-08-17 15:29
 * @Version v1.0
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization....."+o);
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization......"+o);
        return o;
    }
}
