package com.zj.blog.service;

import com.zj.blog.pojo.User;

public interface UserService {
	//根据用户名和邮箱查询用户
	public User getUserByNameOrEmail(String str) throws Exception;
	
	//修改用户信息
	public void updateUser(User user) throws Exception;
}
