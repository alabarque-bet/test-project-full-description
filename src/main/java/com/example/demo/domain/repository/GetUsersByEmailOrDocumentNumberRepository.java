package com.example.demo.domain.repository;

import com.example.demo.domain.model.User;
import java.util.List;

public interface GetUsersByEmailOrDocumentNumberRepository {
    List<User> findByEmailOrDni(String email, String dni);
} 