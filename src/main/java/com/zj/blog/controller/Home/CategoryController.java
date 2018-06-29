package com.zj.blog.controller.Home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zj.blog.pojo.custom.ArticleListVo;
import com.zj.blog.pojo.custom.CategoryCustom;
import com.zj.blog.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@ModelAttribute
	public void init(Model model) throws Exception {
		
	}
	//根据分类查询文章
	@RequestMapping("/category/{cateId}")
	public ModelAndView ArticleListByCategoryView(@PathVariable("cateId") Integer cateId) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		//设置每页显示条数
		int pageSize = 10;
		List<ArticleListVo> articleListVoList = categoryService.listArticleWithCategoryByPage(1,null,pageSize,cateId);
		//如果articleListVoList=null表示该分类不存在，如果=0表示该分类暂时没有文章
        modelAndView.addObject("articleListVoList",articleListVoList);

		//该分类信息
		CategoryCustom categoryCustom = categoryService.getCategoryById(1,cateId);
		modelAndView.addObject("categoryCustom",categoryCustom);

		modelAndView.setViewName("Home/Page/articleListByCategory");
		return modelAndView;

	}

}
