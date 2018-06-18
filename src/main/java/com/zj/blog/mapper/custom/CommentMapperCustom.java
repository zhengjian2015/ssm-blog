package com.zj.blog.mapper.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zj.blog.pojo.Comment;
import com.zj.blog.pojo.custom.CommentCustom;

/**
 * Created by �ԕ� on 2017/9/10.
 */
public interface CommentMapperCustom {

	//��������id��ȡ�����б�
	public List<CommentCustom> listCommentByArticleId(@Param(value="status")  Integer status,@Param(value="id") Integer id);
	
	//��������б��ҳ
	public List<CommentCustom> listCommentByPage(@Param(value="status") Integer status,@Param(value="startPos") Integer startPos, @Param(value="pageSize") Integer pageSize) throws Exception;

	//��������б�
	public List<CommentCustom> listComment(@Param(value="status") Integer status) throws Exception;

	//ͳ��������
	public Integer countComment(@Param(value="status") Integer status) throws Exception;

	//����������
	public List<CommentCustom> listRecentComment(@Param(value = "limit") Integer limit) throws Exception;

	//������۵�������
	public List<Comment> listChildComment(@Param(value = "id") Integer id) throws Exception;

}

