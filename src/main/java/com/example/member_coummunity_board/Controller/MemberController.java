package com.example.member_coummunity_board.Controller;

import com.example.member_coummunity_board.DTO.MemberJoinDto;
import com.example.member_coummunity_board.DTO.MemberLoginDto;
import com.example.member_coummunity_board.DTO.MemberResponseDto;
import com.example.member_coummunity_board.Service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RequiredArgsConstructor
@RestController
@CrossOrigin
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
    public ResponseEntity<String> Login(@RequestBody MemberLoginDto memberLoginDto) {
        if (memberService.login(memberLoginDto)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("bad request");
        }
    }
}
    /*
    @PostMapping("/SignUp")
    public ResponseEntity<MemberResponseDto> SignUp(@RequestBody MemberJoinDto memberJoinDto) {
        MemberResponseDto successMember = memberService.joinMember(memberJoinDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(successMember);
    } */
