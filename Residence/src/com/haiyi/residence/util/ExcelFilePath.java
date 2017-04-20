package com.haiyi.residence.util;

import javax.servlet.http.HttpServletRequest;

public class ExcelFilePath {

	private static String fileP="";
	public String getFilePath(HttpServletRequest request){
		String url=request.getRealPath("/");
		String[] urls=url.split(":");
		String disk=urls[0];
		String fileurl=disk+":\\excelFile\\";
		return fileurl;
	}
}
