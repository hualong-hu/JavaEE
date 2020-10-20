package org.bigjava.dao;

import org.bigjava.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ProjectName: JavaEE
 * @ClassName: CustomerDao
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-12 18:10
 * @Version v1.0
 *
 * 编写符合SpringData JPA 的DAO层接口规范
 *      需要继承两个接口
 *          1、JpaRepository<操作的实体类类型,实体类中主键属性的类型>
 *              * 封装了CRUD操作
 *          2、JpaSpecificationExecutor<操作的实体类类型>
 *              * 封装了复制查询（分页）
 *
 *
 */
public interface CustomerDao extends JpaRepository<Customer,Integer>, JpaSpecificationExecutor<Customer> {


    /**
     * 案例：根据客户名称查询客户
     *  使用jpql的形式查询
     *  配置jpql语句，需要使用 @Query 注解
     * @data: 2020-10-12-19:34
     * @method: findByCustName
     * @params: [custName]
     * @return: java.util.List<org.bigjava.bean.Customer>
     */
    @Query(value = "from Customer where custName = ?1 ")
    List<Customer> findByCustName(String custName);

    /**
     * 案例：根据客户id和客户名称查询客户
     *  对于多个占位符参数
     *      赋值的时候，默认情况下占位符的位置需要和方法参数中的位置保持一致
     *      也可以使用 < ?+索引 > 的方式制定占位符参数的位置
     *
     * @data: 2020-10-12-19:43
     * @method: findCustomerByCustIdAndAndCustName
     * @params: [id, name]
     * @return: org.bigjava.bean.Customer
     */
    @Query(value = "from Customer where custId = ?1 and custName = ?2")
    Customer findByCustIdAndAndCustName(Integer id,String name);


    /**
     * 案例：通过id修改客户的姓名
     *  @Query ： 代表的是进行查询
     *          * 声明此方法是用来进行更新操作
     *
     *  @Modifying ： 声明当前执行的是一个更新操作！
     *
     * @data: 2020-10-13-8:48
     * @method: updateCustomer
     * @params: [id, name]
     * @return: void
     */
    @Query(value = "update Customer set custName = ?2 where custId = ?1")
    @Modifying
    void updateCustomer(Integer id, String name);

    /**
     * 案例：查询所有数据（使用sql）
     *   @Query ： 配置sql查询
     *      value：sql语句
     *      nativeQuery ：指定查询方式 -> (true：sql查询 ； false：jpql查询)
     *
     *
     *
     * @data: 2020-10-13-9:02
     * @method: findAll
     * @params: []
     * @return: java.util.List<org.bigjava.bean.Customer>
     */
    @Query(value = "select * from jpa.cst_customer",nativeQuery = true)
    List<Customer> findAll();

    /**
     * 案例：模糊查询
     *  sql语句和jpql语句占位符填充方式是一致的
     * @data: 2020-10-13-9:08
     * @method: findAllByCustPhone
     * @params: [phone]
     * @return: java.util.List<org.bigjava.bean.Customer>
     */
    @Query(value = "select * from jpa.cst_customer where cust_phone like ?1",nativeQuery = true)
    List<Customer> findAllByCustPhone(String phone);

    /**
     * 方法命名规则查询
     *      findBy -> 查询
     *          对象中的属性名（首字母大写）： 查询条件
     *      findByCustAddress ： 根据客户地址查询客户信息
     *
     *      在SpringDataJPA的运行阶段
     *          会根据方法名进行解析： findBy from xxx(实体类) 属性名 where CustAddress = ?
     * @data: 2020-10-13-9:26
     * @method: findByCustAddress
     * @params: [address]
     * @return: org.bigjava.bean.Customer
     */
    Customer findByCustAddress(String address);


    /**
     * 模糊查询
     *  1、findBy + 属性名称 （根据属性名称进行完全匹配的查询=）
     *  2、findBy + 属性名称 + “查询方式(like | isnull ....)”
     *
     * @data: 2020-10-13-9:54
     * @method: findByCustAddressLike
     * @params: [address]
     * @return: java.util.List<org.bigjava.bean.Customer>
     */
    List<Customer> findByCustAddressLike(String address);

    /**
     * 多条件查询
     *  findBy + 属性名 + “查询方式” + “多条件的连接符（and|or）” + 属性名 + “查询方式”
     * @data: 2020-10-13-10:04
     * @method: findByCustNameAndCustAddress
     * @params: [name, address]
     * @return: org.bigjava.bean.Customer
     */
    Customer findByCustNameAndCustAddress(String name,String address);
}
