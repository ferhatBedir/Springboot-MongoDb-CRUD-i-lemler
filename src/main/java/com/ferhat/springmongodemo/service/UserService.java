package com.ferhat.springmongodemo.service;

import com.ferhat.springmongodemo.entity.User;
import com.ferhat.springmongodemo.repository.UserJobInformationRepository;
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
public class UserService {

    private UserRepository userRepository;
    private SmartValidator smartValidator;
    private UserJobInformationRepository userJobInfo;
    private UserWorkExperienceRepository userWorkExperienceRepository;

    @Autowired
    public UserService(UserRepository userRepository,
                       SmartValidator smartValidator,
                       UserJobInformationRepository userJobInfo,
                       UserWorkExperienceRepository userWorkExperienceRepository) {
        this.userRepository = userRepository;
        this.smartValidator = smartValidator;
        this.userJobInfo = userJobInfo;
        this.userWorkExperienceRepository = userWorkExperienceRepository;
    }

    public void addUser(User newUser) {
        User user = userRepository.findByUserId(newUser.getUserId());
        if (user == null) {
            userRepository.save(newUser);
            System.out.println("User registered to Database.");
        } else {
            System.out.println("User already registered to Database.");
        }
    }

    public void addUserList(List<User> users, HttpServletResponse httpServletResponse) throws IOException {
        if (users == null) {
            System.out.println("List not must be empty !");
        }
        for (User temp : users) {
            checkData(temp, httpServletResponse);
        }
    }

    public void editUser(User newUser) {
        User user = userRepository.findByUserId(newUser.getUserId());
        if (user != null) {
            user.setUserFirstName(newUser.getUserFirstName());
            user.setUserLastName(newUser.getUserLastName());
            user.setUserAge(newUser.getUserAge());
            user.setUserPhoneNum(newUser.getUserPhoneNum());
            user.setUserIdentityNumber(newUser.getUserIdentityNumber());
            user.setUserNationality(newUser.getUserNationality());
            user.setUserJobInfo(newUser.getUserJobInfo());
            user.setUserWorkExperience(newUser.getUserWorkExperience());

            userRepository.save(user);
            System.out.println("User updated.");
        } else {
            System.out.println("User not found in database.");
        }
    }

    public User getUserByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    public List<User> getUserByUserName(String userName) {
        return userRepository.findOneByUserFirstNameIgnoreCase(userName);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserByUserId(String userId) {
        User user = userRepository.findByUserId(userId);
        if (user != null) {
            userRepository.delete(user);
        } else {
            System.out.println("User not found in database.");
        }
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
        System.out.println("All users deleted.");
    }

    private void checkData(User user, HttpServletResponse httpServletResponse) throws IOException {
        DataBinder binder = new DataBinder(user);
        binder.setValidator(smartValidator);
        binder.validate();
        BindingResult bindingResult = binder.getBindingResult();

        if (bindingResult.hasErrors()) {
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameter is failure.");
        } else {
            userRepository.save(user);
            System.out.println("User registered to Database.");
        }
    }


}
