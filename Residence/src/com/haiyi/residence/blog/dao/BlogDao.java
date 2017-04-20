package com.haiyi.residence.blog.dao;

import com.haiyi.residence.mapper.SuperMapper;
import com.haiyi.residence.model.Blog;

public interface BlogDao extends SuperMapper {

	public Blog selectBlog(int id);
}
