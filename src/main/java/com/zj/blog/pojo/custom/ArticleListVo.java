package com.zj.blog.pojo.custom;

import java.util.List;

import com.zj.blog.util.Page;

/**
 * ���ڷ�װ�����б�����������Ϣ��������Ϣ��������Ϣ����ǩ��Ϣ
 * Created by ֣�� on 2018/6/15 22:24 ���籭 ����-Ħ���.
 */
public class ArticleListVo {
	//������Ϣ
	private ArticleCustom articleCustom;
	
	//���¶�Ӧ�ķ���
    private List<CategoryCustom> categoryCustomList;
    
    //���¶�Ӧ�ı�ǩ
  	private List<TagCustom> tagCustomList;
  	
  //������Ϣ
  	private UserCustom userCustom;

  	public UserCustom getUserCustom() {
  		return userCustom;
  	}

  	public void setUserCustom(UserCustom userCustom) {
  		this.userCustom = userCustom;
  	}
  	
    //���·�ҳ��Ϣ
  	private Page page;
  	
  	public ArticleCustom getArticleCustom() {
  		return articleCustom;
  	}
 
	
	public void setArticleCustom(ArticleCustom articleCustom) {
		this.articleCustom = articleCustom;
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

	public Page getPage() {
		return page;
	}
	
	public void setPage(Page page) {
		this.page = page;
	}
}
