package com.haiyi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * �ļ��ϴ�Servlet
 * 
 * @author Java
 * 
 */
public class ServletUploadFile extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	// �����ļ����ϴ���С 1G
	private int maxPostSize = 1 * 1024 * 1024 * 1024;

	public ServletUploadFile()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
      IOException
  {
    PrintWriter out = response.getWriter();
    String contextPath = request.getSession().getServletContext().getRealPath("/");
    String webDir = "uploadfile" + File.separator + "images" + File.separator;
    String systemPath = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ systemPath + "/";
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");

    try
    {
      DiskFileItemFactory factory = new DiskFileItemFactory();
      factory.setSizeThreshold(1024 * 4); // ����д���С
      ServletFileUpload upload = new ServletFileUpload(factory);
      upload.setSizeMax(maxPostSize); // �����ļ��ϴ�����С
      
      System.out.println(request.getContentType());
      //��ȡaction����ƴ�ӵĲ���(�磺http://www.baidu.com?q=android)
      System.out.println("========��ӡURL����ƴ�ӵĲ���========");
      Enumeration enumList = request.getParameterNames();
      while(enumList.hasMoreElements()){
        String key = (String)enumList.nextElement();
        String value = request.getParameter(key);
        System.out.println(key+"="+value);
      }
      
      System.out.println("========��ӡpost������========");
      //��ȡ�ύ����Ŀ
      List listItems = upload.parseRequest(request);
      Iterator iterator = listItems.iterator();
      while (iterator.hasNext())
      {
        FileItem item = (FileItem) iterator.next();
        //����ͨ����Ŀ
        if (!item.isFormField())
        {
         //��ȡ��չ��
          String ext = item.getName().substring(item.getName().lastIndexOf("."), item.getName().length());
          String fileName = System.currentTimeMillis() + ext;
          
          File dirFile = new File(contextPath + webDir + fileName);
          if (!dirFile.exists())
          {
            dirFile.getParentFile().mkdirs();
          }

          item.write(dirFile);
          System.out.println("fileName��" + item.getName() + "=====" + item.getFieldName() + " size�� "+ item.getSize());
          System.out.println("�ļ��ѱ��浽�� " + contextPath + webDir + fileName);
          //��Ӧ�ͻ�������
          out.print(basePath + webDir.replace("\\", "/") + fileName);
          out.flush();
        }else{
          //��ͨ����Ŀ
          System.out.println("����ͨ��Ŀ��"+item.getFieldName()+"=" + item.getString("UTF-8"));// ��ʾ�����ݡ�item.getString("UTF-8")���Ա�֤�������ݲ�����
        }
      }
    } catch (Exception e)
    {
      e.printStackTrace();
    } finally
    {
      out.close();
    }
  }
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//	{
//
//		PrintWriter out = response.getWriter();
//		String contextPath = request.getSession().getServletContext().getRealPath("/");
//		String webDir = "uploadfile" + File.separator + "images" + File.separator;
//		String systemPath = request.getContextPath();
//		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + systemPath + "/";
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=UTF-8");
//		
//		Map parms = request.getParameterMap();
//		System.out.println(parms.toString());
//		
//		try
//		{
//			DiskFileItemFactory factory = new DiskFileItemFactory();
//			factory.setSizeThreshold(1024 * 4); // ����д���С
//			ServletFileUpload upload = new ServletFileUpload(factory);
//			upload.setSizeMax(maxPostSize); // �����ļ��ϴ�����С
//			List listItems = upload.parseRequest(request);
//			Iterator iterator = listItems.iterator();
//
//			while (iterator.hasNext())
//			{
//				FileItem item = (FileItem) iterator.next();
//				if (!item.isFormField())
//				{
//					String ext = item.getName().substring(item.getName().lastIndexOf("."), item.getName().length());
//					String fileName = System.currentTimeMillis() + ext;
//					File dirFile = new File(contextPath + webDir + fileName);
//					
//					if (!dirFile.exists())
//					{
//						dirFile.getParentFile().mkdirs();
//					}
//					
//					item.write(dirFile);
//					System.out.println("fileName��" + item.getName() + "=====" + item.getFieldName() + " size�� " + item.getSize());
//					System.out.println("�ļ��ѱ��浽�� " + contextPath + webDir + fileName);
//					out.print(basePath + webDir.replace("\\", "/") + fileName);
//					out.flush();
//				}
//			}
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//		} finally
//		{
//			out.close();
//		}
//
//	}
	
//	private void postFile(){
//
//	   file=req.getParameter("file");
//	   if(file!=null){
//	    byte[] b= Base64Coder.decodeLines(file);
//	    String filepath=req.getSession().getServletContext().getRealPath("/files");
//	    File file=new File(filepath);
//	    if(!file.exists())
//	        file.mkdirs();
//	    FileOutputStream fos=new FileOutputStream(file.getPath()+"/person_head"+(int)(Math.random()*100)+".png");
//	    System.out.println(file.getPath());
//	    fos.write(b);
//	    fos.flush();
//	    fos.close();
//	   }
//	            
//	}

}
