package com.zj.blog.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zj.blog.mapper.TestMyBatis;
import com.zj.blog.pojo.Article;
import com.zj.blog.pojo.custom.ArticleListVo;


@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml"})  
public class TestService {
	private static Logger logger = Logger.getLogger(TestService.class); 
	
	@Resource
	private ArticleService articleService = null;
	
	@Test
	public void testCRUD() throws Exception {
		List<ArticleListVo> articleListVoList = new ArrayList<ArticleListVo>();
		articleListVoList = articleService.listArticle(1);
		logger.debug("***********************************");
		logger.debug(articleListVoList);
	}
}
