package com.github.lexya.userservice.service.dto;

import com.github.lexya.userservice.service.dto.validation.annotations.ValidCardHolder;
import com.github.lexya.userservice.service.dto.validation.annotations.ValidCardNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.YearMonth;


@Data
public class CardInfoCreateDTO {
    @NotNull
    private Long user;

    @ValidCardNumber
    @NotBlank
    private String cardNumber;

    @ValidCardHolder
    @NotBlank
    private String holder;

    @NotNull
    private YearMonth expirationDate;

    private boolean isCardActive;

}
