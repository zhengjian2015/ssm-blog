package com.zj.blog.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zj.blog.mapper.ArticleMapper;
import com.zj.blog.pojo.Article;
import com.zj.blog.service.ArticleService;


@Service("articleService")
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	public ArticleMapper articleMapper;

	@Override
	public Article getArticleById(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.selectByPrimaryKey(id);
	}


}
