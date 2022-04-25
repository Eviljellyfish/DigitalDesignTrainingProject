package com.kashigin.stanislav.controller;

import com.kashigin.stanislav.dto.UserDto;
import com.kashigin.stanislav.dto.map.UserMapper;
import org.springframework.web.bind.annotation.*;
import com.kashigin.stanislav.entity.*;
import com.kashigin.stanislav.service.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping(consumes = "application/json")
    public UserDto add(@RequestBody UserDto user) {
        return userMapper.convertToDto(userService.addUser(userMapper.convertToModel(user)));
    }

    @GetMapping
    public List<UserDto> getAll() {
        return userService.
                getAll().
                stream().
                map(user -> userMapper.convertToDto(user)).
                collect(Collectors.toList());
    }

    @GetMapping(path = "{id}")
    public Optional<UserDto> findById(@PathVariable Long id) {
        return userService.
                findUser(id).
                map(user -> userMapper.convertToDto(user));
    }

    @PutMapping(consumes = "application/json")
    public UserDto update(@RequestBody UserDto user) {
        return add(user);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable long id) {
        userService.deleteUser(id);
    }


}
