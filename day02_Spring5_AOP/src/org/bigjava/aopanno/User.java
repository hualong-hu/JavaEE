package org.bigjava.aopanno;

import org.springframework.stereotype.Component;

/**
 * @ProjectName: JavaEE
 * @ClassName: User
 * @Description: 被增强类
 * @Author: 洛笙
 * @Date: 2020-07-09 23:39
 * @Version v1.0
 */
@Component
public class User {
    public void add(){
        System.out.println("add方法执行ing！！！！");
    }
}
