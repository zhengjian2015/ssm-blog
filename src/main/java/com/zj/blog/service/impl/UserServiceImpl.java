package com.zj.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zj.blog.mapper.UserMapper;
import com.zj.blog.mapper.custom.UserMapperCustom;
import com.zj.blog.pojo.User;
import com.zj.blog.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapperCustom userMapperCustom;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUserByNameOrEmail(String str) throws Exception {
		User user = userMapperCustom.getUserByNameOrEmail(str);
		return user;
	}
	
	
	@Override
	public void updateUser(User user) throws Exception {
		userMapper.updateByPrimaryKeySelective(user);
	}

}
