package com.marketplace.demo.persistence.model;

import jakarta.persistence.*;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "USER_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "USER_SEQ", allocationSize = 1, sequenceName = "USER_SEQ")
    private Long UserId;
    @Column(name = "user_name", nullable = false)
    private String userName;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email_id", nullable = false)
    private String emailId;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    public User() {}

    public User(String userName, String password, String emailId, String phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public Long getUserId() {
        return UserId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
