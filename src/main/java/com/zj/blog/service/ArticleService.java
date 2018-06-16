package com.zj.blog.service;

import java.util.List;

import com.zj.blog.pojo.Article;
import com.zj.blog.pojo.custom.ArticleListVo;

public interface ArticleService {
	//根据id获得文章
	public Article getArticleById(Integer id);
	
	//测试
	//public List<Article> getArticles(Integer status);
	
	//获得所有文章不分页
	public List<ArticleListVo> listArticle(Integer status) throws Exception;
}
