package org.bigjava.test;

import org.apache.ibatis.session.SqlSession;
import org.bigjava.bean.Department;
import org.bigjava.bean.Employee;
import org.bigjava.dao.DepartmentMapper;
import org.bigjava.dao.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @ProjectName: JavaEE
 * @ClassName: MapperTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-07 22:20
 * @Version v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;
    /**
     * 测试DepartmentMapper
     * @data: 2020-08-07-22:20
     * @method: test1
     * @params: []
     * @return: void
     */
    @Test
    public void test1(){
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        DepartmentMapper mapper = context.getBean(DepartmentMapper.class);
        System.out.println(departmentMapper);

        departmentMapper.insertSelective(new Department(null, "开发部"));
        departmentMapper.insertSelective(new Department(null, "测试部"));

    }

    @Test
    public void test2(){
//        Employee employee = new Employee(null, "洛笙", "男", "2423604249@qq.com", 1);
//        employeeMapper.insertSelective(employee);
//        Employee employee1 = new Employee(null, "断念", "女", "duannian@qq.com", 2);
//        employeeMapper.insertSelective(employee);
        Employee employee2 = new Employee();
        employee2.setEmployeeId(2);
        employee2.setEmail("duannian@qq.com");
        employee2.setEmployeeName("断念");
        employee2.setGender("女");
        employeeMapper.updateByPrimaryKeySelective(employee2);
    }

//    @Test
//    public void test3(){
//        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        for (int i = 0; i < 1000; i++) {
//            String uuid = UUID.randomUUID().toString().substring(0,5)+i;
//            mapper.insertSelective(new Employee(null, uuid, "男", uuid+"@bigjava.com", 1));
//        }
//    }
    @Test
    public void test4(){
        Employee employee = employeeMapper.selectByPrimaryKeyWithDepartment(1);
        System.out.println("employee = " + employee);
//        List<Employee> employees = employeeMapper.selectByExampleWithDepartment(null);
//        for (Employee employee : employees) {
//            System.out.println("employee = " + employee);
//        }
    }
    @Test
    public void test5(){
        Employee employee = employeeMapper.selectByPrimaryKey(1);
        System.out.println("employee = " + employee);
    }

}
