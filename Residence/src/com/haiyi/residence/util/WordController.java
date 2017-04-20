package com.haiyi.residence.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.DocumentHandler;
import com.haiyi.residence.model.bo.HousePopulationBO;
import com.haiyi.residence.model.bo.UnitPopulationBO;

@Controller
@RequestMapping("/word")
public class WordController {
	@RequestMapping("/exportWord")
	public void exportWord(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, JSONException {
		//获取参数
		String fileName = request.getParameter("fileName") == null ? "" : request.getParameter("fileName");
		String type = request.getParameter("type") == null ? "" : request.getParameter("type");
		String rowsJsonStr = request.getParameter("rowsJsonStr") == null ? "" : request.getParameter("rowsJsonStr");
		//得到要导出数据的json数组
		//rowsJsonStr = setEncode(rowsJsonStr, "ISO-8859-1", "UTF-8");
		JSONArray rows = new JSONArray(rowsJsonStr);
		boolean result = true;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<UnitPopulationBO> unitPBoList = new ArrayList<UnitPopulationBO>();
		if("1".equals(type)){
			Map<String, Object> map = new HashMap<String, Object>();
			List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
			JSONObject row = rows.getJSONObject(0);
			byte[] imageByte = getImageByteArray(request, row.getString("imgPersonUrl"));
			UnitPopulationBO upbo = new UnitPopulationBO(row, imageByte);
			unitPBoList.add(upbo);
			map.put("username", row.getString("name"));
			map.put("sex","1".equals(row.getString("sex")) ? "男" :"女");
			map.put("age", row.getString("birthday"));
			map.put("zhengzhi", "");
			map.put("degreeEducation", row.getString("degreeEducation"));
			map.put("post", row.getString("post"));
			map.put("telephone", row.getString("telephone"));
			map.put("certificateNum", row.getString("certificateNum"));
			map.put("actualLiveAddr", row.getString("actualLiveAddr"));
			map.put("jianli", "");
			map.put("imgPersonUrl", "");
			list1.add(map);
			dataMap.put("table1", list1);
			DocumentHandler mdoc = new DocumentHandler();
			//生成doc文件
			String url=request.getRealPath("/");
			String[] urls=url.split(":");
			String disk=urls[0];
			String fileurl=disk+":\\wordFile\\法人.doc";
			result = mdoc.createDoc(dataMap, fileurl,1);
		}else if("2".equals(type)){
			List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
			StringBuffer str = new StringBuffer();
			int index = 0;
			for(int i = 0; i < rows.length(); i++){
				JSONObject row = rows.getJSONObject(i);
				//if("2".equals(row.getString("uid"))){
					Map<String, Object> map = new HashMap<String, Object>();
					byte[] imageByte = getImageByteArray(request, row.getString("imgPersonUrl"));
					UnitPopulationBO upbo = new UnitPopulationBO(row, imageByte);
					unitPBoList.add(upbo);
					map.put("name",row.getString("name"));
					map.put("post",row.getString("post"));
					map.put("telephone",row.getString("telephone"));
					map.put("actualLiveAddr",row.getString("actualLiveAddr"));
					list1.add(map);  
				//}
			}
			dataMap.put("table1", list1);
			DocumentHandler mdoc = new DocumentHandler();
			//生成doc文件
			String url=request.getRealPath("/");
			String[] urls=url.split(":");
			String disk=urls[0];
			String fileurl=disk+":\\wordFile\\员工.doc";
			result = mdoc.createDoc(dataMap, fileurl,2);
		}else if("3".equals(type)){
			Map<String, Object> map = new HashMap<String, Object>();
			List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
			JSONObject row = rows.getJSONObject(0);
			byte[] imageByte = getImageByteArray(request, row.getString("imgPersonUrl"));
			UnitPopulationBO upbo = new UnitPopulationBO(row, imageByte);
			unitPBoList.add(upbo);
			map.put("xingming", row.getString("name"));
			map.put("xingbie","1".equals(row.getString("sex")) ? "男" :"女");
			map.put("nianling", row.getString("birthday"));
			map.put("zhengzhi", "");
			map.put("wenhua", row.getString("degreeEducation"));
			map.put("zhiwu", row.getString("post"));
			map.put("dianhua", row.getString("telephone"));
			map.put("shenfenzheng", row.getString("certificateNum"));
			map.put("zhuzhi", row.getString("actualLiveAddr"));
			map.put("jianli", "");
			map.put("img", "");
			list1.add(map);
			dataMap.put("table1", list1);
			DocumentHandler mdoc = new DocumentHandler();
			//生成doc文件
			String url=request.getRealPath("/");
			String[] urls=url.split(":");
			String disk=urls[0];
			String fileurl=disk+":\\wordFile\\baoan.doc";
			result = mdoc.createDoc(dataMap, fileurl,3);
		}
		
		String message = "0";
		if (result) {
			message = "1";
		}
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(message);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (out != null) {
				out.close();
			}
		}
	}
	public String setEncode(String string, String code1, String code2){
		String newString = null;
		try {
			newString = new String(string.getBytes(code1), code2);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return newString;
	}
	/**
	 * 将单图片url转换为字节数组
	 * @param request
	 * @param url
	 * @return
	 */
	private byte[] getImageByteArray(HttpServletRequest request, String url){
		byte[] imageByte = null;
		try {
			// 获取当前web服务器存放文件的地方
			String webPath = request.getSession().getServletContext().getRealPath("\\")+ "image\\";
//			String imageName = "lufei.jpg";
			String imageName = url;
			String filePath = webPath + imageName;
			File file = new File(filePath);
			if (!file.exists()) {
				return imageByte;
			}
			FileImageInputStream input = new FileImageInputStream(file);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int numBytesRead = 0;
			while ((numBytesRead = input.read(buf)) != -1) {
				output.write(buf, 0, numBytesRead);
			}
			imageByte = output.toByteArray();
			output.close();
		    input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return imageByte;
	}
	/** 
	* @Title: downFile 
	* @Description: TODO(下载文件方法) 
	* @param @param req
	* @param @param rep    设定文件 
	* @return void    返回类型 
	* @throws 
	*/ 
	@RequestMapping("/downFile")
	public void downFile(HttpServletRequest req, HttpServletResponse rep) {
		String type = req.getParameter("type") == null ? "" : req.getParameter("type");
		String url=req.getRealPath("/");
		String[] urls=url.split(":");
		String disk=urls[0];
		try {
			File file = null;
			String path = (String) req.getSession().getAttribute("filepath");
			if("1".equals(type)){
				String fileurl=disk+":\\wordFile\\法人.doc";
				file = new File(fileurl);
			}else if("2".equals(type)){
				String fileurl=disk+":\\wordFile\\员工.doc";
				file = new File(fileurl);
			}
			String filename = file.getName();
			rep.setContentType("application/x-download; charset=utf-8");
			rep.setHeader("Content-Disposition", "attachment; filename=\""
					+ new String(filename.getBytes("gbk"), "ISO-8859-1") + "\"");
			OutputStream out = rep.getOutputStream();
			FileInputStream in = null;
			if (file.exists()) {
				in = new FileInputStream(file);
				byte[] buffer = new byte[4096];
				int read;
				while ((read = in.read(buffer)) != -1) {
					out.write(buffer, 0, read);
				}
				in.close();
				out.flush();
				out.close();
			}
//			com.common.downFile.deletefile(file.getParent());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
