package com.example.demo.domain.usecase.impl;

import com.example.demo.domain.model.User;
import com.example.demo.domain.model.UserStatus;
import com.example.demo.domain.repository.SaveUserRepository;
import com.example.demo.domain.usecase.CreateUser;
import com.example.demo.domain.usecase.ValidateUserDoesNotExist;
import com.example.demo.domain.usecase.ValidateUserIsAliveAndIsAnAdult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserImpl implements CreateUser {
    
    private final SaveUserRepository saveUserRepository;
    private final ValidateUserDoesNotExist validateUserDoesNotExist;
    private final ValidateUserIsAliveAndIsAnAdult validateUserIsAliveAndIsAnAdult;

    @Override
    public void execute(User user) {
        validateUserDoesNotExist.execute(user.getEmail(), user.getDni());
        validateUserIsAliveAndIsAnAdult.execute(user.getDni());
        
        user.setStatus(UserStatus.NEW);
        saveUserRepository.save(user);
    }
} 