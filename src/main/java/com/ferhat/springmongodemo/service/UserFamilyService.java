package com.ferhat.springmongodemo.service;


import com.ferhat.springmongodemo.entity.User;
import com.ferhat.springmongodemo.entity.UserFamilyInfo;
import com.ferhat.springmongodemo.repository.UserFamilyRepository;
import com.ferhat.springmongodemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.SmartValidator;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class UserFamilyService {

    private UserFamilyRepository userFamilyRepository;
    private UserRepository userRepository;
    private SmartValidator smartValidator;

    @Autowired
    public UserFamilyService(UserFamilyRepository userFamilyRepository,
                             UserRepository userRepository, SmartValidator smartValidator) {
        this.userFamilyRepository = userFamilyRepository;
        this.userRepository = userRepository;
        this.smartValidator = smartValidator;
    }

    public void addUsersfamilyInfo(List<UserFamilyInfo> userFamilyInfoList,
                                   HttpServletResponse httpServletResponse) throws Exception {
        for (UserFamilyInfo userFamilyInfo : userFamilyInfoList) {
            User user = userRepository.findOneByUserId(userFamilyInfo.getUserId());
            if (user != null) {
                userFamilyInfo.setUser(user);
                controllValidator(userFamilyInfo, httpServletResponse, user);
            } else {
                System.out.println();
                System.out.println("Aranılan User Bulunamadı.\nLütfen dogru giriniz ve aratınız.");
            }
        }
    }

    public void addUserInfo(UserFamilyInfo userFamilyInfo) {
        User user = userRepository.findOneByUserId(userFamilyInfo.getUserId());
        if (user != null) {
            userFamilyInfo.setUser(user);
            userFamilyRepository.save(userFamilyInfo);
            System.out.println();
            System.out.println("User Id --> " + user.getUserId());
            System.out.println("User Name --> " + user.getUserFirstName());
            System.out.println("User Surname --> " + user.getUserLastName());
            System.out.println("User Department Name --> " + user.getUserDepartmentName());
            System.out.println("User Email --> " + user.getUserEmail());
            System.out.println("User Mother name and surname --> " + userFamilyInfo.getMotherFirstName() + " " +
                    userFamilyInfo.getMotherLastName());
            System.out.println("User father name and surname -->" + userFamilyInfo.getFatherFirstName() + " " +
                    userFamilyInfo.getFatherLastName());
            System.out.println("*********************************************");
        } else {
            System.out.println("Aranılan User Bulunamadı.\n Lütfen dogru giriniz ve aratınız.");
        }
    }

    public UserFamilyInfo getUserInfo(Long userFamilyId, Long userId) {
        UserFamilyInfo userFamilyInfo = userFamilyRepository.findFirstByUserFamilyIdAndUserId(userFamilyId, userId);
        System.out.println("User Id --> " + userFamilyInfo.getUser().getUserId());
        System.out.println("User Name --> " + userFamilyInfo.getUser().getUserFirstName());
        System.out.println("User Surname --> " + userFamilyInfo.getUser().getUserLastName());
        System.out.println("User Department --> " + userFamilyInfo.getUser().getUserDepartmentName());
        System.out.println("User Email --> " + userFamilyInfo.getUser().getUserEmail());
        System.out.println("User Family Id --> " + userFamilyInfo.getUserFamilyId());
        System.out.println("User Mother Name And Surname --> " + userFamilyInfo.getMotherFirstName() + " " + userFamilyInfo.getMotherLastName());
        System.out.println("User Father Name And Surname --> " + userFamilyInfo.getFatherFirstName() + " " + userFamilyInfo.getFatherLastName());
        return userFamilyInfo;

    }

    public void controllValidator(UserFamilyInfo userFamilyInfo, HttpServletResponse httpServletResponse, User user) throws Exception {
        DataBinder binder = new DataBinder(userFamilyInfo);
        binder.setValidator(smartValidator);
        binder.validate();
        BindingResult bindingResult = binder.getBindingResult();

        if (bindingResult.hasErrors()) {
            System.out.println();
            System.out.println("Gönderilen parametre bilgileri hatalı.. \nLütfen gönderdiğiniz parametreyi kontrol ediniz ve " +
                    "işlemi tekrarlayınız.");
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            userFamilyRepository.save(userFamilyInfo);
            System.out.println();
            System.out.println("User Id --> " + user.getUserId());
            System.out.println("User Name --> " + user.getUserFirstName());
            System.out.println("User Surname --> " + user.getUserLastName());
            System.out.println("User Department Name --> " + user.getUserDepartmentName());
            System.out.println("User Email --> " + user.getUserEmail());
            System.out.println("User Mother name and surname --> " + userFamilyInfo.getMotherFirstName() + " " +
                    userFamilyInfo.getMotherLastName());
            System.out.println("User father name and surname -->" + userFamilyInfo.getFatherFirstName() + " " +
                    userFamilyInfo.getFatherLastName());
            System.out.println("*********************************************");
        }
    }


}
