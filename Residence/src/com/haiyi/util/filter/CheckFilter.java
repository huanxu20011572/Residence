/**    
* @Title: CheckFilter.java  
* @Package com.haiyi.util.filter  
* @Description: TODO(用一句话描述该文件做什么)  
* @author yanwenyan     
* @date 2015-11-16 上午11:54:13  
* @version V1.0    
*/ 
package com.haiyi.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

  
/**     
 * 版权所有：2015-yanwenyan 
 * 项目名称：Residence     
 *  
 * 类描述：  
 * 类名称：com.haiyi.util.filter.CheckFilter       
 * 创建人：yanwenyan  
 * 创建时间：2015-11-16 上午11:54:13     
 * 修改人：  
 * 修改时间：2015-11-16 上午11:54:13     
 * 修改备注：     
 * @version   V1.0      
 */

public class CheckFilter implements Filter {

	/** 
	 * @author yanwenyan 
	 * @see javax.servlet.Filter#destroy()  
	 */

	private FilterConfig config;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/** 
	 * @author yanwenyan 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)  
	 */

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep=(HttpServletResponse)response;
		Object uName=req.getSession().getAttribute("username");
		String path = req.getContextPath();
		if(uName==null||uName.toString().equals("")){
			String url=path+"/login1.jsp";
			//req.getRequestDispatcher(url).forward(req, rep);
			rep.sendRedirect(url);
			//chain.doFilter(request, response);
			return;
		}else{
			chain.doFilter(request, response);
		}
	}

	/** 
	 * @author yanwenyan 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)  
	 */

	@Override
	public void init(FilterConfig chain) throws ServletException {
		// TODO Auto-generated method stub
		this.config=chain;
	}

}
