package org.bigjava.aop;

import org.springframework.stereotype.Component;

/**
 * @ProjectName: JavaEE
 * @ClassName: Math
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-18 13:29
 * @Version v1.0
 */
@Component
public class MyMath {

    public int division(int i , int j){
        System.out.println("除法开始运行....");
        return i/j;
    }
}
