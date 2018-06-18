package com.zj.blog.service;

import java.util.List;

import com.zj.blog.pojo.Article;
import com.zj.blog.pojo.custom.ArticleCustom;
import com.zj.blog.pojo.custom.ArticleDetailVo;
import com.zj.blog.pojo.custom.ArticleListVo;

public interface ArticleService {
	//����id�������
	public Article getArticleById(Integer id);
	
	//����
	//public List<Article> getArticles(Integer status);
	
	//����������²���ҳ
	public List<ArticleListVo> listArticle(Integer status) throws Exception;
	
	//����id�������
	public ArticleCustom getArticleById(Integer status,Integer id) throws Exception;
	
	//��ҳ��ʾ()
	public List<ArticleListVo> listArticleByPage(Integer status,Integer pageNow,Integer pageSize) throws Exception;
	
	//��������ҳ����ʾ
	public ArticleDetailVo getArticleDetailById(Integer id) throws Exception;
	
	
	//����������
	public List<ArticleCustom> listArticleWithSameCategory(Integer status,Integer parentCategoryId,Integer childCategoryId, Integer limit) throws Exception;

	//��ȡ�������϶������
	public List<ArticleCustom> listArticleByViewCount(Integer status,Integer limit) throws Exception;
	
	//�����һƪ����
	public ArticleCustom getAfterArticle(Integer status,Integer id) throws Exception;
	
	//�����һƪ����
	public ArticleCustom getPreArticle(Integer status,Integer id) throws Exception;

}
