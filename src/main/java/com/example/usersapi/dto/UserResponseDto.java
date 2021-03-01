package com.example.usersapi.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    
}
