package org.bigjava.config;

import org.bigjava.aop.MathAspects;
import org.bigjava.aop.MyMath;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * @ProjectName: JavaEE
 * @ClassName: MainConfigAOP
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-18 13:38
 * @Version v1.0
 *
 * AOP：【动态代理】
 *      值在程序运行期间动态的讲某段代码切入到指定方法指定位置进行运行的编码方式
 *
 * 1、导入AOP模块：spring-aspects
 * 2、定义一个业务逻辑类（Math）：在业务逻辑运行的时候将日志进行打印
 * 3、定义一个切面类（MathAspects）：切面类里面的方法需要动态感知Math.division运行到
 *      通知方法：
 *          @Before 前置通知：在目标方法（Math.division）运行之前运行
 *          @After  后置通知：在目标方法（Math.division）运行之后运行
 *          @AfterReturning 返回通知：在目标方法（Math.division）正常返回之后运行
 *          @AfterThrowing 异常通知：在目标方法（Math.division）出现异常后运行
 *          @Around 环绕通知：动态代理，手动推进目标方法（Math.division）运行（joinPoint.procced()）
 * 4、给切面类的目标方法标注何时何地运行（通知注解）；
 * 5、将切面类和业务逻辑类（目标方法所在类）都加入到容器中;
 * 6、必须告诉Spring哪个类是切面类(给切面类上加一个注解：@Aspect)
 * [7]、给配置类中加 @EnableAspectJAutoProxy 【开启基于注解的aop模式】
 * 		在Spring中很多的 @EnableXXX;
 *
 * 三步：
 *   1）、将业务逻辑组件和切面类都加入到容器中；告诉Spring哪个是切面类（@Aspect）
 *   2）、在切面类上的每一个通知方法上标注通知注解，告诉Spring何时何地运行（切入点表达式）
 *   3）、开启基于注解的aop模式；@EnableAspectJAutoProxy
 *
 *
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(value = "org.bigjava.aop")
public class MainConfigAOP {

//    @Bean
//    public MyMath myMath(){
//        return new MyMath();
//    }
//
//    @Bean
//    public MathAspects mathAspects(){
//        return new MathAspects();
//    }
}
