package org.bigajava.test;

import org.bigjava.bean.Customer;
import org.bigjava.dao.CustomerDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: CustomerDaoTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-12 18:14
 * @Version v1.0
 */
//声明spring提供的单元测试环境
@RunWith(SpringJUnit4ClassRunner.class)
//指定spring容器的配置信息
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerDaoTest {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 根据id查询某条数据
     * @data: 2020-10-12-18:33
     * @method: testFindOne
     * @params: []
     * @return: void
     */
    @Test
    public void testFindOne(){
        Customer customer = customerDao.findOne(1);
        System.out.println("customer = " + customer);
    }
    /**
     * 查询所有的数据
     * @data: 2020-10-12-18:33
     * @method: testFindAll
     * @params: []
     * @return: void
     */
    @Test
    public void testFindAll(){
        List<Customer> customerList = customerDao.findAll();
        for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }
    }

    /**
     * save():保存或者更新
     *      根据传递的对象是否存在主键id
     *          如果没有主键id，则保存
     *          如果存在主键id，则根据主键id更新数据
     *
     *
     * @data: 2020-10-12-18:27
     * @method: testSave
     * @params: []
     * @return: void
     */
    @Test
    public void testSave1(){
        Customer customer = new Customer(null, "挽念", "推广", "SVIP", "IT", "110", "九江");
        customerDao.save(customer);
    }

    @Test
    public void testSave2(){
        Customer customer = new Customer(5, "叶默", "推广", "SVIP", "IT", "110", "九江");
        customerDao.save(customer);
    }

    /**
     * 根据id删除某条数据
     * @data: 2020-10-12-18:33
     * @method: testDelete
     * @params: []
     * @return: void
     */
    @Test
    public void testDelete(){
        customerDao.delete(5);
    }

    /**
     * 查询数据的条数
     *      count()；统计总条数
     * @data: 2020-10-12-19:09
     * @method: testCount
     * @params: []
     * @return: void
     */
    @Test
    public void testCount(){
        //查询所有数据的数量
        long count = customerDao.count();
        System.out.println("count = " + count);
    }

    /**
     * 通过id判断该数据是否存在
     * @data: 2020-10-12-19:11
     * @method: test
     * @params: []
     * @return: void
     */
    @Test
    public void testExists(){
        boolean exists = customerDao.exists(4);
        System.out.println("exists = " + exists);
    }

    /**
     * getOne()：根据id查询某条数据
     *      @Transactional ： 保证getOne()正常运行
     * findOne():
     *      底层调用em.find() -> 立即加载
     * getOne():
     *      底层调用em.getReference -> 延时加载
     *      1、返回的是一个客户的动态代理对象
     *      2、什么时候用，什么时候查询
     *
     * @data: 2020-10-12-19:20
     * @method: testGetOne
     * @params: []
     * @return: void
     */
    @Test
    @Transactional
    public void testGetOne(){
        Customer customer = customerDao.getOne(4);
        System.out.println("customer = " + customer);
    }




}
