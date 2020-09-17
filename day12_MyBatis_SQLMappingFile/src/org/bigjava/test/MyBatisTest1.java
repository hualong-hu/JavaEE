package org.bigjava.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.bigjava.bean.Key;
import org.bigjava.bean.Lock;
import org.bigjava.dao.KeyDao;
import org.bigjava.dao.LockDao;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: MyBatisTest1
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-02 14:19
 * @Version v1.0
 */
public class MyBatisTest1 {
    SqlSessionFactory sqlSessionFactory;

    @Before
    public void initSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream stream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
    }

    @Test
    public void test1(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        KeyDao keyDao = sqlSession.getMapper(KeyDao.class);
        try {
            Key key = keyDao.getKeyById(1);
            System.out.println("key = " + key);
        } finally {
            sqlSession.close();
        }
    }
    @Test
    public void test2(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        LockDao lockDao = sqlSession.getMapper(LockDao.class);
        try {
            Lock lock = lockDao.getLockById(3);
            System.out.println("lock = " + lock);
            List<Key> keys = lock.getKeys();
            for (Key key : keys) {
                System.out.println("key = " + key);
            }
        } finally {
            sqlSession.close();
        }
    }
}
