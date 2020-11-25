import org.bigjava.entity.Customer;
import org.bigjava.utils.HibernateUtil;
import org.hibernate.*;
import org.hibernate.graph.RootGraph;
import org.junit.Test;

import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: QBCQueryTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-18 23:31
 * @Version v1.0
 */
public class QBCQueryTest {

    @Test
    public void testDemo1(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Criteria criteria = session.createCriteria(Customer.class);
            List<Customer> list = criteria.list();
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


}
