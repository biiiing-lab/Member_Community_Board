package com.example.member_coummunity_board.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    ErrorTest("잘못된 요청입니다");

    private final String message;

}
