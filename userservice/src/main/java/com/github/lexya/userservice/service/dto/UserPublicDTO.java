package com.github.lexya.userservice.service.dto;

import lombok.Data;

import java.util.List;

// dto for rest response
@Data
public class UserPublicDTO {
    private Long id;
    private boolean isUserActive;
    private List<CardInfoPublicDTO> cards;
}
