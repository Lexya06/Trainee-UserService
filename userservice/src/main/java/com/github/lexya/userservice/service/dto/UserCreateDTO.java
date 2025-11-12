package com.github.lexya.userservice.service.dto;

import com.github.lexya.userservice.service.dto.validation.annotations.ValidName;
import com.github.lexya.userservice.service.dto.validation.annotations.ValidSurname;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserCreateDTO {

    @NotBlank
    @ValidName
    private String userName;

    @ValidSurname
    private String userSurname;

    @NotBlank
    @Email
    private String userEmail;

    @NotNull
    @Past
    private LocalDate userBirthday;

    private boolean isUserActive;
}
