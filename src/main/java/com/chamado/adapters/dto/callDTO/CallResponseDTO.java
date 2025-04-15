package com.chamado.adapters.dto.callDTO;

import com.chamado.adapters.dto.commentDTO.CommentResponseDTO;
import com.chamado.adapters.dto.userDTO.UserResponseDTO;
import com.chamado.domain.entities.Comment;
import com.chamado.domain.enums.Priority;
import com.chamado.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CallResponseDTO {

    private UserResponseDTO user;
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime closingDate;
    private Priority priority;
    private Status status;
    private List<CommentResponseDTO> comments;
}
