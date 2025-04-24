package com.example.demo.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonInfoResponseDTO {
    
    @JsonProperty("fecha_nacimiento")
    private LocalDate birthDate;
    
    @JsonProperty("fecha_fallecido")
    private LocalDate fechaFallecido;
} 