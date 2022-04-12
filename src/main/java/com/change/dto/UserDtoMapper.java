package com.change.dto;

import com.change.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
        UserDto usertoDto(User user);
        User dtoToUser(UserDto userDto);
    }

