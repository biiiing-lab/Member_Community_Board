package com.example.member_coummunity_board.Service;

import com.example.member_coummunity_board.Dto.JoinDto;
import com.example.member_coummunity_board.Dto.LoginDto;
import com.example.member_coummunity_board.Entity.Member;
import com.example.member_coummunity_board.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    // 회원가입 : 데이터 저장
    public void joinMember(JoinDto joinDto) {
        Member member = Member.builder()
                .memberId(joinDto.getMemberId())
                .password(joinDto.getPassword())
                .email(joinDto.getEmail())
                .memberName(joinDto.getMemberName())
                .build();

        memberRepository.save(member);
    }
}
