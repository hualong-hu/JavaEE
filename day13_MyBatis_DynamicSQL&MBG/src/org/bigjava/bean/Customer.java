package org.bigjava.bean;

import java.util.Date;

public class Customer {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customers.id
     *
     * @mbg.generated Wed Aug 05 17:11:21 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customers.name
     *
     * @mbg.generated Wed Aug 05 17:11:21 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customers.email
     *
     * @mbg.generated Wed Aug 05 17:11:21 CST 2020
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customers.birth
     *
     * @mbg.generated Wed Aug 05 17:11:21 CST 2020
     */
    private Date birth;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customers.photo
     *
     * @mbg.generated Wed Aug 05 17:11:21 CST 2020
     */
    private byte[] photo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customers.id
     *
     * @return the value of customers.id
     *
     * @mbg.generated Wed Aug 05 17:11:21 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customers.id
     *
     * @param id the value for customers.id
     *
     * @mbg.generated Wed Aug 05 17:11:21 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customers.name
     *
     * @return the value of customers.name
     *
     * @mbg.generated Wed Aug 05 17:11:21 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customers.name
     *
     * @param name the value for customers.name
     *
     * @mbg.generated Wed Aug 05 17:11:21 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customers.email
     *
     * @return the value of customers.email
     *
     * @mbg.generated Wed Aug 05 17:11:21 CST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customers.email
     *
     * @param email the value for customers.email
     *
     * @mbg.generated Wed Aug 05 17:11:21 CST 2020
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customers.birth
     *
     * @return the value of customers.birth
     *
     * @mbg.generated Wed Aug 05 17:11:21 CST 2020
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customers.birth
     *
     * @param birth the value for customers.birth
     *
     * @mbg.generated Wed Aug 05 17:11:21 CST 2020
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customers.photo
     *
     * @return the value of customers.photo
     *
     * @mbg.generated Wed Aug 05 17:11:21 CST 2020
     */
    public byte[] getPhoto() {
        return photo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customers.photo
     *
     * @param photo the value for customers.photo
     *
     * @mbg.generated Wed Aug 05 17:11:21 CST 2020
     */
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}