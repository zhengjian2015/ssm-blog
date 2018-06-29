package com.zj.blog.controller.Admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zj.blog.pojo.custom.CategoryCustom;
import com.zj.blog.service.ArticleService;
import com.zj.blog.service.CategoryService;

@Controller
@RequestMapping("/admin/category")
public class BackCategoryController {
	
	@Resource
	private ArticleService articleService;
	
	@Resource
	private CategoryService categoryService;
	
	//后台分类列表显示
    @RequestMapping(value = "")
    public ModelAndView categoryList() throws Exception {
        ModelAndView modelandview = new ModelAndView();

        List<CategoryCustom> categoryCustomList = categoryService.listCategory(null);
        modelandview.addObject("categoryCustomList",categoryCustomList);

        modelandview.setViewName("Admin/Category/index");
        return modelandview;

    }
}
