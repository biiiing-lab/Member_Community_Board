package com.example.member_coummunity_board.DTO;

import com.example.member_coummunity_board.Domain.Board;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@Getter
public class BoardListView {
    private final Long id;
    private final String title;
    private final String content;
    private final String writer;
    private final LocalDateTime regDate;
    private final LocalDateTime modDate;


    public BoardListView(Board board){
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getWriter();
        this.regDate = board.getRegDate();
        this.modDate = board.getModDate();
    }
}
