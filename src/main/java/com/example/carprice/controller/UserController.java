package com.example.carprice.controller;

import com.example.carprice.entity.User;
import com.example.carprice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PostMapping("/")
    public User adduser(@RequestBody User user){
        userService.saveUser(user);
        return user;
    }
    @PutMapping("/")
    public User updateUser(@RequestBody User user){
        userService.saveUser(user);
        return user;

    }
}
