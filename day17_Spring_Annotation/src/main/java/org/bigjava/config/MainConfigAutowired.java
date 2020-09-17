package org.bigjava.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: JavaEE
 * @ClassName: MainConfigAutowired
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-17 16:12
 * @Version v1.0
 *
 * 自动装配：
 *      Spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖关系赋值
 *
 * 1)、@Autowired：自动注入
 *      ①默认优先安置类型去容器中找对应的组件：
 *      ②如果找到多个相同的组件，再讲属性的名称作为组件的id去容器中查找
 *      ③使用@Qualifier("bookMapper")指定需要装配的组件的id，而不是使用属性名
 *      ④自动装配默认一定要将属性赋值好，没有就会报错
 *          可以使用@Autowired(required = false)
 *      ⑤@Primary，让Spring进行自动装配的时候，默认使用首先的bean；
 *          也可以继续使用@Qualifier指定需要装配的bean的id
 *
 * 2)、Spring还支持使用@Resource(name = "")（JSR250） @Inject（JSR330）【java规范的注释】
 *      @Resource (name = "")：
 *          可以和@Autowired一样实现自动装配功能，默认是按照组件名称进行装配的
 *          没有能支持@Primary功能也不支持@Autowired(required = false)
 *      @Inject
 *          需要导入javax.inject的包，和@Autowired的功能一样，没有@Autowired(required = false)的功能
 * 3)、@Autowired：还可以标注在构造器、参数、方法、属性；都是从容器中获取参数组件的值
 *      ①【标注在方法位置】：@Bean+方法参数；参数从容器中获取；默认不写@Autowired效果是一样的
 *                        都能自动装配
 *      ②【标注在构造器上】：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，
 *                        参数位置的组件还是可以自动从容器中获取
 *
 * 4)、自定义组件想要使用Spring容器底层的一些组件（ApplicationContext,BeanFactory.....）
 *      自定义组件实现xxxAware；在创建对象的时候，会调用接口规定的方法注入相关组件：Aware；
 *      把spring底层一些组件注入到自定义的Bean中；
 *      xxxAware：功能使用xxxProcessor
 */
@Configuration
@ComponentScan(value = {"org.bigjava.service","org.bigjava.controller","org.bigjava.mapper"})
public class MainConfigAutowired {

}
