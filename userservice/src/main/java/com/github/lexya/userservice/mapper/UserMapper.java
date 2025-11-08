package com.github.lexya.userservice.mapper;

import com.github.lexya.userservice.dto.UserCreateDTO;
import com.github.lexya.userservice.dto.UserPublicDTO;
import com.github.lexya.userservice.dto.UserUpdateDTO;
import com.github.lexya.userservice.model.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {CardMapper.class})
public interface UserMapper {
    User toEntity(UserCreateDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(UserUpdateDTO dto, @MappingTarget User user);

    UserPublicDTO toDto(User user);
}
