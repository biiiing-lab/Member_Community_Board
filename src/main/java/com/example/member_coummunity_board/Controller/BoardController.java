package com.example.member_coummunity_board.Controller;

import com.example.member_coummunity_board.DTO.BoardListView;
import com.example.member_coummunity_board.DTO.BoardViewResponse;
import com.example.member_coummunity_board.Domain.Board;
import com.example.member_coummunity_board.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardService boardService;

    //게시물 세부내용
    @GetMapping("/boards/{id}")
    public String getBoard(@PathVariable Long id, Model model){
        Board board = boardService.findById(id);
        model.addAttribute("board", new BoardListView(board));

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

    @GetMapping("/boards")
    public String boardList(Model model,
                            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC)
                            Pageable pageable,
                            String searchKeyword){

        /*검색기능-3*/
        Page<Board> list = null;

        /*searchKeyword = 검색하는 단어*/
        if(searchKeyword == null){
            list = (Page<Board>) boardService.findAll(pageable); //기존의 리스트보여줌
        }else{
            list = boardService.boardSearchList(searchKeyword, pageable); //검색리스트반환
        }

        int nowPage = list.getPageable().getPageNumber() + 1; //pageable에서 넘어온 현재페이지를 가지고올수있다 * 0부터시작하니까 +1
        int startPage = Math.max(nowPage - 4, 1); //매개변수로 들어온 두 값을 비교해서 큰값을 반환
        int endPage = Math.min(nowPage + 5, list.getTotalPages());

        //BoardService에서 만들어준 boardList가 반환되는데, list라는 이름으로 받아서 넘기겠다는 뜻
        model.addAttribute("list" , list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "boardList";
    }


}
