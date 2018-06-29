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
import com.zj.blog.mapper.custom.CommentMapperCustom;
import com.zj.blog.pojo.Article;
import com.zj.blog.pojo.Tag;
import com.zj.blog.pojo.User;
import com.zj.blog.pojo.custom.ArticleCustom;
import com.zj.blog.pojo.custom.ArticleDetailVo;
import com.zj.blog.pojo.custom.ArticleListVo;
import com.zj.blog.pojo.custom.CategoryCustom;
import com.zj.blog.pojo.custom.CommentCustom;
import com.zj.blog.pojo.custom.TagCustom;
import com.zj.blog.pojo.custom.UserCustom;
import com.zj.blog.service.ArticleService;
import com.zj.blog.util.Functions;
import com.zj.blog.util.others.Page;


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
    
    @Autowired
	private CommentMapperCustom commentMapperCustom;

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


	@Override
	public List<ArticleListVo> listArticleByPage(Integer status, Integer pageNow, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		List<ArticleListVo> articleListVoList = new ArrayList<ArticleListVo>();
		
		//��������б���Ϣ�ͷ�ҳ��Ϣ
		List<ArticleCustom> articleCustomList = new ArrayList<ArticleCustom>();
		Page page = null;
		int totalCount = articleMapperCustom.countArticle(status);
		if (pageNow != null) {
			page = new Page(totalCount, pageNow,pageSize);
			articleCustomList = articleMapperCustom.listArticleByPage(status,page.getStartPos(),pageSize);
		} else {
			page = new Page(totalCount, 1,pageSize);
			articleCustomList = articleMapperCustom.listArticleByPage(status,page.getStartPos(), pageSize);
		}
		//��÷�����Ϣ
		for(int i=0;i<articleCustomList.size();i++) {
			ArticleListVo articleListVo = new ArticleListVo();
			
			//1����������Ϣװ�� articleListVoList ��
			ArticleCustom articleCustom = articleCustomList.get(i);
			articleListVo.setArticleCustom(articleCustom);
			
			//2����������Ϣװ�� articleListVoList ��
			List<CategoryCustom> categoryCustomList = new ArrayList<CategoryCustom>();
			Integer parentCategoryId =articleCustomList.get(i).getArticleParentCategoryId();
            Integer childCategoryId =articleCustomList.get(i).getArticleChildCategoryId();
            CategoryCustom categoryCustom = categoryMapperCustom.getCategoryById(status,parentCategoryId);
			CategoryCustom categoryCustom2 = categoryMapperCustom.getCategoryById(status,childCategoryId);
			if(categoryCustom!=null) {
                categoryCustomList.add(categoryCustom);
            }
            if(categoryCustom2!=null) {
                categoryCustomList.add(categoryCustom2);
            }
            articleListVo.setCategoryCustomList(categoryCustomList);

			//3����ñ�ǩ��Ϣ
			List<TagCustom> tagCustomList = new ArrayList<TagCustom>();
			String tagIds = articleCustomList.get(i).getArticleTagIds();
			//��ֹ������û�з��࣬��ָ��
			if(tagIds!=null && tagIds!="") {
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
			UserCustom  userCustom = new UserCustom();
			BeanUtils.copyProperties(user,userCustom);
			articleListVo.setUserCustom(userCustom);


			articleListVoList.add(articleListVo);
		}

		if(articleListVoList.size()>0) {
			//4����Page��Ϣ�洢�ڵ�һ��Ԫ����
			articleListVoList.get(0).setPage(page);
		}
		return articleListVoList;
	}

	//������Ϣ�����࣬��ǩ�����ߣ�����
	@Override
	public ArticleDetailVo getArticleDetailById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		ArticleDetailVo articleDetailVo = new ArticleDetailVo();
		//1�����������Ϣ
		ArticleCustom articleCustom = articleMapperCustom.getArticleById(1,id);
		if(articleCustom ==null) {
			return null;
		}
		articleDetailVo.setArticleCustom(articleCustom);
		
		//2����������Ϣװ�� articleListVoList ��
		List<CategoryCustom> categoryCustomList = new ArrayList<CategoryCustom>();
		Integer cate =articleCustom.getArticleParentCategoryId();
		Integer cate2 =articleCustom.getArticleChildCategoryId();
		CategoryCustom categoryCustom = categoryMapperCustom.getCategoryById(1,cate);
		CategoryCustom categoryCustom2 = categoryMapperCustom.getCategoryById(1,cate2);
		if(categoryCustom!=null) {
            categoryCustomList.add(categoryCustom);
        }
        if(categoryCustom2!=null) {
            categoryCustomList.add(categoryCustom2);
        }
		articleDetailVo.setCategoryCustomList(categoryCustomList);
		
		//3��������µı�ǩ
		String tag_ids = articleCustom.getArticleTagIds();
		List<TagCustom> tagCustomList = new ArrayList<TagCustom>();
		if (tag_ids != null && tag_ids != "") {
			String[] tags = tag_ids.split(",");
			int tagLength = tags.length;
			
			for (int i = 0; i < tagLength; i++) {
				Tag tag= tagMapper.selectByPrimaryKey(Integer.valueOf(tags[i]));
				if(tag!=null) {
					TagCustom tagCustom = new TagCustom();
					BeanUtils.copyProperties(tag,tagCustom);
					tagCustomList.add(tagCustom);
				}
			}
		}
		articleDetailVo.setTagCustomList(tagCustomList);
		
		//4��������µ�����
		Integer userId = articleCustom.getArticleUserId();
		User user = userMapper.selectByPrimaryKey(userId);
		UserCustom userCustom = new UserCustom();
		BeanUtils.copyProperties(user,userCustom);
		articleDetailVo.setUserCustom(userCustom);
		
		//5����ȡ������Ϣ�б�
		List<CommentCustom> commentCustomList = commentMapperCustom.listCommentByArticleId(1,id);
		//��ÿ�������û����ͷ��
		for(int i=0;i<commentCustomList.size();i++) {
			String avatar = Functions.getGravatar(commentCustomList.get(i).getCommentAuthorEmail());
			commentCustomList.get(i).setCommentAuthorAvatar(avatar);
		}
		articleDetailVo.setCommentCustomList(commentCustomList);


		return articleDetailVo;

	}


	@Override
	public ArticleCustom getArticleById(Integer status,Integer id) throws Exception {
		return articleMapperCustom.getArticleById(status,id);
	}


	//�������»�ȡ
	@Override
	public List<ArticleCustom> listArticleWithSameCategory(Integer status,Integer parentCategoryId,Integer childCategoryId, Integer limit) throws Exception {
		List<ArticleCustom> similarArticleList = articleMapperCustom.listArticleWithSameCategory(status,parentCategoryId,childCategoryId,limit);
		return similarArticleList;
	}


	//�������Ӷൽ�ٵ����»�ȡ
	@Override
	public List<ArticleCustom> listArticleByViewCount(Integer status,Integer limit) throws Exception {
		List<ArticleCustom> mostViewArticleList = articleMapperCustom.listArticleByViewCount(status,limit);
		return mostViewArticleList;
	}


	//��ȡ��һƪ����
	@Override
	public ArticleCustom getAfterArticle(Integer status,Integer id) throws Exception {
		ArticleCustom articleCustom = articleMapperCustom.getAfterArticle(status,id);
		return articleCustom;
	}


	//��ȡ��һƪ����
	@Override
	public ArticleCustom getPreArticle(Integer status,Integer id) throws Exception {
		ArticleCustom articleCustom = articleMapperCustom.getPreArticle(status,id);
		return articleCustom;
	}


	@Override
	public void insertArticle(Article article) throws Exception {
		// TODO Auto-generated method stub
		articleMapper.insertSelective(article);
	}


	@Override
	public void updateArticle(Integer id, Article article) throws Exception {
		//���ҵ��У�飬ͨ����service�ӿڶԹؼ�
		article.setArticleId(id);
		articleMapper.updateByPrimaryKeySelective(article);
		
	}


	@Override
	public void deleteArticle(Integer id) throws Exception {
		// TODO Auto-generated method stub
		articleMapper.deleteByPrimaryKey(id);
	}
}
