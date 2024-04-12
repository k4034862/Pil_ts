package com.example.demo.controller;

import com.example.demo.Model.Calendar;
import com.example.demo.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@RestController
public class CalendarController {
    @Autowired
    private CalendarService calendarService;
    //일정 조회
    @RequestMapping(value ="scheduleSelect" ,method = RequestMethod.GET)
    public List<Calendar> getSelectList(List<Calendar> calendar){

        return calendarService.select(calendar);
    }
    //회원가입 버튼
    @RequestMapping(value ="calendarInsert", method = RequestMethod.POST)
    public void insertUser(@RequestBody List<Calendar> calendarList) {
        calendarService.insert(calendarList);
    }

}
