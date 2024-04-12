package com.example.demo.mapper;
import com.example.demo.Model.MyUser;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserMapper
{
    List<MyUser> select(MyUser user);
    List<MyUser> findId(MyUser user);
    List<MyUser> findPw(MyUser user);
    void insert(MyUser user);
}
