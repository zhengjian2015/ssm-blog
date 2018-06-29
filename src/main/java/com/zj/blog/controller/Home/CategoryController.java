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
	//���ݷ����ѯ����
	@RequestMapping("/category/{cateId}")
	public ModelAndView ArticleListByCategoryView(@PathVariable("cateId") Integer cateId) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		//����ÿҳ��ʾ����
		int pageSize = 10;
		List<ArticleListVo> articleListVoList = categoryService.listArticleWithCategoryByPage(1,null,pageSize,cateId);
		//���articleListVoList=null��ʾ�÷��಻���ڣ����=0��ʾ�÷�����ʱû������
        modelAndView.addObject("articleListVoList",articleListVoList);

		//�÷�����Ϣ
		CategoryCustom categoryCustom = categoryService.getCategoryById(1,cateId);
		modelAndView.addObject("categoryCustom",categoryCustom);

		modelAndView.setViewName("Home/Page/articleListByCategory");
		return modelAndView;

	}

}
