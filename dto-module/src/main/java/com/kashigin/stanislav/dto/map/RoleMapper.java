package com.kashigin.stanislav.dto.map;

import com.kashigin.stanislav.dto.RoleDto;
import com.kashigin.stanislav.entity.Role;
import com.kashigin.stanislav.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper implements Mapper<Role, RoleDto> {

    private final ModelMapper modelMapper;

    private final RoleService roleService;

    public RoleMapper(ModelMapper modelMapper, RoleService roleService) {
        this.modelMapper = modelMapper;
        this.roleService = roleService;
    }

    @Override
    public RoleDto convertToDto(Role role) {
        RoleDto dto = modelMapper.map(role, RoleDto.class);
        return dto;
    }

    @Override
    public Role convertToModel(RoleDto roleDto) {
        Role role = modelMapper.map(roleDto, Role.class);
        return role;
    }
}
