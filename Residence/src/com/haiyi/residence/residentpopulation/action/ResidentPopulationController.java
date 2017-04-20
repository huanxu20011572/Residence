package com.haiyi.residence.residentpopulation.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.PageInfo;
import com.google.gson.Gson;
import com.haiyi.residence.house.service.HouseService;
import com.haiyi.residence.model.MiniResidentPopulation;
import com.haiyi.residence.model.PopulationStactisc;
import com.haiyi.residence.model.TBHouse;
import com.haiyi.residence.model.TBResidentPopulation;
import com.haiyi.residence.model.TBUnit;
import com.haiyi.residence.residentpopulation.service.ResidentPopulationService;

@Controller
@RequestMapping("/residentPopulationController")
public class ResidentPopulationController {
	@Resource(name = "residentPopulationService")
	private ResidentPopulationService  residentPopulationService;
	@Resource(name = "houseService")
	private HouseService houseService;
	private JSONObject result;// 返回的json

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	//查询所有
	@RequestMapping("/getListPage")
	public void getListPage(HttpServletResponse rep,HttpServletRequest req,int type) throws Exception {
		Integer page = Integer.valueOf((String) ((req.getParameter("page")) == null ? "1": req.getParameter("page")));
		// jsp返回每页行数
		
		Integer rows = Integer.valueOf((String) ((req.getParameter("rows")) == null ? PageInfo.DEFAULT_ROWS.toString(): req.getParameter("rows")));	
		int start = (page-1)*rows;
		int end = page*rows;
		int count = 0;
		PrintWriter out = null;
		List<TBResidentPopulation> list=null;
		try {
			rep.setContentType("application/json;charset=UTF-8");
			out = rep.getWriter();
			if(type==0){
				 list = residentPopulationService.getAll(start,end);
				count = residentPopulationService.getCount();
			}else{
				 list=this.residentPopulationService.findCriminalPersons(start,end);
				 count = residentPopulationService.getCountCriminal();
			}
		
			String json = new Gson().toJson(list);
			out.print("{\"total\":"+count+",\"rows\":"+json+"}");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	// 删除
	@RequestMapping("/residentpopulationDel")
	public void residentpopulationDel(HttpServletResponse rep,String id) {
		int flag = 0;
		PrintWriter out = null;
		try {
			// 判断是否多选
			if (id.indexOf(",") > 0) {
				String[] str = id.split(",");
				for (int i = 0; i < str.length; i++) {
					this.residentPopulationService.deleteResidentPopulation(str[i]);
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
	@RequestMapping("/getResidentPopulationQuery")
	public void getResidentPopulationQuery(HttpServletResponse rep,HttpServletRequest req,int type
//			HttpServletResponse response,String sname, String sidNumber, String sactualLiveAddr,String shouseRegist,String stelephone
			)throws Exception{
		
		req.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("sname") == null ? "": req.getParameter("sname");
		name=new String(name.getBytes("iso-8859-1"),"UTF-8");

		String certificateNum = req.getParameter("scertificateNum") == null ? "": req.getParameter("scertificateNum");
		certificateNum=new String(certificateNum.getBytes("iso-8859-1"),"UTF-8");

		String telephone = req.getParameter("stelephone") == null ? "": req.getParameter("stelephone");
		telephone=new String(telephone.getBytes("iso-8859-1"),"UTF-8");
		
		String criminal = req.getParameter("criminal") == null ? "": req.getParameter("criminal");
		criminal=java.net.URLDecoder.decode(criminal,"UTF-8");
//		String hname = req.getParameter("hName") == null ? "": req.getParameter("hName");	
//		hname=new String(hname.getBytes("iso-8859-1"),"UTF-8");
//
//		String hbuildingNum = req.getParameter("hBuildingNum") == null ? "" : req.getParameter("hBuildingNum");
//		hbuildingNum=new String(hbuildingNum.getBytes("iso-8859-1"),"UTF-8");
//
//		String hunitNum = req.getParameter("hUnitNum") == null ? "" : req.getParameter("hUnitNum");
//		hunitNum=new String(hunitNum.getBytes("iso-8859-1"),"UTF-8");
//
//		String hroomNumber = req.getParameter("hRoomNumber") == null ? "" : req.getParameter("hRoomNumber");
//		hroomNumber=new String(hroomNumber.getBytes("iso-8859-1"),"UTF-8");

//		TBHouse t = new TBHouse();
		List<TBResidentPopulation> list = new ArrayList<TBResidentPopulation>();
//		t.setHname(hname);
//		t.setHbuildingNum(hbuildingNum);
//		t.setHunitNum(hunitNum);
//		t.setHroomNum(hroomNumber);
//		
//		String hid = "";
//		TBHouse tbh = new TBHouse();
//		tbh = houseService.getHIdByHname(t);
		PrintWriter out = null;
		TBResidentPopulation tb = new TBResidentPopulation();	
		rep.setContentType("application/json;charset=UTF-8");
		try {
//			if(tbh != null){
//				hid = tbh.getHid();
				tb.setName(name);
				tb.setCertificateNum(certificateNum);
//				tb.setHid(hid);
				tb.setTelephone(telephone);
				if(!"".equals(criminal)){
					tb.setCriminal(criminal);
				}else if(type==0){
					tb.setCriminal("000");
				}else{
					tb.setCriminal("111");
				}
				list = this.residentPopulationService.getResidentPopulationQuery(tb);
//			}
			out = rep.getWriter();
			out.print(new Gson().toJson(list));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	//修改
	@RequestMapping("/updateResidentPopulation")
	public void updataResidentPopulation(HttpServletResponse rep,HttpServletRequest req
			) throws Exception {
		String id = req.getParameter("id") == null ? "" : req.getParameter("id");	
//		String hId = req.getParameter("hId") == null ? "": req.getParameter("hId");
		String pType = req.getParameter("pType") == null ? "" : req
				.getParameter("pType");
		String name = req.getParameter("name") == null ? ""
				: req.getParameter("name");
		String oldName = req.getParameter("oldName") == null ? "" : req
				.getParameter("oldName");
		String sex = req.getParameter("sex") == null ? ""
				: req.getParameter("sex");
		String nation = req.getParameter("nation") == null ? "" : req
				.getParameter("nation");
		String certificateNum = req.getParameter("certificateNum") == null ? ""
				: req.getParameter("certificateNum");
		String birthday = req.getParameter("birthday") == null ? ""
				: req.getParameter("birthday");
		String degreeEducation = req.getParameter("degreeEducation") == null ? ""
				: req.getParameter("degreeEducation");
		String maritalSta = req.getParameter("maritalSta") == null ? ""
				: req.getParameter("maritalSta");
		String militarySta = req.getParameter("militarySta") == null ? "" : req
				.getParameter("militarySta");
		String tempLiveNo = req.getParameter("tempLiveNo") == null ? "" : req
				.getParameter("tempLiveNo");
		String relation = req.getParameter("relation") == null ? "" : req
				.getParameter("relation");
		String tempLiveDate = req.getParameter("tempLiveDate") == null ? "" : req
				.getParameter("tempLiveDate");
		String bloodType = req.getParameter("bloodType") == null ? "" : req
				.getParameter("bloodType");
		
		String height = req.getParameter("height") == null ? "" : req
				.getParameter("height");
		
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
		
		String telephone = req.getParameter("telephone") == null ? ""
				: req.getParameter("telephone");
		
		String qqNum = req.getParameter("qqNum") == null ? ""
				: req.getParameter("qqNum");
		
		String weChatNum = req.getParameter("weChatNum") == null ? ""
				: req.getParameter("weChatNum");
		
//		String imgPersonUrl = req.getParameter("imgPersonUrl") == null ? ""
//				: req.getParameter("imgPersonUrl");
		String rentDate = req.getParameter("rentDate") == null ? ""
				: req.getParameter("rentDate");
		String rentReason = req.getParameter("rentReason") == null ? ""
				: req.getParameter("rentReason");
		String liveDate = req.getParameter("liveDate") == null ? ""
				: req.getParameter("liveDate");
		String version = req.getParameter("version") == null ? ""
				: req.getParameter("version");
		String personType = req.getParameter("personType") == null ? ""
				: req.getParameter("personType");
		PrintWriter out = null;
		TBResidentPopulation tb = new TBResidentPopulation();
		
		tb.setId(id);
//		tb.setHid(hId);
		tb.setName(name);
		tb.setOldName(oldName);
		tb.setBirthday(birthday);                                       
		tb.setSex(sex);
		tb.setNation(nation);
		tb.setCertificateNum(certificateNum);
		tb.setDegreeEducation(degreeEducation);
		tb.setPersonType(personType);
	                                 		
		tb.setMaritalSta(maritalSta);
                                          		
		tb.setMilitarySta(militarySta);                                            		
		tb.setBloodType(bloodType);
		
		tb.setHeight(height);
		tb.setOccupation(occupation);
		tb.setPost(post);
		tb.setRelation(relation);
		tb.setHouseRegist(houseRegist);
		tb.setServiceAddr(serviceAddr);
		tb.setPtype(Integer.parseInt(pType));
		tb.setLandLine(landLine);
		tb.setActualLiveAddr(actualLiveAddr);
		tb.setTelephone(telephone);
		tb.setQqNum(qqNum);
		tb.setWeChatNum(weChatNum);
//		tb.setImgPersonUrl(imgPersonUrl);
		tb.setTempLiveDate(tempLiveDate);
		tb.setTempLiveNo(tempLiveNo);
		tb.setRentalTime(rentDate);
		tb.setRentReason(rentReason);
		tb.setLiveDate(liveDate);
		tb.setVersion(Integer.valueOf(version));
		
		int flag = 0;
		try {
			rep.setContentType("application/json;charset=UTF-8");
			this.residentPopulationService.updateResidentPopulation(tb);			
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
	/**
	 * 查询犯罪的人口
	 */
	public void findCriminalPersons(HttpServletRequest request,HttpServletResponse response){
		List<TBResidentPopulation> list=this.residentPopulationService.findCriminalPersons(1, 5);
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
	/**
	 * 查出快到期未检查的流动人口
	 */
	@RequestMapping("/findFlowPopulationWillExpire")
	public void findFlowPopulationWillExpire(HttpServletRequest request,HttpServletResponse response){
		Integer page = Integer.valueOf((String) ((request.getParameter("page")) == null ? "1": request.getParameter("page")));
		// jsp返回每页行数
		
		Integer rows = Integer.valueOf((String) ((request.getParameter("rows")) == null ? PageInfo.DEFAULT_ROWS.toString(): request.getParameter("rows")));	
		int start = (page-1)*rows;
		int end = page*rows;
		int count = 0;
		TBResidentPopulation tb=new TBResidentPopulation();
		tb.setTempEndDateCheck(0);
		tb.setPersonType("流动人口");
		List<TBResidentPopulation> list=this.residentPopulationService.findFlowPopulationWillExpire(tb,start,end);
		List<TBResidentPopulation> tlist=new ArrayList();
		for(int i=0;i<list.size();i++){
			TBResidentPopulation tp=list.get(i);
			String startDate=tp.getTempLiveDate();
			String endDate=tp.getRentalTime();
			Long d=this.computeInterval(startDate, endDate);
			if(d<10){
				tlist.add(tp);
			}
		}
		count=this.residentPopulationService.findFlowPopulationnotCheckCount(tb);
		String json = new Gson().toJson(list);
		response.setContentType("application/json;charset=UTF-8");
		try {
			response.getWriter().print("{\"total\":"+count+",\"rows\":"+json+"}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Long computeInterval(String startT,String endT){
		SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
		Date start=null;
		Date end=null;
		long interval=0L;
		try {
			start = sm.parse(startT);
			end=sm.parse(endT);
			interval=end.getTime()-start.getTime();
			interval=interval/(1000*3600*24);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return interval;
	}
	/**
	 * 检查操作
	 */
	@RequestMapping("/checkOperateModify")
	public void checkOperateModify(HttpServletRequest request,HttpServletResponse response){
		String rowsJsonStr = request.getParameter("rowsJsonStr") == null ? "" : request.getParameter("rowsJsonStr");
		try {
			JSONArray rows = new JSONArray(rowsJsonStr);
			for(int i=0;i<rows.length();i++){
				JSONObject row = rows.getJSONObject(i);
				String id=row.getString("id");
				TBResidentPopulation tb=new TBResidentPopulation();
				tb.setId(id);
				this.residentPopulationService.updateCheckStatus(tb);
			}
			response.getWriter().println("1");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				response.getWriter().println("2");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
		}
		
	}
	@RequestMapping("/selectHousePopulation")
	public void selectHousePopulation(HttpServletRequest request,HttpServletResponse response,String hId,Integer pType){
		List<TBResidentPopulation> list=this.residentPopulationService.selectHouseOwner(pType, hId);
		this.printTOClient(response, list); 
	}
	@RequestMapping("/findCriminalPersonsStatistics")
	public void findCriminalPersonsStatistics(HttpServletResponse response){
		List<MiniResidentPopulation> list=this.residentPopulationService.findCriminalPersonsStatistics();
		this.printTOClient(response, list);
	}
	@RequestMapping("/findPopulationPersonsStatistics")
	public void findPopulationPersonsStatistics(HttpServletResponse response){
		List<PopulationStactisc> list=this.residentPopulationService.findPopulationPersonsStatistics();
		for(PopulationStactisc p:list){
			if(p.getPersonType()==null||p.getPersonType().equals("")){
				p.setPersonType("流动人口");
			}
		}
		this.printTOClient(response, list);
	}
}
