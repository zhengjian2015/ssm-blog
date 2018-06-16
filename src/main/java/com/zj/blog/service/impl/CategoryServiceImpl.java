package com.zj.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zj.blog.mapper.custom.ArticleMapperCustom;
import com.zj.blog.mapper.custom.CategoryMapperCustom;
import com.zj.blog.pojo.Category;
import com.zj.blog.pojo.custom.ArticleListVo;
import com.zj.blog.pojo.custom.CategoryCustom;
import com.zj.blog.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryMapperCustom categoryMapperCustom;
	
	//@Autowired
	//private CategoryMapper categoryMapper;

	@Autowired
	private ArticleMapperCustom articleMapperCustom;


	@Override
	public Integer countCategory(Integer status) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryCustom> listCategory(Integer status) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleListVo> listArticleWithCategoryByPage(Integer status, Integer pageNow, Integer pageSize,
			Integer cateId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryCustom getCategory(Integer status, Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCategory(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CategoryCustom getCategoryById(Integer status, Integer id) throws Exception {
		// TODO Auto-generated method stub
		return categoryMapperCustom.getCategoryById(status,id);
	}

	@Override
	public void insertCategory(Category category) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCategory(Category category) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category getCategoryByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
