package com.chamado.adapters.dto.userDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequestDTO {

    @NotBlank(message = "The name is required.")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid e-mail.")
    private String email;

    @NotBlank(message = "The password is required.")
    @Size(min = 6, message = "The password must be as least 6 characteres long.")
    private String password;
}