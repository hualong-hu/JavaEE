package org.bigjava.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ProjectName: JavaEE
 * @ClassName: DogLifeCycle
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-17 15:17
 * @Version v1.0
 */
@Component
public class DogLifeCycle {
    public DogLifeCycle() {
        System.out.println("dog创建");
    }
    //对象创建并赋值之后调用
    @PostConstruct
    public void init(){
        System.out.println("dog...@PostConstruct....");
    }
    //容器移除对象之前调用
    @PreDestroy
    public void destroy(){
        System.out.println("dog...@PreDestroy...");
    }
}
