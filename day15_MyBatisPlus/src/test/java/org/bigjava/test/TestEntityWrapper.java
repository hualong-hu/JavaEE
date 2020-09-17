package org.bigjava.test;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.bigjava.bean.Employee;
import org.bigjava.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: TestEntityWrapper
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-14 17:14
 * @Version v1.0
 */
public class TestEntityWrapper {
    ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper =
            context.getBean("employeeMapper", EmployeeMapper.class);

    @Test
    public void testEntityWrapperDelete(){
        //删除名为TOM，年龄为20的数据
        Integer integer = employeeMapper.delete(new EntityWrapper<Employee>()
                .eq("last_name", "Tom")
                .eq("age", 20));
        System.out.println("受影响的行数 = " + integer);
    }

    @Test
    public void testEntityWrapperUpdate(){
        //将名为Tom，年龄为22岁的数据改为名为洛笙，邮箱为luosheng@qq.com，年龄为18
        Employee employee = new Employee(null,"洛笙","luosheng@qq.com",null,18);
        Integer integer = employeeMapper.update(employee, new EntityWrapper<Employee>()
                .eq("last_name", "Tom")
                .eq("age", 22));
        System.out.println("受影响的行数 = " + integer);

    }

    @Test
    public void testEntityWrapperSelect(){
        //查询tbl_employee表中，年龄在18-50之间且性别为男且姓名为Tom的所有用户
        //参数使用的是数据库字段，不是Java属性!
//        List<Employee> employees = employeeMapper.selectList(new EntityWrapper<Employee>()
//                .between("age", 18, 50)
//                .eq("gender", 1).eq("last_name", "Tom"));
//        for (Employee employee : employees) {
//            System.out.println("employee = " + employee);
//        }

        //查询tbl_employee表中，性别为男且名字中带有“ t ” 或者邮箱中带有“m”
//        List<Employee> employees = employeeMapper.selectList(new EntityWrapper<Employee>()
//                .eq("gender", 1)
//                .like("last_name", "t")
//                .or()
//                .like("email", "m"));
//        /*
//         SQL:SELECT id,last_name AS lastName,email,gender,age FROM tbl_employee
//         WHERE (gender = ? AND last_name LIKE ? OR email LIKE ?)
//      */
//        for (Employee employee : employees) {
//            System.out.println("employee = " + employee);
//        }

        //查询tbl_employee表中，性别为男，并按年龄排序
//        List<Employee> employees = employeeMapper.selectList(new EntityWrapper<Employee>()
//                .eq("gender", 1)
//                .orderBy("age", true));
//        for (Employee employee : employees) {
//            System.out.println("employee = " + employee);
//        }
        //查询表中名为洛笙的数据
        List employee = employeeMapper.selectList(Condition.create().eq("last_name", "洛笙"));
        for (Object o : employee) {
            System.out.println("employee = " + o);
        }

    }



}
