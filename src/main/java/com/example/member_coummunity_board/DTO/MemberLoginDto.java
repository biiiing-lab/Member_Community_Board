package com.example.member_coummunity_board.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberLoginDto {
    private String memberId;
    private String password;
}

