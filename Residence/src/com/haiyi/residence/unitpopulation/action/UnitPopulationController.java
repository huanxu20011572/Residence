package com.haiyi.residence.unitpopulation.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.PageInfo;
import com.google.gson.Gson;
import com.haiyi.residence.mediafile.service.MediaFileService;
import com.haiyi.residence.model.MediaFile;
import com.haiyi.residence.model.TBHouse;
import com.haiyi.residence.model.TBUnitPopulation;
import com.haiyi.residence.unit.service.UnitService;
import com.haiyi.residence.unitpopulation.service.UnitPopulationService;

@Controller
@RequestMapping("/unitPopulationController")
public class UnitPopulationController {
	@Resource(name = "unitPopulationService")
	private UnitPopulationService  unitPopulationService;
	@Resource(name = "unitService")
	private UnitService unitService ;
	@Resource(name="mediaFileService")
	private MediaFileService mediaFileService;
	//查询所有
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
			List<TBUnitPopulation> list = new ArrayList<TBUnitPopulation>();
			 list=unitPopulationService.getAll(start,end);
			 count = unitPopulationService.getCount();
			 String json = new Gson().toJson(list);
			 out.print("{\"total\":"+count+",\"rows\":"+json+"}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//删除
	@RequestMapping("/unitPopulationDel")
	public void unitPopulationDel(HttpServletResponse rep,String id) {
		int flag = 0;
		PrintWriter out = null;
		try {
			// 判断是否多选
			if (id.indexOf(",") > 0) {
				String[] str = id.split(",");
				for (int i = 0; i < str.length; i++) {
					this.unitPopulationService.deleteUnitPopulation(str[i]);
				}
			}
			flag = 1;				
			out = rep.getWriter();
			out.print(flag);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (out != null) {
				out.close();
			}
		}
	}
	
	//条件查询
	@RequestMapping("/getUnitPopulationQuery")
	public void getUnitPopulationQuery(HttpServletResponse rep,HttpServletRequest req
			)throws Exception{	
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("sname") == null ? ""
				: req.getParameter("sname");
		name=new String(name.getBytes("iso-8859-1"),"UTF-8");
		String certificateNum = req.getParameter("scertificateNum") == null ? ""
				: req.getParameter("scertificateNum");	
		certificateNum=new String(certificateNum.getBytes("iso-8859-1"),"UTF-8");

		String uName = req.getParameter("suName") == null ? ""
				: req.getParameter("suName");	
		uName=new String(uName.getBytes("iso-8859-1"),"UTF-8");

		String telephone = req.getParameter("stelephone") == null ? ""
				: req.getParameter("stelephone");
		telephone=new String(telephone.getBytes("iso-8859-1"),"UTF-8");

		String id ="";
		id = unitService.getUnitIdByUname(uName);
		PrintWriter out = null;
		List<TBUnitPopulation> list = new ArrayList<TBUnitPopulation>();
		rep.setContentType("application/json;charset=UTF-8");
		TBUnitPopulation tb = new TBUnitPopulation();		
		try {
			tb.setName(name);
			tb.setCertificateNum(certificateNum);
			tb.setUid(id);
			tb.setTelephone(telephone);
			list = this.unitPopulationService.getUnitPopulationQuery(tb);
			out = rep.getWriter();
			out.print(new Gson().toJson(list));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	//查询法人 或者  房主  
	@RequestMapping("/getLegalOrLandlordInfo")
	public void getLegalOrLandlordInfo(HttpServletResponse rep,String id)throws Exception{	
		id=new String(id.getBytes("iso-8859-1"),"UTF-8");
		PrintWriter out = null;
		rep.setContentType("application/json;charset=UTF-8");
		TBUnitPopulation tb = new TBUnitPopulation();		
		try {
			tb = this.unitPopulationService.getLLUPInfo(id);
			out = rep.getWriter();
			out.print(new Gson().toJson(tb));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	//查询员工同事信息
	@RequestMapping("/getunitColleagueInfo")
	public void getunitColleagueInfo(HttpServletResponse rep,String id,String uId)throws Exception{	
		id=new String(id.getBytes("iso-8859-1"),"UTF-8");
		uId=new String(uId.getBytes("iso-8859-1"),"UTF-8");

		PrintWriter out = null;
		rep.setContentType("application/json;charset=UTF-8");
		List<TBUnitPopulation> list = new ArrayList<TBUnitPopulation>();
		try {
			list = this.unitPopulationService.getunitColleagueInfo(uId, id);
			out = rep.getWriter();
			out.print(new Gson().toJson(list));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
	//修改
	@RequestMapping("/updataUnitPopulation")
	public void updataUnitPopulation(HttpServletResponse rep,HttpServletRequest req
//			,String name,String oldName,
//			String sex,String nation,String idNumber,String degreeEducation,String maritalSta, 
//			String militarySta,String bloodType,String height,String occupation,String post,
//			String houseRegist,String serviceAddr,String pType,String landLine,String actualLiveAddr,
//			String telephone,String qqNum,String weChatNum,String imgPersonUrl
			) throws Exception {
		
		String id = req.getParameter("id") == null ? ""
				: req.getParameter("id");		
		
//		String uId = req.getParameter("uId") == null ? ""
//				: req.getParameter("uId");	
		
		String pType = req.getParameter("pType") == null ? "" : req
				.getParameter("pType");
		String hBuildingNum = req.getParameter("hBuildingNum") == null ? "" : req
				.getParameter("hBuildingNum");
		String hUnitNum = req.getParameter("hUnitNum") == null ? "" : req
				.getParameter("hUnitNum");		
		String hFloorNum = req.getParameter("hFloorNum") == null ? "" : req
						.getParameter("hFloorNum");
		String roomNumber = req.getParameter("roomNumber") == null ? "" : req
				.getParameter("roomNumber");						
		
		String name = req.getParameter("name") == null ? ""
				: req.getParameter("name");
		String oldName = req.getParameter("oldName") == null ? "" : req
				.getParameter("oldName");
		String birthday = req.getParameter("birthday") == null ? "" : req
				.getParameter("birthday");		
		String sex = req.getParameter("sex") == null ? ""
				: req.getParameter("sex");
		String nation = req.getParameter("nation") == null ? "" : req
				.getParameter("nation");
		String certificateNum = req.getParameter("certificateNum") == null ? ""
				: req.getParameter("certificateNum");
		
		
		String degreeEducation = req.getParameter("degreeEducation") == null ? ""
				: req.getParameter("degreeEducation");
		String maritalSta = req.getParameter("maritalSta") == null ? ""
				: req.getParameter("maritalSta");
		String militarySta = req.getParameter("militarySta") == null ? "" : req
				.getParameter("militarySta");
		
		String bloodType = req.getParameter("bloodType") == null ? "" : req
				.getParameter("bloodType");
		
		String height = req.getParameter("height") == null ? "" : req
				.getParameter("height");
		
		String rentDate = req.getParameter("rentDate") == null ? "" : req
				.getParameter("rentDate");
		String workDate = req.getParameter("workDate") == null ? "" : req
				.getParameter("workDate");
		String IdType = req.getParameter("IdType") == null ? "" : req
				.getParameter("height");
		String residenceId = req.getParameter("residenceId") == null ? "" : req
				.getParameter("residenceId");
		String occupation = req.getParameter("occupation") == null ? ""
				: req.getParameter("occupation");
		
		String post = req.getParameter("post") == null ? ""
				: req.getParameter("post");
		
		String houseRegist = req.getParameter("houseRegist") == null ? "" : req
				.getParameter("houseRegist");
		
		String serviceAddr = req.getParameter("serviceAddr") == null ? "" : req
				.getParameter("serviceAddr");		
				
		String landLine = req.getParameter("landLine") == null ? ""
				: req.getParameter("landLine");
		
		String actualLiveAddr = req.getParameter("actualLiveAddr") == null ? ""
				: req.getParameter("actualLiveAddr");
		String personType = req.getParameter("personType") == null ? ""
				: req.getParameter("personType");
		String telephone = req.getParameter("telephone") == null ? ""
				: req.getParameter("telephone");
		
		String qqNum = req.getParameter("qqNum") == null ? ""
				: req.getParameter("qqNum");
		
		String weChatNum = req.getParameter("weChatNum") == null ? ""
				: req.getParameter("weChatNum");
		
//		String imgPersonUrl = req.getParameter("imgPersonUrl") == null ? ""
//				: req.getParameter("imgPersonUrl");
		String version = req.getParameter("version") == null ? ""
				: req.getParameter("version");		
		PrintWriter out = null;
		TBUnitPopulation tb = new TBUnitPopulation();
		tb.setId(id);
//		tb.setuId(uId);
		tb.setPtype(Integer.parseInt(pType));
		tb.setHbuildingNum(hBuildingNum);
		tb.setHunitNum(hUnitNum);
		tb.setHfloorNum(hFloorNum);
		tb.setRoomNumber(roomNumber);
		tb.setName(name);
		tb.setOldName(oldName);
		tb.setBirthday(birthday);
		char chsex=sex.toCharArray()[0];                                            
		tb.setSex(sex);
		tb.setNation(nation);
		tb.setCertificateNum(certificateNum);
		tb.setDegreeEducation(degreeEducation);
		//char chmaritalSta=maritalSta.toCharArray()[0];                                            		
		tb.setMaritalSta(maritalSta);
		//char chmilitarySta=militarySta.toCharArray()[0];                                            		
		tb.setMilitarySta(militarySta);
		char chbloodType=bloodType.toCharArray()[0];                                            		
		tb.setBloodType(bloodType);
		tb.setHeight(height);
		tb.setRentDate(rentDate);
		tb.setWorkDate(workDate);
		tb.setIdType(IdType);
		tb.setResidenceId(residenceId);
		tb.setOccupation(occupation);
		tb.setPost(post);
		tb.setHouseRegist(houseRegist);
		tb.setServiceAddr(serviceAddr);
		tb.setLandLine(landLine);
		tb.setActualLiveAddr(actualLiveAddr);
		tb.setTelephone(telephone);
		tb.setQqNum(qqNum);
		tb.setWeChatNum(weChatNum);
		tb.setPersonType(personType);
//		tb.setImgPersonUrl(imgPersonUrl);
		tb.setVersion(Integer.valueOf(version));
		int flag = 0;
		try {
			rep.setContentType("application/json;charset=UTF-8");
			this.unitPopulationService.updateUnitPopulation(tb);			
			flag = 1;				
			out = rep.getWriter();
			out.print(flag);
		} catch (Exception e) {
			e.printStackTrace();
			if (out != null) {
				out.close();
			}
		}	
	}
	
	//获取法人或者房主信息或者员工信息
	@RequestMapping("/getLegalOrLandlordOrUnitPopulationInfo")
	public void getLegalOrLandlordOrUnitPopulationInfo(HttpServletResponse rep,String uId,String id)throws Exception{	
//		uId=new String(uId.getBytes("iso-8859-1"),"UTF-8");
		id=new String(id.getBytes("iso-8859-1"),"UTF-8");
		rep.setContentType("application/json;charset=UTF-8");
		PrintWriter out = null;
		TBUnitPopulation tb = new TBUnitPopulation();		
		try {
			tb = this.unitPopulationService.getLLUPInfo(id);
			out = rep.getWriter();
			out.print(new Gson().toJson(tb));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	//获取单位员工信息
	@RequestMapping("/getUnitPopulationInfo")
	public void getUnitPopulationInfo(HttpServletResponse rep,String uId)throws Exception{	
		uId=new String(uId.getBytes("iso-8859-1"),"UTF-8");
		rep.setContentType("application/json;charset=UTF-8");
		PrintWriter out = null;
		List<TBUnitPopulation> list = new ArrayList<TBUnitPopulation>();
		try {
			list = this.unitPopulationService.getUnitPopulationInfo(uId);
			out = rep.getWriter();
			out.print(new Gson().toJson(list));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	@RequestMapping("/findImages")
	public void findImages(HttpServletRequest request,HttpServletResponse response,String imagesIds){

		String[] imageIds=imagesIds.split(";");
		List<MediaFile> list=new ArrayList();
		for(String id:imageIds){
			MediaFile m=unitService.findImages(id);
			list.add(m);
		}
		this.printTOClient(response, list);
		
	}
	public void printTOClient(HttpServletResponse response,List<?>list) {
		try {
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().println(new Gson().toJson(list));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/findByID")
	public void findMediaFiles(HttpServletRequest request,HttpServletResponse response){
		 MediaFile m=new MediaFile();
		 m.setModeId("3acdd5f4d3af4b92b339c1a91d338939");
		 m.setSource("");
		 List<MediaFile> list=mediaFileService.selectMediaFiles(m);
		 Gson g=new Gson();
		 g.toJson(list);
		 System.out.println( g.toJson(list));

	}
}
