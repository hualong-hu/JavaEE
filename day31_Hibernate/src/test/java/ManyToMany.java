import org.bigjava.entity.Role;
import org.bigjava.entity.User;
import org.bigjava.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl;
import org.junit.Test;

/**
 * @ProjectName: JavaEE
 * @ClassName: ManyToMany
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-18 17:49
 * @Version v1.0
 */
public class ManyToMany {

    @Test
    public void testAdd(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            //添加两个用户，为每个用户添加两个角色
            //1、创建对象
            User user = new User(null, "lucy", "123");
            User user1 = new User(null, "mary", "123");

            Role role = new Role(null, "总经理", "总经理");
            Role role1 = new Role(null, "秘书", "秘书");
            Role role2 = new Role(null, "保安", "保安");

            //2、建立关系，把角色放到用户里面
            user.getSetRole().add(role);
            user.getSetRole().add(role1);

            user1.getSetRole().add(role1);
            user1.getSetRole().add(role2);

            session.save(user);
            session.save(user1);

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
     * 级联删除一般不用
     * @data: 2020-11-18-17:59
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

            User user = session.get(User.class, 1);
            session.delete(user);

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
     * 维护第三张表
     * @data: 2020-11-18-22:56
     * @method: testTable
     * @params: []
     * @return: void
     */
    @Test
    public void testTable(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            //让某个用户有某个角色
            //1、查询用户和角色
            User user = session.get(User.class, 1);
            Role role = session.get(Role.class, 1);

            //2、把角色放到用户的set集合里面
            user.getSetRole().add(role);


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
     * 让某个用户没有某个角色
     * @data: 2020-11-18-23:00
     * @method: testTable2
     * @params: []
     * @return: void
     */
    @Test
    public void testTable2(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            //1、查询用户和角色
            User user = session.get(User.class, 1);
            Role role = session.get(Role.class, 1);

            user.getSetRole().remove(role);

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
