package com.example.demo.domain.usecase;

public interface ValidateUserDoesNotExist {
    void execute(String email, String dni);
} 