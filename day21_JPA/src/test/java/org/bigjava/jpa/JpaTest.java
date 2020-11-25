package org.bigjava.jpa;

import org.bigjava.bean.Customer;
import org.bigjava.utils.JPAUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @ProjectName: JavaEE
 * @ClassName: JpaTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-11 11:10
 * @Version v1.0
 */
public class JpaTest {

    @Test
    public void testSave(){
//        //1、加载配置文件创建工厂（实体类管理器工厂）对象
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJPA");
//        //2、通过实体类管理器工厂获取实体管理器
//        EntityManager entityManager = factory.createEntityManager();

        EntityManager entityManager = JPAUtils.getEntityManager();
        //3、获取事务对象，开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //4、完成增删改查操作，保存一个客户到数据库中
        Customer customer = new Customer(null, "洛笙", "推广", "SVIP", "IT", "110", "抚州");
        //保存客户到数据库
        entityManager.persist(customer);
        //5、提交事务
        transaction.commit();
        //6、释放资源
        entityManager.close();
//        factory.close();
    }

    /**
     * 根据id查询客户
     * 使用find()方法查询（立即加载）：
     *      1、查询的对象就是当前客户端对象本身
     *      2、在调用find方法是，就会立即方式sql语句查询数据库
     *
     * @data: 2020-10-11-19:39
     * @method: testFind
     * @params: []
     * @return: void
     */
    @Test
    public void testFind(){
        //1、通过自定义的工具类获取entityManager
        EntityManager entityManager = JPAUtils.getEntityManager();
        //2、通过entityManager对象获取事务并开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        /*
         *  3、通过entityManager调用find()查询表中数据
         *      find()：根据id查询数据
         *          第一个参数：查询数据的结果需要包装的实体类类型
         *          第二个参数：查询的主键
         *
         */
        Customer customer = entityManager.find(Customer.class, 1);
        System.out.println("customer = " + customer);
        //4、提交事务
        transaction.commit();
        //5、释放资源
        entityManager.close();
    }
    /**
     * 根据id查询客户
     *      getReference()
     *          1、获取的对象是一个动态代理对象
     *          2、调用getReference()方法不会立即发送sql语句查询数据库
     *              当调用查询结果的时候，才会发送查询的sql语句，什么时候用，什么时候放手sql语句查询数据库
     *
     * 延时加载（懒加载）：
     *      1、得到的是一个动态代理对象
     *      2、什么时候用，什么时候查询！
     *
     * @data: 2020-10-11-19:59
     * @method: testGetReference
     * @params: []
     * @return: void
     */
    @Test
    public void testGetReference(){
        //1、通过自定义的工具类获取entityManager
        EntityManager entityManager = JPAUtils.getEntityManager();
        //2、通过entityManager对象获取事务并开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        /*
         *  3、通过entityManager调用getReference()查询表中数据
         *      getReference()：根据id查询数据
         *          第一个参数：查询数据的结果需要包装的实体类类型
         *          第二个参数：查询的主键
         *
         */
        Customer customer = entityManager.getReference(Customer.class, 1);
        System.out.println("customer = " + customer);
        //4、提交事务
        transaction.commit();
        //5、释放资源
        entityManager.close();
    }
    /**
     * 根据id删除数据
     * @data: 2020-10-11-20:12
     * @method: testRemove
     * @params: []
     * @return: void
     */
    @Test
    public void testRemove(){
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //根据id删除数据
        //i、根据id查询客户
        Customer customer = entityManager.getReference(Customer.class, 3);
        //ii、调用remove()方法完成删除操作
        entityManager.remove(customer);
        System.out.println("删除成功！！");
        transaction.commit();
        entityManager.close();
    }

    /**
     * 更新数据
     * @data: 2020-10-11-20:16
     * @method: testUpdate
     * @params: []
     * @return: void
     */
    @Test
    public void testUpdate(){
        EntityManager entityManager = JPAUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //更新数据
        //i、先根据id查询客户
        Customer customer = entityManager.getReference(Customer.class, 2);
        //ii、设置客户数据
        customer.setCustAddress("南昌");
        //iii、更新客户
        entityManager.merge(customer);

        System.out.println("数据更新成功！");
        Customer customer1 = entityManager.getReference(Customer.class, 2);
        System.out.println("customer = " + customer1);
        transaction.commit();
        entityManager.close();
    }




}
