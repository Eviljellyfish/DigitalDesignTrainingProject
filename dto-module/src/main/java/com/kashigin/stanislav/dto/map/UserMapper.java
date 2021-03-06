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

    private final OrgStructureService orgStructureService;


    public UserMapper(ModelMapper modelMapper, OrgStructureService orgStructureService) {
        this.modelMapper = modelMapper;
        this.orgStructureService = orgStructureService;
    }

    @Override
    public UserDto convertToDto(User user) {
        UserDto dto = new UserDto(user.getId(), user.getFirstName(),
                                user.getSecondName());
        if (user.getOrg() != null)
            dto.setOrg(user.getOrg().getId());
        dto.setPosition(user.getPosition());
        return dto;
    }

    @Override
    public User convertToModel(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        if (userDto.getOrg() != 0)
            user.setOrg(orgStructureService.findOrg(userDto.getOrg()).get());
        return user;
    }
}
