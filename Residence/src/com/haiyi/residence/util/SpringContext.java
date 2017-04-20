package com.haiyi.residence.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringContext implements ServletContextListener {

	private static WebApplicationContext springContext;
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		//this.contextDestroyed(event);
	}
	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		springContext=WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
	}
	public static WebApplicationContext getApplicationContext(){
		return springContext;
	}

}
