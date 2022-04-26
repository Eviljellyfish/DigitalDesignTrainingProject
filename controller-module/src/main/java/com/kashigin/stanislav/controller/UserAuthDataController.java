package com.kashigin.stanislav.controller;

import com.kashigin.stanislav.dto.UserAuthDataDto;
import com.kashigin.stanislav.dto.map.UserAuthDataMapper;
import com.kashigin.stanislav.service.UserAuthDataService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/v1/usersdata")
public class UserAuthDataController {

    private final UserAuthDataService userAuthDataService;
    private final UserAuthDataMapper userAuthDataMapper;

    public UserAuthDataController(UserAuthDataService userAuthDataService, UserAuthDataMapper userAuthDataMapper) {
        this.userAuthDataService = userAuthDataService;
        this.userAuthDataMapper = userAuthDataMapper;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(consumes = "application/json")
    public UserAuthDataDto add(@RequestBody UserAuthDataDto user) {
        return userAuthDataMapper.convertToDto(userAuthDataService.add(userAuthDataMapper.convertToModel(user)));
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(consumes = "application/json")
    public UserAuthDataDto update(@RequestBody UserAuthDataDto user) {
        return userAuthDataMapper.convertToDto(
                userAuthDataService.update(userAuthDataMapper.convertToModel(user))
        );
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable long id) {
        userAuthDataService.delete(id);
    }
}
