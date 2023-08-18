package com.customer.manage.controller;

import com.customer.manage.exceptions.UserNotFoundException;
import com.customer.manage.model.LoginRequest;
import com.customer.manage.model.User;
import com.customer.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    // -->  Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            User isAuthenticated = userService.authenticateUser(loginRequest);
            return ResponseEntity.ok(isAuthenticated);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found"); // or any other error response
        }
    }
    // --> Create New User
    @PostMapping("/register") // http://localhost:8010/api/users/register
    public ResponseEntity<String> saveUser(@RequestBody User user){
        try{
            String result = userService.saveUser(user);
            return ResponseEntity.ok(result);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save user");
        }
    }
    // --> Delete User By ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") String id) {
        try {
            String result = userService.deleteUser(id);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid user ID format"); // 11114s3
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user"); // deleted twice
        }
    }

}
