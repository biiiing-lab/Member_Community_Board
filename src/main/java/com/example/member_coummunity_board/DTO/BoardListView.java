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
    private final LocalDateTime regDate;


    public BoardListView(Board board){
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.regDate = board.getRegDate();
    }
}
