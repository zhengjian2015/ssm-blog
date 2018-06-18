package com.zj.blog.pojo.custom;

import com.zj.blog.pojo.Comment;

/**
 * Created by 郑健 on 2018/6/18.  03:32 巴西-瑞士
 */
public class CommentCustom extends Comment {
    //评论者的头像
    private String commentAuthorAvatar;

    public String getCommentAuthorAvatar() {
        return commentAuthorAvatar;
    }

    public void setCommentAuthorAvatar(String commentAuthorAvatar) {
        this.commentAuthorAvatar = commentAuthorAvatar;
    }
}
