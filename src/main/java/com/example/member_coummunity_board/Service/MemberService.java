package com.example.member_coummunity_board.Service;

import com.example.member_coummunity_board.DTO.MemberJoinDto;
import com.example.member_coummunity_board.DTO.MemberLoginDto;
import com.example.member_coummunity_board.Domain.Member;
import com.example.member_coummunity_board.Repository.MemberRepository;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private RuntimeException Exception;

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
        Member findMember = memberRepository.findByMemberId(memberLoginDto.getMemberId())
                .orElseThrow(() -> Exception);

        try {
            if(findMember != null && passwordEncoder.matches(memberLoginDto.getPassword(),
                    findMember.getPassword())) {
                return true;
            }
        } catch (Exception e) {
            e.getMessage();
            return false;
        }

        return false;
    }

    public Cookie makeCookie(MemberLoginDto memberLoginDto) {
        Cookie cookie = new Cookie("checkLogin", memberLoginDto.getMemberId());
        cookie.setDomain("localhost");
        cookie.setPath("/Login");
        // 1시간 저장
        cookie.setMaxAge(60 * 60);
        cookie.setSecure(false);
        return cookie;
    }

    public String findByNickName(MemberLoginDto memberLoginDto) {
        Member findMember = memberRepository.findByMemberId(memberLoginDto.getMemberId())
                .orElseThrow(() -> Exception);

        return findMember.getMemberName();
    }
}
