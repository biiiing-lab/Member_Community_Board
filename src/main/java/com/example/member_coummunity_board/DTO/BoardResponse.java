package com.example.member_coummunity_board.DTO;

import com.example.member_coummunity_board.Domain.Board;
import lombok.Getter;

@Getter
public class BoardResponse {
    private final String title;
    private final String content;

    public BoardResponse(Board board) {
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
