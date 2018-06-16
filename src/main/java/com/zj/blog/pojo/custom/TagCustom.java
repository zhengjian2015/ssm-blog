package com.zj.blog.pojo.custom;

import com.zj.blog.pojo.Tag;

/**
 * 文章标签的信息的扩展
 * Created by 郑健 on 2018/6/15 23:20 世界杯 伊朗-摩洛哥.
 */
public class TagCustom extends Tag {
	//标签对应的文章数目
	private Integer articleCount;

	public Integer getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}
}