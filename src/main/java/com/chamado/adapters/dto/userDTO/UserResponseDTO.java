package com.chamado.adapters.dto.userDTO;

import com.chamado.adapters.dto.callDTO.CallResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private List<CallResponseDTO> calls;
}
