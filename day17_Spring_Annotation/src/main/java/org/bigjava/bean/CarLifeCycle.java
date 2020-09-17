package org.bigjava.bean;

/**
 * @ProjectName: JavaEE
 * @ClassName: CarLifeCycle
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-17 13:21
 * @Version v1.0
 */
public class CarLifeCycle {

    public CarLifeCycle() {
        System.out.println("car创建");
    }
    public void init(){
        System.out.println("car初始化");
    }
    public void destroy(){
        System.out.println("car销毁");
    }

}
