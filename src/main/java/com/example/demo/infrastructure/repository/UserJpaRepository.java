package com.example.demo.infrastructure.repository;

import com.example.demo.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    
    @Query("SELECT u FROM UserEntity u WHERE u.email = :email OR u.dni = :dni")
    List<UserEntity> findByEmailOrDni(@Param("email") String email, @Param("dni") String dni);
} 