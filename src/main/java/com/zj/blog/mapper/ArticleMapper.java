package com.zj.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zj.blog.pojo.Article;

/*��ʵ����Dao�㣬mybatis���򹤳����ɵ���Mapper*/

public interface ArticleMapper {
	Article selectByPrimaryKey(Integer articleId);
	
	int insertSelective(Article record);
	//List<Article> getArticles(@Param(value="status")Integer status);
}
