package com.example.member_coummunity_board.Controller;

import com.example.member_coummunity_board.DTO.MemberJoinDto;
import com.example.member_coummunity_board.DTO.MemberLoginDto;
import com.example.member_coummunity_board.DTO.MemberResponseDto;
import com.example.member_coummunity_board.DTO.MemberTokenDto;
import com.example.member_coummunity_board.Service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    // 로그인
    @PostMapping("/Login")
    public ResponseEntity<MemberTokenDto> login(@RequestBody MemberLoginDto memberLoginDto){
        MemberTokenDto loginTokenDto = memberService.login(memberLoginDto);
        return ResponseEntity.status(HttpStatus.OK).header(loginTokenDto.getToken()).body(loginTokenDto);
    }

    // 회원가입
    @PostMapping("/SignUp")
    public ResponseEntity<MemberResponseDto> SignUp(@RequestBody MemberJoinDto memberJoinDto) {
        MemberResponseDto successMember = memberService.joinMember(memberJoinDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(successMember);
    }

    // 로그아웃
    @PostMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response) {
        new SecurityContextLogoutHandler()
                .logout(request, response,
                        SecurityContextHolder
                                .getContext()
                                .getAuthentication());
        return "redirect:/Login";
    }

}
