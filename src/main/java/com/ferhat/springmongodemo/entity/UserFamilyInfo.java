package com.ferhat.springmongodemo.entity;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Size;

public class UserFamilyInfo {

    @Id
    private Long userFamilyId;

    @Size(max = 40, min = 3)
    private String motherFirstName;

    @Size(max = 40, min = 3)
    private String motherLastName;

    @Size(max = 40, min = 3)
    private String fatherFirstName;

    @Size(max = 40, min = 3)
    private String fatherLastName;

    private Long userId;

    private User user;


    public UserFamilyInfo() {
    }

    public UserFamilyInfo(Long id,
                          @Size(min = 3, max = 40) String motherFirstnanme,
                          @Size(min = 3, max = 40) String morherLastName,
                          @Size(min = 3, max = 40) String fatherFirstname,
                          @Size(min = 3, max = 40) String fatherLastName,
                          Long userId,
                          User user) {
        this.userFamilyId = id;
        this.motherFirstName = motherFirstnanme;
        this.motherLastName = morherLastName;
        this.fatherFirstName = fatherFirstname;
        this.fatherLastName = fatherLastName;
        this.userId = userId;
        this.user = user;
    }

    public Long getUserFamilyId() {
        return userFamilyId;
    }

    public void setUserFamilyId(Long userFamilyId) {
        this.userFamilyId = userFamilyId;
    }

    public String getMotherFirstName() {
        return motherFirstName;
    }

    public void setMotherFirstName(String motherFirstnanme) {
        this.motherFirstName = motherFirstnanme;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherLastName(String morherLastName) {
        this.motherLastName = morherLastName;
    }

    public String getFatherFirstName() {
        return fatherFirstName;
    }

    public void setFatherFirstName(String fatherFirstname) {
        this.fatherFirstName = fatherFirstname;
    }

    public String getFatherLastName() {
        return fatherLastName;
    }

    public void setFatherLastName(String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
