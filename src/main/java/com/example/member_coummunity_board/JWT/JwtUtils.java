package com.example.member_coummunity_board.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import org.springframework.data.util.Pair;
import org.springframework.security.core.userdetails.User;

import java.security.Key;
import java.util.Date;

// 토큰 활용
public class JwtUtils {

    // 토큰에서 memberId 찾기
    public static String getMemberId(String token) {
        // jwt token에서 memberId 찾는 로직
        return Jwts.parserBuilder()
                .setSigningKeyResolver(SigningKeyResolver.instance)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject(); // memberId
    }

    // user로 토큰 생성
    public static String createToken(User user) {
        Claims claims = Jwts.claims().setSubject(user.getUsername()); // memberId
        Date now = new Date(); // 현재 시간 가져오기
        Pair<String, Key> key = JwtKey.getRandomKey(); // 랜덤 키 가지고 오기

        // json token 생성
        return Jwts.builder()
                .setClaims(claims) // 정보 저장
                .setIssuedAt(now) // 토큰 발행 시간
                .setExpiration(new Date(now.getTime() + JwtProperties.EXPIRATION_TIME)) // 만료 시간 설정
                .setHeaderParam(JwsHeader.KEY_ID, key.getFirst()) // kid
                .signWith(key.getSecond())
                .compact();
    }
}
