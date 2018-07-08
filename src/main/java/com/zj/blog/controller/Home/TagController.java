package com.zj.blog.controller.Home;

import java.util.List;

import javax.enterprise.inject.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zj.blog.pojo.custom.ArticleListVo;
import com.zj.blog.pojo.custom.TagCustom;
import com.zj.blog.service.TagService;


@Controller
public class TagController {
	
	@Autowired
	private TagService tagService;
	
	
	//根据标签查询文章
		@RequestMapping("tag/{tagId}")
		@ResponseBody
		public ModelAndView ArticleListByTagView(@PathVariable("tagId") Integer tagId) throws Exception {
			ModelAndView modelAndView = new ModelAndView();
			//设置每页显示条数、
			System.out.println("9999");
			int pageSize = 10;
			List<ArticleListVo> articleListVoList = tagService.getArticleListByPage(1,null,pageSize,tagId);

			modelAndView.addObject("articleListVoList",articleListVoList);

			//标签信息
			TagCustom tagCustom = tagService.getTagById(tagId);
			modelAndView.addObject("tagCustom",tagCustom);

			modelAndView.setViewName("Home/Page/articleListByTag");
			return modelAndView;
		}
}
