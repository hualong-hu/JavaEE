package org.bigjava.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @ProjectName: JavaEE
 * @ClassName: JdkProxy
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-09 22:15
 * @Version v1.0
 */
public class JdkProxy {

    public static void main(String[] args) {
        //创建接口实现代理对象
        //方法一
        Class[] interfaces = {UserDao.class};
        UserDao userDao = (UserDao) Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("方法执行前");
                UserDaoImpl userDao = new UserDaoImpl();
                Object invoke = method.invoke(userDao, args);
                System.out.println("方法执行之后！！！");
                return invoke;
            }
        });
        int result = userDao.add(11, 22);
        System.out.println("result = " + result);
            //方法二
//        Class[] interfaces = {UserDao.class};
//        UserDao userDao = (UserDao) Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), interfaces, new UserProxy(new UserDaoImpl()));
//        int result = userDao.add(3, 4);
//        System.out.println("result = " + result);

    }
}
/**
 * 创建代理对象代码
 */
class UserPorxy implements InvocationHandler{


    /**
     *1.创建的是谁的代理对象，把谁传递过来
     * 有参构造器
     */
    private Object obj;
    public UserPorxy(Object obj) {
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法之前
        System.out.println("执行的方法是："+method.getName()+";传递的参数是："+ Arrays.toString(args));
        //被增强的方法执行
        Object invoke = method.invoke(obj, args);
        //方法之后
        System.out.println("方法执行之后输出！！！该方法对象是："+obj);


        return invoke;
    }
}