package com.zj.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zj.blog.mapper.CategoryMapper;
import com.zj.blog.mapper.TagMapper;
import com.zj.blog.mapper.custom.ArticleMapperCustom;
import com.zj.blog.mapper.custom.CategoryMapperCustom;
import com.zj.blog.mapper.custom.TagMapperCustom;
import com.zj.blog.pojo.Tag;
import com.zj.blog.pojo.custom.ArticleListVo;
import com.zj.blog.pojo.custom.TagCustom;
import com.zj.blog.service.TagService;

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

	@Override
	public List<ArticleListVo> getArticleListByPage(Integer status, Integer pageNow, Integer pageSize, Integer tagId)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
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
