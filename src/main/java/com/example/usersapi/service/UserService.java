package com.example.usersapi.service;

import com.example.usersapi.dto.UserRequestDto;
import com.example.usersapi.dto.UserResponseDto;

public interface UserService {
    
    UserResponseDto getUserById(Long id);

    UserResponseDto create(UserRequestDto userRequestDto);
    
}
