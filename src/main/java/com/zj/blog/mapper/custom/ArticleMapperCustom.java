package com.zj.blog.mapper.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zj.blog.pojo.custom.ArticleCustom;

@Repository
public interface ArticleMapperCustom {
	
	//获得所有文章(文章归档)
	public List<ArticleCustom> listArticle(@Param(value="status")Integer status) throws Exception;
}
