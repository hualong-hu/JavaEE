package org.bigjava.aopanno;

import org.springframework.stereotype.Component;

/**
 * @ProjectName: JavaEE
 * @ClassName: Student
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-10 0:21
 * @Version v1.0
 */
@Component
public class Student {
    public void show(){
        System.out.println("方法执行ing！！！！");
    }
}
