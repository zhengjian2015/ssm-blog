package com.zj.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zj.blog.pojo.Article;

/*��ʵ����Dao�㣬mybatis���򹤳����ɵ���Mapper*/

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
}
