package com.zj.blog.controller.Home;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zj.blog.pojo.Article;
import com.zj.blog.pojo.custom.ArticleListVo;
import com.zj.blog.service.ArticleService;

@Controller
public class PageController {
    @Autowired
    private ArticleService articleService;
    //Œƒ’¬πÈµµ“≥√Êœ‘ æ
    @RequestMapping(value = "/articleFile")
    public ModelAndView articleFile() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Home/Page/articleFile");
        List<ArticleListVo> articleList = articleService.listArticle(1);
        System.out.println(articleList);
        System.out.println(articleList.size());
        modelAndView.addObject("articleList",articleList);
        return modelAndView;
    }
}
