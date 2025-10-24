package com.github.lexya.userservice.service;

import com.github.lexya.userservice.model.CardInfo;
import com.github.lexya.userservice.repository.CardInfoRepository;
import com.github.lexya.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    final UserRepository userRepository;

    final CardInfoRepository cardInfoRepository;

    @Autowired
    public UserService(UserRepository userRepository, CardInfoRepository cardInfoRepository) {
        this.userRepository = userRepository;
        this.cardInfoRepository = cardInfoRepository;
    }



}
