package com.zj.blog.service;

import com.zj.blog.pojo.Tag;
import com.zj.blog.pojo.custom.ArticleListVo;
import com.zj.blog.pojo.custom.TagCustom;
import org.apache.xpath.operations.Bool;

import java.util.List;

/**
 * Created by �ԕ� on 2017/9/2.
 */
public interface TagService {
	
	//��ñ�ǩ����
	public Integer countTag(Integer status) throws Exception;
	
	//��ñ�ǩ�б�
	public List<TagCustom> listTag(Integer status) throws Exception;

	//��ú��иñ�ǩ�������б�
	public List<ArticleListVo> getArticleListByPage(Integer status,Integer pageNow, Integer pageSize,Integer tagId) throws Exception;

	//����id��ñ�ǩ��Ϣ
	public TagCustom getTagById(Integer id) throws Exception;

	//��ӱ�ǩ
	public void insertTag(Tag tag) throws Exception;

	//�޸ı�ǩ
	public void updateTag(Tag tag) throws Exception;

	//ɾ����ǩ
    public void deleteTag(Integer id) throws Exception;

    //���ݱ�ǩ����ȡ��ǩ
	public Tag getTagByName(String name) throws Exception;

}
