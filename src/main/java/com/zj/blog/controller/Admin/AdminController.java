package com.zj.blog.controller.Admin;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.zj.blog.pojo.User;
import com.zj.blog.pojo.custom.ArticleListVo;
import com.zj.blog.pojo.custom.CommentListVo;
import com.zj.blog.service.ArticleService;
import com.zj.blog.service.CommentService;
import com.zj.blog.service.UserService;
import static com.zj.blog.util.Functions.getIpAddr;

@Controller
public class AdminController {
	@Autowired
    private UserService userService;
	
	@Autowired
    private ArticleService articleService;
	
	@Autowired
	private CommentService commentService;
	
	
    //��̨��ҳ
    @RequestMapping("/admin")
    public ModelAndView index() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //�����б�
        List<ArticleListVo> articleCustomList = articleService.listArticle(null);
        modelAndView.addObject("articleCustomList",articleCustomList);
        //�����б�
        List<CommentListVo> commentListVoList = commentService.listCommentVo(null);
        modelAndView.addObject("commentListVoList",commentListVoList);
        //������
        Integer allCommentCount = commentService.countComment(null);
        Integer approvedCommentCount = commentService.countComment(1);
        Integer hiddenCommentCount = commentService.countComment(0);
        modelAndView.addObject("allCommentCount",allCommentCount);
        modelAndView.addObject("approvedCommentCount",approvedCommentCount);
        modelAndView.addObject("hiddenCommentCount",hiddenCommentCount);

        modelAndView.setViewName("/Admin/index");
        return modelAndView;
    }
	
	//��¼ҳ����ʾ
    @RequestMapping("/login")
    public ModelAndView loginView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/Admin/login");
        return modelAndView;
    }
    
  //��¼��֤
    @RequestMapping(value = "/loginVerify",method = RequestMethod.POST)
    @ResponseBody
    public String loginVerify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberme = request.getParameter("rememberme");
        User user = userService.getUserByNameOrEmail(username);
        if(user==null) {
            map.put("code",0);
            map.put("msg","�û�����Ч��");
        } else if(!user.getUserPass().equals(password)) {
            map.put("code",0);
            map.put("msg","�������");
        } else {
            //��¼�ɹ�
            map.put("code",1);
            map.put("msg","");
            //���session
            request.getSession().setAttribute("user", user);
            //���cookie
            if(rememberme!=null) {
                //��������Cookie����
                Cookie nameCookie = new Cookie("username", username);
                //����Cookie����Ч��Ϊ3��
                nameCookie.setMaxAge(60 * 60 * 24 * 3);
                Cookie pwdCookie = new Cookie("password", password);
                pwdCookie.setMaxAge(60 * 60 * 24 * 3);
                response.addCookie(nameCookie);
                response.addCookie(pwdCookie);
            }
            user.setUserLastLoginTime(new Date());
            user.setUserLastLoginIp(getIpAddr(request));
            userService.updateUser(user);

        }
        String result = new JSONObject(map).toString();
        System.out.println(result);
        return result;
    }
}
