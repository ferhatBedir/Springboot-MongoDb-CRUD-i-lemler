package com.ferhat.springmongodemo.controller;


import com.ferhat.springmongodemo.entity.UserFamilyInfo;
import com.ferhat.springmongodemo.service.UserFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
public class UserFamilyController {

    @Autowired
    private UserFamilyService userFamilyService;


    @PostMapping("/addUserFamily")
    public void adduserFamilyInfo(@RequestBody @Valid UserFamilyInfo userFamilyInfo,
                                  BindingResult bindingResult,
                                  HttpServletResponse httpServletResponse) throws IOException {
        if (bindingResult.hasErrors()) {
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            userFamilyService.addUserInfo(userFamilyInfo);
        }

    }

    @PostMapping("/addUsersFamily")
    public void addUsersFamily(@RequestBody @Valid List<UserFamilyInfo> userFamilyInfoList,
                               HttpServletResponse httpServletResponse) throws Exception {
        userFamilyService.addUsersfamilyInfo(userFamilyInfoList, httpServletResponse);
    }

    @GetMapping("/getUserFamily")
    public UserFamilyInfo getUserFamily(@RequestParam(value = "id") Long userId,
                                        @RequestParam(value = "familyId") Long familyId) {
        return userFamilyService.getUserInfo(familyId, userId);
    }
}
