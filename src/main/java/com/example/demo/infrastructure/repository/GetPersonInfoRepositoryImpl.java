package com.example.demo.infrastructure.repository;

import com.example.demo.domain.model.PersonInfo;
import com.example.demo.domain.repository.GetPersonInfoRepository;
import com.example.demo.infrastructure.dto.PersonInfoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@RequiredArgsConstructor
public class GetPersonInfoRepositoryImpl implements GetPersonInfoRepository {

    private final RestTemplate restTemplate;

    @Value("${external.service.person-info.url}")
    private String personInfoUrl;

    @Override
    public PersonInfo getPersonInfo(String dni) {
        PersonInfoResponseDTO response = restTemplate.getForObject(
                personInfoUrl + "?dni=" + dni,
                PersonInfoResponseDTO.class
        );

        if (response == null || response.getBirthDate() == null) {
            throw new RuntimeException("Unable to get person information");
        }

        return PersonInfo.builder()
                .birthDate(response.getBirthDate())
                .isDeceased(response.getFechaFallecido() != null)
                .build();
    }
} 