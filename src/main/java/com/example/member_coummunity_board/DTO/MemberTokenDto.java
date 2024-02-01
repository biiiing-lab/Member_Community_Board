package com.example.member_coummunity_board.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

// 사용자 정보 + token dto
@Getter
@Setter
@NoArgsConstructor
public class MemberTokenDto {
    private String memberId;
    private String Token;

    @Builder
    public MemberTokenDto(String memberId, String token) {
        this.memberId = memberId;
        this.Token = token;
    }

    public static MemberTokenDto toDto(UserDetails member, String token) {
        return MemberTokenDto.builder()
                .memberId(member.getUsername())
                .token(token)
                .build();
    }
}
