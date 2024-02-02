package com.example.member_coummunity_board.Service;

import com.example.member_coummunity_board.DTO.MemberJoinDto;
import com.example.member_coummunity_board.DTO.MemberLoginDto;
import com.example.member_coummunity_board.DTO.MemberResponseDto;
import com.example.member_coummunity_board.Domain.Member;
import com.example.member_coummunity_board.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원가입 : 데이터 저장
    public void joinMember(MemberJoinDto memberJoinDto) {
        Member member = Member.builder()
                .memberId(memberJoinDto.getMemberId())
                .password(memberJoinDto.getPassword())
                .email(memberJoinDto.getEmail())
                .memberName(memberJoinDto.getMemberName())
                .build();

        memberRepository.save(member);
    }

    // 로그인
    public MemberResponseDto login(MemberLoginDto memberLoginDto) {
        MemberResponseDto entity = memberRepository.findByMemberIdAndPassword(
                memberLoginDto.getMemberId(),
                memberLoginDto.getPassword()
        );
        return entity;
    }
}
