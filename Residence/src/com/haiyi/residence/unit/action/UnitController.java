package com.haiyi.residence.unit.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.PageInfo;
import com.google.gson.Gson;
import com.haiyi.residence.model.MediaFile;
import com.haiyi.residence.model.TBUnit;
import com.haiyi.residence.model.TBUnitPopulation;
import com.haiyi.residence.unit.service.UnitService;
import com.haiyi.residence.unitpopulation.service.UnitPopulationService;

@Controller
@RequestMapping("/unitController")
public class UnitController {
	@Resource(name="unitService")
	private UnitService unitService;
	@Resource(name = "unitPopulationService")
	private UnitPopulationService  unitPopulationService;
	@RequestMapping("/getListPage")
	public void getListPage(HttpServletResponse rep,HttpServletRequest req) throws Exception {
		Integer page = Integer.valueOf((String) ((req.getParameter("page")) == null ? "1": req.getParameter("page")));
		// jsp返回每页行数
		Integer rows = Integer.valueOf((String) ((req.getParameter("rows")) == null ? PageInfo.DEFAULT_ROWS.toString(): req.getParameter("rows")));	
		int start = (page-1)*rows;
		int end = page*rows;
		int count = 0;
		PrintWriter out = null;
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			rep.setContentType("application/json;charset=UTF-8");
			out = rep.getWriter();
			List<TBUnit> list = new ArrayList<TBUnit>();
			 list=unitService.getAll(start,end);			 
			 count = unitService.getCount();
				String json = new Gson().toJson(list);
				out.print("{\"total\":"+count+",\"rows\":"+json+"}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//条件查询
	@RequestMapping("/unitQuery")
	public void unitQuery(HttpServletResponse rep,HttpServletRequest req
			)throws Exception{	
		req.setCharacterEncoding("utf-8");
		String uname = req.getParameter("suName") == null ? ""
				: req.getParameter("suName");
		uname=new String(uname.getBytes("iso-8859-1"),"UTF-8");
		String bussinessNum = req.getParameter("sbussinessNum") == null ? ""
				: req.getParameter("sbussinessNum");	
		bussinessNum=new String(bussinessNum.getBytes("iso-8859-1"),"UTF-8");

		String orgNum = req.getParameter("sorgNum") == null ? ""
				: req.getParameter("sorgNum");	
		orgNum=new String(orgNum.getBytes("iso-8859-1"),"UTF-8");

//		String id ="";
//		id = unitService.getUnitIdByUname(uName);
		PrintWriter out = null;
		List<TBUnit> list = new ArrayList<TBUnit>();
		TBUnit tb = new TBUnit();
		try {
			tb.setUname(uname);
			tb.setBussinessNum(bussinessNum);
			tb.setOrgNum(orgNum);
			list = this.unitService.unitQuery(tb);
			rep.setContentType("application/json;charset=UTF-8");
			out = rep.getWriter();
			out.print(new Gson().toJson(list));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	//
	
	//条件查询
	@RequestMapping("/getUnitIdById")
	public void getUnitIdById(HttpServletResponse rep,String uId
			)throws Exception{	
		uId=new String(uId.getBytes("iso-8859-1"),"UTF-8");
		PrintWriter out = null;
		TBUnit tb = new TBUnit();
		try {
			tb = this.unitService.getUnitIdById(uId);
			rep.setContentType("application/json;charset=UTF-8");
			out = rep.getWriter();
			out.print(new Gson().toJson(tb));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	//修改
	@RequestMapping("/updataUnit")
	public void updataUnitPopulation(HttpServletResponse rep,HttpServletRequest req
//			,String name,String oldName,
//			String sex,String nation,String idNumber,String degreeEducation,String maritalSta, 
//			String militarySta,String bloodType,String height,String occupation,String post,
//			String houseRegist,String serviceAddr,String pType,String landLine,String actualLiveAddr,
//			String telephone,String qqNum,String weChatNum,String imgPersonUrl
			) throws Exception {
		
		String id = req.getParameter("id") == null ? ""
				: req.getParameter("id");		
		String uname = req.getParameter("uName") == null ? ""
				: req.getParameter("uName");	
		String uaddr = req.getParameter("uAddr") == null ? "" : req
				.getParameter("uAddr");
		String uproperty = req.getParameter("uProperty") == null ? "" : req
				.getParameter("uProperty");
		String uoperateRange = req.getParameter("uOperateRange") == null ? "" : req
				.getParameter("uOperateRange");		
		String uoperateArea = req.getParameter("uOperateArea") == null ? "" : req
						.getParameter("uOperateArea");
		String rent = req.getParameter("rent") == null ? "" : req
				.getParameter("rent");					
		String LinkNumber = req.getParameter("LinkNumber") == null ? ""
				: req.getParameter("LinkNumber");
		String ucategory = req.getParameter("uCategory") == null ? "" : req
				.getParameter("uCategory");
		String securityPersonId = req.getParameter("securityPersonId") == null ? "" : req
				.getParameter("securityPersonId");		
		String upersonNum = req.getParameter("uPersonNum") == null ? ""
				: req.getParameter("uPersonNum");
		String utelephone = req.getParameter("uTelephone") == null ? "" : req
				.getParameter("uTelephone");
		String bussinessNum = req.getParameter("bussinessNum") == null ? ""
				: req.getParameter("bussinessNum");
		String regesistMoney = req.getParameter("regesistMoney") == null ? ""
				: req.getParameter("regesistMoney");
		String regesistTime = req.getParameter("regesistTime") == null ? ""
				: req.getParameter("regesistTime");
		String openningTime = req.getParameter("openningTime") == null ? "" : req
				.getParameter("openningTime");
		String closeTime = req.getParameter("closeTime") == null ? "" : req
				.getParameter("closeTime");
		String orgNum = req.getParameter("orgNum") == null ? "" : req
				.getParameter("orgNum");
//		String legalRepresentId = req.getParameter("legalRepresentId") == null ? "" : req
//				.getParameter("legalRepresentId");
//		String landlordId = req.getParameter("landlordId") == null ? "" : req
//				.getParameter("landlordId");
//		String imageUrls = req.getParameter("imageUrls") == null ? "" : req
//				.getParameter("imageUrls");
//		String layoutDiagramUrl = req.getParameter("layoutDiagramUrl") == null ? "" : req
//				.getParameter("layoutDiagramUrl");
		String version = req.getParameter("version") == null ? ""
				: req.getParameter("version");
			

		PrintWriter out = null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		TBUnit tb = new TBUnit();
		
		tb.setId(id);
		tb.setUname(uname);
		tb.setUaddr(uaddr);
		tb.setUproperty(uproperty);
		tb.setUoperateRange(uoperateRange);
		tb.setUoperateArea(uoperateArea);
		tb.setRent(rent);
		tb.setLinkNumber(LinkNumber);
		tb.setUcategory(ucategory);
		tb.setSecurityPersonId(securityPersonId);
		tb.setUpersonNum(upersonNum);
		tb.setUtelephone(utelephone);
		tb.setBussinessNum(bussinessNum);
		tb.setRegesistMoney(regesistMoney);
		tb.setRegesistTime(regesistTime);
		tb.setOpenningTime(openningTime);
		tb.setCloseTime(closeTime);
		tb.setOrgNum(orgNum);
//		tb.setLegalRepresentId(legalRepresentId);
//		tb.setLandlordId(landlordId);
//		tb.setImageUrls(imageUrls);
//		tb.setLayoutDiagramUrl(layoutDiagramUrl);
		tb.setVersion(Integer.valueOf(version));
		int flag = 0;
		try {
			rep.setContentType("application/json;charset=UTF-8");
			this.unitService.updateUnit(tb);			
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
	
	// 删除
	@RequestMapping("/deleteUnit")
	public void deleteUnit(HttpServletResponse rep,String id) {
		int flag = 0;
		PrintWriter out = null;
		try {
			// 判断是否多选
			if (id.indexOf(",") > 0) {
				String[] str = id.split(",");
				for (int i = 0; i < str.length; i++) {
					this.unitService.deleteUnit(str[i]);
					this.unitPopulationService.deleteUnitPopulationByUId(str[i]);
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

}
