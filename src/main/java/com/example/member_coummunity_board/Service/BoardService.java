package com.example.member_coummunity_board.Service;

import com.example.member_coummunity_board.DTO.AddBoard;
import com.example.member_coummunity_board.DTO.UpdateRequest;
import com.example.member_coummunity_board.Domain.Board;
import com.example.member_coummunity_board.Repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public Board save(AddBoard request) {
        return boardRepository.save(request.toEntity());
    }

    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    public Board findById (long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
    }

    public void delete(long id){
        boardRepository.deleteById(id);
    }

    @Transactional
    public Board update(long id, UpdateRequest request) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+id));

        board.update(request.getTitle(), request.getContent());
        return board;
    }
}
