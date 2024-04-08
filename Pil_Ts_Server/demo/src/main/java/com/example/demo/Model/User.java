package com.example.demo.Model;

import lombok.Data;

@Data
public class User {
//    사용자아이디
    private String USER_ID;
//    사용자 이름
    private String USER_NM;
    //패스워드
    private String PASSWORD;
    //    전화번호
    private String USER_TEL;
    //    이메일
    private String USER_EMAIL;
    //    사용여부
    private String USE_YN;
    //    생성일자
    private String CREATE_DATE;
    //    생성자
    private String CREATE_ID;
    //    수정일자
    private String UPDATE_DATE;
    //    수정자
    private String UPDATE_ID;

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSER_NM() {
        return USER_NM;
    }

    public void setUSER_NM(String USER_NM) {
        this.USER_NM = USER_NM;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getUSER_TEL() {
        return USER_TEL;
    }

    public void setUSER_TEL(String USER_TEL) {
        this.USER_TEL = USER_TEL;
    }

    public String getUSER_EMAIL() {
        return USER_EMAIL;
    }

    public void setUSER_EMAIL(String USER_EMAIL) {
        this.USER_EMAIL = USER_EMAIL;
    }

    public String getUSE_YN() {
        return USE_YN;
    }

    public void setUSE_YN(String USE_YN) {
        this.USE_YN = USE_YN;
    }

    public String getCREATE_DATE() {
        return CREATE_DATE;
    }

    public void setCREATE_DATE(String CREATE_DATE) {
        this.CREATE_DATE = CREATE_DATE;
    }

    public String getCREATE_ID() {
        return CREATE_ID;
    }

    public void setCREATE_ID(String CREATE_ID) {
        this.CREATE_ID = CREATE_ID;
    }

    public String getUPDATE_DATE() {
        return UPDATE_DATE;
    }

    public void setUPDATE_DATE(String UPDATE_DATE) {
        this.UPDATE_DATE = UPDATE_DATE;
    }

    public String getUPDATE_ID() {
        return UPDATE_ID;
    }

    public void setUPDATE_ID(String UPDATE_ID) {
        this.UPDATE_ID = UPDATE_ID;
    }
}
