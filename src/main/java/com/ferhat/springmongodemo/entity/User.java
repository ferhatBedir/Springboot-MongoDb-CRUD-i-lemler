package com.ferhat.springmongodemo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Size;

public class User {

    @Id
    private Long userId;

    @Size(max = 40, min = 3)
    private String userFirstName;

    @Size(max = 40, min = 3)
    private String userLastName;

    @Size(max = 40, min = 3)
    private String userEmail;

    @Size(max = 40, min = 2)
    private String userDepartmentName;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserDepartmentName() {
        return userDepartmentName;
    }

    public void setUserDepartmentName(String userDepartmentName) {
        this.userDepartmentName = userDepartmentName;
    }
}
