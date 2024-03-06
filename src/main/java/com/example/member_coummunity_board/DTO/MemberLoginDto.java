package com.example.member_coummunity_board.DTO;

import com.example.member_coummunity_board.Domain.Member;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberLoginDto {
    private String memberId;
    private String password;

    public Member toEntity() {
        return Member.builder()
                .memberId(memberId)
                .password(password)
                .build();
    }
}

