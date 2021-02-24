package com.example.usersapi.service;

import com.example.usersapi.dto.UserRequestDto;
import com.example.usersapi.dto.UserResponseDto;
import com.example.usersapi.entity.UserEntity;
import com.example.usersapi.exception.EntityNotFoundException;
import com.example.usersapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto getUserById(Long id) {
        return userRepository.findById(id)
                             .map(this::toUserResponseDto)
                             .orElseThrow(() -> new EntityNotFoundException(UserEntity.class.getSimpleName(), id));
    }

    @Override
    public UserResponseDto create(UserRequestDto userRequestDto) {
        var user = new UserEntity();
        user.setEmail(userRequestDto.getEmail());
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());

        UserEntity savedUser = userRepository.save(user);

        return toUserResponseDto(savedUser);
    }

    private UserResponseDto toUserResponseDto(UserEntity userEntity) {
        return UserResponseDto.builder()
                              .id(userEntity.getId())
                              .email(userEntity.getEmail())
                              .firstName(userEntity.getFirstName())
                              .lastName(userEntity.getLastName())
                              .build();
    }

}
