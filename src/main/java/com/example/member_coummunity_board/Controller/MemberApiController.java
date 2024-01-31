package com.example.member_coummunity_board.Controller;

import com.example.member_coummunity_board.DTO.JoinDto;
import com.example.member_coummunity_board.DTO.LoginDto;
import com.example.member_coummunity_board.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberApiController {

    private final MemberService memberService;

    // 회원가입 로직
    @PostMapping("/api/SignUp")
    public String join(@ModelAttribute JoinDto joinDto) {
        memberService.joinMember(joinDto);
        return "redirect:Login"; // 회원가입 후 로그인 페이지로 이동
    }

    @PostMapping("/api/Login")
    public String login(@RequestBody LoginDto loginDto) {
        try {
            return memberService.login(loginDto);
        }catch (Exception e) {
            return e.getMessage();
        }
    }
}
