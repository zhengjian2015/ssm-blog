package com.zj.blog.mapper;

import com.zj.blog.pojo.Article;

/*��ʵ����Dao�㣬mybatis���򹤳����ɵ���Mapper*/

public interface ArticleMapper {
	Article selectByPrimaryKey(Integer articleId);
}
