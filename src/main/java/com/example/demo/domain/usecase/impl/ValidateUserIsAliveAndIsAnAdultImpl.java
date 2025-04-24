package com.example.demo.domain.usecase.impl;

import com.example.demo.domain.model.PersonInfo;
import com.example.demo.domain.repository.GetPersonInfoRepository;
import com.example.demo.domain.usecase.ValidateUserIsAliveAndIsAnAdult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
@RequiredArgsConstructor
public class ValidateUserIsAliveAndIsAnAdultImpl implements ValidateUserIsAliveAndIsAnAdult {

    private final GetPersonInfoRepository getPersonInfoRepository;

    @Override
    public void execute(String dni) {
        PersonInfo personInfo = getPersonInfoRepository.getPersonInfo(dni);
        
        if (personInfo.isDeceased()) {
            throw new RuntimeException("Person is deceased");
        }

        if (Period.between(personInfo.getBirthDate(), LocalDate.now()).getYears() < 18) {
            throw new RuntimeException("Person must be at least 18 years old");
        }
    }
} 