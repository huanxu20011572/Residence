/**    
* @Title: SecurityInterceptor.java  
* @Package com.haiyi.web.interceptor  
* @Description: TODO(用一句话描述该文件做什么)  
* @author yanwenyan     
* @date 2015-11-17 上午12:10:18  
* @version V1.0    
*/ 
package com.haiyi.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

  
/**     
 * 版权所有：2015-yanwenyan 
 * 项目名称：Residence     
 *  
 * 类描述：  
 * 类名称：com.haiyi.web.interceptor.SecurityInterceptor       
 * 创建人：yanwenyan  
 * 创建时间：2015-11-17 上午12:10:18     
 * 修改人：  
 * 修改时间：2015-11-17 上午12:10:18     
 * 修改备注：     
 * @version   V1.0      
 */

public class SecurityInterceptor implements HandlerInterceptor {  
	  
    private static final String LOGIN_URL = "/login.jsp";  
  
    @Override  
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {  
    	System.out.println("wenyanwe===========");
    	HttpSession session = req.getSession(true);  
        // 从session 里面获取用户名的信息  
        Object obj = session.getAttribute("username");  
        // 判断如果没有取到用户信息，就跳转到登陆页面，提示用户进行登陆  
        if (obj == null || "".equals(obj.toString())) {  
            res.sendRedirect("/login.jsp");  
        }  
        return true;  
    }

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("wenyanwe===========");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("wenyanwe===========");
		
	}  
  
}  