package com.example.member_coummunity_board.JWT;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.SigningKeyResolverAdapter;

import java.security.Key;

// jwsHeader을 통하여 시그니처 검증에 필요한 키를 가져옴
public class SigningKeyResolver extends SigningKeyResolverAdapter {
    public static SigningKeyResolver instance = new SigningKeyResolver();

    @Override
    public Key resolveSigningKey(JwsHeader header, Claims claims) {
        String kid = header.getKeyId();
        if(kid == null) {
            return null;
        } return JwtKey.getKey(kid);
    }
}
