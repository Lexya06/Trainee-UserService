package com.github.lexya.userservice.service.dto;

import lombok.Data;

@Data
// dto for rest response
public class CardInfoPublicDTO {
    private Long id;
    boolean isCardActive;
    private UserPublicDTO user;
}
