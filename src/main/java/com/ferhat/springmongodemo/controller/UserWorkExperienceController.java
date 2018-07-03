package com.ferhat.springmongodemo.controller;

import com.ferhat.springmongodemo.entity.UserWorkExperience;
import com.ferhat.springmongodemo.service.UserWorkExperianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/userworkexperience")
public class UserWorkExperienceController {


    private UserWorkExperianceService userWorkExperianceService;


    @Autowired
    public UserWorkExperienceController(UserWorkExperianceService userWorkExperianceService) {
        this.userWorkExperianceService = userWorkExperianceService;
    }

    @PostMapping("/add")
    public void add(@RequestBody @Valid UserWorkExperience userWorkExperience,
                    BindingResult bindingResult,
                    HttpServletResponse httpServletResponse) throws IOException {
        if (bindingResult.hasErrors()) {
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameter is failud. \nPlease check parameters.");
        } else {
            userWorkExperianceService.addUserWorkExperience(userWorkExperience);
        }
    }

    @PostMapping("/addlist")
    public void addList(@RequestBody List<UserWorkExperience> userWorkExperienceList,
                        HttpServletResponse httpServletResponse) throws IOException {
        userWorkExperianceService.addUsersWorkExperience(userWorkExperienceList, httpServletResponse);
    }

    @PostMapping("/edit")
    public void edit(@RequestBody @Valid UserWorkExperience userWorkExperience,
                     BindingResult bindingResult,
                     HttpServletResponse httpServletResponse) throws IOException {
        if (bindingResult.hasErrors()) {
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameter is failud. \nPlease check parameters.");
        } else {
            userWorkExperianceService.editUserWorkExperience(userWorkExperience);
        }
    }

    @GetMapping("/userworkexperiencebyid")
    public UserWorkExperience getUserWorkExperienceById(@RequestParam(value = "id") String userWorkExperience) {
        return userWorkExperianceService.getUserWorkExperienceByUserWorkExperienceId(userWorkExperience);
    }

    @GetMapping("/userworkexperiencebycompanyname")
    public List<UserWorkExperience> getUserWorkExperienceByCompanyName(
            @RequestParam(value = "companyname") String userCompanyName) {
        return userWorkExperianceService.getUserWorkExperienceByCompanyName(userCompanyName);
    }

    @GetMapping("/getalluserworkexperience")
    public List<UserWorkExperience> getAllUserworkExperience() {
        return userWorkExperianceService.getAllUserWorkExperience();
    }

    @DeleteMapping("delete")
    public void delete(@RequestParam(value = "id") String userWorkExperience) {
        userWorkExperianceService.deleteUserWorkExperience(userWorkExperience);
    }

    @DeleteMapping("/deletealluserworkexperience")
    public void deleteAll() {
        userWorkExperianceService.deleteAllUserWorkExperience();
    }


}
