package com.example.member_coummunity_board.Config;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JwtTokenProvider {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    public String generateToken(String memberId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(memberId)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            // Handle invalid signature
        } catch (MalformedJwtException ex) {
            // Handle invalid JWT format
        } catch (ExpiredJwtException ex) {
            // Handle expired JWT
        } catch (UnsupportedJwtException ex) {
            // Handle unsupported JWT
        } catch (IllegalArgumentException ex) {
            // Handle empty or null JWT
        }
        return false;
    }
}
