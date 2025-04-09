package com.chamado.adapters.dto.callDTO;

import com.chamado.domain.enums.Priority;
import com.chamado.domain.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CallRequestDTO {

    @NotBlank(message = "The title is required.")
    private String title;

    @NotBlank(message = "The description is required.")
    private String description;

    @NotNull(message = "The priority is required.")
    private Priority priority;

    private Status status;

    @NotNull(message = "The user ID is required. ")
    private Long userId;

}
