package com.example.member_coummunity_board.Jwt;

import com.example.member_coummunity_board.Repository.MemberRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

public class JwtAuthorizationFilter extends OncePerRequestFilter {
    private final MemberRepository memberRepository;

    public JwtAuthorizationFilter(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws IOException, ServletException {
        String token = null;
        try {
            token = Arrays.stream(request.getCookies())
                    .filter(cookie -> cookie.getName().equals(JwtProperties.COOKIE_NAME)).findFirst()
                    .map(Cookie::getValue)
                    .orElse(null);
        } catch (Exception ignored) {
            if (token != null) {
                try {
                    Authentication authentication = getUsernamePasswordAuthenticationToken(token);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } catch (Exception e) {
                    Cookie cookie = new Cookie(JwtProperties.COOKIE_NAME, null);
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
            chain.doFilter(request, response);
        }
    }

    private Authentication getUsernamePasswordAuthenticationToken(String token) {
        String userName = JwtUtils.getMemberId(token);
        if (userName != null) {
            User user = memberRepository.findByMember(userName);
            return new UsernamePasswordAuthenticationToken(
                    user, null, user.getAuthorities()
            );
        }
        return null;
    }

}
