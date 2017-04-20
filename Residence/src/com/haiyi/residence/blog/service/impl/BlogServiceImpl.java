package com.haiyi.residence.blog.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.haiyi.residence.blog.dao.BlogDao;
import com.haiyi.residence.blog.service.BlogService;
import com.haiyi.residence.model.Blog;
@Service("blogService")
public class BlogServiceImpl implements BlogService {

	private BlogDao blogDao;
	
	/**  
	 * @return the blogDao  
	 */
	public BlogDao getBlogDao() {
		return blogDao;
	}

	/**  
	 * @param blogDao the blogDao to set  
	 */
	@Resource(name="blogDao")
	public void setBlogDao(BlogDao blogDao) {
		this.blogDao = blogDao;
	}

	@Override
	public Blog selectBlog(int id) {
		// TODO Auto-generated method stub
		
		return blogDao.selectBlog(id);
	}

}
