package com.zj.blog.controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.zj.blog.pojo.custom.ArticleListVo;
import com.zj.blog.service.ArticleService;
import com.zj.blog.service.CategoryService;
import com.zj.blog.service.TagService;



@Controller
@RequestMapping("/admin/article")
public class BackArticleController {
	@Autowired
    private ArticleService articleService;


    /*@Autowired
    private TagService tagService;
*/
    @Autowired
    private CategoryService categoryService;

    //��̨�����б���ʾ
    @RequestMapping(value = "")
    public ModelAndView index() throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        //��ҳ��ʾ�ѷ�������
        Integer pageSize = 20;
        List<ArticleListVo> publishedArticleListVoList = articleService.listArticleByPage(1,null,pageSize);
        modelAndView.addObject("publishedArticleListVoList",publishedArticleListVoList);

        //����ҳ��ʾ �ݸ�����
        List<ArticleListVo> draftArticleList = articleService.listArticle(0);
        modelAndView.addObject("draftArticleList",draftArticleList);
        modelAndView.setViewName("Admin/Article/index");
        return modelAndView;
    }
}