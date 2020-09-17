package org.bigjava.test;

import com.baomidou.mybatisplus.plugins.Page;
import org.bigjava.beans.Employee;
import org.bigjava.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: TestPlugin
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-15 14:03
 * @Version v1.0
 */
public class TestPlugin {
    ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper =
            context.getBean("employeeMapper", EmployeeMapper.class);

    /**
     * 测试分页查询插件
     * @data: 2020-08-15-14:04
     * @method: testPage
     * @params: []
     * @return: void
     */
    @Test
    public void testPage(){
        Page<Employee> page = new Page<Employee>(1,1);
        List<Employee> employees = employeeMapper.selectPage(page, null);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
        System.out.println("====================获取分页相关的信息=======================");
        System.out.println("总条数："+page.getTotal());
        System.out.println("当前页码："+page.getCurrent());
        System.out.println("总页码："+page.getPages());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());

        //将查询的结果封装到page对象中
        page.setRecords(employees);
    }

    /**
     * 测试 执行分析插件
     * 该插件的作用是分析 DELETE UPDATE 语句,
     * 防止小白或者恶意进行 DELETE UPDATE 全表操作
     * @data: 2020-08-15-16:17
     * @method: test
     * @params: []
     * @return: void
     */
    @Test
    public void testSqlExplain(){
        employeeMapper.delete(null);
    }


    /**
     * 测试 性能分析插件
     * @data: 2020-08-15-17:07
     * @method: testPerformance
     * @params: []
     * @return: void
     */
    @Test
    public void testPerformance(){
        Employee employee = new Employee(null, "宁城", "ningcheng@qq.com", "1", 36);
//        boolean insert = employee.insert();
        Integer integer = employeeMapper.insertAllColumn(employee);

        System.out.println("integer = " + integer);
    }

    /**
     * 测试 乐观锁插件
     * @data: 2020-08-15-17:22
     * @method: testOptimisticLocker
     * @params: []
     * @return: void
     */
    @Test
    public void testOptimisticLocker(){

    }

    @Test
    public void test(){
//        int i = employeeMapper.deleteAll();
//        System.out.println("i = " + i);
    }
}
