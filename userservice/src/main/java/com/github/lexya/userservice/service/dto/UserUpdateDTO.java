package com.github.lexya.userservice.service.dto;

import com.github.lexya.userservice.service.dto.validation.annotations.ValidName;
import com.github.lexya.userservice.service.dto.validation.annotations.ValidSurname;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserUpdateDTO{
    @ValidName
    String userName;

    @ValidSurname
    String userSurname;

    @Email
    String userEmail;

    boolean isUserActive;
}
