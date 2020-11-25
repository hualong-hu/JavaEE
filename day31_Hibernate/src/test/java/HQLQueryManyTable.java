
import org.bigjava.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: HQLQueryManyTable
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-19 14:47
 * @Version v1.0
 */
public class HQLQueryManyTable {
    @Test
    public void testQuery1(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            /*
                迫切内连接：from Customer c inner join fetch c.setLinkMan
                内连接：from Customer c inner join c.setLinkMan

                迫切内连接返回list每部分是对象
                内连接返回list中每部分是数组
             */

            Query query = session.createQuery("from Customer c inner join c.setLinkMan");

            //迫切内连接查询输出
//            List list = query.list();
//            for (Object o : list) {
//                System.out.println("o = " + o);
//            }
            //内连接查询输出
            List<Object[]> list = query.list();
            for (Object[] objects : list) {
                System.out.println("objects = " + Arrays.toString(objects));
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
    public void testQuery2(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            /*
                左外连接：from Customer c left join c.setLinkMan
                迫切左外连接：from Customer c left join fetch c.setLinkMan

                迫切左外连接返回list每部分是对象
                左外连接返回list中每部分是数组
             */

            Query query = session.createQuery("from Customer c left join c.setLinkMan");
            List<Object[]> list = query.list();
            for (Object[] objects : list) {
                System.out.println("objects = " + Arrays.toString(objects));
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
}
