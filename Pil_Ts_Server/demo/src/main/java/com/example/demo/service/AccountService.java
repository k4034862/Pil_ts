package com.example.demo.service;
import com.example.demo.Model.User;
import com.example.demo.controller.CommonController;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
@Service
@Transactional
public class AccountService {

    @Autowired
    private UserMapper userMapper;
    public String select(User user) {
        List<User> userInfo;
        userInfo = userMapper.select(user);
        // 유저 정보가 존재하지 않을 경우 처리
        if(userInfo.isEmpty()) {
            // 예외 처리 또는 사용자에게 메시지 전달 등
            return "fail";
        }
        // 데이터베이스에서 불러온 비밀번호
        String dbHashedPassword = userInfo.get(0).getPASSWORD();
        // 사용자가 입력한 비밀번호를 해시화
        String userInputPassword = user.getPASSWORD();
        String userEnteredHashedPassword = CommonController.hashPassword(userInputPassword);
        // 해시 값 비교
        if (dbHashedPassword.equals(userEnteredHashedPassword)) {
           return "success";
        } else {
           return "fail";
        }
    }
    public List<User> findId(User user) {
        return userMapper.findId(user);
    }
    public List<User> findPw(User user) {
        return userMapper.findPw(user);
    }
    public void insert(User user){
        // 비밀번호 해시화
        String hashedPassword = CommonController.hashPassword(user.getPASSWORD());
        user.setPASSWORD(hashedPassword);
        userMapper.insert(user);
    }


}
