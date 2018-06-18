package com.zj.blog.controller.Home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zj.blog.pojo.custom.ArticleCustom;
import com.zj.blog.pojo.custom.ArticleDetailVo;
import com.zj.blog.service.ArticleService;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	//文章详情页显示
	@RequestMapping(value = "/article/{articleId}")
	@ResponseBody //适合RESTful
	public ModelAndView ArticleDetailView(@PathVariable("articleId") Integer articleId) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		//文章信息，分类，标签，作者，评论
		ArticleDetailVo articleDetailVo  = articleService.getArticleDetailById(articleId);
		if(articleDetailVo!=null) {

			modelAndView.addObject("articleDetailVo", articleDetailVo);
			//相关文章
			Integer parentCategoryId = articleService.getArticleById(1, articleId).getArticleParentCategoryId();
			Integer childCategoryId = articleService.getArticleById(1, articleId).getArticleChildCategoryId();
			List<ArticleCustom> similarArticleList = articleService.listArticleWithSameCategory(1, parentCategoryId, childCategoryId, 5);
			modelAndView.addObject("similarArticleList", similarArticleList);

			//猜你喜欢
			List<ArticleCustom> mostViewArticleList = articleService.listArticleByViewCount(1, 5);
			modelAndView.addObject("mostViewArticleList", mostViewArticleList);
			//获取下一篇文章
			ArticleCustom afterArticle = articleService.getAfterArticle(1, articleId);
			modelAndView.addObject("afterArticle", afterArticle);
			//获取上一篇文章
			ArticleCustom preArticle = articleService.getPreArticle(1, articleId);
			modelAndView.addObject("preArticle", preArticle);
			modelAndView.setViewName("Home/Page/articleDetail");
		} else {
			modelAndView.setViewName("Home/Error/404");
		}
	
		
		return modelAndView;//不会被解析为跳转路径，而是直接写入HTTP response body中	
		
	}
	
	

}
