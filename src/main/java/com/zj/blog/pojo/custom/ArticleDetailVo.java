package com.zj.blog.pojo.custom;

import java.util.List;

public class ArticleDetailVo {
	//���������Ϣ
	private ArticleCustom articleCustom;
	
	//���µ����������Ϣ
	private UserCustom userCustom;
	
	//���µķ��������Ϣ
	private List<CategoryCustom> categoryCustomList;
	
	//���µı�ǩ�����Ϣ
	private List<TagCustom> tagCustomList;
	
	//������Ϣ
	private List<CommentCustom> commentCustomList;

	public ArticleCustom getArticleCustom() {
		return articleCustom;
	}
	
	public void setArticleCustom(ArticleCustom articleCustom) {
		this.articleCustom = articleCustom;
	}
	
	public UserCustom getUserCustom() {
		return userCustom;
	}
	
	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	
	public List<CategoryCustom> getCategoryCustomList() {
		return categoryCustomList;
	}
	
	public void setCategoryCustomList(List<CategoryCustom> categoryCustomList) {
		this.categoryCustomList = categoryCustomList;
	}
	
	public List<TagCustom> getTagCustomList() {
		return tagCustomList;
	}
	
	public void setTagCustomList(List<TagCustom> tagCustomList) {
		this.tagCustomList = tagCustomList;
	}
	
	public List<CommentCustom> getCommentCustomList() {
		return commentCustomList;
	}
	
	public void setCommentCustomList(List<CommentCustom> commentCustomList) {
		this.commentCustomList = commentCustomList;
	}
}