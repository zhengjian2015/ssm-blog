package com.zj.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zj.blog.mapper.ArticleMapper;
import com.zj.blog.mapper.CommentMapper;
import com.zj.blog.mapper.custom.ArticleMapperCustom;
import com.zj.blog.mapper.custom.CommentMapperCustom;
import com.zj.blog.pojo.custom.ArticleCustom;
import com.zj.blog.pojo.custom.CommentCustom;
import com.zj.blog.pojo.custom.CommentListVo;
import com.zj.blog.service.CommentService;
import com.zj.blog.util.Functions;


@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentMapperCustom commentMapperCustom;

	@Autowired
	private CommentMapper commentMapper;
	
	@Autowired
	private ArticleMapper articleMapper;
	
	
	@Autowired
	private ArticleMapperCustom articleMapperCustom;


	@Override
	public List<CommentListVo> listCommentVo(Integer status) throws Exception {
		// TODO Auto-generated method stub
		List<CommentListVo> commentListVoList = new ArrayList<CommentListVo>();
		
		List<CommentCustom> commentCustomList = commentMapperCustom.listComment(status);
		
		for(int i=0;i<commentCustomList.size();i++) {
			CommentListVo commentListVo = new CommentListVo();
			//获得文章信息
			Integer articleId = commentCustomList.get(i).getCommentArticleId();
			ArticleCustom articleCustom = articleMapperCustom.getArticleById(status,articleId);
			commentListVo.setArticleCustom(articleCustom);

			//评论信息
			CommentCustom commentCustom = commentCustomList.get(i);
			//评论者Gravatar头像
			String avatar = Functions.getGravatar(commentCustom.getCommentAuthorEmail());
			commentCustom.setCommentAuthorAvatar(avatar);
			commentListVo.setCommentCustom(commentCustomList.get(i));

			commentListVoList.add(commentListVo);
		}

		return commentListVoList;
	}


	@Override
	public Integer countComment(Integer status) throws Exception {
		Integer commentCount = commentMapperCustom.countComment(status);
		return commentCount;
	}
}
