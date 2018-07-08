package com.zj.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zj.blog.mapper.CategoryMapper;
import com.zj.blog.mapper.TagMapper;
import com.zj.blog.mapper.custom.ArticleMapperCustom;
import com.zj.blog.mapper.custom.CategoryMapperCustom;
import com.zj.blog.mapper.custom.TagMapperCustom;
import com.zj.blog.pojo.Tag;
import com.zj.blog.pojo.custom.ArticleCustom;
import com.zj.blog.pojo.custom.ArticleListVo;
import com.zj.blog.pojo.custom.CategoryCustom;
import com.zj.blog.pojo.custom.TagCustom;
import com.zj.blog.service.TagService;
import com.zj.blog.util.others.Page;




@Service
public class TagServiceImpl implements TagService{
	
	@Autowired
	private TagMapper tagMapper;

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Autowired
	private CategoryMapperCustom categoryMapperCustom;

	@Autowired
	private TagMapperCustom tagMapperCustom;

	@Autowired
	private ArticleMapperCustom articleMapperCustom;

	@Override
	public Integer countTag(Integer status) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TagCustom> listTag(Integer status) throws Exception {
		List<TagCustom> tagList = tagMapperCustom.listTag(status);
		for(int i=0;i<tagList.size();i++) {
			Integer tagId = tagList.get(i).getTagId();
			int count = articleMapperCustom.countArticleByTag(status,tagId);
			tagList.get(i).setArticleCount(count);
		}
		return tagList;
	}

	//获得含有该标签的文章列表
		@Override
		public List<ArticleListVo> getArticleListByPage(Integer status,Integer pageNow, Integer pageSize,Integer tagId) throws Exception {
			List<ArticleListVo> articleListVoList = new ArrayList<ArticleListVo>();
			List<ArticleCustom> articleCustomList = new ArrayList<ArticleCustom>();
			//获得该标签的具体信息
			Tag tag = tagMapper.selectByPrimaryKey(tagId);
			if(tag==null) {
				return null;
			}
			//分页显示
			Page page = null;

			int totalCount = articleMapperCustom.countArticleByTag(status,tagId);
			if (pageNow != null) {
				page = new Page(totalCount, pageNow,pageSize);
				articleCustomList = tagMapperCustom.listArticleWithTagByPage(status,tagId,page.getStartPos(), page.getPageSize());
			} else {
				page = new Page(totalCount, 1,pageSize);
				articleCustomList = tagMapperCustom.listArticleWithTagByPage(status,tagId,page.getStartPos(), page.getPageSize());
			}
			
			for(int i=0;i<articleCustomList.size();i++) {
				ArticleListVo articleListVo = new ArticleListVo();
				//1、将文章装入 articleListVo
				ArticleCustom articleCustom = articleCustomList.get(i);
				articleListVo.setArticleCustom(articleCustom);
				//2、将分类信息装到 articleListVoList 中
				List<CategoryCustom> categoryCustomList = new ArrayList<CategoryCustom>();
				Integer cate =articleCustomList.get(i).getArticleParentCategoryId();
				Integer cate2 =articleCustomList.get(i).getArticleChildCategoryId();
				CategoryCustom categoryCustom = categoryMapperCustom.getCategoryById(status,cate);
				CategoryCustom categoryCustom2 = categoryMapperCustom.getCategoryById(status,cate2);
				if(categoryCustom!=null) {
					categoryCustomList.add(categoryCustom);
				}
				if(categoryCustom2!=null) {
					categoryCustomList.add(categoryCustom2);
				}
				articleListVo.setCategoryCustomList(categoryCustomList);
				
				articleListVoList.add(articleListVo);
			}
			//确保该标签有文章，防止空指针
			if(totalCount!=0) {
				//3、将Page存储在 articleListVoList 第一个元素中
				articleListVoList.get(0).setPage(page);

				//4、将标签信息 装入  articleListVoList 第一个元素中
				List<TagCustom> tagCustomList = new ArrayList<TagCustom>();
				TagCustom tagCustom = new TagCustom();
				BeanUtils.copyProperties(tag, tagCustom);
				tagCustomList.add(tagCustom);
				articleListVoList.get(0).setTagCustomList(tagCustomList);
			}
			return articleListVoList;
		}
	@Override
	public TagCustom getTagById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertTag(Tag tag) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTag(Tag tag) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTag(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tag getTagByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
