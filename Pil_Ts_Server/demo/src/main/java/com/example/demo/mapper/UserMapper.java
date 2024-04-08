package com.example.demo.mapper;
import com.example.demo.Model.User;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface UserMapper
{
    List<User> select(User user);
    List<User> findId(User user);
    List<User> findPw(User user);
    void insert(User user);
}
