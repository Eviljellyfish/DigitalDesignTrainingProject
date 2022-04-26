package com.kashigin.stanislav.dto.map;

import com.kashigin.stanislav.dto.UserAuthDataDto;
import com.kashigin.stanislav.entity.UserAuthData;
import com.kashigin.stanislav.service.RoleService;
import com.kashigin.stanislav.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserAuthDataMapper implements Mapper<UserAuthData, UserAuthDataDto>{

    private final ModelMapper modelMapper;

    private final UserService userService;
    private final RoleService roleService;

    public UserAuthDataMapper(ModelMapper modelMapper, UserService userService, RoleService roleService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public UserAuthDataDto convertToDto(UserAuthData userAuthData) {
        UserAuthDataDto dto = new UserAuthDataDto(userAuthData.getLogin(), userAuthData.getHash());
        if (userAuthData.getRole() != null)
            dto.setRole(userAuthData.getRole().getId());
        else
            dto.setRole(0);
        if (userAuthData.getUser() != null)
            dto.setUser(userAuthData.getUser().getId());
        else
            dto.setUser(0);
        return dto;
    }

    @Override
    public UserAuthData convertToModel(UserAuthDataDto userAuthDataDto) {
        UserAuthData model = modelMapper.map(userAuthDataDto, UserAuthData.class);
        if (userAuthDataDto.getRole() != 0)
            model.setRole(roleService.find(userAuthDataDto.getRole()).get());
        else
            model.setRole(null);
        if (userAuthDataDto.getUser() != 0)
            model.setUser(userService.findUser(userAuthDataDto.getId()).get());
        else
            model.setUser(null);
        return model;
    }
}
