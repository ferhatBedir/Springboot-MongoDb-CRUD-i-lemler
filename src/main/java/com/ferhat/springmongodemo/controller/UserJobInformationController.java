package com.ferhat.springmongodemo.controller;

import com.ferhat.springmongodemo.entity.UserJobInformation;
import com.ferhat.springmongodemo.service.UserJobInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/userjobinformation")
public class UserJobInformationController {

    private UserJobInformationService userJobInformationService;

    @Autowired
    public UserJobInformationController(UserJobInformationService userJobInformationService) {
        this.userJobInformationService = userJobInformationService;
    }


    @PostMapping("/add")
    public void add(@RequestBody @Valid UserJobInformation userJobInfo,
                    BindingResult bindingResult,
                    HttpServletResponse httpServletResponse) throws IOException {
        if (bindingResult.hasErrors()) {
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameter is failud. \nPlease check parameters.");
        } else {
            userJobInformationService.addUserJobInfo(userJobInfo);
        }

    }

    @PostMapping("/addlist")
    public void addList(@RequestBody List<UserJobInformation> userJobInformationList,
                        HttpServletResponse httpServletResponse) throws IOException {
        userJobInformationService.addUsersJobInfo(userJobInformationList, httpServletResponse);
    }

    @PostMapping("/edit")
    public void editUser(@RequestBody @Valid UserJobInformation userJobInfo,
                         BindingResult bindingResult,
                         HttpServletResponse httpServletResponse) throws IOException {
        if (bindingResult.hasErrors()) {
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameter is failud. \nPlease check parameters.");
        } else {
            userJobInformationService.editUserJobInfo(userJobInfo);
        }
    }

    @GetMapping("/getuserjobinfobyid")
    public UserJobInformation getUserJobInfoById(@RequestParam(value = "id") String userJobInfoId) {
        return userJobInformationService.getUserJobInfo(userJobInfoId);
    }

    @GetMapping("/getuserjobinfobydepartment")
    public List<UserJobInformation> getUserJobInfoByDepartmentName(@RequestParam(value = "departmentname") String departmentName) {
        return userJobInformationService.getUsersJobInfoByUserJobDepartment(departmentName);
    }

    @GetMapping("/getalluserjobinfo")
    public List<UserJobInformation> getAllUserJobInfo() {
        return userJobInformationService.getAllUsersJobInfo();
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam(value = "id") String userJobInfoId) {
        userJobInformationService.deleteUserJobınfo(userJobInfoId);
    }

    @DeleteMapping("/deleteall")
    public void deelteAll() {
        userJobInformationService.deleteAllUserJobInfo();
    }
}
