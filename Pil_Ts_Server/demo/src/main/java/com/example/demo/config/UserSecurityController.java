package com.example.demo.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class UserSecurityController {
    // 비밀번호 해시화 메서드
    public static String hashPassword(String password) {
        try {
            // SHA-256 해시 함수 생성
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // 비밀번호를 바이트 배열로 변환하여 해시화
            byte[] hashedBytes = md.digest(password.getBytes());
            // 바이트 배열을 Base64로 인코딩하여 반환
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // JWT 유효 시간(30분)
    private static final long JWT_VALIDITY = 30 * 60 * 1000;

    // 시크릿 키
    public static String secretKeyGenerator(){
        int keyLength = 256;

        // 안전한 난수 생성기 생성
        SecureRandom secureRandom = new SecureRandom();

        // 무작위 바이트 배열 생성
        byte[] keyBytes = new byte[keyLength / 8];
        secureRandom.nextBytes(keyBytes);

        // 바이트 배열을 Base64 문자열로 변환하여 시크릿 키 생성

        return Base64.getEncoder().encodeToString(keyBytes);
    }

    // 토큰 생성
    public static String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("roles", userDetails.getAuthorities())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_VALIDITY))
                .signWith(SignatureAlgorithm.HS256, secretKeyGenerator())
                .compact();
    }
}
