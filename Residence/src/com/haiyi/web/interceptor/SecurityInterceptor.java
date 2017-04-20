/**    
* @Title: SecurityInterceptor.java  
* @Package com.haiyi.web.interceptor  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author yanwenyan     
* @date 2015-11-17 ����12:10:18  
* @version V1.0    
*/ 
package com.haiyi.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

  
/**     
 * ��Ȩ���У�2015-yanwenyan 
 * ��Ŀ���ƣ�Residence     
 *  
 * ��������  
 * �����ƣ�com.haiyi.web.interceptor.SecurityInterceptor       
 * �����ˣ�yanwenyan  
 * ����ʱ�䣺2015-11-17 ����12:10:18     
 * �޸��ˣ�  
 * �޸�ʱ�䣺2015-11-17 ����12:10:18     
 * �޸ı�ע��     
 * @version   V1.0      
 */

public class SecurityInterceptor implements HandlerInterceptor {  
	  
    private static final String LOGIN_URL = "/login.jsp";  
  
    @Override  
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {  
    	System.out.println("wenyanwe===========");
    	HttpSession session = req.getSession(true);  
        // ��session �����ȡ�û�������Ϣ  
        Object obj = session.getAttribute("username");  
        // �ж����û��ȡ���û���Ϣ������ת����½ҳ�棬��ʾ�û����е�½  
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