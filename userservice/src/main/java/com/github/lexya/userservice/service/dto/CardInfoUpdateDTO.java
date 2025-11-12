package com.github.lexya.userservice.service.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CardInfoUpdateDTO {
    boolean isCardActive;
    Long user;
}
