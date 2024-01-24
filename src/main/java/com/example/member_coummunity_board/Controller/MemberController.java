package com.example.member_coummunity_board.Controller;

import com.example.member_coummunity_board.Dto.JoinDto;
import com.example.member_coummunity_board.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    /** 회원가입 **/
    // 회원가입 페이지 출력
    @GetMapping("/join")
    public String join() {
        return "join";
    }

    // 회원가입 로직
    @PostMapping("/join")
    public String join(@ModelAttribute JoinDto joinDto) {
        memberService.joinMember(joinDto);
        return "redirect:login"; // 회원가입 후 로그인 페이지로 이동
    }

    /** 로그인 **/
    // 로그인 페이지 출력
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // 로그인 로직

    @GetMapping("/mypage/{memberId}")
    public String mypage() {
        return ""; // 개인 페이지
    }
}
