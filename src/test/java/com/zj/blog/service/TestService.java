package com.zj.blog.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	
	@Test
	public void testCRUD2() throws Exception {
		Integer pn = 1;
		PageHelper.startPage(pn, 8);
		List<ArticleListVo> articleListVoList = new ArrayList<ArticleListVo>();
		articleListVoList = articleService.listArticle(1);
		logger.debug("***********************************");
		logger.debug(articleListVoList.size());
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		PageInfo page = new PageInfo(articleListVoList);
		System.out.println(page);
		
	}
}
