package com.example.demo.mapper;
import com.example.demo.Model.MyUser;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface UserMapper
{
    List<MyUser> select(MyUser user);
    List<MyUser> findId(MyUser user);
    List<MyUser> findPw(MyUser user);
    void insert(MyUser user);
}
