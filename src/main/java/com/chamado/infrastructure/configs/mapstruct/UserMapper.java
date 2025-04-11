package com.chamado.infrastructure.configs.mapstruct;

import com.chamado.adapters.dto.userDTO.UserRequestDTO;
import com.chamado.adapters.dto.userDTO.UserResponseDTO;
import com.chamado.domain.entities.User;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring", uses = {CallMapper.class})
public interface UserMapper {

    User toEntity(UserRequestDTO requestDTO);

    UserResponseDTO toResponse(User user);

    List<UserResponseDTO> toUserListResponse(List<User> users);
}
