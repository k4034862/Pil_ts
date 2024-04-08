package com.example.demo.service;
import com.example.demo.Model.Calendar;
import com.example.demo.Model.UserGroup;
import com.example.demo.mapper.CalendarMapper;
import com.example.demo.mapper.UserGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserGroupService {
    @Autowired
    private UserGroupMapper userGroupMapper;
    public List<UserGroup> select(UserGroup userGroup) {
        List<UserGroup> userGroupList;
        userGroupList = userGroupMapper.select(userGroup);

        return userGroupList;
    }

}
