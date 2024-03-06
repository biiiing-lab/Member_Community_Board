package com.example.member_coummunity_board.DTO;


import com.example.member_coummunity_board.Domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class MemberResponseDto {
    private String memberId;
    private String password;

    @Builder
    public MemberResponseDto(String memberId, String password) {
        this.memberId = memberId;
        this.password = password;
    }

    public static MemberResponseDto toDto(Member member) {
        return MemberResponseDto.builder()
                .memberId(member.getMemberId())
                .password(member.getPassword())
                .build();
    }
}