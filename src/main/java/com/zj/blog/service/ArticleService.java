package com.zj.blog.service;

import java.util.List;

import com.zj.blog.pojo.Article;
import com.zj.blog.pojo.custom.ArticleCustom;
import com.zj.blog.pojo.custom.ArticleDetailVo;
import com.zj.blog.pojo.custom.ArticleListVo;

public interface ArticleService {
	//根据id获得文章
	public Article getArticleById(Integer id);
	
	//测试
	//public List<Article> getArticles(Integer status);
	
	//获得所有文章不分页
	public List<ArticleListVo> listArticle(Integer status) throws Exception;
	
	//根据id获得文章
	public ArticleCustom getArticleById(Integer status,Integer id) throws Exception;
	
	//分页显示()
	public List<ArticleListVo> listArticleByPage(Integer status,Integer pageNow,Integer pageSize) throws Exception;
	
	//文章详情页面显示
	public ArticleDetailVo getArticleDetailById(Integer id) throws Exception;
	
	
	//获得相关文章
	public List<ArticleCustom> listArticleWithSameCategory(Integer status,Integer parentCategoryId,Integer childCategoryId, Integer limit) throws Exception;

	//获取访问量较多的文章
	public List<ArticleCustom> listArticleByViewCount(Integer status,Integer limit) throws Exception;
	
	//获得下一篇文章
	public ArticleCustom getAfterArticle(Integer status,Integer id) throws Exception;
	
	//获得上一篇文章
	public ArticleCustom getPreArticle(Integer status,Integer id) throws Exception;

}
