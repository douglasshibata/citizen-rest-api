package br.edu.unyleya.aluno.citizen_rest_api.execeptions;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.edu.unyleya.aluno.citizen_rest_api.dto.ErrorDTO;

@ControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "Access denied", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({ NotFoundException.class })
    public ResponseEntity<Object> handleNotFoundException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                new ErrorDTO(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()), new HttpHeaders(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleExceptionGeneric(Exception ex, WebRequest request) {
        String message = Objects.nonNull(ex.getLocalizedMessage()) ? ex.getLocalizedMessage() : "Não encontrado";
        return new ResponseEntity<Object>(
                new ErrorDTO(message, HttpStatus.BAD_REQUEST, LocalDateTime.now()), new HttpHeaders(),
                HttpStatus.BAD_REQUEST);
    }

}
