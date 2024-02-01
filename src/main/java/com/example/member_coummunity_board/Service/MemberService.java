package com.example.member_coummunity_board.Service;

import com.example.member_coummunity_board.DTO.MemberJoinDto;
import com.example.member_coummunity_board.DTO.MemberLoginDto;
import com.example.member_coummunity_board.DTO.MemberResponseDto;
import com.example.member_coummunity_board.DTO.MemberTokenDto;
import com.example.member_coummunity_board.Domain.Member;
import com.example.member_coummunity_board.Jwt.JwtUtils;
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
    public MemberResponseDto joinMember(MemberJoinDto memberJoinDto) {
        Member member = Member.builder()
                .memberId(memberJoinDto.getMemberId())
                .password(passwordEncoder.encode(memberJoinDto.getPassword())) // 패스워드 암호화 완료
                .email(memberJoinDto.getEmail())
                .memberName(memberJoinDto.getMemberName())
                .build();

        memberRepository.save(member);

        return MemberResponseDto.toDto(member);
    }

    // 로그인
    public MemberTokenDto login(MemberLoginDto memberLoginDto) {
        // 인증, 권한 부여하기(id, pw)
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(memberLoginDto.getMemberId(), memberLoginDto.getPassword()));

        // authentication 넣기
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String token = JwtUtils.createToken(userDetails);

        return MemberTokenDto.toDto(userDetails, token);
    }

    /*
    // 스프링 시큐리티에서 memberId로 사용자의 정보를 가져옴
    public User findMember(String memberId){
        return memberRepository.findByMember(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected User"));
    }
 */

}
