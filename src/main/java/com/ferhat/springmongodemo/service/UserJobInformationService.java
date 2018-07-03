package com.ferhat.springmongodemo.service;


import com.ferhat.springmongodemo.entity.User;
import com.ferhat.springmongodemo.entity.UserJobInformation;
import com.ferhat.springmongodemo.repository.UserJobInformationRepository;
import com.ferhat.springmongodemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.SmartValidator;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class UserJobInformationService {

    private UserRepository userRepository;
    private UserJobInformationRepository userJobInformationRepository;
    private SmartValidator smartValidator;

    @Autowired
    public UserJobInformationService(UserRepository userRepository,
                                     UserJobInformationRepository userJobInformationRepository,
                                     SmartValidator smartValidator) {
        this.userRepository = userRepository;
        this.userJobInformationRepository = userJobInformationRepository;
        this.smartValidator = smartValidator;
    }

    public void addUserJobInfo(UserJobInformation userJobInformation) {
        User user = userRepository.findByUserId(userJobInformation.getUserId());
        if (user != null) {
            userJobInformationRepository.save(userJobInformation);
        } else {
            System.out.println("User not found in Database.");
        }
    }

    public void addUsersJobInfo(List<UserJobInformation> userJobInformationList,
                                HttpServletResponse httpServletResponse) throws IOException {
        for (UserJobInformation temp : userJobInformationList) {
            User user = userRepository.findByUserId(temp.getUserId());
            if (user != null) {
                checkData(temp, httpServletResponse);
            } else {
                System.out.println("User not found in Database.");
            }
        }
    }

    public void editUserJobInfo(UserJobInformation newUserJobInfo) {
        UserJobInformation oldUserJobInfo = userJobInformationRepository.
                findByUserJobInformationId(newUserJobInfo.getUserJobInformationId());
        if (oldUserJobInfo != null) {
            oldUserJobInfo.setUserDepartmentName(newUserJobInfo.getUserDepartmentName());
            oldUserJobInfo.setUserTask(newUserJobInfo.getUserTask());
            oldUserJobInfo.setUserTitle(newUserJobInfo.getUserTitle());

            userJobInformationRepository.save(oldUserJobInfo);
        } else {
            System.out.println("User Job Info not found in Database.");
        }
    }

    public UserJobInformation getUserJobInfo(String userJobInfoId) {
        return userJobInformationRepository.findByUserJobInformationId(userJobInfoId);
    }

    public List<UserJobInformation> getUsersJobInfoByUserJobDepartment(String departmentName) {
        return userJobInformationRepository.findOneByUserDepartmentNameIgnoreCase(departmentName);
    }

    public List<UserJobInformation> getAllUsersJobInfo() {
        return userJobInformationRepository.findAll();
    }

    public void deleteUserJobınfo(String userJobInfoId) {
        UserJobInformation userJobInfo = userJobInformationRepository.findByUserJobInformationId(userJobInfoId);
        if (userJobInfo != null) {
            userJobInformationRepository.delete(userJobInfo);
        } else {
            System.out.println("User Job info not found in Database.");
        }
    }

    public void deleteAllUserJobInfo() {
        userJobInformationRepository.deleteAll();
    }

    private void checkData(UserJobInformation userJobInformation,
                           HttpServletResponse httpServletResponse) throws IOException {
        DataBinder binder = new DataBinder(userJobInformation);
        binder.setValidator(smartValidator);
        binder.validate();
        BindingResult bindingResult = binder.getBindingResult();

        if (bindingResult.hasErrors()) {
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameter is failure.");
        } else {
            userJobInformationRepository.save(userJobInformation);
            System.out.println("User Job Information retistered to Database.");
        }
    }
}
