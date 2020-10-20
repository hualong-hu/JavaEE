package org.bigajava.test;

import org.bigjava.bean.Customer;
import org.bigjava.dao.CustomerDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
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
public class JpqlTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testFindByCustName(){
        List<Customer> customerList = customerDao.findByCustName("叶默");
        for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }
    }

    @Test
    public void testFindByCustIdAndAndCustName(){
        Customer customer = customerDao.findByCustIdAndAndCustName(1, "洛笙");
        System.out.println("customer = " + customer);
    }

    /**
     * 测试jpql的更新操作
     *
     *  SpringDataJPA中使用jpql完成更新/删除操作时
     *      * 需要手动添加事务的支持
     *      * 默认会执行结束之后，回滚事务
     *
     *  @Transactional ： 添加事务的支持
     *  @Rollback ： 设置是否自动回滚 ： true | false
     *
     * @data: 2020-10-13-8:53
     * @method: testUpdateCustomer
     * @params: []
     * @return: void
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testUpdateCustomer(){
        customerDao.updateCustomer(4, "叶默");
    }

    @Test
    public void testFindAll(){
        List<Customer> customerList = customerDao.findAll();
        for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }
    }

    @Test
    public void testFindAllByCustPhone(){
        List<Customer> customerList = customerDao.findAllByCustPhone("1%");
        for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }

    }

    @Test
    public void testFindByCustAddress(){
        Customer customer = customerDao.findByCustAddress("南昌");
        System.out.println("customer = " + customer);
    }

    @Test
    public void testFindByCustAddressLike(){
        List<Customer> customers = customerDao.findByCustAddressLike("南%");
        for (Customer customer : customers) {
            System.out.println("customer = " + customer);
        }
    }

    @Test
    public void testFindByCustNameAndCustAddress(){
        Customer customer = customerDao.findByCustNameAndCustAddress("溪苏", "南昌");
        System.out.println("customer = " + customer);
    }
}
