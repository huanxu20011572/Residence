package com.haiyi.residence.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.stream.FileImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.haiyi.residence.mediafile.service.MediaFileService;
import com.haiyi.residence.model.MediaFile;
import com.haiyi.residence.model.bo.HouseBO;
import com.haiyi.residence.model.bo.HousePopulationBO;
import com.haiyi.residence.model.bo.UnitBO;
import com.haiyi.residence.model.bo.UnitPopulationBO;
import com.haiyi.residence.model.bo.UserBO;
import com.haiyi.residence.unit.service.UnitService;
import com.haiyi.residence.user.service.UserService;


@Controller
@RequestMapping("/excel")
public class ExcelController {
//	@Resource(name="manageUserService")
//	private ManageUserService manageUserService;
//	@Resource(name="houseService")
//	private HouseService houseService;
//	@Resource(name="residentPopulationService")
//	private ResidentPopulationService residentPopulationService;
//	@Resource(name="unitService")
//	private UnitService unitService;
//	@Resource(name="unitPopulationService")
//	private UnitPopulationService unitPopulationService;
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="unitService")
	private UnitService unitService;
	@Resource(name="mediaFileService")
	private MediaFileService mediaFileService;
	@RequestMapping("/exportExcel")
	public void saveUser(HttpServletRequest request, HttpServletResponse response) {
		//���嵼�������б�
		List<HouseBO> houseBoList = new ArrayList<HouseBO>();
		List<HousePopulationBO> housePBoList = new ArrayList<HousePopulationBO>();
		List<UnitBO> unitBoList = new ArrayList<UnitBO>();
		List<UnitPopulationBO> unitPBoList = new ArrayList<UnitPopulationBO>();
		List<UserBO> userBoList = new ArrayList<UserBO>();
		boolean result = false;
		//��ȡ����
//		String[] imageIds=imagesIds.split(";");
//		List<MediaFile> list=new ArrayList();
//		for(String id:imageIds){
//			MediaFile m=unitService.findImages(id);
//			list.add(m);
//		}
		String fileName = request.getParameter("fileName") == null ? "" : request.getParameter("fileName");
		String type = request.getParameter("type") == null ? "" : request.getParameter("type");
		String rowsJsonStr = request.getParameter("rowsJsonStr") == null ? "" : request.getParameter("rowsJsonStr");
		try {
			//�õ�Ҫ�������ݵ�json����
			//rowsJsonStr = setEncode(rowsJsonStr, "GBK", "UTF-8");
			JSONArray rows = new JSONArray(rowsJsonStr);
			//��õ����Ķ����б�������
			String fileN=fileName;
			//fileName=setEncode(fileName,"GBK","ISO-8859-1");
			response.setHeader("content-disposition", "attachment;filename=" + fileName + ".xls");
			OutputStream ops = response.getOutputStream();
			String url=request.getRealPath("/");
			String[] urls=url.split(":");
			String disk=urls[0];
			String fileurl=disk+":\\excelFile\\"+fileN+".xls";
			File filed=new File(fileurl);
			File parent = filed.getParentFile(); 
			if(parent!=null&&!parent.exists()){ 
				parent.mkdirs(); 
			} 
			String dateFormat = "yyyy-MM-dd HH:mm:ss";
			if ("house".equals(type)) {	
				for (int i = 0; i < rows.length(); i++) {
					JSONObject row = rows.getJSONObject(i);
					 String layoutDiagramUrl=row.getString("layoutDiagramUrl");
					 String[] imageIds=layoutDiagramUrl.split(";");
					StringBuilder layOutUrls=new StringBuilder("");
					StringBuilder imageUrls=new StringBuilder("");
					for(String id:imageIds){
						MediaFile m=unitService.findImages(id);
						layOutUrls.append(m.getPhysicalName()+";");
					}
					String dimageUrls=row.getString("imageUrls");
					String[] dimageIds=dimageUrls.split(";");
					for(String id:dimageIds){
						MediaFile m=unitService.findImages(id);
						if(m==null){
							continue;
						}
						imageUrls.append(m.getPhysicalName()+";");
					}
					String layOutUrlsStr="";
					if(layOutUrls.toString().equals("")==false){
						layOutUrlsStr=layOutUrls.substring(0,layOutUrls.length()-1);
					}
					String imageUrlsStr="";
					if(imageUrls.toString().equals("")==false){
						imageUrlsStr=imageUrls.substring(0,imageUrls.length()-1);
					}
					byte[] imageByte = getImageByteArray(request, layOutUrlsStr);
					List<byte[]> list = getImageByteList(request, imageUrlsStr);
					HouseBO hbo = new HouseBO(row, imageByte, list);
					houseBoList.add(hbo);
				}
				//�����ļ�
				String title = "ס����Ϣ";
				String[] headers = {"���ӵ�ַ��Ϣ", "��������", "������", "��Ԫ��", "¥��", 
						"�����", "���ݽṹ", "��Ȩ����", "��ȫ״��", "����ʱ��", "�������", 
						"�������", "��������", "��������", "ί��", "�������񾯱��", 
						"����ID��", "�汾��", "���ݻ��ͻ�ͼ", "���ݻ���ͼƬ"};
				Excel<HouseBO> excel = new Excel<HouseBO>();
				String fileUrl=fileurl;
				OutputStream os=new FileOutputStream(fileUrl);
				result = excel.exportExcel(os, title, headers, houseBoList, dateFormat,fileurl);
				PrintWriter pw=new PrintWriter(ops);
				pw.print("success");
				pw.flush();
				pw.close();
			} else if ("house_p".equals(type)) {
				for (int i = 0; i < rows.length(); i++) {
					JSONObject row = rows.getJSONObject(i);
					StringBuilder imageUrls=new StringBuilder("");
					
					String dimageUrls=row.getString("imgPersonUrl");
					String[] dimageIds=dimageUrls.split(";");
					for(String id:dimageIds){
						MediaFile m=unitService.findImages(id);
						imageUrls.append(m.getPhysicalName()+";");
					}
					String imageUrlsStr="";
					if(imageUrls.toString().equals("")==false){
						imageUrlsStr=imageUrls.substring(0,imageUrls.length()-1);
					}
					byte[] imageByte = getImageByteArray(request,imageUrlsStr);
					HousePopulationBO hpbo = new HousePopulationBO(row, imageByte);
					housePBoList.add(hpbo);
				}
				//�����ļ�
				String title = "ס����Ա��Ϣ";
				String[] headers = {"��Ա���", "����", "������", "�Ա�", "����", "���֤��", "��������", 
						"�Ļ��̶�", "����״��", "����״��", "��ס����", "��Ա��ϵ", "��ס����", "Ѫ��", 
						"���", "ְҵ", "ְ��", "����", "������", "�̶��绰", "�ֻ�����", "�־�ס��ַ", 
						"QQ", "΢�ź�", "��סʱ��", "��ס����", "��סʱ��", "�汾��", "������Ƭ"};
				Excel<HousePopulationBO> excel = new Excel<HousePopulationBO>();
				String fileUrl=fileurl;
				OutputStream os=new FileOutputStream(fileUrl);
				result = excel.exportExcel(os, title, headers, housePBoList, dateFormat,fileurl);
				PrintWriter pw=new PrintWriter(ops);
				pw.print("success");
				pw.flush();
				pw.close();
			} else if ("unit".equals(type)) {
				for (int i = 0; i < rows.length(); i++) {
					JSONObject row = rows.getJSONObject(i);
					 String layoutDiagramUrl=row.getString("layoutDiagramUrl");
					 String[] imageIds=layoutDiagramUrl.split(";");
					StringBuilder layOutUrls=new StringBuilder("");
					StringBuilder imageUrls=new StringBuilder("");
					for(String id:imageIds){
						MediaFile m=unitService.findImages(id);
						layOutUrls.append(m.getPhysicalName()+";");
					}
					String dimageUrls=row.getString("imageUrls");
					String[] dimageIds=dimageUrls.split(";");
					for(String id:dimageIds){
						MediaFile m=unitService.findImages(id);
						if(m==null||m.getFileName().equals("null")||m.getFileName().equals("")){
							imageUrls.append("");
						}else{
							imageUrls.append(m.getPhysicalName()+";");
						}
					}
					String layOutUrlsStr="";
					if(layOutUrls.toString().equals("")==false){
						layOutUrlsStr=layOutUrls.substring(0,layOutUrls.length()-1);
					}
					String imageUrlsStr="";
					if(imageUrls.toString().equals("")==false){
						imageUrlsStr=imageUrls.substring(0,imageUrls.length()-1);
					}
					byte[] imageByte = getImageByteArray(request, layOutUrlsStr);
					List<byte[]> list = getImageByteList(request, imageUrlsStr);
					UnitBO ubo = new UnitBO(row, imageByte, list);
					unitBoList.add(ubo);
				}
				//�����ļ�
				String title = "��λ��Ϣ";
				String[] headers = {"��λ����", "��λ��ַ", "��Ӫ����", "��Ӫ��Χ", "��Ӫ���", 
						"���", "��ϵ�绰", "��λ���", "�ΰ�������ID", "��ҵ����", "��λ��ϵ�绰", 
						"����ִ�պ�", "ע���ʽ�", "ע������", "��ҵʱ��", "��Ч������", "��֯�ṹ����", 
						"���˴���ID��", "����ID��", "�汾��", "��λ���ͻ�ͼ", "��λ����ͼƬ"};
				Excel<UnitBO> excel = new Excel<UnitBO>();
				String fileUrl=fileurl;
				OutputStream os=new FileOutputStream(fileUrl);
				result = excel.exportExcel(os, title, headers, unitBoList, dateFormat,fileurl);
				PrintWriter pw=new PrintWriter(ops);
				pw.print("success");
				pw.flush();
				pw.close();
			} else if ("unit_p".equals(type)) {
				for (int i = 0; i < rows.length(); i++) {
					JSONObject row = rows.getJSONObject(i);
					StringBuilder imageUrls=new StringBuilder("");
					
					String dimageUrls=row.getString("imgPersonUrl");
					String[] dimageIds=dimageUrls.split(";");
					for(String id:dimageIds){
						MediaFile m=unitService.findImages(id);
						if(m==null||m.getFileName().equals("null")||m.getFileName().equals("")){
							imageUrls.append("");
						}else{
							imageUrls.append(m.getPhysicalName()+";");
						}
					}
					String ddimageUrls="";
					if(imageUrls.toString().equals("")==false){
						ddimageUrls=imageUrls.substring(0,imageUrls.length()-1);
					}

					byte[] imageByte = getImageByteArray(request, ddimageUrls);
					UnitPopulationBO upbo = new UnitPopulationBO(row, imageByte);
					unitPBoList.add(upbo);
				}
				//�����ļ�
				String title = "ס����Ա��Ϣ";
				String[] headers = {"������", "��Ԫ��", "¥��", "�����", "����", "������", 
						"��������", "�Ա�", "����", "���֤��", "�Ļ��̶�", "����״��", "����״��", 
						"Ѫ��", "���", "��������", "��ҵ����", "�������", "��ס֤��", 
						"ְҵ", "ְ��", "����", "������", "�̶��绰", "�־�ס��ַ", 
						"�ֻ�����", "QQ", "΢�ź�", "��Ա���", "�汾��", "������Ƭ"};
				Excel<UnitPopulationBO> excel = new Excel<UnitPopulationBO>();
				String fileUrl=fileurl;
				OutputStream os=new FileOutputStream(fileUrl);
				result = excel.exportExcel(os, title, headers, unitPBoList, dateFormat,fileurl);
				PrintWriter pw=new PrintWriter(ops);
				pw.print("success");
				pw.flush();
				pw.close();
			}
//			else {
//				List<User> userList = this.userService.getAll();
//				for (User user : userList) {
//					byte[] imageByte = getImageByteArray(request, user.getImageUrl());
//					UserBO userbo = new UserBO(user, imageByte);
//					userBoList.add(userbo);
//				}
//				//�����ļ�
//				String title = "�û���Ϣ";
//				String[] headers = {"ID", "����", "����", "��Ƭ"};
//				Excel<UserBO> excel = new Excel<UserBO>();
//				result = excel.exportExcel(ops, title, headers, userBoList, dateFormat);
//			}
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//return "";
	}
	
	/**
	 * ����ͼƬurlת��Ϊ�ֽ������б�
	 * @param request
	 * @param url
	 * @return
	 */
	private List<byte[]> getImageByteList(HttpServletRequest request, String url){
		List<byte[]> list = new ArrayList<byte[]>();
		if (url != null && !"".equals(url)) {
			String[] urls = url.split(";");
			if (urls != null) {
				for (int i = 0; i < urls.length; i++) {
					byte[] imageByte = getImageByteArray(request, urls[i]);
					list.add(imageByte);
				}
			}
		}
		return list;
	}
	
	/**
	 * ����ͼƬurlת��Ϊ�ֽ�����
	 * @param request
	 * @param url
	 * @return
	 */
	private byte[] getImageByteArray(HttpServletRequest request, String url){
		byte[] imageByte = null;
		if (url != null && !"".equals(url)){
			try {
				// ��ȡ��ǰweb����������ļ��ĵط�
				String webPath = request.getSession().getServletContext().getRealPath("\\")+ "image\\";
//				String imageName = "lufei.jpg";
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
		}
	    return imageByte;
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
			b = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
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
	@RequestMapping("/downFile")
	public void downFile(HttpServletRequest req, HttpServletResponse rep,String fileName) {
		String type = req.getParameter("type") == null ? "" : req.getParameter("type");
		try {
			File file = null;
			String path = (String) req.getSession().getAttribute("filepath");
			//fileName=setEncode(fileName,"ISO-8859-1","UTF-8");
			String url=req.getRealPath("/");
			String[] urls=url.split(":");
			String disk=urls[0];
			String fileurl=disk+":\\excelFile\\"+fileName+".xls";
			file = new File(fileurl);
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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

