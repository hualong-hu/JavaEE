import org.bigjava.entity.Customer;
import org.bigjava.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import org.hibernate.query.Query;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: HQLQueryTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-18 23:14
 * @Version v1.0
 */
public class HQLQueryTest {

    @Test
    public void testQueryAll(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Customer");
            List<Customer> list = query.list();
            for (Customer customer : list) {
                System.out.println("customer = " + customer);
            }

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

    /**
     * 测试条件查询
     * @data: 2020-11-19-13:40
     * @method: testQuery1
     * @params: []
     * @return: void
     */
    @Test
    public void testQuery1(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("from Customer where cid = ?1 and custName = ?2");
            query.setParameter(1, 1);
            query.setParameter(2, "洛笙");
            List<Customer> list = query.list();
            for (Customer customer : list) {
                System.out.println("customer = " + customer);
            }

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

    /**
     * 测试模糊查询
     * @data: 2020-11-19-14:07
     * @method: testQuery2
     * @params: []
     * @return: void
     */
    @Test
    public void testQuery2(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("from Customer where custPhone like ?1");
            query.setParameter(1, "%1%");
            List<Customer> list = query.list();
            for (Customer customer : list) {
                System.out.println("customer = " + customer);
            }

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

    /**
     * 测试排序查询
     * @data: 2020-11-19-14:09
     * @method: testQuery3
     * @params: []
     * @return: void
     */
    @Test
    public void testQuery3(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("from Customer order by cid desc ");
            List<Customer> list = query.list();
            for (Customer customer : list) {
                System.out.println("customer = " + customer);
            }

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

    /**
     * 
     * @data: 2020-11-19-14:15
     * @method: testQuery4
     * @params: []
     * @return: void
     */
    @Test
    public void testQuery4(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            //分页查询
            Query query = session.createQuery("from Customer ");
            //设置分页的开始页码
            query.setFirstResult(0);
            //设置分页的每页记录数
            query.setMaxResults(2);

            List<Customer> list = query.list();
            for (Customer customer : list) {
                System.out.println("customer = " + customer);
            }
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

    /**
     * 投影查询，查询的不是所有字段值，而是部分字段的值
     * @data: 2020-11-19-14:32
     * @method: testQuery5
     * @params: []
     * @return: void
     */
    @Test
    public void testQuery5(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            //分页查询
            Query query = session.createQuery("select cid,custName from Customer ");


            List<Object> list = query.list();
            for (Object o : list) {
                System.out.println("o = " + o);
            }

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

    /**
     * 演示聚合函数
     * @data: 2020-11-19-14:36
     * @method: testQuery6
     * @params: []
     * @return: void
     */
    @Test
    public void testQuery6(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("select count(*) from Customer ");
            Object result = query.uniqueResult();
            Long obj = (Long) result;
            int count  = obj.intValue();

            System.out.println("result = " + count);

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
    public void testQuery7(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            //分页查询
            Query query = session.createQuery("from Customer ");
            //设置分页的开始页码
            query.setFirstResult(0);
            //设置分页的每页记录数
            query.setMaxResults(2);

            List<Customer> list = query.list();
            for (Customer customer : list) {
                System.out.println("customer = " + customer);
            }
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
    public void testDemo(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();



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
