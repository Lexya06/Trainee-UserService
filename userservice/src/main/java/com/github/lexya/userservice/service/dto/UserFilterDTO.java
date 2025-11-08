package com.github.lexya.userservice.service.dto;

import com.github.lexya.userservice.service.dto.validation.annotations.ValidName;
import com.github.lexya.userservice.service.dto.validation.annotations.ValidSurname;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserFilterDTO {
    @NotBlank
    @ValidName
    String userName;

    @ValidSurname
    String userSurname;
}
