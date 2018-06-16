package com.zj.blog.service;




import java.util.List;

import com.zj.blog.pojo.Category;
import com.zj.blog.pojo.custom.ArticleListVo;
import com.zj.blog.pojo.custom.CategoryCustom;

/**
 * Created by �ԕ� on 2017/8/24.
 */
public interface CategoryService {
	//��÷�������
	public Integer countCategory(Integer status) throws Exception;
	
	//��÷����б�
	public List<CategoryCustom> listCategory(Integer status) throws Exception;

	//��ô��и÷���������б�
	public  List<ArticleListVo> listArticleWithCategoryByPage(Integer status,Integer pageNow,Integer pageSize,Integer cateId) throws Exception;

	//���ĳ��������Ϣ
	public CategoryCustom getCategory(Integer status,Integer id) throws Exception;

	//ɾ������
	public void deleteCategory(Integer id) throws Exception;

	//����id��ѯ������Ϣ
	public CategoryCustom getCategoryById(Integer status,Integer id) throws Exception;

	//��ӷ���
	public void insertCategory(Category category) throws Exception;

	//���·���
	public void updateCategory(Category category) throws Exception;

	//���ݷ�������ȡ����
	public Category getCategoryByName(String name) throws Exception;
	

	
}
