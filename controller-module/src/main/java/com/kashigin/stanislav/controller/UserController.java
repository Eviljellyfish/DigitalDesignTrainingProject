package com.kashigin.stanislav.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import com.kashigin.stanislav.entity.*;
import com.kashigin.stanislav.service.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = "application/json")
    public User add(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping(path = "{id}")
    public Optional<User> findById(@PathVariable Long id) {
        return userService.findUser(id);
    }

    @PutMapping(consumes = "application/json")
    public User update(@RequestBody User user) {
        return add(user);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable long id) {
        userService.deleteUser(id);
    }


}
