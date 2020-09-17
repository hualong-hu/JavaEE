package org.bigjava.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.bigjava.bean.Employee;
import org.bigjava.dao.EmployeeDAO;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: MyBatisTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-07-31 16:54
 * @Version v1.0
 */
public class MyBatisTest {
    SqlSessionFactory sqlSessionFactory;

    @Before
    public void initSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream stream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
    }

    @Test
    public void test1(){
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession(true);
            EmployeeDAO employeeDAO = sqlSession.getMapper(EmployeeDAO.class);
            Employee employee = employeeDAO.getEmployeeById(1);
            System.out.println(employee);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public void test2(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeDAO employeeDAO = sqlSession.getMapper(EmployeeDAO.class);
        try {
            Employee employee = new Employee(null, "断念", "duannian@qq.com", 1);
            int i = employeeDAO.insertEmployee(employee);
            System.out.println("----->"+i);
            System.out.println("----->"+employee.getId());
        } finally {
            sqlSession.close();
        }
    }
    @Test
    public void test3(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeDAO employeeDAO = sqlSession.getMapper(EmployeeDAO.class);
        try {
            Employee employee = employeeDAO.getEmployeeByIdAndName(1, "洛笙");
            System.out.println("employee = " + employee);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test4(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeDAO employeeDAO = sqlSession.getMapper(EmployeeDAO.class);
        try {
            List<Employee> employeeList = employeeDAO.getAllEmployees();
            for (Employee employee : employeeList) {
                System.out.println("employee = " + employee);
            }
        } finally {
            sqlSession.close();
        }
    }
    @Test
    public void test5(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeDAO employeeDAO = sqlSession.getMapper(EmployeeDAO.class);
        List<Employee> employeeList = employeeDAO.getAllEmployeesResultMap();
        for (Employee employee : employeeList) {
            System.out.println("employee = " + employee);
        }
    }

}
