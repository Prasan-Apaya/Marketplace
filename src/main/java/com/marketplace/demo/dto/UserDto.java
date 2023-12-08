package com.marketplace.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class UserDto {

    @NotNull(message = "User Name must not be blank")
    private String userName;

    @NotNull(message = "Password must be between 4 to 15 characters")
    @Size(min = 4, max = 15)
    private String password;

    @NotNull(message = "Email must not be blank")
    private String emailId;

    @NotNull(message = "Phone Number must not be blank")
    private String phoneNumber;

    public UserDto() {
    }

    public UserDto(String userName, String password, String emailId, String phoneNumber) {
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
