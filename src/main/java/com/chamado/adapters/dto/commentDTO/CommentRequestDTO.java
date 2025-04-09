package com.chamado.adapters.dto.commentDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentRequestDTO {

    @NotNull(message = "Call ID is required.")
    private Long callId;

    @NotNull(message = "User ID is required.")
    private Long userId;

    @NotBlank(message = "Message cannot be blank.")
    @Pattern(regexp = ".*[a-zA-Z].*", message = "Message must contain at least one letter.")
    private String message;
}
