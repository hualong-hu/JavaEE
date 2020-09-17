package org.bigjava.test;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.bigjava.bean.Employee;
import org.bigjava.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: TestActiveRecord
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-15 11:43
 * @Version v1.0
 */
public class TestActiveRecord {
    ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper =
            context.getBean("employeeMapper", EmployeeMapper.class);
    /**
     * AR  插入操作
     * @data: 2020-08-15-11:58
     * @method: testARInsert
     * @params: []
     * @return: void
     */
    @Test
    public void testARInsert(){
        Employee employee = new Employee(null, "挽念", "wannian@qq.com", 1, 21);
        boolean insert = employee.insert();
        System.out.println("操作是否成功 = " + insert);
    }

    /**
     * AR  更新操作
     * @data: 2020-08-15-11:59
     * @method: testARUpdate
     * @params: []
     * @return: void
     */
    @Test
    public void testARUpdate(){
        Employee employee = new Employee(null, "叶默", "yemo@qq.com", 1, 35);
        boolean b = employee.update(new EntityWrapper().eq("id", 3));
        System.out.println("操作是否成功 = " + b);
    }

    /**
     * AR  的查询操作
     * @data: 2020-08-15-12:02
     * @method: testARSelect
     * @params: []
     * @return: void
     */
    @Test
    public void testARSelect(){
        Employee employee = new Employee();
//        int count = employee.selectCount(new EntityWrapper().eq("gender", 1));
//        System.out.println("查询到的记录数 = " + count);
        List<Employee> employees = employee.selectAll();
        for (Employee employee1 : employees) {
            System.out.println("employee = " + employee1);
        }
    }
    /**
     * AR  删除操作
     * @data: 2020-08-15-12:08
     * @method: testARDelete
     * @params: []
     * @return: void
     */
    @Test
    public void testARDelete(){
        Employee employee = new Employee();
        boolean b = employee.delete(new EntityWrapper().eq("id", 8));
        System.out.println("操作是否成功 = " + b);
    }
}
