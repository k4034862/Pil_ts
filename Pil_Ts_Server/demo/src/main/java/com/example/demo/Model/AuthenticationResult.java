package com.example.demo.Model;

public class AuthenticationResult {
    private boolean success;
    private String token;
    private String userId;
    // 기타 필요한 정보

    public AuthenticationResult(boolean success, String token,String userId) {
        this.success = success;
        this.token = token == null ? "" : token;
        this.userId = userId == null ? "" : userId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.token = userId;
    }
}