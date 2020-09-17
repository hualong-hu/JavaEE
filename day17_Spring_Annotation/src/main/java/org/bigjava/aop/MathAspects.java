package org.bigjava.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ProjectName: JavaEE
 * @ClassName: MathAspects
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-18 13:30
 * @Version v1.0
 */
@Aspect
@Component
public class MathAspects {
    /**
     * 抽取公共的切入点表达式
     * @data: 2020-08-18-13:52
     * @method: pointcut
     * @params: []
     * @return: void
     */
    @Pointcut("execution(* org.bigjava.aop.*.*(..))")
    public void pointcut(){

    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        //获取切入点名称（切入点：实际真正被增强的方法）
        String name = joinPoint.getSignature().getName();
        //获取切入点的参数
        Object[] args = joinPoint.getArgs();
        System.out.println(name+"运行之前..@Before..参数列表是：{"+ Arrays.toString(args) +"}");
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"运行结束...@After...");
    }
    //获取切入点返回值
    @AfterReturning(value = "pointcut()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"正常返回..@AfterReturning..运行结果是：{"+result+"}");
    }
    //获取切入点异常信息
    @AfterThrowing(value = "pointcut()",throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint,Exception exception){
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"运行异常..@AfterThrowing...异常信息是：{"+exception+"}");
    }

//    @Around("pointcut()")
//    public void around(){
//
//    }

}
