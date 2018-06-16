package com.zj.blog.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zj.blog.mapper.custom.ArticleMapperCustom;
import com.zj.blog.pojo.Article;
import com.zj.blog.pojo.custom.ArticleCustom;
import com.zj.blog.pojo.custom.ArticleListVo;
import com.zj.blog.pojo.custom.CategoryCustom;
import com.zj.blog.service.ArticleService;
import com.zj.blog.service.CategoryService;


@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml"})  
public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class); 
	@Resource
	private ArticleService articleService = null;  
	
	@Resource
	private CategoryService categoryService = null;  
	
	@Autowired
	private ArticleMapperCustom articleMapperCustom;
	@Test
	public void testCRUD() {
		Article art= articleService.getArticleById( 3);
		System.out.println("2222");
		System.out.println(art);
	}
	
/*	@Test
	public void testCURD2() throws Exception {
		List<ArticleListVo> arvl = new ArrayList<ArticleListVo>();
		arvl = articleService.listArticle(1);
		logger.debug(arvl);
	}*/
	
	@Test
	public void testCURD8() throws Exception {
		
		List<ArticleCustom> articleCustomList = articleMapperCustom.listArticle(1);
		
		logger.debug(articleCustomList);
		System.out.println(articleCustomList.get(0));
		System.out.println(2222222);
		System.out.println(articleCustomList.get(0).getArticleContent());
		System.out.println(3333333);
	}
	
	
/*	@Test
	public void testCURD4(){
		List<Article> arvl = new ArrayList<Article>();
		arvl = articleService.getArticles(1);
		logger.debug(arvl);
		}*/
	

	@Test
	public void testCURD4() throws Exception{
		CategoryCustom ca = new CategoryCustom();
		ca = categoryService.getCategoryById(1, 1);
		logger.debug(ca);
		}
}
	
