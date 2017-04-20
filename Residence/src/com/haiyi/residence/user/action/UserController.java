package com.haiyi.residence.user.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.haiyi.residence.model.TBUnit;
import com.haiyi.residence.model.User;
import com.haiyi.residence.user.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name="userService")
	private UserService userService;
	
	
	
	@RequestMapping("/getListPage")
	public void getListPage(HttpServletResponse response) throws Exception {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			List<User> list = new ArrayList<User>();
			 list=userService.getAll();
			out.print(new Gson().toJson(list));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping("/getAll")
	public String getAll(String name) {
		System.out.println("个人信息");
		List<User>list=userService.getAll();
		for(User u:list){
			System.out.println(u.getName()+"\t"+u.getAge());
		}		
		return "aa";
	}
	@RequestMapping("/save")
	public String saveUser(HttpServletRequest request) {
		System.out.println("保存信息");
		User u=new User();
		u.setId(1);
		u.setName("测试");
		u.setAge(23);
		userService.insertUser(u);
		return "aa";
	}
	public void printTOClient(HttpServletResponse response,String msg) {
		try {
			response.getOutputStream().println(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String codeType(String name) {
		String b = "";
		try {
			b = new String(name.getBytes("UTF-8"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
}

