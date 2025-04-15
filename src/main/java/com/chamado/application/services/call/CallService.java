package com.chamado.application.services.call;

import com.chamado.adapters.dto.callDTO.CallRequestDTO;
import com.chamado.adapters.dto.callDTO.CallResponseDTO;
import com.chamado.application.exceptions.CallNotFoundException;
import com.chamado.application.exceptions.UserNotFoundException;
import com.chamado.domain.entities.Call;
import com.chamado.domain.enums.Status;
import com.chamado.infrastructure.configs.mapstruct.CallMapper;
import com.chamado.infrastructure.repositorys.CallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CallService {

    private final CallRepository repository;
    private final CallMapper mapper;

    public CallResponseDTO createCall(CallRequestDTO request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public CallResponseDTO findById(Long id) {
        Call call = repository.findById(id).
                orElseThrow(() -> new CallNotFoundException("Call not found with ID: " + id));

        return mapper.toResponse(call);
    }

    public List<CallResponseDTO> findAll() {
        return repository.findAll().
                stream()
                .map(mapper::toResponse)
                .toList();
    }

    public CallResponseDTO update(Long id, CallRequestDTO request) {
        Call call = repository.findById(id)
                .orElseThrow(() -> new CallNotFoundException("Call not found with ID: " + id));

        call.setDescription(request.getDescription());
        call.setTitle(request.getTitle());

        if (request.getPriority() != null) {
            call.setPriority(request.getPriority());
        }

        if(request.getStatus() != null) {
            call.setStatus(request.getStatus());
        }

        return mapper.toResponse(repository.save(call));
    }

    public CallResponseDTO closeCall(Long id) {
        Call call = repository.findById(id)
                .orElseThrow(() -> new CallNotFoundException("Call not found with ID: " + id));

        if(call.getStatus() == Status.CLOSED) {
            throw new IllegalArgumentException("This call is already closed.");
        }

        call.setStatus(Status.CLOSED);
        call.setClosingDate(LocalDateTime.now());

        return mapper.toResponse(repository.save(call));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new CallNotFoundException("Call not found with ID: " + id);
        }

        repository.deleteById(id);
    }
}
