package com.example.demo.controller;

import com.example.demo.Model.MyUser;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model.AuthenticationResult;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;
    //로그인 버튼
    @RequestMapping(value ="select" ,method = RequestMethod.GET)
    public AuthenticationResult postSelectList( MyUser user){

        return accountService.select(user);
    }
    //아이디 찾기 버튼
    @RequestMapping(value ="findId" ,method = RequestMethod.GET)
    public List<MyUser> getFindId(MyUser user){

        return accountService.findId(user);
    }
    //비밀번호 찾기 버튼
    @RequestMapping(value ="findPw" ,method = RequestMethod.GET)
    public List<MyUser> getFindPw(MyUser user){

        return accountService.findPw(user);
    }
    //회원가입 버튼
    @RequestMapping(value ="insert", method = RequestMethod.POST)
    public void insertUser( MyUser user) {
        accountService.insert(user);
    }

}
