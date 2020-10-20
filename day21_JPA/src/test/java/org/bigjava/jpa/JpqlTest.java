package org.bigjava.jpa;

import org.bigjava.bean.Customer;
import org.bigjava.utils.JPAUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: JpqlTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-11 20:20
 * @Version v1.0
 *
 *
 * 进行jpql查询
 *      1、创建query查询对象
 *      2、对参数进行赋值
 *      3、查询，并得到返回结果
 */
public class JpqlTest {

    /**
     * 查询所有数据
     * @data: 2020-10-11-20:26
     * @method: testFindAll
     * @params: []
     * @return: void
     */
    @Test
    public void testFindAll(){
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        //编写jpql语句
        String jpql = "from org.bigjava.bean.Customer";
        //创建Query查询对象，query对象才是执行jpql的对象
        Query query = entityManager.createQuery(jpql);
        //发送查询，并封装结果集
        List list = query.getResultList();

        for (Object o : list) {
            System.out.println("customer = " + o);
        }

        transaction.commit();
        entityManager.close();
    }

    /**
     * 倒序查询所有数据
     * @data: 2020-10-11-23:17
     * @method: testOrders
     * @params: []
     * @return: void
     */
    @Test
    public void testOrders(){
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String jpql = "from Customer order by custId desc";
        Query query = entityManager.createQuery(jpql);
        List list = query.getResultList();
        for (Object o : list) {
            System.out.println("customer = " + o);
        }
        transaction.commit();
        entityManager.close();
    }

    /**
     * 查询个数
     * @data: 2020-10-11-23:25
     * @method: testCount
     * @params: []
     * @return: void
     */
    @Test
    public void testCount(){
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String jpql = "select count(custId) from Customer";
        Query query = entityManager.createQuery(jpql);

        /*
            getResultList()：直接将查询结果封装到list集合
            getSingleResult()：得到唯一的结果集
         */
        Object result = query.getSingleResult();
        System.out.println("result = " + result);
        transaction.commit();
        entityManager.close();
    }

    @Test
    public void testPage(){
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String jpql = "from Customer";
        Query query = entityManager.createQuery(jpql);
        //对参数赋值
        //起始索引赋值
        query.setFirstResult(0);
        //每页查询的条数
        query.setMaxResults(2);

        List list = query.getResultList();
        for (Object o : list) {
            System.out.println("customer = " + o);
        }
        transaction.commit();
        entityManager.close();

    }

    /**
     * 条件查询
     * @data: 2020-10-11-23:37
     * @method: test
     * @params: []
     * @return: void
     */
    @Test
    public void test(){

        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String jpql = "from Customer where custName like ?1";
        Query query = entityManager.createQuery(jpql);
        //第一个参数：占位符的索引位置（从1开始）；第二个参数：占位符的取值
        query.setParameter(1, "洛%");
        List list = query.getResultList();
        for (Object o : list) {
            System.out.println("customer = " + o);
        }

    }

}
