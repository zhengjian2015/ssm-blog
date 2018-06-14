package com.zj.blog.mapper;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zj.blog.pojo.Article;
import com.zj.blog.service.ArticleService;


@RunWith(SpringJUnit4ClassRunner.class)     //��ʾ�̳���SpringJUnit4ClassRunner��  
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml"})  
public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class); 
	@Resource
	private ArticleService articleService = null;  
	@Test
	public void testCRUD(){
		Article art= articleService.getArticleById( 3);
		System.out.println("2222");
		System.out.println(art);
	}
}