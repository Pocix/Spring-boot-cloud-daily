package com.dcp.springcloud.services.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcp.springcloud.mybatis.dao.UserInfoMapper;
import com.dcp.springcloud.mybatis.model.UserInfo;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> getAllUser(){
    	UserInfo user = new UserInfo(null);
    	user.setId("0fb8ebbff20a46029596806aa077d3c2");
    	System.out.println(userInfoMapper.getByLoginName("admin").size());
    	return userInfoMapper.getByLoginName("admin");
    }
}