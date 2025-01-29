package br.edu.unyleya.aluno.citizen_rest_api.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public record ErrorDTO(String message, HttpStatus status, LocalDateTime time) {
    
}
