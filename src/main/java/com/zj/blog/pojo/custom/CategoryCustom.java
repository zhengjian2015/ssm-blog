package com.zj.blog.pojo.custom;

import com.zj.blog.pojo.Category;

/**
 * ���·���Ŀ¼����Ϣ����չ
 * Created by ֣�� on 2018/6/15 22:33 ���籭 ����-Ħ���.
 */
public class CategoryCustom extends Category {
    //�����Ӧ��������
    private Integer articleCount;

    //����ĸ���������
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
