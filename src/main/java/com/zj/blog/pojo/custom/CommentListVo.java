package com.zj.blog.pojo.custom;

import com.zj.blog.util.Page;

/**
 *  ���ڷ�װ������Ϣ�������������ݣ�������Ϣ��������Ϣ
  */
public class CommentListVo {
    //������Ϣ
    private CommentCustom commentCustom;

    //������Ϣ
    private ArticleCustom articleCustom;

    //��ҳ��Ϣ
    private Page page;

    public CommentCustom getCommentCustom() {
        return commentCustom;
    }

    public void setCommentCustom(CommentCustom commentCustom) {
        this.commentCustom = commentCustom;
    }

    public ArticleCustom getArticleCustom() {
        return articleCustom;
    }

    public void setArticleCustom(ArticleCustom articleCustom) {
        this.articleCustom = articleCustom;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
