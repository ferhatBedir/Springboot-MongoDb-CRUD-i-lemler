package com.ferhat.springmongodemo.service;


import com.ferhat.springmongodemo.entity.User;
import com.ferhat.springmongodemo.entity.UserWorkExperience;
import com.ferhat.springmongodemo.repository.UserRepository;
import com.ferhat.springmongodemo.repository.UserWorkExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.SmartValidator;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class UserWorkExperianceService {

    private UserRepository userRepository;
    private UserWorkExperienceRepository userWorkExperienceRepository;
    private SmartValidator smartValidator;


    @Autowired
    public UserWorkExperianceService(UserRepository userRepository,
                                     UserWorkExperienceRepository userWorkExperienceRepository,
                                     SmartValidator smartValidator) {
        this.userRepository = userRepository;
        this.userWorkExperienceRepository = userWorkExperienceRepository;
        this.smartValidator = smartValidator;
    }

    public void addUserWorkExperience(UserWorkExperience userWorkExperience) {
        userWorkExperienceRepository.save(userWorkExperience);
    }

    public void addUsersWorkExperience(List<UserWorkExperience> userWorkExperiences,
                                       HttpServletResponse httpServletResponse) throws IOException {
        for (UserWorkExperience temp : userWorkExperiences) {
            User user = userRepository.findByUserId(temp.getUserId());
            if (user != null) {
                checkData(temp, httpServletResponse);
            } else {
                System.out.println("User not found in Database.");
            }
        }
    }

    public void editUserWorkExperience(UserWorkExperience newUserWorkExperience) {
        UserWorkExperience oldUserWorkExperience = userWorkExperienceRepository.
                findByUserWorkExperienceId(newUserWorkExperience.getUserWorkExperienceId());
        if (oldUserWorkExperience != null) {
            oldUserWorkExperience.setCompanyName(newUserWorkExperience.getCompanyName());
            oldUserWorkExperience.setUserWorkTime(newUserWorkExperience.getUserWorkTime());
            userWorkExperienceRepository.save(oldUserWorkExperience);
        } else {
            System.out.println("User Work Experience not found in database.");
        }
    }

    public UserWorkExperience getUserWorkExperienceByUserWorkExperienceId(String userWorkExperinceId) {
        return userWorkExperienceRepository.findByUserWorkExperienceId(userWorkExperinceId);
    }

    public List<UserWorkExperience> getUserWorkExperienceByCompanyName(String companyName) {
        return userWorkExperienceRepository.findOneByCompanyName(companyName);
    }

    public List<UserWorkExperience> getAllUserWorkExperience() {
        return userWorkExperienceRepository.findAll();
    }

    public void deleteUserWorkExperience(String userWorkExperienceId) {
        UserWorkExperience userWorkExperience = userWorkExperienceRepository.
                findByUserWorkExperienceId(userWorkExperienceId);
        if (userWorkExperience != null) {
            userWorkExperienceRepository.delete(userWorkExperience);
        } else {
            System.out.println("User Work Experience not found in Database.");
        }
    }

    public void deleteAllUserWorkExperience() {
        userWorkExperienceRepository.deleteAll();
    }

    private void checkData(UserWorkExperience userWorkExperience,
                           HttpServletResponse httpServletResponse) throws IOException {
        DataBinder binder = new DataBinder(userWorkExperience);
        binder.setValidator(smartValidator);
        binder.validate();
        BindingResult bindingResult = binder.getBindingResult();

        if (bindingResult.hasErrors()) {
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameter is failure.");
        } else {
            userWorkExperienceRepository.save(userWorkExperience);
            System.out.println("User Work Experince retistered to Database.");
        }
    }
}
