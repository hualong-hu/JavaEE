package org.bigjava.test;

import com.baomidou.mybatisplus.plugins.Page;
import org.bigjava.bean.Employee;
import org.bigjava.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: TestMP
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-13 22:00
 * @Version v1.0
 */
public class TestMP {
    ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper =
            context.getBean("employeeMapper", EmployeeMapper.class);

    @Test
    public void testInsert(){
        Employee employee = new Employee(null, "洛笙", "luosheng@qq.com", 0, 20);
        //insert方法插入时，会根据实体类的每个属性进行非空判断，只有非空的属性对应的字段才会出现在SQL语句中
        Integer insert = employeeMapper.insert(employee);

        //insertAllColumn方法在插入时，不管属性是否非空，属性所对应的字段都会在SQL语句中
//        Integer insert = employeeMapper.insertAllColumn(employee);

        System.out.println("insert = " + insert);

        //获取当前数据在数据库中的主键值
        Integer id = employee.getId();
        System.out.println("主键值是："+id);
    }

    @Test
    public void testUpdate(){
        Integer i = employeeMapper.updateById(new Employee(5, "断念", "duannian@qq.com", 0, 22));
        System.out.println("i = " + i);
    }

    @Test
    public void testSelect(){

        //1、selectById：通过id查询
//        Employee employee = employeeMapper.selectById(1);

        //2、selectOne：通过多个列进行查询（id+lastName）：最多只能查一条数据、、。
//        Employee employee = new Employee();
//        employee.setId(5);
//        employee.setLastName("断念");
//        Employee employee1 = employeeMapper.selectOne(employee);
//        System.out.println("employee = " + employee1);

//        3、selectBatchIds：通过一个id集合查询多条数据
//        List<Employee> employeeList = employeeMapper.selectBatchIds(Arrays.asList(1, 2, 3, 4));
//        for (Employee employee : employeeList) {
//            System.out.println("employee = " + employee);
//        }

//        4、selectByMap：通过map封装条件查询，map的key要与数据库的列名一致
//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("last_name", "洛笙");
//        map.put("age", 20);
//        List<Employee> employeeList = employeeMapper.selectByMap(map);
//        for (Employee employee : employeeList) {
//            System.out.println("employee = " + employee);
//        }
//      5、selectPage:分页查询；第一个参数：第几页，第二个参数：每页多少条数据
//        List<Employee> employees = employeeMapper.selectPage(new Page<Employee>(2, 3), null);
//        for (Employee employee : employees) {
//            System.out.println("employee = " + employee);
//        }

//      6、selectList：查询所有的数据
        List<Employee> employees = employeeMapper.selectList(null);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }

    }

    @Test
    public void testDelete(){
//        Integer integer = employeeMapper.deleteById(7);
//        System.out.println("受影响的行数有：" + integer);

//        Integer integer = employeeMapper.deleteBatchIds(Arrays.asList(6, 5, 4));
//        System.out.println("受影响的行数有：" + integer);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("last_name", "Black");
        map.put("age", 30);
        Integer integer = employeeMapper.deleteByMap(map);
        System.out.println("受影响的行数有：" + integer);


    }

    @Test
    public void test() throws SQLException {
        DataSource source = context.getBean("dataSource", DataSource.class);
        System.out.println("source = " + source);

        Connection connection = source.getConnection();
        System.out.println("connection = " + connection);

    }



}
