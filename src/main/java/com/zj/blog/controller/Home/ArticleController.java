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
	
	//��������ҳ��ʾ
	@RequestMapping(value = "/article/{articleId}")
	@ResponseBody //�ʺ�RESTful
	public ModelAndView ArticleDetailView(@PathVariable("articleId") Integer articleId) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		//������Ϣ�����࣬��ǩ�����ߣ�����
		ArticleDetailVo articleDetailVo  = articleService.getArticleDetailById(articleId);
		if(articleDetailVo!=null) {

			modelAndView.addObject("articleDetailVo", articleDetailVo);
			//�������
			Integer parentCategoryId = articleService.getArticleById(1, articleId).getArticleParentCategoryId();
			Integer childCategoryId = articleService.getArticleById(1, articleId).getArticleChildCategoryId();
			List<ArticleCustom> similarArticleList = articleService.listArticleWithSameCategory(1, parentCategoryId, childCategoryId, 5);
			modelAndView.addObject("similarArticleList", similarArticleList);

			//����ϲ��
			List<ArticleCustom> mostViewArticleList = articleService.listArticleByViewCount(1, 5);
			modelAndView.addObject("mostViewArticleList", mostViewArticleList);
			//��ȡ��һƪ����
			ArticleCustom afterArticle = articleService.getAfterArticle(1, articleId);
			modelAndView.addObject("afterArticle", afterArticle);
			//��ȡ��һƪ����
			ArticleCustom preArticle = articleService.getPreArticle(1, articleId);
			modelAndView.addObject("preArticle", preArticle);
			modelAndView.setViewName("Home/Page/articleDetail");
		} else {
			modelAndView.setViewName("Home/Error/404");
		}
	
		
		return modelAndView;//���ᱻ����Ϊ��ת·��������ֱ��д��HTTP response body��	
		
	}
	
	

}
