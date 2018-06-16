package com.zj.blog.mapper.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zj.blog.pojo.Category;
import com.zj.blog.pojo.custom.ArticleCustom;
import com.zj.blog.pojo.custom.CategoryCustom;

/**
 * Created by ֣��  on 2018/6/16  00:15
 */
@Repository
public interface CategoryMapperCustom {
	//��ѯ��������
	public Integer countCategory(@Param(value="status") Integer status) throws Exception;
	
	//��÷����б�
	public List<CategoryCustom> listCategory(@Param(value="status") Integer status) throws Exception;
	
	//���ݷ���id��÷�����Ϣ
	public CategoryCustom getCategoryById(@Param(value="status") Integer status,@Param(value="id")Integer id) throws Exception;

	//��ú��и÷���������б�
	public List<ArticleCustom> listArticleWithCategoryByPage(
			@Param(value="status") Integer status,
			@Param(value = "cateId") Integer cateId
			,@Param(value="startPos") Integer startPos
			,@Param(value="pageSize") Integer pageSize
	);

	//ɾ������
	public void deleteCategory(Integer id) throws Exception;

	//���ݸ��������ӷ���
	public List<CategoryCustom> findChildCategory(@Param(value="status") Integer status,@Param(value="id")Integer id) throws Exception;

	//���ݱ�ǩ����ȡ��ǩ
	public Category  getCategoryByName(String name) throws Exception;

}