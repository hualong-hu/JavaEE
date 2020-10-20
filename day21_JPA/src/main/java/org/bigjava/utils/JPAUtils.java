package org.bigjava.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @ProjectName: JavaEE
 * @ClassName: JPAUtils
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-11 19:26
 * @Version v1.0
 * 解决实体管理器工厂的浪费资源和耗时问题
 *      通过静态代码块的形式，当程序第一次访问次工具类时，创建一个公共的实体管理器工厂对象
 *
 * 第一次访问getEntityManager()方法，经过静态代码块创建一个managerFactory对象，
 *      再调用方法创建一个EntityManager
 * 第二次访问getEntityManager()方法，直接通过一个已经创建好的managerFactory对象，
 *      创建EntityManager对象
 *
 *
 */
public class JPAUtils {

    private static EntityManagerFactory managerFactory;
    static {
        //1、加载配置文件，创建EntityManagerFactory
        managerFactory = Persistence.createEntityManagerFactory("myJPA");
    }
    /**
     * 获取EntityManager对象
     * @data: 2020-10-11-19:36
     * @method: getEntityManager
     * @params: []
     * @return: javax.persistence.EntityManager
     */
    public static EntityManager getEntityManager(){
        return managerFactory.createEntityManager();
    }
}
