package com.example.articulate.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import static com.example.articulate.constant.Constants.Default.PASSWORD_MIN_LENGTH;
import static com.example.articulate.constant.Constants.ErrorMessages.PASSWORD_MIN_LENGTH_MESSAGE;

@Data
public class LoginRequest {
    @NotBlank
    private String identifier;
    @NotBlank
    @Size(min = PASSWORD_MIN_LENGTH, message = PASSWORD_MIN_LENGTH_MESSAGE)
    private String password;
}
