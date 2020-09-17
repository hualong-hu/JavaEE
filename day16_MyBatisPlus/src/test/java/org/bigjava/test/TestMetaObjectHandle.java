package org.bigjava.test;


import org.bigjava.beans.Employee;
import org.bigjava.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ProjectName: JavaEE
 * @ClassName: MetaObjectHandle
 * @Description: 自定义公共字段填充处理器
 * @Author: 洛笙
 * @Date: 2020-08-15 18:30
 * @Version v1.0
 */
public class TestMetaObjectHandle{
    ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper =
            context.getBean("employeeMapper", EmployeeMapper.class);

    @Test
    public void test(){
        Employee employee = new Employee(null, "火破云", null, "1", 32);
        Integer insert = employeeMapper.insert(employee);
        System.out.println("受影响的行数 = " + insert);
    }
}
