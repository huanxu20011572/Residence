package com.haiyi.residence.manageuser.action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.CreateImage;
import com.common.PageInfo;
import com.common.UUIDGenerator;
import com.google.gson.Gson;
import com.haiyi.residence.manageuser.service.ManageUserService;
import com.haiyi.residence.model.TBManageUser;


@Controller
@RequestMapping("manageUserController")
public class ManageUserController {
	
	@Resource(name="manageUserService")
	private ManageUserService manageUserService;

	@RequestMapping("/getImage")
	public void getImage(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		CreateImage image = new CreateImage(90,24);
		String randomCode = image.getRandomCode();
		request.getSession().setAttribute("randomCode", randomCode);
		response.setContentType("image/png");
		OutputStream out = response.getOutputStream();
		out.write(image.getRandomImageBytes());
		out.flush();
//		out.close();
	}
	/*20151031
	 * 
	 * */
	@RequestMapping("/loginSys")
	public void loginSys(HttpServletResponse rep,HttpServletRequest req){
		String uName=req.getParameter("username")==null?"":req.getParameter("username");
		String password=req.getParameter("pass")==null?"":req.getParameter("pass");
		//String checkCode=req.getParameter("code")==null?"":req.getParameter("code");
		//String randomCode = (String)req.getSession().getAttribute("randomCode");		
		int flag = 0;
		PrintWriter out = null;
		TBManageUser tb = new TBManageUser();
		tb.setuName(uName);
		tb.setPassword(password);
		try {			
//			if (checkCode==null || checkCode=="" || (!randomCode.equalsIgnoreCase(checkCode))) {
//				flag = 1;//验证码错误
//				req.getSession().setAttribute("username","");
//			}else{				
				TBManageUser m = this.manageUserService.getManageUserByName(uName);			
				if (m == null) {
					flag = 2;//用户名不存在
					req.getSession().setAttribute("username","");
				}else{				
					TBManageUser mm = this.manageUserService.getManageUserByLogin(tb);			
					if (mm != null) {
						flag = 4;
						req.getSession().setAttribute("username",uName);
//						req.getRequestDispatcher("/jSP/home.jsp").forward(req, rep);				
					}else{
						flag = 3;//密码错误
						req.getSession().setAttribute("username","");
					}
				}
			//}
			//rep.setContentType("application/json;charset=UTF-8");
			out = rep.getWriter();
			out.print(flag);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (out != null) {
//				out.close();
			}
		}	
	}
	//注册
	@RequestMapping("/userRegistation")
	public void updataResidentPopulation(HttpServletResponse rep,HttpServletRequest req
			) throws Exception {
		String password = req.getParameter("password1") == null ? ""
				: req.getParameter("password1");			
		String uName = req.getParameter("uName") == null ? ""
				: req.getParameter("uName");
		String certificateType = req.getParameter("certificateType") == null ? ""
				: req.getParameter("certificateType");
		String certificateNum = req.getParameter("certificateNum") == null ? "" : req
				.getParameter("certificateNum");
		String telephone = req.getParameter("telephone") == null ? ""
				: req.getParameter("telephone");
		String email = req.getParameter("email") == null ? ""
				: req.getParameter("email");
		String qqNum = req.getParameter("qqNum") == null ? ""
				: req.getParameter("qqNum");
		TBManageUser tb = new TBManageUser();
		String id="";
		id = UUIDGenerator.getUUID32();
		tb.setId(id);
		tb.setuName(uName);
		tb.setPassword(password);
		tb.setCertificateType(certificateType);
		tb.setCertificateNum(certificateNum);
		tb.setTelephone(telephone);
		tb.setQqNum(qqNum);
		tb.setEmail(email);
		int flag = 0;
		PrintWriter out = null;
		rep.setContentType("application/json;charset=UTF-8");
		try {
			this.manageUserService.insertManageUser(tb);			
			flag = 1;		
//			req.getRequestDispatcher("/login.jsp").forward(req, rep);
			out = rep.getWriter();
			out.print(flag);
		} catch (Exception e) {
			e.printStackTrace();
//			if (out != null) {
//				out.close();
//			}
		}
	}
	
	@RequestMapping("/checkNumber")
	public void checkNumber(HttpServletResponse rep,HttpServletRequest req) throws Exception {
		String certificateNum = req.getParameter("certificateNum") == null ? "" : req
				.getParameter("certificateNum");
		int flag = 0;
		PrintWriter out = null;
		TBManageUser tb = new TBManageUser();
		tb.setCertificateNum(certificateNum);
		try {
			TBManageUser mm = this.manageUserService.checkNumber(tb);
			if (mm != null) {
				flag = 1;
			}
			out = rep.getWriter();
			out.print(flag);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
			if (out != null) {
				out.close();
			}
		}
	}
	@RequestMapping("/checkUserName")
	public void checkUserName(HttpServletResponse rep,HttpServletRequest req) throws Exception {
		String uName = req.getParameter("uName") == null ? "" : req
				.getParameter("uName");
		int flag = 0;
		PrintWriter out = null;
		TBManageUser tb = new TBManageUser();
		tb.setuName(uName);
		try {
			TBManageUser mm = this.manageUserService.checkUserName(tb);
			if (mm != null) {
				flag = 1;
			}
			out = rep.getWriter();
			out.print(flag);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
			if (out != null) {
				out.close();
			}
		}
	}
	@RequestMapping("/calcelUser")
	public String calcelUser(HttpServletResponse rep,HttpServletRequest req) throws Exception {
		req.getSession().setAttribute("username","");
		return "/login.jsp";
	}
	@RequestMapping("/updatepass")	
	public void updatepass(HttpServletResponse rep,HttpServletRequest req){
		String oldpassword=req.getParameter("oldpassword")==null?"":req.getParameter("oldpassword");
		String newpassword1=req.getParameter("newpassword1")==null?"":req.getParameter("newpassword1");
		String uName=String.valueOf(req.getSession().getAttribute("username"));
		TBManageUser tb = new TBManageUser();
		tb.setuName(uName);
		tb.setPassword(oldpassword);
		int flag = 0;
		PrintWriter out = null;
		try {
			TBManageUser mm = this.manageUserService.checkUser(tb);
			if (mm != null) {
				this.manageUserService.updatePass(newpassword1, oldpassword, uName);
				flag = 1;
			}else{
				flag = 2;
			}
			rep.setContentType("application/json;charset=UTF-8");
			out = rep.getWriter();
			out.print(flag);
			out.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	@RequestMapping("/getListPage")
	public void getListPage(HttpServletResponse rep,HttpServletRequest req) throws Exception {
		Integer page = Integer.valueOf((String) ((req.getParameter("page")) == null ? "1": req.getParameter("page")));
		// jsp返回每页行数
		Integer rows = Integer.valueOf((String) ((req.getParameter("rows")) == null ? PageInfo.DEFAULT_ROWS.toString(): req.getParameter("rows")));	
		int start = (page-1)*rows;
		int end = page*rows;
		int count = 0;
		PrintWriter out = null;
		try {
			rep.setContentType("application/json;charset=UTF-8");
			out = rep.getWriter();
			List<TBManageUser> list = new ArrayList<TBManageUser>();
			list=manageUserService.getAll(start,end);
			count = manageUserService.getCount();
			String json = new Gson().toJson(list);
			out.print("{\"total\":"+count+",\"rows\":"+json+"}");
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
