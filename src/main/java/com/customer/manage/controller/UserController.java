package com.customer.manage.controller;

import com.customer.manage.model.User;
import com.customer.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @GetMapping("/getAllUsers")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

}
