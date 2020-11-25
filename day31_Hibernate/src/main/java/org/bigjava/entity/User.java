package org.bigjava.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
  	private Integer user_id;//用户id
	@Column(name = "user_name")
  	private String user_name;//用户名称
	@Column(name = "user_password")
  	private String user_password;//用户密码

	/*
		配置用户到角色的多对多关系
			配置多对多的映射关系
				1、声明表关系的配置
				2、配置中间表（包含两个外键）
	 */
	//声明多对多关系
	@ManyToMany(targetEntity = Role.class)
	//@JoinTable：配置中间表，name -> 中间表的名称
	@JoinTable(name = "user_role",
			//joinColumns：当前对象在中间表中的外键;
			// 			name：外键的名称  referencedColumnName：参照的主表的主键名

			joinColumns = {@JoinColumn(name = "userid",referencedColumnName = "user_id")},
			//inverseJoinColumns：对方对象在中间表中的外键
			//			name：外键的名称  referencedColumnName：参照的主表的主键名
			inverseJoinColumns = {@JoinColumn(name = "roleid",referencedColumnName = "role_id")}
	)
	private Set<Role> setRole = new HashSet<Role>();

	public User(Integer user_id, String user_name, String user_password) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User{" +
				"user_id=" + user_id +
				", user_name='" + user_name + '\'' +
				", user_password='" + user_password + '\'' +
				'}';
	}


  	
	public Set<Role> getSetRole() {
		return setRole;
	}
	public void setSetRole(Set<Role> setRole) {
		this.setRole = setRole;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
}
