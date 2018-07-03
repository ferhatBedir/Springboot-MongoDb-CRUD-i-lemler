package com.ferhat.springmongodemo.controller;

import com.ferhat.springmongodemo.entity.User;
import com.ferhat.springmongodemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public void add(@RequestBody @Valid User user,
                    BindingResult bindingResult,
                    HttpServletResponse httpServletResponse) throws IOException {
        if (bindingResult.hasErrors()) {
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameter is failud. \nPlease check parameters.");
        } else {
            userService.addUser(user);
        }
    }

    @PostMapping("/addlist")
    public void addList(@RequestBody List<User> users, HttpServletResponse httpServletResponse) throws IOException {
        userService.addUserList(users, httpServletResponse);
    }

    @PostMapping("edit")
    public void edit(@RequestBody @Valid User user,
                     BindingResult bindingResult,
                     HttpServletResponse httpServletResponse) throws IOException {
        if (bindingResult.hasErrors()) {
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameter is failud. \nPlease check parameters.");
        } else {
            userService.editUser(user);
        }
    }

    @GetMapping("/getuserbyid")
    public User getUserById(@RequestParam(value = "userid") String userId) {
        return userService.getUserByUserId(userId);
    }

    @GetMapping("/getuserbyname")
    public List<User> getUserByName(@RequestParam(value = "username") String userName) {
        return userService.getUserByUserName(userName);
    }

    @GetMapping("/getallusers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam(value = "userid") String userId) {
        userService.deleteUserByUserId(userId);
    }

    @DeleteMapping("/deleteall")
    public void deleteAll() {
        userService.deleteAllUsers();
    }

}
