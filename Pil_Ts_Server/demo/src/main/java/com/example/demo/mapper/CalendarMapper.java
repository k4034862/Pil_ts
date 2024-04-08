package com.example.demo.mapper;

import com.example.demo.Model.Calendar;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CalendarMapper
{
    List<Calendar> select(List<Calendar> calendar);
    //List<Calendar> findId(Calendar calendar);
    //List<Calendar> findPw(Calendar calendar);
    void insert(Calendar calendar);
}
