package com.example.demo.application.controller;

import com.example.demo.application.dto.CreateUserRequestDTO;
import com.example.demo.domain.model.User;
import com.example.demo.domain.usecase.CreateUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class CreateUserController {

    private final CreateUser createUser;

    @PostMapping
    public ResponseEntity<Void> createUser(@Valid @RequestBody CreateUserRequestDTO request) {
        User user = User.builder()
                .nombreCompleto(request.getNombreCompleto())
                .dni(request.getDni())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        createUser.execute(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
} 