package com.zj.blog.service;

import java.util.List;

import com.zj.blog.pojo.Article;

public interface ArticleService {
	//根据id获得文章
	public Article getArticleById(Integer id);
}
