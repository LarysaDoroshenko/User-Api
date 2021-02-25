package com.example.usersapi.mapper;

import com.example.usersapi.dto.UserRequestDto;
import com.example.usersapi.dto.UserResponseDto;
import com.example.usersapi.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    UserResponseDto userEntityToUserResponseDto(UserEntity userEntity);
    
    UserEntity userRequestDtoToUserEntity(UserRequestDto userRequestDto);
    
}
