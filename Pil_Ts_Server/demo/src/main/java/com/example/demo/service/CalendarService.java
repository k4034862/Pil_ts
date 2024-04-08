package com.example.demo.service;
import com.example.demo.Model.Calendar;
import com.example.demo.Model.User;
import com.example.demo.mapper.CalendarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CalendarService {
    @Autowired
    private CalendarMapper calendarMapper;
    public List<Calendar> select(List<Calendar> calendar) {
        List<Calendar> calendarList;
        calendarList = calendarMapper.select(calendar);

        return calendarList;
    }
    public void insert(List<Calendar> calendarList){
        for (int i = 0; i < calendarList.size(); i++) {
            Calendar calendar = calendarList.get(i);
            calendarMapper.insert(calendar);
        }
    }

}
