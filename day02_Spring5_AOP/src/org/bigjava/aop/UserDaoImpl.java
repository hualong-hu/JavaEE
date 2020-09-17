package org.bigjava.aop;

/**
 * @ProjectName: JavaEE
 * @ClassName: UserDaoImpl
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-09 22:14
 * @Version v1.0
 */
public class UserDaoImpl implements UserDao{

    @Override
    public int add(int a, int b) {
        System.out.println("add方法执行ing！！！");
        return a+b;
    }

    @Override
    public String update(String id) {
        System.out.println("update方法执行ing！！！");
        return id;
    }
}
