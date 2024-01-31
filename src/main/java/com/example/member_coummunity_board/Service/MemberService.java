package com.example.member_coummunity_board.Service;

import com.example.member_coummunity_board.DTO.JoinDto;
import com.example.member_coummunity_board.DTO.LoginDto;
import com.example.member_coummunity_board.Domain.Member;
import com.example.member_coummunity_board.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    @Transactional
    // 회원가입 : 데이터 저장
    public void joinMember(JoinDto joinDto) {
        Member member = Member.builder()
                .memberId(joinDto.getMemberId())
                .password(passwordEncoder.encode(joinDto.getPassword())) // 패스워드 암호화 완료
                .email(joinDto.getEmail())
                .memberName(joinDto.getMemberName())
                .build();

        memberRepository.save(member);
    }

    // 로그인 (반환값 user)
    public String login(LoginDto loginDto) throws Exception {
        // 인증, 권한 부여하기(id, pw)
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getMemberId(), loginDto.getPassword()));

        // authentication 넣기
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }

    /*
    // 스프링 시큐리티에서 memberId로 사용자의 정보를 가져옴
    public User findMember(String memberId){
        return memberRepository.findByMember(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected User"));
    }
 */

}
