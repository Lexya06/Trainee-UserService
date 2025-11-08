package com.github.lexya.userservice.service.dto;

import lombok.Data;

@Data
// dto for rest response
public class CardInfoPublicDTO {
    Long id;
    boolean isCardActive;
    UserPublicDTO user;
}
