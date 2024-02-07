package com.example.member_coummunity_board.Service;

import com.example.member_coummunity_board.DTO.AddBoard;
import com.example.member_coummunity_board.DTO.UpdateRequest;
import com.example.member_coummunity_board.Domain.Board;
import com.example.member_coummunity_board.Repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public Board save(AddBoard request) {
        return boardRepository.save(request.toEntity());
    }

    public List<Board> findAll(Pageable pageable){
        return boardRepository.findAll(pageable).getContent();
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

    //검색
    public Page<Board> boardSearchList(String searchKeyword, Pageable pageable){
        return boardRepository.findByTitleContaining(searchKeyword, pageable);
    }

    /*
    //특정 게시글 불러오기
    public Board boardview(Long id){
        return boardRepository.findById(id).get(); //어떤게시글을 불러올지 지정을해주어야한다 (Integer값으로)
    }
     */

}
