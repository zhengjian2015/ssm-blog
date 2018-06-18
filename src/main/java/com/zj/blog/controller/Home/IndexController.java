package com.zj.blog.controller.Home;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zj.blog.pojo.custom.ArticleListVo;
import com.zj.blog.service.ArticleService;



@Controller
public class IndexController {
	@Autowired
    private ArticleService articleService;
	
	//首页显示
	
	@RequestMapping("/")  
    public ModelAndView IndexView() throws Exception {  
		ModelAndView modelAndView = new ModelAndView();
		//文章列表
		int pageSize = 10;
		List<ArticleListVo> articleListVoList = articleService.listArticleByPage(1,null,pageSize);
		modelAndView.addObject("articleListVoList",articleListVoList);
		modelAndView.setViewName("/Home/index");
		return modelAndView;
    }
	
	//后台分页用mybatis插件实验下  实验结果还是不行，没报错，但是没办法分页，猜测和这个sql太咋的原因
	//不对，原来是mybaits-config没引入pageheper
	//但是引入后，总数又不对，没法搞定了。。。。。。。。。。。。
	/*
	@RequestMapping(value="/",method=RequestMethod.GET)  
    public String getArticleByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) throws Exception {
        PageHelper.startPage(pn, 5);
        System.out.println(pn);
		// startPage后面紧跟的这个查询就是一个分页查询
        List<ArticleListVo> articleList = articleService.listArticle(1);
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		PageInfo page = new PageInfo(articleList, 5);
		model.addAttribute("pageInfo", page);
        return "Home/index2";  
    }  
	*/
	
	//文章分页显示
	@RequestMapping("p/{pageNow}")
	//适合RESTful
	public @ResponseBody  ModelAndView ArticleListByPageView(@PathVariable("pageNow") Integer pageNow) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		//设置每页显示的数量
		int pageSize = 10;
		List<ArticleListVo> articleListVoList = articleService.listArticleByPage(1,pageNow,pageSize);
		modelAndView.addObject("articleListVoList",articleListVoList);
		modelAndView.setViewName("Home/index");
		return modelAndView;//不会被解析为跳转路径，而是直接写入HTTP response body中
	}
	
	
}
