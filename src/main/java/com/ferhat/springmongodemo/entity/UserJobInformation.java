package com.ferhat.springmongodemo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserJobInformation {

    @Id
    private String userJobInformationId;

    @NotNull
    private String userId;

    @NotNull
    @Size(min = 2, max = 40)
    private String userDepartmentName;

    @NotNull
    @Size(min = 2, max = 40)
    private String userTitle;

    @NotNull
    @Size(min = 2, max = 40)
    private String userTask;


}
