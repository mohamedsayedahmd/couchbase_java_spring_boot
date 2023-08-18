package com.customer.manage.service;

import com.customer.manage.exceptions.UserNotFoundException;
import com.customer.manage.model.LoginRequest;
import com.customer.manage.model.User;
import com.customer.manage.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

//    public String saveUser(User user){
//        userRepo.save(user);
//        return "user Saved Successfully!!";
//    }
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
    public User authenticateUser(LoginRequest loginRequest) throws UserNotFoundException {
        String storedPassword = "123456";
        String username = loginRequest.getUsername();

        Optional<User> optionalUser = Optional.ofNullable(userRepo.findByEmail(username)); // Assuming you have a method findByEmail in your userRepo

        if (!optionalUser.isPresent()) { //isPresent It is used to check whether an Optional instance contains a non-null value or not.
            throw new UserNotFoundException("User not found for ID: " + loginRequest.getUsername());

        } else {
            User retrievedUser = optionalUser.get();
            // Compare the stored password with the input password (you should hash and compare securely)
            if (storedPassword.equals(loginRequest.getPassword())) {
                System.out.println("Retrieved User: " + retrievedUser);
                System.out.println("user password: " + retrievedUser.getPassword());
                return retrievedUser;
            } else {
                return null;
//                return "Invalid credentials";
            }
        }
    }
    public String saveUser(User user){
        try {
            userRepo.save(user);
            return "User saved successfully";
        }catch (Exception e){
            throw new RuntimeException("Failed to save user", e);
        }
    }
    public String deleteUser(String id){
        try{
            userRepo.deleteById(Integer.valueOf(id));
            return "This user was deleted successfully";
        }catch (Exception e){
            throw new RuntimeException("Error");
        }
    }
}
