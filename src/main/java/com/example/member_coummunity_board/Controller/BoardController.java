package com.example.member_coummunity_board.Controller;

import com.example.member_coummunity_board.DTO.BoardListView;
import com.example.member_coummunity_board.DTO.BoardViewResponse;
import com.example.member_coummunity_board.Domain.Board;
import com.example.member_coummunity_board.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    //게시물 리스트로 보여줌
    @GetMapping("boards")
    public String getBoards(Model model){
        List<BoardListView> boards = boardService.findAll()
                .stream()
                .map(BoardListView::new)
                .toList();
        model.addAttribute("boards",boards);
        return "boardList";
    }

    //게시물 세부내용
    @GetMapping("/articles/{id}")
    public String getBoard(@PathVariable Long id, Model model){
        Board board = boardService.findById(id);
        model.addAttribute("article", new BoardListView(board));

        return "board";
    }

//새 게시물 작성
    @GetMapping("/new-board")
    public String newBoard(@RequestParam(required = false) Long id, Model model){

        if(id == null) {
            model.addAttribute("board", new BoardViewResponse());
        } else {
            Board board = boardService.findById(id);
            model.addAttribute("board", new BoardViewResponse(board));
        }

        return "newBoard";
    }



}
