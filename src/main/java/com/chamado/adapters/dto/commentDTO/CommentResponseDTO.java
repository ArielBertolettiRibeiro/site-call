package com.chamado.adapters.dto.commentDTO;

import com.chamado.adapters.dto.userDTO.UserResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentResponseDTO {

    private Long id;
    private UserResponseDTO user;
    private String message;
    private LocalDateTime creationDate;
}
