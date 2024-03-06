package com.example.member_coummunity_board.DTO;

import com.example.member_coummunity_board.Domain.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddBoard {
    private String title;
    private String content;
    private String writer;
    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }
}
