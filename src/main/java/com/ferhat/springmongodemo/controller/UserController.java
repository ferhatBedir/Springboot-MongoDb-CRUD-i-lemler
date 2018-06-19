package com.ferhat.springmongodemo.controller;


import com.ferhat.springmongodemo.entity.User;
import com.ferhat.springmongodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
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
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @GetMapping("/getAllUsers")
    public void getAllUsers() {
        userService.getAllUsers();
    }

    @PostMapping("/addUsers")
    public void addUsers(@RequestBody List<User> users) {
        userService.addUsers(users);
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
