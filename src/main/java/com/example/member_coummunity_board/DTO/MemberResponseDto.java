package com.example.member_coummunity_board.DTO;


import com.example.member_coummunity_board.Domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;



@Getter
@Setter
@NoArgsConstructor
public class MemberResponseDto {
    private String memberId;
    private String username;

    @Builder
    public MemberResponseDto(String memberId, String username) {
        this.memberId = memberId;
        this.username = username;
    }

    public static MemberResponseDto toDto(Member member) {
        return MemberResponseDto.builder()
                .memberId(member.getMemberId())
                .username(member.getMemberName())
                .build();
    }
}