package com.ferhat.springmongodemo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserWorkExperience {

    @Id
    private String userWorkExperienceId;

    @NotNull
    private String userId;

    @NotNull
    @Size(min = 2, max = 40)
    private String companyName;

    @NotNull
    @Size(min = 2, max = 40)
    private String userWorkTime;
}
