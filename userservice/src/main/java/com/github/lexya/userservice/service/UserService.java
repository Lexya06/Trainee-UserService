package com.github.lexya.userservice.service;

import com.github.lexya.userservice.service.dto.*;
import com.github.lexya.userservice.service.mapper.CardMapper;
import com.github.lexya.userservice.service.mapper.UserMapper;
import com.github.lexya.userservice.model.CardInfo;
import com.github.lexya.userservice.model.User;
import com.github.lexya.userservice.repository.CardInfoRepository;
import com.github.lexya.userservice.repository.UserRepository;
import com.github.lexya.userservice.service.specification.UserSpecifications;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    final UserRepository userRepository;
    final CardInfoRepository cardInfoRepository;
    final UserMapper userMapper;
    final CardMapper cardMapper;

    final int maxUserCards = 5;

    @Autowired
    public UserService(UserRepository userRepository, CardInfoRepository cardInfoRepository, UserMapper userMapper, CardMapper cardMapper) {
        this.userRepository = userRepository;
        this.cardInfoRepository = cardInfoRepository;
        this.userMapper = userMapper;
        this.cardMapper = cardMapper;
    }


    @Override
    public UserPublicDTO createUser(UserCreateDTO userCreateDTO) {
        User entity = userMapper.toEntity(userCreateDTO);
        entity = userRepository.save(entity);
        return userMapper.toDto(entity);
    }

    @Override
    public CardInfoPublicDTO createCardInfo(CardInfoCreateDTO cardInfo) {
        CardInfo entity = cardMapper.toEntity(cardInfo,userRepository);
        if (cardInfoRepository.countCardInfoByUserId(entity.getId()) > maxUserCards) {
            throw new IllegalArgumentException("Количество карт уже максимально");
        }
        entity = cardInfoRepository.save(entity);
        return cardMapper.toDto(entity);
    }

    @Transactional
    @Override
    public UserPublicDTO updateUserById(Long id, UserUpdateDTO userUpdateDTO) {
        User entity = userRepository.findUserById(id).orElseThrow(()->new EntityNotFoundException("User with id = " + id + "not found"));
        userMapper.updateEntity(userUpdateDTO, entity);
        return userMapper.toDto(entity);
    }

    @Transactional
    @Override
    public CardInfoPublicDTO updateCardInfoById(Long id, CardInfoUpdateDTO cardInfo) {
        CardInfo entity = cardInfoRepository.findCardInfoById(id).orElseThrow(()->new EntityNotFoundException("Card with id = " + id + "not found"));
        cardMapper.updateEntity(cardInfo, entity);
        return cardMapper.toDto(entity);
    }

    @Override
    public UserPublicDTO getUserById(Long id) {
        return userMapper.toDto(userRepository.findUserById(id).orElseThrow(()->new EntityNotFoundException("User with id = " + id + "not found")));
    }

    @Override
    public List<CardInfoPublicDTO> getAllCardsByUserId(Long id) {
        List<CardInfo> entity = cardInfoRepository.findCardInfoByUserId(id);
        return entity.stream().map(cardMapper::toDto).collect(Collectors.toList());
    }


    @Transactional
    @Override
    public UserPublicDTO activateUser(Long id) {
        return updateUserById(id,UserUpdateDTO.builder().isUserActive(true).build());
    }

    // all cards also?
    @Transactional
    @Override
    public UserPublicDTO deactivateUser(Long id) {
        return updateUserById(id,UserUpdateDTO.builder().isUserActive(false).build());
    }

    // when user only active?
    @Transactional
    @Override
    public CardInfoPublicDTO activateCard(Long id) {
        CardInfo cardInfo = cardInfoRepository.findCardInfoById(id).orElseThrow(()->new EntityNotFoundException("Card with id = " + id + "not found"));
        User user = cardInfo.getUser();
        CardInfoPublicDTO cardDto;
        if (user.isUserActive())
            cardDto = updateCardInfoById(id, CardInfoUpdateDTO.builder().isCardActive(true).build());
        else
            cardDto = cardMapper.toDto(cardInfo);
        return cardDto;
    }

    @Transactional
    @Override
    public CardInfoPublicDTO deactivateCard(Long id) {
        return updateCardInfoById(id,CardInfoUpdateDTO.builder().isCardActive(false).build());
    }

    @Transactional
    @Override
    public CardInfoPublicDTO removeCard(Long id) {
        CardInfo deleted = cardInfoRepository.findCardInfoById(id).orElseThrow(()->new EntityNotFoundException("Card with id = " + id + "not found"));
        cardInfoRepository.delete(deleted);
        return cardMapper.toDto(deleted);
    }

    @Transactional
    @Override
    public UserPublicDTO removeUser(Long id) {
        User deleted = userRepository.findUserById(id).orElseThrow(()->new EntityNotFoundException("User with id = " + id + "not found"));
        userRepository.delete(deleted);
        return userMapper.toDto(deleted);
    }

    @Override
    public Page<UserPublicDTO> getUsers(UserFilterDTO filter, Pageable pageable) {
        Specification<User> spec = UserSpecifications.buildNameAndSurnameSpecification(filter);
        return userRepository.findAll(spec, pageable).map(userMapper::toDto);
    }
}
