package com.example.usersapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {
    
    Long id;
    String firstName;
    String lastName;
    String email;
    
}
