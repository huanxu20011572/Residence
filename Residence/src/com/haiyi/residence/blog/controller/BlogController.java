package com.haiyi.residence.blog.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.haiyi.residence.blog.service.BlogService;
import com.haiyi.residence.model.Blog;
import com.haiyi.residence.model.Comment;

@Controller
@RequestMapping("/blogController")
public class BlogController {

	@Resource(name="blogService")
	private BlogService blogService;
	@RequestMapping("/selectBlog")
	public void selectBlog(){
		Blog blog=blogService.selectBlog(1);
		System.out.println("博客内容:"+blog.getContent()+"\t发起者:"+blog.getOwner());
		List<Comment> comments=blog.getComments();
		for(Comment comment:comments){
			System.out.println("评论内容:"+comment.getContent());
		}
		
	}
}
