package com.chamado.application.services.comment;

import com.chamado.adapters.dto.callDTO.CallRequestDTO;
import com.chamado.adapters.dto.commentDTO.CommentRequestDTO;
import com.chamado.adapters.dto.commentDTO.CommentResponseDTO;
import com.chamado.application.exceptions.CallNotFoundException;
import com.chamado.application.exceptions.UserNotFoundException;
import com.chamado.domain.entities.Call;
import com.chamado.domain.entities.Comment;
import com.chamado.domain.entities.User;
import com.chamado.infrastructure.configs.mapstruct.CommentMapper;
import com.chamado.infrastructure.repositorys.CallRepository;
import com.chamado.infrastructure.repositorys.CommentRepository;
import com.chamado.infrastructure.repositorys.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository repository;
    private final CommentMapper mapper;
    private final UserRepository userRepository;
    private final CallRepository callRepository;

    public CommentResponseDTO creatComment(CommentRequestDTO request) {
        Call call = callRepository.findById(request.getCallId())
                .orElseThrow(() -> new CallNotFoundException("Call not found with ID: " + request.getCallId()));

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + request.getUserId()));

        Comment comment = new Comment();
        comment.setCall(call);
        comment.setUser(user);
        comment.setMessage(request.getMessage());
        comment.setCreationDate(LocalDateTime.now());

        return mapper.toResponse(repository.save(comment));
    }

    public List<CommentResponseDTO> findAllByCallId(Long callId) {
        if (!callRepository.existsById(callId)) {
            throw new CallNotFoundException("Call not foun with ID: " + callId);
        }

        return repository.findByCallId(callId)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}
