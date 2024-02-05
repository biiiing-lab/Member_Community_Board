package com.example.member_coummunity_board.Service;

import com.example.member_coummunity_board.DTO.MemberJoinDto;
import com.example.member_coummunity_board.DTO.MemberLoginDto;
import com.example.member_coummunity_board.DTO.MemberResponseDto;
import com.example.member_coummunity_board.Domain.Member;
import com.example.member_coummunity_board.Repository.MemberRepository;
import lombok.AllArgsConstructor;
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
    public boolean login(MemberLoginDto memberLoginDto) {

        String memberId = memberRepository.findByMemberId(memberLoginDto.getMemberId());
        String password = memberRepository.findByPassword(memberLoginDto.getPassword());

        if(!memberId.isEmpty() || !password.isEmpty()) {

            try {
                if (memberId.equals(memberLoginDto.getMemberId()) && password.equals(memberLoginDto.getPassword())) {
                    return true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        }

        return false;
    }
}
