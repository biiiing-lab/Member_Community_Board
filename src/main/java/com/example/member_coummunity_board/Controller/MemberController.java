package com.example.member_coummunity_board.Controller;

import com.example.member_coummunity_board.Config.JwtTokenProvider;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
public class MemberController {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
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
/*
    @PostMapping("/Login")
    public ResponseEntity<String> Login(@RequestBody MemberLoginDto memberLoginDto,
                                        HttpServletResponse response) {
        if (memberService.login(memberLoginDto)) {
            // Perform successful login logic

            // For simplicity, just setting a cookie with the member's ID
            Cookie cookie = new Cookie("memberId", memberLoginDto.getMemberId());
            cookie.setHttpOnly(true);
            cookie.setSecure(true); // Enable only for HTTPS
            cookie.setPath("/"); // Set the path based on your application's context
            response.addCookie(cookie);
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    } */

    @GetMapping("/Secured")
    public ResponseEntity<?> securedEndpoint(@CookieValue(name = "access_token", required = false) String token) {
        // Validate the token and perform authentication logic
        if (jwtTokenProvider.validateToken(token)) {
            // Access allowed for authenticated user
            return ResponseEntity.ok("Hello, authenticated user!");
        } else {
            // Access denied for unauthenticated user
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }
    }
}
    /*
    @PostMapping("/SignUp")
    public ResponseEntity<MemberResponseDto> SignUp(@RequestBody MemberJoinDto memberJoinDto) {
        MemberResponseDto successMember = memberService.joinMember(memberJoinDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(successMember);
    } */