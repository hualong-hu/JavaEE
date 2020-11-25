package org.bigjava.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @ProjectName: JavaEE
 * @ClassName: HibernateUtil
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-16 15:37
 * @Version v1.0
 */
public class HibernateUtil {
    private static final Configuration configuration;
    private static final SessionFactory sessionFactory;

    static {
        configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
