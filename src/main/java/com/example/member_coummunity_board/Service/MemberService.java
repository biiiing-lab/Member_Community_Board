package com.example.member_coummunity_board.Service;

import com.example.member_coummunity_board.DTO.MemberJoinDto;
import com.example.member_coummunity_board.DTO.MemberLoginDto;
import com.example.member_coummunity_board.DTO.MemberResponseDto;
import com.example.member_coummunity_board.Domain.Member;
import com.example.member_coummunity_board.Repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원가입 : 데이터 저장, encoder 처리 완료
    public void joinMember(MemberJoinDto memberJoinDto) {
        Member member = Member.builder()
                .memberId(memberJoinDto.getMemberId())
                .password(passwordEncoder.encode(memberJoinDto.getPassword()))
                .email(memberJoinDto.getEmail())
                .memberName(memberJoinDto.getMemberName())
                .build();
        memberRepository.save(member);
    }

    public boolean login(MemberLoginDto memberLoginDto) {
        User user = memberRepository.findByMemberIdAndPassword
                (memberLoginDto.getMemberId(), memberLoginDto.getPassword());

        if(user != null && passwordEncoder.matches(memberLoginDto.getPassword(), user.getPassword())) {
            return true;
        } else {
            return false;
        }

    }
}
