package com.example.usersapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestDto {
    
    String firstName;
    String lastName;
    String email;
    
}
