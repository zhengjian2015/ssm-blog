package com.zj.blog.service;

import java.util.List;

import com.zj.blog.pojo.custom.CommentListVo;

public interface CommentService {

	
	//��������б�
	public List<CommentListVo> listCommentVo(Integer status) throws Exception;
	
	
	//ͳ��������
	public Integer countComment(Integer status) throws Exception;
}
