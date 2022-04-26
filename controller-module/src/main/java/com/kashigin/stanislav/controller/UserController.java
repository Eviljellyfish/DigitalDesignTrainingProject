package com.kashigin.stanislav.controller;

import com.kashigin.stanislav.dto.UserDto;
import com.kashigin.stanislav.dto.map.UserMapper;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(consumes = "application/json")
    public UserDto add(@RequestBody UserDto user) {
        return userMapper.convertToDto(userService.addUser(userMapper.convertToModel(user)));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping
    public List<UserDto> getAll() {
        return userService.
                getAll().
                stream().
                map(user -> userMapper.convertToDto(user)).
                collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping(path = "{id}")
    public Optional<UserDto> findById(@PathVariable Long id) {
        return userService.
                findUser(id).
                map(user -> userMapper.convertToDto(user));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(consumes = "application/json")
    public UserDto update(@RequestBody UserDto user) {
        return userMapper.convertToDto(
                userService.updateUser(userMapper.convertToModel(user))
        );
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable long id) {
        userService.deleteUser(id);
    }


}
