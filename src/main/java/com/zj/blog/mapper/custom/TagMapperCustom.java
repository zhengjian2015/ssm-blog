package com.zj.blog.mapper.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zj.blog.pojo.Tag;
import com.zj.blog.pojo.custom.ArticleCustom;
import com.zj.blog.pojo.custom.TagCustom;

public interface TagMapperCustom {
	//��ñ�ǩ����
	public Integer countTag(@Param(value = "status") Integer status) throws Exception;
	
	//��ñ�ǩ�б�
	public List<TagCustom> listTag(@Param(value = "status")Integer status) throws Exception;

	//��ô��иñ�ǩ�������б�
	public List<ArticleCustom> listArticleWithTagByPage(@Param(value = "status") Integer status,@Param(value = "tagId") Integer tagId, @Param(value="startPos") Integer startPos, @Param(value="pageSize") Integer pageSize) throws Exception;

	//���ݱ�ǩ����ȡ��ǩ
	public Tag  getTagByName(String name) throws Exception;
}
