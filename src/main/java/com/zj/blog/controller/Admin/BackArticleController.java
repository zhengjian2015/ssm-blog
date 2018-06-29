package com.zj.blog.controller.Admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zj.blog.pojo.Article;
import com.zj.blog.pojo.custom.ArticleCustom;
import com.zj.blog.pojo.custom.ArticleListVo;
import com.zj.blog.pojo.custom.CategoryCustom;
import com.zj.blog.pojo.custom.TagCustom;
import com.zj.blog.service.ArticleService;
import com.zj.blog.service.CategoryService;
import com.zj.blog.service.TagService;



@Controller
@RequestMapping("/admin/article")
public class BackArticleController {
	@Autowired
    private ArticleService articleService;
	
	@Autowired
    private TagService tagService;

    @Autowired
    private CategoryService categoryService;

    //后台文章列表显示
    @RequestMapping(value = "")
    public ModelAndView index() throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        //分页显示已发布文章
        Integer pageSize = 20;
        List<ArticleListVo> publishedArticleListVoList = articleService.listArticleByPage(1,null,pageSize);
        modelAndView.addObject("publishedArticleListVoList",publishedArticleListVoList);

        //不分页显示 草稿文章
        List<ArticleListVo> draftArticleList = articleService.listArticle(0);
        modelAndView.addObject("draftArticleList",draftArticleList);
        modelAndView.setViewName("Admin/Article/index");
        return modelAndView;
    }
    
    //后台添加文章提交操作
    @RequestMapping(value = "/insertSubmit",method = RequestMethod.POST)
    public String insertArticleSubmit(Article article) throws Exception {

        article.setArticlePostTime(new Date());
        article.setArticleUpdateTime(new Date());
        article.setArticleIsComment(1);
        article.setArticleViewCount(0);
        article.setArticleLikeCount(0);
        article.setArticleCommentCount(0);
        article.setArticleStatus(1);
        article.setArticleOrder(1);

        articleService.insertArticle(article);

        return "redirect:/admin/article";
    }
    
    //后台添加文章页面显示
    @RequestMapping(value = "/insert")
    public ModelAndView insertArticleView() throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        List<CategoryCustom> categoryCustomList = categoryService.listCategory(1);
        List<TagCustom> tagCustomList = tagService.listTag(1);

        modelAndView.addObject("categoryCustomList",categoryCustomList);
        modelAndView.addObject("tagCustomList",tagCustomList);

        modelAndView.setViewName("Admin/Article/insert");
        return modelAndView;
    }
    
    
    //编辑文章页面显示
    @RequestMapping(value="/edit/{id}")
    public ModelAndView editArticleView(@PathVariable("id") Integer id) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		ArticleCustom articleCustom =  articleService.getArticleById(null,id);
        modelAndView.addObject("articleCustom",articleCustom);

        List<CategoryCustom> categoryCustomList = categoryService.listCategory(1);
        modelAndView.addObject("categoryCustomList",categoryCustomList);

        List<TagCustom> tagCustomList = tagService.listTag(1);
        modelAndView.addObject("tagCustomList",tagCustomList);
		
        modelAndView.setViewName("Admin/Article/edit");
    	return modelAndView;
    	
    }
    
  //编辑文章提交
    @RequestMapping(value = "/editSubmit",method = RequestMethod.POST)
    public String editArticleSubmit(ArticleCustom articleCustom) throws Exception {
        Integer id = articleCustom.getArticleId();
        articleCustom.setArticleUpdateTime(new Date());
        articleService.updateArticle(id,articleCustom);
        return "redirect:/admin/article";
    }
    
    @RequestMapping(value="/delete/{id}",method = RequestMethod.POST)
    public void deleteArticle(@PathVariable("id") Integer id) throws Exception {
    	articleService.deleteArticle(id);
    }
    
}