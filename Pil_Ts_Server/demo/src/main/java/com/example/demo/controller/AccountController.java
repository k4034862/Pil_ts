package com.example.demo.controller;

import com.example.demo.Model.Calendar;
import com.example.demo.Model.User;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;
    //로그인 버튼
    @RequestMapping(value ="select" ,method = RequestMethod.GET)
    public String getSelectList(User user){

        return accountService.select(user);
    }
    //아이디 찾기 버튼
    @RequestMapping(value ="findId" ,method = RequestMethod.GET)
    public List<User> getFindId(User user){

        return accountService.findId(user);
    }
    //비밀번호 찾기 버튼
    @RequestMapping(value ="findPw" ,method = RequestMethod.GET)
    public List<User> getFindPw(User user){

        return accountService.findPw(user);
    }
    //회원가입 버튼
    @RequestMapping(value ="insert", method = RequestMethod.POST)
    public void insertUser(User user) {
        accountService.insert(user);
    }

}
