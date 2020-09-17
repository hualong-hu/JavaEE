package org.bigjava.aopanno;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: JavaEE
 * @ClassName: UserProxy
 * @Description: 增强的类
 * @Author: 洛笙
 * @Date: 2020-07-09 23:39
 * @Version v1.0
 */
@Component
@Aspect
public class UserProxy {
    @Pointcut(value = "execution(* org.bigjava.aopanno.User.add(..))")
    public void log() {

    }
    //@Before 注解表示作为前置通知
    @Before(value = "log()")
    public void before(){
        System.out.println("before！！！");
    }

    //@After最终通知，有异常也执行
    @After(value = "log()")
    public void after(){
        System.out.println("after！！！");
    }
    //@AfterReturning后置通知（返回通知）有异常不执行
    @AfterReturning(value = "log()")
    public void afterReturning(){
        System.out.println("AfterReturning！！！");
    }

    //@AfterThrowing异常通知，有异常时执行
    @AfterThrowing(value = "log()")
    public void afterThrowing(){
        System.out.println("AfterThrowing！！！");
    }

    // @Around环绕通知，在方法执行前后执行
    @Around(value = "log()")
    public void around(ProceedingJoinPoint point){
        System.out.println("环绕之前！！！");

        //被增强的方法执行
        try {
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("环绕之后！！！");
    }
}
