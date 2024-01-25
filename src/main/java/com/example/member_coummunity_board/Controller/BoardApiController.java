package com.example.member_coummunity_board.Controller;

import com.example.member_coummunity_board.DTO.AddBoard;
import com.example.member_coummunity_board.DTO.BoardResponse;
import com.example.member_coummunity_board.DTO.UpdateRequest;
import com.example.member_coummunity_board.Domain.Board;
import com.example.member_coummunity_board.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class BoardApiController {
    private final BoardService boardService;

    @PostMapping("/api/boards")
    public ResponseEntity<Board> addBoard(@RequestBody AddBoard request){
        Board savedBoard = boardService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBoard);
    }
    @GetMapping("/api/boards")
    public ResponseEntity<List<BoardResponse>> findAllBoards(){
        List<BoardResponse> boards = boardService.findAll().stream().map(BoardResponse::new).toList();
        return ResponseEntity.ok().body(boards);
    }

    @GetMapping("/api/boards/{id}")
    public ResponseEntity<BoardResponse> findBoard(@PathVariable long id){
        Board board = boardService.findById(id);
        return ResponseEntity.ok().body(new BoardResponse(board));
    }
    //DELETE
    @DeleteMapping("/api/boards/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        boardService.delete(id);
        return ResponseEntity.ok().build();
    }
    //UPDATE
    @PutMapping("/api/boards/{id}")
    public ResponseEntity<Board> updateArticle(@PathVariable long id, @RequestBody UpdateRequest request) {
        Board updatedBoard = boardService.update(id, request);
        return ResponseEntity.ok().body(updatedBoard);
    }
}





























