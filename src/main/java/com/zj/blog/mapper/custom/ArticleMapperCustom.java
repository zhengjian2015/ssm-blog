package com.zj.blog.mapper.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zj.blog.pojo.custom.ArticleCustom;

@Repository
public interface ArticleMapperCustom {
	
	//��ȡ��������
	public Integer countArticle(@Param(value="status") Integer status) throws Exception;
	
	//�����������(���¹鵵)
	public List<ArticleCustom> listArticle(@Param(value="status")Integer status) throws Exception;
	
	//��ҳ����(�����)
	public List<ArticleCustom> listArticleByPage(@Param(value="status") Integer status,@Param(value="startPos") Integer startPos, @Param(value="pageSize") Integer pageSize) throws Exception;
	
	
	//����id��ѯ�û���Ϣ
	public ArticleCustom getArticleById(@Param(value="status")Integer status,@Param(value="id")Integer id) throws Exception;
	
	//���ͬ���������(�������)
	public List<ArticleCustom> listArticleWithSameCategory(
			@Param(value="status") Integer status,
			 @Param(value = "parentCategory") Integer parentCategory
			,@Param(value = "childCategory") Integer childCategory
			,@Param(value = "limit") Integer limit
	) throws Exception;
	
	//��÷�����������(����ϲ��)
	public List<ArticleCustom> listArticleByViewCount(@Param(value="status") Integer status,@Param(value = "limit") Integer limit) throws Exception;
	
	//�����һƪ����
	public ArticleCustom getAfterArticle(@Param(value="status") Integer status,@Param(value="id") Integer id) throws Exception;
	
	//�����һƪ����
	public ArticleCustom getPreArticle(@Param(value="status") Integer status,@Param(value="id") Integer id) throws Exception;
	
	//��ø÷����������
	public Integer countArticleByCategory(@Param(value="status") Integer status,@Param(value = "id") Integer id) throws Exception;
	
	//��ø÷����������
	public Integer countArticleByTag(@Param(value="status") Integer status,@Param(value = "id") Integer id) throws Exception;
}
