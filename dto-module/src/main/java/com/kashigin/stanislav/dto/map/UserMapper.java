package com.kashigin.stanislav.dto.map;

import com.kashigin.stanislav.dto.UserDto;
import com.kashigin.stanislav.entity.User;
import com.kashigin.stanislav.service.OrgStructureService;
import com.kashigin.stanislav.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, UserDto> {

    private final ModelMapper modelMapper;

    private final RoleService roleService;
    private final OrgStructureService orgStructureService;


    public UserMapper(ModelMapper modelMapper, RoleService roleService, OrgStructureService orgStructureService) {
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.orgStructureService = orgStructureService;
    }

    @Override
    public UserDto convertToDto(User user) {
        UserDto dto = new UserDto(user.getId(), user.getFirstName(),
                                user.getSecondName(), user.getRole().getName(),
                                user.getOrg().getId(), user.getPosition());
        return dto;
    }

    @Override
    public User convertToModel(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setRole(roleService.find(userDto.getRole()));
        user.setOrg(orgStructureService.findOrg(userDto.getOrg()).get());
        return user;
    }
}
