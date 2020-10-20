package org.bigajava.test;

import org.bigjava.bean.Customer;
import org.bigjava.dao.CustomerDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: SpecificationTest
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-17 17:22
 * @Version v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpecificationTest {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 根据条件，查询单个电源线
     * @data: 2020-10-17-17:30
     * @method: test
     * @params: []
     * @return: void
     */
    @Test
    public void test1(){
        /*
         * 匿名内部类
         *
         * 自定义查询条件
         *      1、实现 Specification 接口（提供泛型，查询的对象类型）
         *      2、实现 toPredicate 方法（构造查询条件）
         *      3、需要借助 toPredicate 此方法中的两个参数
         *          root : 获取需要查询的对象属性
         *          CriteriaBuilder ：构造查询条件的，内部封装了很多的查询条件（模糊匹配，精准匹配）
         *  案例：
         *      根据客户名称查询，查询客户名为洛笙的客户
         *
         */
        Specification<Customer> specification = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //1、获取需要比较的属性
                Path<Object> custName = root.get("custName");
                /*
                 * 2、构造查询条件，进行精准匹配
                 * 第一个参数：需要比较的属性（path对象）
                 * 第二个参数：当前需要比较的值
                 */
                Predicate predicate = cb.equal(custName, "洛笙");
                return predicate;
            }
        };
        Customer customer = customerDao.findOne(specification);
        System.out.println("customer = " + customer);
    }

    /**
     * 多条件查询
     *      案例：根据客户名和客户所在地区查询
     * @data: 2020-10-17-17:53
     * @method: test2
     * @params: []
     * @return: void
     */
    @Test
    public void test2(){

        Specification<Customer> specification = new Specification<Customer>() {
            /**
             * root：获取属性（客户名，所在地区）
             * cb：构造查询
             *      1、构造客户名精准匹配查询
             *      2、构造所在地区的精准匹配查询
             *      3、将以上两个查询联系起来
             *
             *
             * @data: 2020-10-17-17:54
             * @method: toPredicate
             * @params: [root, query, cb]
             * @return: javax.persistence.criteria.Predicate
             */
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Object> custName = root.get("custName");
                Path<Object> custAddress = root.get("custAddress");
                //1、构造客户名精准匹配查询
                Predicate p1 = cb.equal(custName, "洛笙");
                //2、构造所在地区的精准匹配查询
                Predicate p2 = cb.equal(custAddress, "抚州");
                //3、将以上两个查询联系起来
                Predicate predicate = cb.and(p1, p2);
                return predicate;
            }
        };
        Customer customer = customerDao.findOne(specification);
        System.out.println("customer = " + customer);
    }


    /**
     * 案例：完成根据客户电话的模糊匹配
     *
     * equal：直接得到path对象（属性），然后进行比较即可
     * gt,lt,ge,le,like：到底path对象，根据path指定比较的参数类型，再去进行比较
     *                  指定参数类型：path.as(类型的字节码对象)
     *
     *
     * @data: 2020-10-17-18:06
     * @method: test3
     * @params: []
     * @return: void
     */
    @Test
    public void test3(){
        //构造查询
        Specification<Customer> specification = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //查询属性
                Path<Object> custPhone = root.get("custPhone");
                //进行模糊匹配
                Predicate predicate = cb.like(custPhone.as(String.class), "11%");

                return predicate;
            }
        };
        List<Customer> customerList = customerDao.findAll(specification);
        for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }
    }

    /**
     * 排序查询
     * @data: 2020-10-17-22:34
     * @method: test4
     * @params: []
     * @return: void
     */
    @Test
    public void test4(){
        //构造查询
        Specification<Customer> specification = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //查询属性
                Path<Object> custPhone = root.get("custPhone");
                //进行模糊匹配
                Predicate predicate = cb.like(custPhone.as(String.class), "11%");

                return predicate;
            }
        };
        /*
         *  添加排序
         *      创建排序对象，需要调用构造方法实例化sort对象
         *      第一个参数：排序的顺序（Sort.Direction.DESC：降序；Sort.Direction.ASC：升序）
         *      第二个参数：排序的属性名称
         */
        Sort sort = new Sort(Sort.Direction.DESC, "custId");
        List<Customer> customerList = customerDao.findAll(specification, sort);
        for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }
    }

    /**
     * 分页查询
     *  findAll(Specification,Pageable):带有条件的查询
     *      Specification：查询条件
     *      Pageable：分页参数（查询的页码，每页查询的条数）
     *
     *  findAll(Pageable):不带条件的查询
     *
     *  findAll()方法返回Page对象（SpringDataJPA为我们封装好的pageBean对象，数据列表，总条数）
     *
     *
     * @data: 2020-10-17-22:34
     * @method: test
     * @params: []
     * @return: void
     */
    @Test
    public void test5(){
        /*
         * PageRequest对象是Pageable接口的实现类
         *  创建PageRequest的过程中，需要调用它的构造方法传入两个参数
         *      第一个参数：当前查询的页数（从0开始）
         *      第二个参数：每页查询的数量
         */
        PageRequest pageRequest = new PageRequest(0, 3);
        Page<Customer> page = customerDao.findAll(pageRequest);
        //获取所有查询到的数据
        List<Customer> customerList = page.getContent();
        for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }
        System.out.println("总条数："+page.getTotalElements());
        System.out.println("总页数："+page.getTotalPages());

    }

    

}
//iter