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
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    // 회원가입 페이지 출력
    @GetMapping("/SignUp")
    public String join() {
        return "SignUp";
    }

    // 로그인 페이지 출력
    @GetMapping("/Login")
    public String login() {
        return "Login";
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response) {
        new SecurityContextLogoutHandler()
                .logout(request, response,
                        SecurityContextHolder
                                .getContext()
                                .getAuthentication());
        return "redirect:/Login";
    }
}
