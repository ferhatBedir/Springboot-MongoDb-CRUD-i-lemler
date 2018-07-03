package com.ferhat.springmongodemo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class User {

    @Id
    private String userId;

    @NotNull
    @Size(min = 3, max = 40)
    private String userFirstName;

    @NotNull
    @Size(min = 3, max = 40)
    private String userLastName;

    @NotNull
    @Size(min = 7, max = 11)
    private String userIdentityNumber;

    @NotNull
    @Size(min = 3, max = 40)
    private String userNationality;

    @NotNull
    private Integer userAge;

    @NotNull
    @Size(min = 7, max = 11)
    private String userPhoneNum;


    private UserJobInformation userJobInfo;

    private UserWorkExperience userWorkExperience;
}
