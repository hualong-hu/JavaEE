package org.bigjava.bean;

import javax.persistence.*;

/**
 * @ProjectName: JavaEE
 * @ClassName: Customer
 * @Description: 客户实体类
 * @Author: 洛笙
 * @Date: 2020-10-11 10:39
 * @Version v1.0
 * 配置映射关系
 *  1、实体类和表的映射关系
 *      @Entity -> 声明实体类
 *      @Table -> 配置实体类和表的映射关系
 *             name：配置数据库表的名称
 *  2、实体类中属性和表中字段的映射关系
 *
 */
@Entity
@Table(name = "cst_customer")
public class Customer {
    /**
     *  客户的主键
     *  @Id -> 声明主键的配置
     *  @GeneratedValue -> 配置主键的生成策略
     *      strategy =
     *          GenerationType.IDENTITY：自增（mysql）
     *              * 底层数据库必须支持自动增长（底层数据库支持的自动增长方式，对id自增）
     *          GenerationType.SEQUENCE：序列（oracle）
     *              * 底层数据库必须支持序列
     *          GenerationType.TABLE
     *              * JPA提供的一种机制，通过一张数据库表的形式帮助我们完成主键自增
     *          GenerationType.AUTO
     *              * 由程序自动的帮助我们选择主键生成策略
     *  @Column -> 配置属性和字段的映射关系
     *      name = "cust_id"：数据库表中字段的名称！
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Integer custId;
    /**
     *  客户的姓名
     */
    @Column(name = "cust_name")
    private String custName;
    /**
     *  客户的来源
     */
    @Column(name = "cust_source")
    private String custSource;
    /**
     *  客户的级别
     */
    @Column(name = "cust_level")
    private String custLevel;
    /**
     *  客户所属行业
     */
    @Column(name = "cust_industry")
    private String custIndustry;
    /**
     *  客户的联系方式
     */
    @Column(name = "cust_phone")
    private String custPhone;
    /**
     *  客户的地址
     */
    @Column(name = "cust_address")
    private String custAddress;

    public Customer(Integer custId, String custName, String custSource, String custLevel, String custIndustry, String custPhone, String custAddress) {
        this.custId = custId;
        this.custName = custName;
        this.custSource = custSource;
        this.custLevel = custLevel;
        this.custIndustry = custIndustry;
        this.custPhone = custPhone;
        this.custAddress = custAddress;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custAddress='" + custAddress + '\'' +
                '}';
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }
}
