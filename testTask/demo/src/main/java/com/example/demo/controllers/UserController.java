package com.example.demo.controllers;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return  userService.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        return userService.findByIndex(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.createNewUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User userToUpdate){
        return userService.updateUser(id, userToUpdate);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

}
