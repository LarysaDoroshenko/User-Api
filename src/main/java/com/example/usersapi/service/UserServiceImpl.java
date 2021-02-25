package com.example.usersapi.service;

import com.example.usersapi.dto.UserRequestDto;
import com.example.usersapi.dto.UserResponseDto;
import com.example.usersapi.entity.UserEntity;
import com.example.usersapi.exception.EntityNotFoundException;
import com.example.usersapi.mapper.UserMapper;
import com.example.usersapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto getUserById(Long id) {
        return userRepository.findById(id)
                             .map(userMapper::userEntityToUserResponseDto)
                             .orElseThrow(() -> new EntityNotFoundException(UserEntity.class.getSimpleName(), id));
    }

    @Override
    public UserResponseDto create(UserRequestDto userRequestDto) {
        UserEntity userEntity = userMapper.userRequestDtoToUserEntity(userRequestDto);
        UserEntity savedUser = userRepository.save(userEntity);
        return userMapper.userEntityToUserResponseDto(savedUser);
    }

}
