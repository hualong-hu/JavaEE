package org.bigjava.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.bigjava.bean.Employee;
import org.bigjava.dao.EmployeeDAO;
import org.bigjava.dao.EmployeeDaoAnnotation;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ProjectName: JavaEE
 * @ClassName: MybatisTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-29 17:57
 * @Version v1.0
 */
public class MybatisTest {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void initSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test1() {
        /*
            1、根据全局配置文件创建出一个SqlSessionFactory
            SqlSessionFactory：是SqlSession工厂，负责创SqlSession对象
            SqlSession：sql会话（代表和数据库的一次会话）
         */
        //2、获取和数据库的一次会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3、使用sqlSession操作数据库，获取dao接口的实现
        EmployeeDAO employeeDAO = sqlSession.getMapper(EmployeeDAO.class);
        try {
            Employee employee = employeeDAO.getEmployeeById(1);
            System.out.println("employee = " + employee);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test2(){
        SqlSession sqlSession =sqlSessionFactory.openSession(true);;
        EmployeeDAO employeeDAO = sqlSession.getMapper(EmployeeDAO.class);
        try {

            int i = employeeDAO.insertEmployee(new Employee(null, "tomcat", "tomcat@qq.com", 1));
            System.out.println("受影响的行数为："+i);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test3(){
        SqlSession sqlSession =sqlSessionFactory.openSession(true);;
        EmployeeDAO employeeDAO = sqlSession.getMapper(EmployeeDAO.class);
        try {

            int i = employeeDAO.deleteEmployee(2);
            System.out.println("受影响的行数为："+i);
        } finally {
            sqlSession.close();
        }
    }
    @Test
    public void test4(){
        SqlSession sqlSession =sqlSessionFactory.openSession(true);;
        EmployeeDAO employeeDAO = sqlSession.getMapper(EmployeeDAO.class);
        try {
            int i = employeeDAO.updateEmployee(new Employee(1, "洛笙", "luosheng@qq.com", 1));
            System.out.println("受影响的行数为："+i);
        } finally {
                sqlSession.close();
        }
    }

    @Test
    public void test5(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeDaoAnnotation mapper = sqlSession.getMapper(EmployeeDaoAnnotation.class);
        try {
            Employee employee = mapper.getEmployeeById(1);
            System.out.println("employee = " + employee);
        } finally {
            sqlSession.close();
        }
    }
}
