package com.zj.blog.service;

import java.util.List;

import com.zj.blog.pojo.Article;
import com.zj.blog.pojo.custom.ArticleListVo;

public interface ArticleService {
	//����id�������
	public Article getArticleById(Integer id);
	
	//����
	//public List<Article> getArticles(Integer status);
	
	//����������²���ҳ
	public List<ArticleListVo> listArticle(Integer status) throws Exception;
}
