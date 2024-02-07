package com.example.member_coummunity_board.JWT;

import io.jsonwebtoken.security.Keys;
import org.springframework.data.util.Pair;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Map;
import java.util.Random;

// key 제공 및 조회 - test key 추후에 랜덤으로 돌려야할듯
public class JwtKey {
    public static final Map<String, String> SECRET_KEY_SET = Map.of(
            "Key1", "test1",
            "Key2", "test2",
            "Key3", "test3",
            "Key4", "test4",
            "Key5", "test5"
            );
    private static final String[] KID_SET = SECRET_KEY_SET.keySet().toArray(new String[0]);
    private static Random random = new Random();

    // 랜덤 키 가지고 오기
    public static Pair<String, Key> getRandomKey() {
        String kid = KID_SET[random.nextInt(KID_SET.length)];
        String secretKey = SECRET_KEY_SET.get(kid);
        return Pair.of(kid, Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8)));
    }

    // kid로 key 찾기
    public static Key getKey(String kid) {
        String key = SECRET_KEY_SET.getOrDefault(kid, null);
        if(key == null) {
            return null;
        } return Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
    }
}
