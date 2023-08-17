package com.customer.manage.service;

import com.customer.manage.model.User;
import com.customer.manage.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public String saveUser(User user){
        userRepo.save(user);
        return "user Saved Successfully!!";
    }
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
}
