package com.github.lexya.userservice.mapper;

import com.github.lexya.userservice.dto.*;
import com.github.lexya.userservice.model.CardInfo;
import com.github.lexya.userservice.model.User;
import com.github.lexya.userservice.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {CardMapper.class})
public interface CardMapper {
    CardInfo toEntity(CardInfoCreateDTO dto, @Context UserRepository userRepository);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(CardInfoUpdateDTO dto, @MappingTarget CardInfo cardInfo);

    CardInfoPublicDTO toDto(CardInfo cardInfo);

    default User map(Long id, @Context UserRepository userRepository) {
        return userRepository.findUserById(id).orElseThrow(()->new EntityNotFoundException("User with id = " + id + "not found"));
    }
}
