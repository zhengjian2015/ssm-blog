package com.zj.blog.pojo.custom;

import com.zj.blog.pojo.Category;

/**
 * 文章分类目录的信息的扩展
 * Created by 郑健 on 2018/6/15 22:33 世界杯 伊朗-摩洛哥.
 */
public class CategoryCustom extends Category {
    //分类对应的文章数
    private Integer articleCount;

    //分类的父分类名称
    private String categoryPname;

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public String getCategoryPname() {
        return categoryPname;
    }

    public void setCategoryPname(String categoryPname) {
        this.categoryPname = categoryPname;
    }
}
