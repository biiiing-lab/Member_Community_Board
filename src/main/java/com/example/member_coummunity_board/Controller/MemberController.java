package com.example.member_coummunity_board.Controller;

import com.example.member_coummunity_board.DTO.MemberJoinDto;
import com.example.member_coummunity_board.DTO.MemberLoginDto;
import com.example.member_coummunity_board.DTO.MemberResponseDto;
import com.example.member_coummunity_board.Domain.Member;
import com.example.member_coummunity_board.Repository.MemberRepository;
import com.example.member_coummunity_board.Service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @PostMapping(value = "/SignUp")
    public String signUp(@RequestBody MemberJoinDto memberJoinDto) {
        try {
            memberService.joinMember(memberJoinDto);
            return "src/main/front/src/pages/LogIn.jsx";
        } catch (Exception e) {
            e.getMessage();
            return "src/main/front/src/pages/SignUp.jsx";
        }
    }

    @PostMapping("/Login")
    public MemberResponseDto login(@RequestBody MemberLoginDto memberLoginDto) {
       MemberResponseDto entity = memberService.login(memberLoginDto);
       return entity;
    }
}
    /*
    @PostMapping("/SignUp")
    public ResponseEntity<MemberResponseDto> SignUp(@RequestBody MemberJoinDto memberJoinDto) {
        MemberResponseDto successMember = memberService.joinMember(memberJoinDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(successMember);
    } */
