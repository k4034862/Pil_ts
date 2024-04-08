package com.example.demo.Model;

import lombok.Data;

@Data
public class UserGroup {
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
}
