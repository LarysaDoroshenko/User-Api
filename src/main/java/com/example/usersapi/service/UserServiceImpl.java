package com.example.usersapi.service;

import com.example.usersapi.dto.UserRequestDto;
import com.example.usersapi.dto.UserResponseDto;
import com.example.usersapi.entity.UserEntity;
import com.example.usersapi.exception.ResourceNotFoundException;
import com.example.usersapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                                              .orElseThrow(() -> new ResourceNotFoundException(UserEntity.class.getSimpleName(), id));

        return UserResponseDto.builder()
                              .id(userEntity.getId())
                              .email(userEntity.getEmail())
                              .firstName(userEntity.getFirstName())
                              .lastName(userEntity.getLastName())
                              .build();
    }

    @Override
    public UserResponseDto create(UserRequestDto userRequestDto) {
        var user = new UserEntity();
        user.setEmail(userRequestDto.getEmail());
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());

        UserEntity savedUser = userRepository.save(user);

        return UserResponseDto.builder()
                              .id(savedUser.getId())
                              .email(savedUser.getEmail())
                              .firstName(savedUser.getFirstName())
                              .lastName(savedUser.getLastName())
                              .build();
    }

}
