package com.example.articulate.config;

import com.example.articulate.exception.ServerErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

import static com.example.articulate.constant.Constants.ErrorMessages.GENERIC_SERVER_ERROR;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity.badRequest().body(ex.getBindingResult().getFieldErrors().stream().map(
                fieldError -> String.format("%s: %s", fieldError.getField(), fieldError.getDefaultMessage())
        ));
    }

    @ExceptionHandler(ServerErrorException.class)
    protected ResponseEntity<Object> handleServerErrorException(ServerErrorException ex) {
        return ResponseEntity.internalServerError().body(List.of(GENERIC_SERVER_ERROR));
    }
}
