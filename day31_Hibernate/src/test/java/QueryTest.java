import org.bigjava.entity.Customer;
import org.bigjava.entity.LinkMan;
import org.bigjava.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Set;

/**
 * @ProjectName: JavaEE
 * @ClassName: QueryTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-18 23:05
 * @Version v1.0
 */
public class QueryTest {

    /**
     * 对象导航查询，根据id查询客户，再查询这个客户里面所有联系人
     * @data: 2020-11-18-23:06
     * @method: testSelect1
     * @params: []
     * @return: void
     */
    @Test
    public void testSelect1(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            //根据id查询客户，再查询这个客户里面所有联系人
            Customer customer = session.get(Customer.class, 1);
            //再查询这个客户里面所有的联系人
            //直接得到客户里面联系人的set集合
            Set<LinkMan> setLinkMan = customer.getSetLinkMan();
            System.out.println(setLinkMan.size());


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
