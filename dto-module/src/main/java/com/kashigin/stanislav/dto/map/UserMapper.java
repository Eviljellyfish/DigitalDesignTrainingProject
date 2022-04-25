package com.kashigin.stanislav.dto.map;

import com.kashigin.stanislav.dto.UserDto;
import com.kashigin.stanislav.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, UserDto> {

    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto convertToDto(User user) {
        UserDto dto = modelMapper.map(user, UserDto.class);
        return dto;
    }

    @Override
    public User convertToModel(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return user;
    }
}
