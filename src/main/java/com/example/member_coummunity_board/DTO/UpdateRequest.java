package com.example.member_coummunity_board.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateRequest {
    private String title;
    private String content;
    private LocalDateTime modDate;
}
//제목, 내용만 수정할수 있도록함