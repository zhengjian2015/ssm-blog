package com.zj.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zj.blog.mapper.CategoryMapper;
import com.zj.blog.mapper.custom.ArticleMapperCustom;
import com.zj.blog.mapper.custom.CategoryMapperCustom;
import com.zj.blog.pojo.Category;
import com.zj.blog.pojo.custom.ArticleCustom;
import com.zj.blog.pojo.custom.ArticleListVo;
import com.zj.blog.pojo.custom.CategoryCustom;
import com.zj.blog.service.CategoryService;
import com.zj.blog.util.others.Page;


@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryMapperCustom categoryMapperCustom;
	
	@Autowired
	private CategoryMapper categoryMapper;

	@Autowired
	private ArticleMapperCustom articleMapperCustom;


	@Override
	public Integer countCategory(Integer status) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryCustom> listCategory(Integer status) throws Exception {
		// TODO Auto-generated method stubs
		List<CategoryCustom> categoryCustomList =  categoryMapperCustom.listCategory(1);
		for(int i=0;i<categoryCustomList.size();i++) {
			Integer cateId = categoryCustomList.get(i).getCategoryId();
			Integer count = articleMapperCustom.countArticleByCategory(status,cateId);
			categoryCustomList.get(i).setArticleCount(count);
		}
		return categoryCustomList;
	}

	@Override
	public List<ArticleListVo> listArticleWithCategoryByPage(Integer status, Integer pageNow, Integer pageSize,
			Integer cateId) throws Exception {
		List<ArticleListVo> articleListVoList = new ArrayList<ArticleListVo>();
		List<ArticleCustom> articleCustomList = new ArrayList<ArticleCustom>();
		
		//获得分类的信息
		Category category = categoryMapper.selectByPrimaryKey(cateId);
		//如果没有这个分类，返回null
		if(category==null) {
			return null;
		}

		//分页显示
		Page page = null;
		int totalCount = articleMapperCustom.countArticleByCategory(status,cateId);

		if (pageNow != null) {
			page = new Page(totalCount, pageNow,pageSize);
			articleCustomList = categoryMapperCustom.listArticleWithCategoryByPage(status,cateId,page.getStartPos(), page.getPageSize());
		} else {
			page = new Page(totalCount, 1,pageSize);
			articleCustomList = categoryMapperCustom.listArticleWithCategoryByPage(status,cateId,page.getStartPos(), page.getPageSize());
			
		}
		for(int i=0;i<articleCustomList.size();i++) {
			ArticleListVo articleListVo = new ArticleListVo();
			
			//1、将文章信息装入 articleListVo
			ArticleCustom articleCustom = articleCustomList.get(i);
			articleListVo.setArticleCustom(articleCustom);


			//2、将分类信息装到 articleListVoList 中
			List<CategoryCustom> categoryCustomList = new ArrayList<CategoryCustom>();
			Integer parentCategoryId =articleCustomList.get(i).getArticleParentCategoryId();
			Integer childCategoryId =articleCustomList.get(i).getArticleChildCategoryId();
			CategoryCustom categoryCustom = categoryMapperCustom.getCategoryById(status, parentCategoryId);
			CategoryCustom categoryCustom2 = categoryMapperCustom.getCategoryById(status,childCategoryId);
			if(categoryCustom!=null) {
				categoryCustomList.add(categoryCustom);
			}
			if(categoryCustom2!=null) {
				categoryCustomList.add(categoryCustom2);
			}
			articleListVo.setCategoryCustomList(categoryCustomList);

			articleListVoList.add(articleListVo);
		}
        //如果该分类还没有文章
        if(totalCount!=0) {
            //2、将Page信息存储在第一个元素中
            articleListVoList.get(0).setPage(page);
        }
		return articleListVoList;
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
