import org.bigjava.entity.Customer;
import org.bigjava.entity.LinkMan;
import org.bigjava.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * @ProjectName: JavaEE
 * @ClassName: OneToMany
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-18 10:28
 * @Version v1.0
 */
public class OneToMany {
    /**
     * 演示一对多级联添加
     * @data: 2020-11-18-10:28
     * @method: testAdd
     * @params: []
     * @return: void
     */
    @Test
    public void testAdd(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            //添加一个客户，为这个客户添加一个联系人
            //1、创建客户和联系人对象
            Customer customer = new Customer(null, "断念", "SVIP", "网络", "110", "119");
            LinkMan linkMan = new LinkMan(null, "小马", "男", "911");
            LinkMan linkMan1 = new LinkMan(null, "小王", "男", "111");

            //2、在客户里表示所有联系人，在联系人里表示所有客户，建立客户对象和联系人对象关系
            //2.1把联系人对象放到客户对象的set集合里面
            customer.getSetLinkMan().add(linkMan);
            customer.getSetLinkMan().add(linkMan1);


            //3、保存到数据库
            session.save(customer);
            session.save(linkMan);


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
     * 一对多的级联删除
     * @data: 2020-11-18-10:51
     * @method: testDelete
     * @params: []
     * @return: void
     */
    @Test
    public void testDelete(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            //1、根据id查询出客户对象
            Customer customer = session.get(Customer.class, 2);
            //2、调用方法删除
            session.delete(customer);

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
    public void testUpdate(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            //1、根据id查询联系人，根据id查询客户
            Customer customer = session.get(Customer.class, 1);
            LinkMan linkMan = session.get(LinkMan.class, 5);
            //2、设置持久态对象值
            //把联系人放到客户里面
            customer.getSetLinkMan().add(linkMan);
            //把客户放到联系人里面
            linkMan.setCustomer(customer);

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

            Customer customer = session.get(Customer.class, 1);
            LinkMan linkMan = new LinkMan(null, "龙玺文", "男", "110");
            customer.getSetLinkMan().add(linkMan);
            linkMan.setCustomer(customer);


            session.save(customer);
            session.save(linkMan);


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
