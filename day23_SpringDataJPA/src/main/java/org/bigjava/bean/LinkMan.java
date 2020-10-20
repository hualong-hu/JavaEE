package org.bigjava.bean;

import javax.persistence.*;

/**
 * @ProjectName: JavaEE
 * @ClassName: LinkMan
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-20 23:25
 * @Version v1.0
 */
@Entity
@Table(name = "cst_linkman")
public class LinkMan {

    /**
     *  联系人ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lkm_id")
    private Integer lkmId;
    /**
     *  联系人姓名
     */
    @Column(name = "lkm_name")
    private String lkmName;
    /**
     *  联系人性别
     */
    @Column(name = "lkm_gender")
    private String lkmGender;
    /**
     *  联系人办公电话
     */
    @Column(name = "lkm_phone")
    private String lkmPhone;
    /**
     *  联系人手机号码
     */
    @Column(name = "lkm_mobile")
    private String lkmMobile;
    /**
     *  联系人邮箱
     */
    @Column(name = "lkm_email")
    private String lkmEmail;
    /**
     *  联系人职位
     */
    @Column(name = "lkm_position")
    private String lkmPosition;
    /**
     *  联系人备注
     */
    @Column(name = "lkm_memo")
    private String lkmMemo;


    public LinkMan() {
    }

    public LinkMan(Integer lkmId, String lkmName, String lkmGender, String lkmPhone, String lkmMobile, String lkmEmail, String lkmPosition, String lkmMemo) {
        this.lkmId = lkmId;
        this.lkmName = lkmName;
        this.lkmGender = lkmGender;
        this.lkmPhone = lkmPhone;
        this.lkmMobile = lkmMobile;
        this.lkmEmail = lkmEmail;
        this.lkmPosition = lkmPosition;
        this.lkmMemo = lkmMemo;
    }

    @Override
    public String toString() {
        return "LinkMan{" +
                "lkmId=" + lkmId +
                ", lkmName='" + lkmName + '\'' +
                ", lkmGender='" + lkmGender + '\'' +
                ", lkmPhone='" + lkmPhone + '\'' +
                ", lkmMobile='" + lkmMobile + '\'' +
                ", lkmEmail='" + lkmEmail + '\'' +
                ", lkmPosition='" + lkmPosition + '\'' +
                ", lkmMemo='" + lkmMemo + '\'' +
                '}';
    }

    public Integer getLkmId() {
        return lkmId;
    }

    public void setLkmId(Integer lkmId) {
        this.lkmId = lkmId;
    }

    public String getLkmName() {
        return lkmName;
    }

    public void setLkmName(String lkmName) {
        this.lkmName = lkmName;
    }

    public String getLkmGender() {
        return lkmGender;
    }

    public void setLkmGender(String lkmGender) {
        this.lkmGender = lkmGender;
    }

    public String getLkmPhone() {
        return lkmPhone;
    }

    public void setLkmPhone(String lkmPhone) {
        this.lkmPhone = lkmPhone;
    }

    public String getLkmMobile() {
        return lkmMobile;
    }

    public void setLkmMobile(String lkmMobile) {
        this.lkmMobile = lkmMobile;
    }

    public String getLkmEmail() {
        return lkmEmail;
    }

    public void setLkmEmail(String lkmEmail) {
        this.lkmEmail = lkmEmail;
    }

    public String getLkmPosition() {
        return lkmPosition;
    }

    public void setLkmPosition(String lkmPosition) {
        this.lkmPosition = lkmPosition;
    }

    public String getLkmMemo() {
        return lkmMemo;
    }

    public void setLkmMemo(String lkmMemo) {
        this.lkmMemo = lkmMemo;
    }
}
