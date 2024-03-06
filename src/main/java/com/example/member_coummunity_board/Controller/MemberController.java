package com.example.member_coummunity_board.Controller;

import com.example.member_coummunity_board.DTO.MemberJoinDto;
import com.example.member_coummunity_board.DTO.MemberLoginDto;
import com.example.member_coummunity_board.Repository.MemberRepository;
import com.example.member_coummunity_board.Service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
    public ResponseEntity<?> Login(@RequestBody MemberLoginDto memberLoginDto, HttpServletResponse response) {

        if(memberService.login(memberLoginDto)) {
            response.addCookie(memberService.makeCookie(memberLoginDto)); // 쿠키 저장
            String memberName = memberService.findByNickName(memberLoginDto);
            return ResponseEntity.ok().body(memberName);

        } else {
            return ResponseEntity.ok().body("오류");
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> loginCheck(@CookieValue(name="checkLogin") HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();

        if (cookies == null || cookies.length == 0) {
            return new ResponseEntity<>(new RedirectView("/Login"), HttpStatus.FOUND);
        }
        return ResponseEntity.ok().body("ok");
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
