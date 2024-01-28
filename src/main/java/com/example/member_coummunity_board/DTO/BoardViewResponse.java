package com.example.member_coummunity_board.DTO;

import com.example.member_coummunity_board.Domain.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class BoardViewResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime regDate;

    public BoardViewResponse(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.regDate = board.getRegDate();
    }
}
