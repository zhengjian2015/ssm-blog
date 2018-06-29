package com.zj.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zj.blog.pojo.Article;

/*其实就是Dao层，mybatis逆向工程生成的是Mapper*/

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
}
