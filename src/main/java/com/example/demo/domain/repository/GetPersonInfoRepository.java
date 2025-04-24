package com.example.demo.domain.repository;

import com.example.demo.domain.model.PersonInfo;

public interface GetPersonInfoRepository {
    PersonInfo getPersonInfo(String dni);
} 