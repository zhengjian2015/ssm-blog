package com.zj.blog.service;

import java.util.List;

import com.zj.blog.pojo.custom.CommentListVo;

public interface CommentService {

	
	//获得评论列表
	public List<CommentListVo> listCommentVo(Integer status) throws Exception;
	
	
	//统计评论数
	public Integer countComment(Integer status) throws Exception;
}
