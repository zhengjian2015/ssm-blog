package com.zj.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zj.blog.mapper.ArticleMapper;
import com.zj.blog.mapper.TagMapper;
import com.zj.blog.mapper.UserMapper;
import com.zj.blog.mapper.custom.ArticleMapperCustom;
import com.zj.blog.mapper.custom.CategoryMapperCustom;
import com.zj.blog.pojo.Article;
import com.zj.blog.pojo.Tag;
import com.zj.blog.pojo.User;
import com.zj.blog.pojo.custom.ArticleCustom;
import com.zj.blog.pojo.custom.ArticleListVo;
import com.zj.blog.pojo.custom.CategoryCustom;
import com.zj.blog.pojo.custom.TagCustom;
import com.zj.blog.pojo.custom.UserCustom;
import com.zj.blog.service.ArticleService;


@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    public ArticleMapper articleMapper;
    
    @Autowired
    private ArticleMapperCustom articleMapperCustom;
    
    @Autowired
    private CategoryMapperCustom categoryMapperCustom;
    
    @Autowired
    private TagMapper tagMapper;
    
    @Autowired
    private UserMapper userMapper;

    @Override
    public Article getArticleById(Integer id) {
        // TODO Auto-generated method stub
        return articleMapper.selectByPrimaryKey(id);
    }
    

    @Override
    public List<ArticleListVo> listArticle(Integer status) throws Exception {
        List<ArticleListVo> articleListVoList = new ArrayList<ArticleListVo>();
        
        //��������б���Ϣ�ͷ�ҳ��Ϣ
        List<ArticleCustom> articleCustomList = articleMapperCustom.listArticle(status);

        //��÷�����Ϣ
        for (int i = 0; i < articleCustomList.size(); i++) {
            ArticleListVo articleListVo = new ArticleListVo();
            //1����������Ϣװ�� articleListVoList ��
            ArticleCustom articleCustom = articleCustomList.get(i);
            articleListVo.setArticleCustom(articleCustom);
            
            //2����������Ϣװ�� articleListVoList ��
            List<CategoryCustom> categoryCustomList = new ArrayList<CategoryCustom>();
            //��ø�������ӷ���ID
            //System.out.print(articleCustomList.get(i));
            Integer parentCategoryId = articleCustomList.get(i).getArticleParentCategoryId();
            //System.out.print("3333333333333333333333"+parentCategoryId);
            Integer childCategoryId = articleCustomList.get(i).getArticleChildCategoryId();
            //��÷�����Ϣ
            CategoryCustom categoryCustom = categoryMapperCustom.getCategoryById(1,parentCategoryId);
            CategoryCustom categoryCustom2 = categoryMapperCustom.getCategoryById(1,childCategoryId);           
            if (categoryCustom != null) {
                categoryCustomList.add(categoryCustom);
            }
            if (categoryCustom2 != null) {
                categoryCustomList.add(categoryCustom2);
            }
            articleListVo.setCategoryCustomList(categoryCustomList);
            
            //3����ñ�ǩ��Ϣ
            List<TagCustom> tagCustomList = new ArrayList<TagCustom>();
            String tagIds = articleCustomList.get(i).getArticleTagIds();
            //��ֹ������û�з��࣬��ָ��
            if (tagIds != null && tagIds != "") {
                String[] tagId = tagIds.split(",");
                for (int j = 0; j < tagId.length; j++) {
                    Tag tag = tagMapper.selectByPrimaryKey(Integer.valueOf(tagId[j]));
                    //��ֹ��ǩ�����ڣ���ɾ��
                    if (tag != null) {
                        TagCustom tagCustom = new TagCustom();
                        BeanUtils.copyProperties(tag, tagCustom);
                        tagCustomList.add(tagCustom);
                    }
                }
            }
            articleListVo.setTagCustomList(tagCustomList);
            
            //4�����������Ϣ
            User user = userMapper.selectByPrimaryKey(articleCustom.getArticleUserId());
            UserCustom userCustom = new UserCustom();
            BeanUtils.copyProperties(user, userCustom);
            articleListVo.setUserCustom(userCustom);


            articleListVoList.add(articleListVo);
            
        }
        return articleListVoList;
    }

}
