package com.example.demo.service;
import com.example.demo.Model.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AccountService {
    @Autowired
    private UserMapper userMapper;
    public List<User> select(User user) {
        List<User> userInfo;
        userInfo = userMapper.select(user);

        return userInfo;
    }
    public List<User> findId(User user) {
        return userMapper.findId(user);
    }
    public List<User> findPw(User user) {
        return userMapper.findPw(user);
    }
    public void insert(User user){
        userMapper.insert(user);
    }

}
