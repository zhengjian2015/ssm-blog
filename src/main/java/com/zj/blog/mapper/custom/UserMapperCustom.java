package com.zj.blog.mapper.custom;

import org.springframework.stereotype.Repository;

import com.zj.blog.pojo.User;

@Repository
public interface UserMapperCustom {
	//根据用户名或Email获得用户
	public User getUserByNameOrEmail(String str) throws Exception;
}
