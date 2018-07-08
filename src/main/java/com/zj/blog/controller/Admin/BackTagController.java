package com.zj.blog.controller.Admin;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zj.blog.pojo.custom.TagCustom;
import com.zj.blog.service.TagService;

@Controller
@RequestMapping("/admin/tag")
public class BackTagController {
	@Autowired
    private TagService tagService;
	//后台标签列表显示
    @RequestMapping(value = "")
	public ModelAndView index() throws Exception {
    	ModelAndView modelandview = new ModelAndView();
        List<TagCustom> tagCustomList = tagService.listTag(null);
        modelandview.addObject("tagCustomList",tagCustomList);

        modelandview.setViewName("Admin/Tag/index");
        return modelandview;
		
	}
}
