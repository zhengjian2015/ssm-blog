package com.zj.blog.mapper;

import com.zj.blog.pojo.Article;

/*其实就是Dao层，mybatis逆向工程生成的是Mapper*/

public interface ArticleMapper {
	Article selectByPrimaryKey(Integer articleId);
}
