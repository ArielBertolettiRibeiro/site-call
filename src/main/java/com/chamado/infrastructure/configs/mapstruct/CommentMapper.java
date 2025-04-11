package com.chamado.infrastructure.configs.mapstruct;

import com.chamado.adapters.dto.commentDTO.CommentRequestDTO;
import com.chamado.adapters.dto.commentDTO.CommentResponseDTO;
import com.chamado.domain.entities.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface CommentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "call", ignore = true)
    @Mapping(target = "user", ignore = true)
    Comment toEntity(CommentRequestDTO dto);

    @Mapping(target = "user", source = "user")
    CommentResponseDTO toResponse(Comment comment);
}
