package com.example.demo.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class CommonController {
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
}
