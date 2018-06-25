package com.ferhat.springmongodemo.controller;


import com.ferhat.springmongodemo.entity.User;
import com.ferhat.springmongodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/addUser")
    public void addUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("User bilgileri hatalı. \nLütfen düzeltip tekrar deneyiniz.");
        } else {
            userService.addUser(user);
        }

    }

    @GetMapping("/getUser")
    public void getUser(@RequestParam(value = "userId") Long id) {
        userService.getUser(id);
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestParam(value = "userId") Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/updateUser")
    public void updateUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("User bilgileri hatalı. \nLütfen düzeltip tekrar deneyiniz.");
        } else {
            userService.updateUser(user);
        }
    }

    @GetMapping("/getAllUsers")
    public void getAllUsers() {
        userService.getAllUsers();
    }

    @PostMapping("/addUsers")
    public void addUsers(@RequestBody @Valid List<User> users, BindingResult bindingResult) {
        for (User s : users) {
            userService.addUser(s);
        }
    }

    @DeleteMapping("/deleteAllUsers")
    public void deleteAllUsers() {
        userService.deleteAllusers();
    }

    @GetMapping("/getUserName")
    public void getUserName(@RequestParam(value = "userFirstName") String name) {
        userService.getUserName(name);
    }
}
