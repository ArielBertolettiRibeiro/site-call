package com.chamado.application.services.user;

import com.chamado.adapters.dto.userDTO.UserRequestDTO;
import com.chamado.adapters.dto.userDTO.UserResponseDTO;
import com.chamado.application.exceptions.UserNotFoundException;
import com.chamado.domain.entities.User;
import com.chamado.infrastructure.configs.mapstruct.UserMapper;
import com.chamado.infrastructure.repositorys.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserResponseDTO createUser(UserRequestDTO request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public UserResponseDTO findByIdUser(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User cannot found!"));

        return mapper.toResponse(user);
    }

    public List<UserResponseDTO> findAllUsers() {
       return repository.findAll().stream()
               .map(mapper::toResponse)
               .toList();
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User cannot be found."));

        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());

        return mapper.toResponse(repository.save(user));
    }

    public void deletUser(Long id) {
       if(!repository.existsById(id)) {
                throw  new UserNotFoundException("User cannot be found.");
       }
        repository.deleteById(id);
    }

}
