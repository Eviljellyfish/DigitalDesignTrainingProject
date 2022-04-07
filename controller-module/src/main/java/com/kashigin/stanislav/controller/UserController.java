package com.kashigin.stanislav.controller;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import com.kashigin.stanislav.entity.*;
import com.kashigin.stanislav.service.*;

import java.util.List;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User add(User user) {
        throw new NotImplementedException();
    }

    public User findById(int id) {
        throw new NotImplementedException();
    }

    public List<User> findByFirstName(String name) {
        throw new NotImplementedException();
    }

    public List<User> findByFirstNameAndSecondName(String firstName, String secondName) {
        throw new NotImplementedException();
    }

    public boolean delete(User user) {
        throw new NotImplementedException();
    }


}
