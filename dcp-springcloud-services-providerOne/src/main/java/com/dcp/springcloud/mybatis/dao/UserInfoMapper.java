package com.dcp.springcloud.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.dcp.springcloud.mybatis.model.UserInfo;

public interface UserInfoMapper{
	
	/**
	 * 根据登录名称查询用户
	 * @param loginName
	 * @return
	 */
	@Select("SELECT * from sys_user where login_name = #{loginName}")  
	public List<UserInfo> getByLoginName(String loginName);

}
