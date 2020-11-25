package org.bigjava.hibernate1;

import org.bigjava.entity.User;
import org.bigjava.utils.HibernateUtil;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: TestHibernate
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-16 14:58
 * @Version v1.0
 */
public class TestHibernate {

    @Test
    public void testAdd(){
        //		第一步 加载hibernate核心配置文件
//        Configuration configuration = new Configuration();
//        configuration.configure();

        //      第二步 创建SessionFactory对象
        //读取hibernate核心配置文件内容，创建sessionFactory
        //在过程中，根据映射关系，在配置数据库里面把表创建
//        SessionFactory sessionFactory = configuration.buildSessionFactory();


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        //		第三步 使用SessionFactory创建session对象
        Session session = sessionFactory.openSession();
        //		第四步 开启事务
        Transaction transaction = session.beginTransaction();
        //		第五步 写具体逻辑 crud操作
        session.save(new User(null, "断念", "123456", "上海"));
        
        //		第六步 提交事务
        transaction.commit();
        //		第七步 关闭资源
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testQueryById(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        /*
            get()：即时加载
            load()：延时加载
                1、获取的对象是一个动态代理对象
                2、调用load()方法不会立即发送sql语句查询数据库
                    当调用查询结果的时候，才会发送查询的sql语句，什么时候用，什么时候放手sql语句查询数据库
         *      3、得到的是一个动态代理对象
         *      4、什么时候用，什么时候查询！
         */
//        User user = session.get(User.class, 1);
        User user = session.load(User.class, 1);
        System.out.println("user = " + user);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testUpdate(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        /*
            修改操作执行过程
         */
        //1、先根据id查询
        User user = session.get(User.class, 1);
        //2、向返回的user对象中设置修改之后的值
        user.setPassword("666666");
        //3、调用update()方法修改
        session.update(user);


        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testDelete(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        //删除操作
        //第一种方法，先通过id查询到user，在调用delete()方法进行删除
        User user = session.get(User.class, 4);
        session.delete(user);

        //第二种方法
//        User user = new User();
//        user.setId(4);
//        session.delete(user);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testSaveOrUpdate(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        /*
          瞬时态：不存在持久化标识OID (相当于主键值)，尚未与Hibernate Session关联，
                 在数据库中也没有记录，
          持久态：持久态的对象存在持久化标识OID，加入到了Session 缓存中，并且相关联的Session没有关闭
                在数据库中有对应的记录，在数据库中有对应的对象，每条记录只对应唯一的持久化对象
          脱管态(分离，游离)：脱管态对象存在持久化标识OID，并且仍然与数据库中的数据存在关联，只是失去了与当前
                           Session的关联
         */


//        //实体类状态为瞬时态，做添加
//        User user = new User(null, "云澈", "123456", "广州");
//        session.saveOrUpdate(user);

        //实体类状态为托管态，做修改
//        User user = new User(3, "挽念", "8888", "西安");
//        session.saveOrUpdate(user);

        //实体类状态为持久态，做修改
        User user = session.get(User.class, 1);
        user.setPassword("8888888");
        session.saveOrUpdate(user);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testTX(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            User user = session.load(User.class, 1);
            System.out.println("user = " + user);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    @Test
    public void testQueryAll(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();

            transaction = session.beginTransaction();

//            //1、创建Query对象
            Query query = session.createQuery("from User");
            //2、调用query对象里面的方法得到结果
            List<User> list = query.list();
            for (User user : list) {
                System.out.println("user = " + user);
            }

            //1、创建对象，参数是普通的sql语句
//            NativeQuery query = session.createSQLQuery("select * from t_user");
//            //2、调用 NativeQuery 里面的方法，返回list集合，默认里面每部分都是数组结构
//            //返回的list中每部分都是对象形式
//            query.addEntity(User.class);
//            List<User> list = query.list();
//            for (User user : list) {
//                System.out.println("user = " + user);
//            }

//            List<Object[]> list = query.list();
//            for (Object[] objects : list) {
//                System.out.println("objects = " + Arrays.toString(objects));
//            }

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}
