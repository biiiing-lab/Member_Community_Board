package com.example.member_coummunity_board.Jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;

// jwt를 이용한 로그인 인증
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        this.authenticationManager = authenticationManager;
    }

    // 로그인 인증 시도
    public Authentication attempAuthentication(HttpServletRequest request,
                                               HttpServletResponse response)
    // 로그인 할 때 id, pw로 토큰 생성
        throws AuthenticationException{
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                request.getParameter("memberId"),
                request.getParameter("password"),
                new ArrayList<>()
        );
        return authenticationManager.authenticate(authenticationToken);
    }

    // 인증에 성공했을 경우 -> jwt token을 생성하여 쿠키에 넣기
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authResult) throws IOException {
        User user = (User) authResult.getPrincipal();
        String token = JwtUtils.createToken(user);

        // cookie 생성
        Cookie cookie = new Cookie(JwtProperties.COOKIE_NAME, token); // 기본 쿠기
        cookie.setMaxAge(JwtProperties.EXPIRATION_TIME); // 만료시간
        cookie.setPath("/");
        response.addCookie(cookie); // 쿠키 저장
        response.sendRedirect("/"); // 화면 돌아가는 부분
    }

    // 로그인 화면으로 반환
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException failed)
        throws IOException {
        response.sendRedirect("/login");
    }
}
