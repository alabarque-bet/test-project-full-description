package com.example.demo.infrastructure.repository;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.GetUsersByEmailOrDocumentNumberRepository;
import com.example.demo.infrastructure.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class GetUsersByEmailOrDocumentNumberRepositoryImpl implements GetUsersByEmailOrDocumentNumberRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public List<User> findByEmailOrDni(String email, String dni) {
        return userJpaRepository.findByEmailOrDni(email, dni)
                .stream()
                .map(this::mapToUser)
                .collect(Collectors.toList());
    }

    private User mapToUser(UserEntity userEntity) {
        return User.builder()
                .nombreCompleto(userEntity.getNombreCompleto())
                .dni(userEntity.getDni())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .status(userEntity.getStatus())
                .build();
    }
} 