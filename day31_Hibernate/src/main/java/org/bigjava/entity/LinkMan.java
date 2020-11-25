package org.bigjava.entity;

import javax.persistence.*;

@Entity
@Table(name = "LinkMan")
public class LinkMan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lkm_id")
	private Integer lkm_id; // 联系人编号(主键)
	@Column(name = "lkm_name")
	private String lkm_name;// 联系人姓名
	@Column(name = "lkm_gender")
	private String lkm_gender;// 联系人性别
	@Column(name = "lkm_phone")
	private String lkm_phone;// 联系人办公电话
	
	// 在联系人实体类里面表示所属客户,一个联系人只能属于一个客户
	/**
	 * 配置多对一关系
	 *  使用注解的形式配置多对一关系
	 *      1、配置表关系
	 *        @ManyToOne ： 配置多对一关系
	 *          targetEntity：对方实体类的字节码
	 *      2、配置外键（中间表）
	 *
	 *  配置外键的过程中，配置到了多的衣服，就会在多的一方维护外键！，
	 *
	 */
	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name = "clid",referencedColumnName = "cid")
	private Customer customer;
	public Customer getCustomer() {
		return customer;
	}

	public LinkMan(Integer lkm_id, String lkm_name, String lkm_gender, String lkm_phone) {
		this.lkm_id = lkm_id;
		this.lkm_name = lkm_name;
		this.lkm_gender = lkm_gender;
		this.lkm_phone = lkm_phone;
	}

	public LinkMan() {
	}

	@Override
	public String toString() {
		return "LinkMan{" +
				"lkm_id=" + lkm_id +
				", lkm_name='" + lkm_name + '\'' +
				", lkm_gender='" + lkm_gender + '\'' +
				", lkm_phone='" + lkm_phone + '\'' +
				", customer=" + customer +
				'}';
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Integer getLkm_id() {
		return lkm_id;
	}
	public void setLkm_id(Integer lkm_id) {
		this.lkm_id = lkm_id;
	}
	public String getLkm_name() {
		return lkm_name;
	}
	public void setLkm_name(String lkm_name) {
		this.lkm_name = lkm_name;
	}
	public String getLkm_gender() {
		return lkm_gender;
	}
	public void setLkm_gender(String lkm_gender) {
		this.lkm_gender = lkm_gender;
	}
	public String getLkm_phone() {
		return lkm_phone;
	}
	public void setLkm_phone(String lkm_phone) {
		this.lkm_phone = lkm_phone;
	}
}
