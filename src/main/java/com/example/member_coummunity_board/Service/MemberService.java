package com.example.member_coummunity_board.Service;

import com.example.member_coummunity_board.Dto.JoinDto;
import com.example.member_coummunity_board.Dto.LoginDto;
import com.example.member_coummunity_board.Entity.Member;
import com.example.member_coummunity_board.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

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
    public User login(LoginDto loginDto) {
        Optional<User> optionalUser = memberRepository.findByMember(loginDto.getMemberId());

        if(optionalUser.isEmpty()) {
            return null;
        }

        User user = optionalUser.get();

        if(!user.getPassword().equals(loginDto.getPassword())) {
            return null;
        }

        return user;
    }

    // 스프링 시큐리티에서 memberId로 사용자의 정보를 가져옴
    public User findMember(String memberId){
        return memberRepository.findByMember(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected User"));
    }


}
