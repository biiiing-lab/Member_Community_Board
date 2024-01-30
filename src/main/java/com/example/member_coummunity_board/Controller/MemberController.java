package com.example.member_coummunity_board.Controller;

import com.example.member_coummunity_board.DTO.JoinDto;
import com.example.member_coummunity_board.DTO.LoginDto;
import com.example.member_coummunity_board.Service.MemberService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {
        try {
            return memberService.login(loginDto);
        }catch (Exception e) {
            return e.getMessage();
        }
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response,
                SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }

    // 로그인 로직
    @GetMapping("/mypage/{memberId}")
    public String mypage() {
        return ""; // 개인 페이지
    }
}
