package org.bigjava.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "t_role")
@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
  	private Integer role_id;//角色id
	@Column(name = "role_name")
  	private String role_name;//角色名称
	@Column(name = "role_memo")
  	private String role_memo;//角色描述
  	
  	// 一个角色有多个用户
	/*

	 */
	//声明多对多关系
	@ManyToMany(targetEntity = User.class)
	//@JoinTable：配置中间表，name -> 中间表的名称
	@JoinTable(name = "user_role",
			//joinColumns：当前对象在中间表中的外键;
			// 			name：外键的名称  referencedColumnName：参照的主表的主键名

			joinColumns = {@JoinColumn(name = "roleid",referencedColumnName = "role_id")},
			//inverseJoinColumns：对方对象在中间表中的外键
			//			name：外键的名称  referencedColumnName：参照的主表的主键名
			inverseJoinColumns = {@JoinColumn(name = "userid",referencedColumnName = "user_id")}
	)
  	private Set<User> setUser = new HashSet<User>();
  	
	public Set<User> getSetUser() {
		return setUser;
	}
	public void setSetUser(Set<User> setUser) {
		this.setUser = setUser;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_memo() {
		return role_memo;
	}
	public void setRole_memo(String role_memo) {
		this.role_memo = role_memo;
	}

	@Override
	public String toString() {
		return "Role{" +
				"role_id=" + role_id +
				", role_name='" + role_name + '\'' +
				", role_memo='" + role_memo + '\'' +
				'}';
	}

	public Role() {
	}

	public Role(Integer role_id, String role_name, String role_memo) {
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_memo = role_memo;
	}
}
