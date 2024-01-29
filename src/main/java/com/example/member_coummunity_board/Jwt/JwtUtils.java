package com.example.member_coummunity_board.Jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import org.springframework.data.util.Pair;
import org.springframework.security.core.userdetails.User;

import java.security.Key;
import java.util.Date;
public class JwtUtils {
    // 토큰에서 memberId 찾기 - return memberId
    public static String getMemberId(String token) {
        return Jwts.parserBuilder()
                .setSigningKeyResolver(SigningKeyResolver.instance)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject(); // memberId
    }

    // user로 토큰 생성
    public static String createToken(User user) {
        Claims claims = Jwts.claims().setSubject(user.getUsername());
        Date now = new Date();
        Pair<String, Key> key = JwtKey.getRandomKey();
        return Jwts.builder()
                .setClaims(claims) // 정보 저장
                .setIssuedAt(now) // 토큰 발행 시간
                .setExpiration(new Date(now.getTime() + JwtProperties.EXPIRATION_TIME)) // 만료 시간
                .setHeaderParam(JwsHeader.KEY_ID, key.getFirst()) // kid
                .signWith(key.getSecond()) // signature
                .compact();
    }
}
