package org.bigjava.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_customer")
public class Customer {
	//客户id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid")
	private Integer cid;
	//客户名称
	@Column(name = "custName")
	private String custName;
	//客户级别
	@Column(name = "custLevel")
	private String custLevel;
	//客户来源
	@Column(name = "custSource")
	private String custSource;
	//联系电话
	@Column(name = "custPhone")
	private String custPhone;
	//手机
	@Column(name = "custMobile")
	private String custMobile;
	
	//在客户实体类里面表示多个联系人，一个客户有多个联系人
	//hibernate要求使用集合表示多的数据，使用set集合
	/**
	 *  配置一对多关系
	 *      1、声明关系：
	 *          @OneToMany : 配置一对多关系
	 *              targetEntity ： 对方对象的字节码对象
	 *               mappedBy ：放弃外键维护权 对方配置关系的属性名称
	 *               cascade : 配置级联（CascadeType.ALL）（可以配置到设置多表的映射关系的注解、上）
	 *      2、配置外键（中间表）
	 *          @JoinColumn : 配置外键
	 *              name ：外键字段名称
	 *              referencedColumnName ： 参照的主表的主键字段名称
	 *
	 * 在一的一方添加了外键配置，所有对于多的一方而言，也具备了维护外键的作用
	 *
	 *
	 *
	 */
//	@OneToMany(targetEntity = LinkMan.class)
//	@JoinColumn(name = "clid",referencedColumnName = "cid")
	/*
		放弃外键维护权
			mappedBy：对方配置关系的属性名称
			cascade:配置级联操作
	*/
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private Set<LinkMan> setLinkMan = new HashSet<LinkMan>();

	public Set<LinkMan> getSetLinkMan() {
		return setLinkMan;
	}
	public void setSetLinkMan(Set<LinkMan> setLinkMan) {
		this.setLinkMan = setLinkMan;
	}
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public Customer() {
	}

	@Override
	public String toString() {
		return "Customer{" +
				"cid=" + cid +
				", custName='" + custName + '\'' +
				", custLevel='" + custLevel + '\'' +
				", custSource='" + custSource + '\'' +
				", custPhone='" + custPhone + '\'' +
				", custMobile='" + custMobile + '\'' +
				'}';
	}

	public Customer(Integer cid, String custName, String custLevel, String custSource, String custPhone, String custMobile) {
		this.cid = cid;
		this.custName = custName;
		this.custLevel = custLevel;
		this.custSource = custSource;
		this.custPhone = custPhone;
		this.custMobile = custMobile;
	}


}
