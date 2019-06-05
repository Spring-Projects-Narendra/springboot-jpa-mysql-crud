package com.java.springbootjpamysqlcrud.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="user_details")
@EntityListeners(AuditingEntityListener.class)
/*@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)*/
public class User {

    @Id
/*    @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    @Column(name = "USER_ID")
    private Integer userId;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "EMAIL_ADDRESS")
    private String emailId;
    @Column(name = "PHONE_NO")
    private String phoneNo;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
