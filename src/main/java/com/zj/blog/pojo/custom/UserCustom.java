package com.zj.blog.pojo.custom;

import com.zj.blog.pojo.User;

/**
 * �û���Ϣ����չ
 * Created by ֣�� on 2018/6/15 23:20 ���籭 ����-Ħ���.
 */
public class UserCustom extends User {
    //�û���������
    private Integer articleCount;

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }
}
