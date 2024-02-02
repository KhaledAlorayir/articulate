package com.example.articulate.dto.user;

import com.example.articulate.constant.DbValidator;
import com.example.articulate.validator.ValueDoesntExistInDb;
import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import static com.example.articulate.constant.Constants.Default.DB_MAX_LENGTH;
import static com.example.articulate.constant.Constants.Default.MAX_USERNAME_LENGTH;
import static com.example.articulate.constant.Constants.ErrorMessages.*;
import static com.example.articulate.constant.Constants.Regex.SA_PHONE_NUMBER;

@Data
@GroupSequence({CreateUserRequest.class, DbValidator.class})
public class CreateUserRequest {
    @NotBlank
    @Size(max = MAX_USERNAME_LENGTH)
    @ValueDoesntExistInDb(tableName = "platform_user", fieldName = "username", message = USERNAME_USED, groups = DbValidator.class)
    private String username;
    @Email
    @Size(max = DB_MAX_LENGTH)
    @ValueDoesntExistInDb(tableName = "platform_user", fieldName = "email", message = EMAIL_USED,  groups = DbValidator.class)
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    @Pattern(regexp = SA_PHONE_NUMBER, message = PHONE_NUMBER_INVALID)
    @ValueDoesntExistInDb(tableName = "platform_user", fieldName = "mobile_number", message = PHONE_NUMBER_USED,  groups = DbValidator.class)
    private String mobileNumber;
}
