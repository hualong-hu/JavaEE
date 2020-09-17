package org.bigjava.conditional;

import org.bigjava.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ProjectName: JavaEE
 * @ClassName: MyImportBeanDefinitionRegistrar
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-16 18:24
 * @Version v1.0
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * AnnotationMetadata:当前类的注解信息
     * BeanDefinitionRegistry：BeanDefinition注册类
     *   把所有需要添加到容器中的bean：调用BeanDefinitionRegistry.registerBeanDefinitions手工注册进来
     * @data: 2020-08-16-18:25
     * @method: registerBeanDefinitions
     * @params: [importingClassMetadata, registry]
     * @return: void
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("org.bigjava.bean.Red");
        boolean definition = registry.containsBeanDefinition("org.bigjava.bean.Blue");
        if (definition && red){
            //指定bean定义信息；（bean的类型，......）
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个Bean，指定Bean名
            registry.registerBeanDefinition("rainBow", rootBeanDefinition);
        }

    }
}
