package com.zj.blog.service;

import com.zj.blog.pojo.User;

public interface UserService {
	//�����û����������ѯ�û�
	public User getUserByNameOrEmail(String str) throws Exception;
	
	//�޸��û���Ϣ
	public void updateUser(User user) throws Exception;
}
