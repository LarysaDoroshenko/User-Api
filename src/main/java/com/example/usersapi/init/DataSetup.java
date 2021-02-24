package com.example.usersapi.init;

import com.example.usersapi.entity.UserEntity;
import com.example.usersapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Profile("dev")
@Component
@RequiredArgsConstructor
public class DataSetup {
    
    private final UserRepository userRepository;
    
    @PostConstruct
    public void setupData() {
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setEmail("bruce.wayne@gmail.com");
        user.setFirstName("Bruce");
        user.setLastName("Wayne");
        userRepository.save(user);
    }
    
}
