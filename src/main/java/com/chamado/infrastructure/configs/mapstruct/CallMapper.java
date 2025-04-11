package com.chamado.infrastructure.configs.mapstruct;

import com.chamado.adapters.dto.callDTO.CallRequestDTO;
import com.chamado.adapters.dto.callDTO.CallResponseDTO;
import com.chamado.domain.entities.Call;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, CommentMapper.class})
public interface CallMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "closingDate", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "comments", ignore = true)
    Call toEntity(CallRequestDTO call);

    CallResponseDTO toResponse(Call call);
}
