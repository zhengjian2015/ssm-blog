package com.zj.blog.mapper.custom;

import org.springframework.stereotype.Repository;

import com.zj.blog.pojo.User;

@Repository
public interface UserMapperCustom {
	//�����û�����Email����û�
	public User getUserByNameOrEmail(String str) throws Exception;
}
