package org.bigjava.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: JavaEE
 * @ClassName: StudentProxy
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-10 0:21
 * @Version v1.0
 */
@Component
@Aspect
@Order(0)
public class StudentProxy {

    @Pointcut(value = "execution(* org.bigjava.aopanno.Student.show())")
    public void start() {}

    @Before(value = "start()")
    public void before(){
        System.out.println("before!!!!!!");
    }

    @After(value = "start()")
    public void after(){
        System.out.println("after!!!!!!");
    }

    @AfterReturning(value = "start()")
    public void afterReturning(){
        System.out.println("afterReturning!!!!!!");
    }

    @AfterThrowing(value = "start()")
    public void afterThrowing(){
        System.out.println("afterThrowing!!!!!!");
    }

    @Around(value = "start()")
    public void around(ProceedingJoinPoint point){
        System.out.println("Around before!!!!!!");

        try {
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("Around after!!!!!!!!");
    }

}
