package com.zj.blog.pojo.custom;

import com.zj.blog.pojo.User;

/**
 * 用户信息的扩展
 * Created by 郑健 on 2018/6/15 23:20 世界杯 伊朗-摩洛哥.
 */
public class UserCustom extends User {
    //用户的文章数
    private Integer articleCount;

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }
}
