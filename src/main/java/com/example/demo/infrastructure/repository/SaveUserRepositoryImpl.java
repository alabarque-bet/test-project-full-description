package com.example.demo.infrastructure.repository;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.SaveUserRepository;
import com.example.demo.infrastructure.entity.UserEntity;
import com.example.demo.infrastructure.util.PasswordHasher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SaveUserRepositoryImpl implements SaveUserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public void save(User user) {
        UserEntity userEntity = UserEntity.builder()
                .nombreCompleto(user.getNombreCompleto())
                .dni(user.getDni())
                .email(user.getEmail())
                .password(PasswordHasher.hash(user.getPassword()))
                .status(user.getStatus())
                .build();

        userJpaRepository.save(userEntity);
    }
} 