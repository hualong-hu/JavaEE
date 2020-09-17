package org.bigjava.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.bigjava.bean.User;
import org.bigjava.dao.UserDao;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: UserTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-04 17:04
 * @Version v1.0
 */
public class UserTest {
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
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        try {
            User user = userDao.getUserById(1);
            System.out.println("user = " + user);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test2(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        try {
            User user = new User();
            user.setId(1);
            user.setPhone("%5%");
            List<User> userList = userDao.getAllUsers(user);
            for (User user1 : userList) {
                System.out.println("user = " + user1);
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test3(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<User> idsUsers = userDao.getUsersForeach(list);
        for (User idsUser : idsUsers) {
            System.out.println("User = " + idsUser);
        }
    }
    @Test
    public void test4(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
//        user.setId(2);
//        user.setName("林志颖");
        List<User> users = userDao.getUsersChoose(user);
        for (User user1 : users) {
            System.out.println("user = " + user1);
        }

    }

    @Test
    public void test5(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        try {
            User user = new User();
            user.setId(1);
            user.setName("洛笙");
            int i = userDao.updateUser(user);
            System.out.println("受影响的行数为"+i);
        } finally {
            sqlSession.close();
        }
    }
}
