package com.ferhat.springmongodemo.controller;


import com.ferhat.springmongodemo.entity.User;
import com.ferhat.springmongodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

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
}
