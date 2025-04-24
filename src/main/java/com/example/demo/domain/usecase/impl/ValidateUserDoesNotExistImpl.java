package com.example.demo.domain.usecase.impl;

import com.example.demo.domain.repository.GetUsersByEmailOrDocumentNumberRepository;
import com.example.demo.domain.usecase.ValidateUserDoesNotExist;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidateUserDoesNotExistImpl implements ValidateUserDoesNotExist {

    private final GetUsersByEmailOrDocumentNumberRepository getUsersByEmailOrDocumentNumberRepository;

    @Override
    public void execute(String email, String dni) {
        if (!getUsersByEmailOrDocumentNumberRepository.findByEmailOrDni(email, dni).isEmpty()) {
            throw new RuntimeException("User with provided email or DNI already exists");
        }
    }
} 