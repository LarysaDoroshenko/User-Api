package com.example.usersapi.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserResponseDto {
    
    Long id;
    String firstName;
    String lastName;
    String email;
    
}
