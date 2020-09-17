package org.bigjava.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: JavaEE
 * @ClassName: PersonProxy
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-10 0:15
 * @Version v1.0
 */
@Component
@Aspect
@Order(0)
public class PersonProxy {
    @Before(value = "execution(* org.bigjava.aopanno.User.add())")
    public void before() {
        System.out.println("Person before!!!!");
    }
}
