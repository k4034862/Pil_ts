package com.example.demo.Model;

public class AuthenticationResult {
    private boolean success;
    private String token;
    // 기타 필요한 정보

    public AuthenticationResult(boolean success, String token) {
        this.success = success;
        this.token = token == null ? "" : token;
    }

    // getter, setter 등 필요한 메소드
}
