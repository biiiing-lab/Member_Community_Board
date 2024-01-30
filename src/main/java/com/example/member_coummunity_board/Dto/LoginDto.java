package com.example.member_coummunity_board.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDto {
    private String memberId;
    private String password;
}
