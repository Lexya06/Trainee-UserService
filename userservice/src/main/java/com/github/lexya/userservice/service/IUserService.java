package com.github.lexya.userservice.service;

import com.github.lexya.userservice.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    UserPublicDTO createUser(UserCreateDTO userCreateDTO);
    CardInfoPublicDTO createCardInfo(CardInfoCreateDTO cardInfo);
    UserPublicDTO updateUserById(Long id, UserUpdateDTO userUpdateDTO);
    CardInfoPublicDTO updateCardInfoById(Long id, CardInfoUpdateDTO cardInfo);
    UserPublicDTO getUserById(Long id);
    List<CardInfoPublicDTO> getAllCardsByUserId(Long id);
    UserPublicDTO activateUser(Long id);
    UserPublicDTO deactivateUser(Long id);
    CardInfoPublicDTO activateCard(Long id);
    CardInfoPublicDTO deactivateCard(Long id);
    CardInfoPublicDTO removeCard(Long id);
    UserPublicDTO removeUser(Long id);
    Page<UserPublicDTO> getUsers(UserFilterDTO filter, Pageable pageable);
}
