package com.example.member_coummunity_board.Dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class JoinDto {
    private String memberId;
    private String password;
    private String email;
    private String memberName;
}
