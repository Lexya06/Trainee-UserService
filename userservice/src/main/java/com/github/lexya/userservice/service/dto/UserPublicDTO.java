package com.github.lexya.userservice.service.dto;

import lombok.Data;

import java.util.List;

// dto for rest response
@Data
public class UserPublicDTO {
    Long id;
    private boolean isUserActive;
    List<CardInfoPublicDTO> cards;
}
