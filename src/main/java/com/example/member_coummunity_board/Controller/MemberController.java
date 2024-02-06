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
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.OPTIONS, RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class MemberController {
    private final MemberService memberService;

    @PostMapping( value = "/SignUp")
    public ResponseEntity<String> signUp(@RequestBody MemberJoinDto memberJoinDto) {
      memberService.joinMember(memberJoinDto);
      return ResponseEntity.ok("join successful");
    }

    @PostMapping("/Login")
    public ResponseEntity<String> Login(@RequestBody MemberLoginDto memberLoginDto, HttpServletResponse response) {
        if(memberService.login(memberLoginDto)) {
            Cookie cookie = new Cookie("memberId", memberLoginDto.getMemberId());
            cookie.setHttpOnly(true);
            cookie.setSecure(true);
            cookie.setPath("/");
            response.addCookie(cookie);
            return ResponseEntity.ok("login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login faild");
        }
    }

    /*@PostMapping("/Login")
    public ResponseEntity<String> Login(@RequestBody MemberLoginDto memberLoginDto) {
        if (memberService.login(memberLoginDto)) {
            return ResponseEntity.ok(memberLoginDto.getMemberId());
        } else {
            return ResponseEntity.badRequest().body("bad request");
        }
    } */
}
    /*
    @PostMapping("/SignUp")
    public ResponseEntity<MemberResponseDto> SignUp(@RequestBody MemberJoinDto memberJoinDto) {
        MemberResponseDto successMember = memberService.joinMember(memberJoinDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(successMember);
    } */
