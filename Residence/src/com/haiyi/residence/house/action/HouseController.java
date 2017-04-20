package com.haiyi.residence.house.action;

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
import com.haiyi.residence.house.service.HouseService;
import com.haiyi.residence.model.TBHouse;
import com.haiyi.residence.residentpopulation.service.ResidentPopulationService;

@Controller
@RequestMapping("/houseController")
public class HouseController {
	@Resource(name = "houseService")
	private HouseService  houseService;
	@Resource(name = "residentPopulationService")
	private ResidentPopulationService  residentPopulationService;
	
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
			List<TBHouse> list = new ArrayList<TBHouse>();
			list=houseService.getAll(start,end);
			count = houseService.getCount();
			String json = new Gson().toJson(list);
			out.print("{\"total\":"+count+",\"rows\":"+json+"}");
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// 删除
	@RequestMapping("/deleteHouse")
	public void deleteUnit(HttpServletResponse rep,String hid) {
		int flag = 0;
		PrintWriter out = null;
		try {
			// 判断是否多选
			if (hid.indexOf(",") > 0) {
				String[] str = hid.split(",");
				for (int i = 0; i < str.length; i++) {
					this.houseService.deleteHouse(str[i]);
					this.residentPopulationService.deleteResidentPopulationByHid(str[i]);
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
	@RequestMapping("/houseQuery")
	public void houseQuery(HttpServletResponse rep,HttpServletRequest req
			)throws Exception{	
		req.setCharacterEncoding("utf-8");
		String hbuildingNum = req.getParameter("shbuildingNum") == null ? ""
				: req.getParameter("shbuildingNum");
		hbuildingNum=new String(hbuildingNum.getBytes("iso-8859-1"),"UTF-8");
		String hunitNum = req.getParameter("shunitNum") == null ? ""
				: req.getParameter("shunitNum");	
		hunitNum=new String(hunitNum.getBytes("iso-8859-1"),"UTF-8");


//		String id ="";   shbuildingNum="+shbuildingNum+"&shunitNum="+shunitNum
//		id = unitService.getUnitIdByUname(uName);
		PrintWriter out = null;
		List<TBHouse> list = new ArrayList<TBHouse>();
		TBHouse tb = new TBHouse();
		try {
			tb.setHbuildingNum(hbuildingNum);
			tb.setHunitNum(hunitNum);
			list = this.houseService.houseQuery(tb);
			rep.setContentType("application/json;charset=UTF-8");
			out = rep.getWriter();
			out.print(new Gson().toJson(list));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	
	//修改
	@RequestMapping("/updateHouse")
	public void updateHouse(HttpServletResponse rep,HttpServletRequest req
			) throws Exception {
		String hid = req.getParameter("hid") == null ? ""
				: req.getParameter("hid");	
		String haddr = req.getParameter("haddr") == null ? ""
				: req.getParameter("haddr");
		String hname = req.getParameter("hname") == null ? ""
				: req.getParameter("hname");
		String hbuildingNum = req.getParameter("hbuildingNum") == null ? "" : req
				.getParameter("hbuildingNum");
		String hunitNum = req.getParameter("hunitNum") == null ? ""
				: req.getParameter("hunitNum");
		String hfloorNum = req.getParameter("hfloorNum") == null ? "" : req
				.getParameter("hfloorNum");
		String hroomNum = req.getParameter("hroomNum") == null ? ""
				: req.getParameter("hroomNum");
		String hstructure = req.getParameter("hstructure") == null ? "" : req
				.getParameter("hstructure");
		String hpropertyRight = req.getParameter("hpropertyRight") == null ? ""
				: req.getParameter("hpropertyRight");
		String hsecurityStatus = req.getParameter("hsecurityStatus") == null ? ""
				: req.getParameter("hsecurityStatus");
		String rentalTime = req.getParameter("rentalTime") == null ? ""
				: req.getParameter("rentalTime");
		String rentalArea = req.getParameter("rentalArea") == null ? ""
				: req.getParameter("rentalArea");
		String rentalRoomNum = req.getParameter("rentalRoomNum") == null ? "" : req
				.getParameter("rentalRoomNum");		
		String rentalRoomDate = req.getParameter("rentalRoomDate") == null ? "" : req
				.getParameter("rentalRoomDate");
		String policeOperateArea = req.getParameter("policeOperateArea") == null ? "" : req
				.getParameter("policeOperateArea");
		String operateRow = req.getParameter("operateRow") == null ? "" : req
				.getParameter("operateRow");
		String chargePoliceNum = req.getParameter("chargePoliceNum") == null ? "" : req
				.getParameter("chargePoliceNum");
		
//		String landlordId = req.getParameter("landlordId") == null ? "" : req
//				.getParameter("landlordId");
//		
//		String imageUrls = req.getParameter("imageUrls") == null ? ""
//				: req.getParameter("imageUrls");
//		
//		String layoutDiagramUrl = req.getParameter("layoutDiagramUrl") == null ? ""
//				: req.getParameter("layoutDiagramUrl");
		
		String version = req.getParameter("version") == null ? "" : req
				.getParameter("version");
		
		
		PrintWriter out = null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		TBHouse tb = new TBHouse();
		
		tb.setHid(hid);
		tb.setHaddr(haddr);
		tb.setHname(hname);
		tb.setHbuildingNum(hbuildingNum);
		tb.setHunitNum(hunitNum);
		tb.setHfloorNum(hfloorNum);
		tb.setHroomNum(hroomNum);
		tb.setHstructure(hstructure);
		tb.setHpropertyRight(hpropertyRight);
		tb.setHsecurityStatus(hsecurityStatus);
		tb.setRentalTime(rentalTime);
		tb.setRentalArea(rentalArea);
		tb.setRentalRoomNum(rentalRoomNum);
		tb.setRentalRoomDate(rentalRoomDate);
		tb.setPoliceOperateArea(policeOperateArea);
		tb.setOperateRow(operateRow);
		tb.setChargePoliceNum(chargePoliceNum);
//		tb.setLandlordId(landlordId);
//		tb.setImageUrls(imageUrls);
//		tb.setLayoutDiagramUrl(layoutDiagramUrl);
		tb.setVersion(Integer.valueOf(version));
		int flag = 0;
		try {
			rep.setContentType("application/json;charset=UTF-8");
			this.houseService.updateHouse(tb);			
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
	@RequestMapping("/getHouseInfoByHId")
	public void getHouseInfoByHId(HttpServletRequest request,HttpServletResponse response,String hId){
		List<TBHouse> list=this.houseService.getHouseInfoByHId(hId);
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
