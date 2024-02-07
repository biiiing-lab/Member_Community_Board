package com.example.member_coummunity_board.Controller;

import com.example.member_coummunity_board.DTO.MemberJoinDto;
import com.example.member_coummunity_board.DTO.MemberLoginDto;
import com.example.member_coummunity_board.DTO.MemberResponseDto;
import com.example.member_coummunity_board.Domain.Member;
import com.example.member_coummunity_board.Repository.MemberRepository;
import com.example.member_coummunity_board.Service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.UserDatabase;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Iterator;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@CrossOrigin
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @PostMapping( value = "/SignUp")
    public void signUp(@RequestBody MemberJoinDto memberJoinDto) {
        memberService.joinMember(memberJoinDto);
    }

    @PostMapping("/Login")
    public ResponseEntity<String> Login(@RequestBody MemberLoginDto memberLoginDto) {
        if(memberService.login(memberLoginDto)) {
            String memberName = memberService.findByNickName(memberLoginDto);
            return ResponseEntity.ok().body(memberName);
        } else {
            return ResponseEntity.ok().body("오류");
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
