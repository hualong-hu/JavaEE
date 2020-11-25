package org.bigjava.entity;

import javax.persistence.*;

/**
 * @ProjectName: JavaEE
 * @ClassName: User
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-16 13:44
 * @Version v1.0
 */
@Entity
@Table(name = "user")
public class User {
    /**
     *  hibernate要求实体类有一个属性是唯一的
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "address")
    private String address;

    public User() {
    }

    public User(Integer id, String username, String password, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
