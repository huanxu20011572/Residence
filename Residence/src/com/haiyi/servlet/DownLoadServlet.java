package com.haiyi.servlet;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.google.gson.Gson;
import com.haiyi.residence.entity.House;
import com.haiyi.residence.entity.HouseMember;
import com.haiyi.residence.entity.Unit;
import com.haiyi.residence.entity.UnitMember;
import com.haiyi.residence.house.service.HouseService;
import com.haiyi.residence.mediafile.service.MediaFileService;
import com.haiyi.residence.model.MediaFile;
import com.haiyi.residence.model.TBHouse;
import com.haiyi.residence.model.TBResidentPopulation;
import com.haiyi.residence.model.TBUnit;
import com.haiyi.residence.model.TBUnitPopulation;
import com.haiyi.residence.model.download.DownLoadObject;
import com.haiyi.residence.residentpopulation.service.ResidentPopulationService;
import com.haiyi.residence.unit.service.UnitService;
import com.haiyi.residence.unitpopulation.service.UnitPopulationService;
import com.haiyi.residence.util.SpringContext;

public class DownLoadServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DownLoadServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			
		ApplicationContext cxt=SpringContext.getApplicationContext();
		UnitService unitService=(UnitService) cxt.getBean("unitService");
		DownLoadObject downObj=new DownLoadObject();
		
		UnitPopulationService unitPopulationService=(UnitPopulationService) cxt.getBean("unitPopulationService");
		List<TBUnit> list=unitService.getAllList();
		List<Unit> uList=new ArrayList<Unit>();
		for(TBUnit u:list){
			Unit n=new Unit();
			n.setId(u.getId());
			n.setuName(u.getUname());
			n.setuAddr(u.getUaddr());
			n.setuProperty(u.getUproperty());
			n.setuOperateRange(u.getUoperateRange());
			
			n.setRent(u.getRent().toString());
			n.setLinkNumber(u.getLinkNumber());
			n.setuCategory(u.getUcategory());
			n.setSecurityPersonId(u.getSecurityPersonId());
			n.setuPersonNum(u.getUpersonNum().toString());
			
			n.setBussinessNum(u.getBussinessNum());
			n.setRegesistMoney(u.getRegesistMoney().toString());
			n.setRegesistTime(u.getRegesistTime());
			n.setOpenningTime(u.getOpenningTime());
			n.setCloseTime(u.getCloseTime());
			n.setOrgNum(u.getOrgNum());
			n.setLegalRepresentId(u.getLegalRepresentId());
			n.setLandlordId(u.getLandlordId());
			n.setImageUrls(u.getImageUrls());
			n.setLayoutDiagramUrl(u.getLayoutDiagramUrl());
			n.setVersion(u.getVersion());
			n.setuOperateArea(u.getUoperateArea());
			n.setValid(true);
			n.setIsRefresh(true);
			uList.add(n);
		}
		
		downObj.setUnitList(uList);
		List<TBUnitPopulation> uplist=unitPopulationService.getAllList();
		List<UnitMember> umList=new ArrayList<UnitMember>();
		for(TBUnitPopulation p:uplist){
			UnitMember m=new UnitMember();
			m.setId(p.getId());
			TBUnit tbu = new TBUnit();
			tbu = unitService.getUnitIdById(p.getUid());
			m.setUnit(exchange(tbu));
			m.setpType(p.getPtype());
			m.sethUnitNum(p.getHunitNum());
			m.sethBuildingNum(p.getHbuildingNum());
			m.sethFloorNum(p.getHfloorNum());
			m.setRoomNumber(p.getRoomNumber());
			m.setName(p.getName());
			m.setOldName(p.getOldName());
			m.setBirthday(p.getBirthday());
   			m.setSex(p.getSex());
   			m.setNation(p.getNation());
   			m.setCertificateNum(p.getCertificateNum());
   			m.setDegreeEducation(p.getDegreeEducation());
   			m.setMaritalSta(p.getMaritalSta());
   			m.setMilitarySta(p.getMilitarySta());
   			m.setBloodType(p.getBloodType());
   			m.setHeight(p.getHeight().toString());
   			m.setRentDate(p.getRentDate());
   			m.setWorkDate(p.getWorkDate());
   			m.setIdType(p.getIdType());
   			m.setResidenceId(p.getResidenceId());
   			m.setOccupation(p.getOccupation());
   			m.setPost(p.getPost());
   			m.setHouseRegist(p.getHouseRegist());
   			m.setServiceAddr(p.getServiceAddr());
   			m.setLandLine(p.getLandLine());
   			m.setActualLiveAddr(p.getActualLiveAddr());
   			m.setTelephone(p.getTelephone());
   			m.setQqNum(p.getQqNum());
   			m.setWetChatNum(p.getWeChatNum());
   			m.setImgPersonUrl(p.getImgPersonUrl());
   			m.setVersion(p.getVersion());
   			m.setValid(true);
   			m.setIsRefresh(true);
   			umList.add(m);
		}
		downObj.setUnitMemberList(umList);
		//============== HOUSE AND HOUSEMEMBER ============
		HouseService hService = (HouseService)cxt.getBean("houseService");
		ResidentPopulationService rpService = (ResidentPopulationService)cxt.getBean("residentPopulationService");
		
		List<House> hList = new ArrayList<House>();
		List<HouseMember> hmList = new ArrayList<HouseMember>();
		List<TBHouse> tbhList = hService.getAllInfo();
		List<TBResidentPopulation> tbrpList = rpService.getAllInfo();
		//for House
		for (TBHouse tbh : tbhList) {
			House h = new House();
			h.setId(tbh.getHid());
			h.setuName(tbh.getHname());
			h.sethBuildingNum(tbh.getHbuildingNum());
			h.sethUnitNum(tbh.getHunitNum());
			h.setRoomNumber(tbh.getRentalRoomNum()+"");
			h.setRealAddress(tbh.getRealAddress());
			h.sethFloorNum(tbh.getHfloorNum());
			h.sethStructure(tbh.getHstructure());
			h.sethPropertyRight(tbh.getHpropertyRight());
			h.sethSecurityStatus(tbh.getHsecurityStatus());
			h.setRentalTime(tbh.getRentalTime());
			h.setRentalArea(tbh.getRentalArea()+"");
			h.setRentalRoomNum(tbh.getRentalRoomNum()+"");
			h.setRentalRoomDate(tbh.getRentalRoomDate());
			h.setRentType(tbh.getRentType());
			h.setPoliceOperateArea(tbh.getPoliceOperateArea());
			h.setOperateRow(tbh.getOperateRow());
			h.setChargePoliceNum(tbh.getChargePoliceNum());
			h.setLandlordId(tbh.getLandlordId());
			h.setLayoutDiagramUrl(tbh.getLayoutDiagramUrl());
			h.setImageUrls(tbh.getImageUrls());
			h.setValid(true);
			h.setIsRefresh(true);
			hList.add(h);
		}
		downObj.setHouseList(hList);
		//for HouseMember
		for (TBResidentPopulation tbrp : tbrpList) {
			HouseMember hm = new HouseMember();
			hm.setId(tbrp.getId());
			
			//≤È’“house
			TBHouse tse=hService.getHouseById(tbrp.getHid());
			House hu=this.exchangeHouse(tse);
			hm.setHouse(hu);
			hm.sethId(hu.getId());
			hm.setpType(tbrp.getPtype());
			hm.setName(tbrp.getName());
			hm.setOldName(tbrp.getOldName());
			hm.setSex(tbrp.getSex());
			hm.setNation(tbrp.getNation());
			hm.setCertificateNum(tbrp.getCertificateNum());
			hm.setBirthday(tbrp.getBirthday());
			hm.setDegreeEducation(tbrp.getDegreeEducation());
			hm.setMaritalSta(tbrp.getMaritalSta()+"");
			hm.setMilitarySta(tbrp.getMilitarySta()+"");
			hm.setTempLiveNo(tbrp.getTempLiveNo());
			hm.setRelation(tbrp.getRelation());
			hm.setTempLiveDate(tbrp.getTempLiveDate());
			hm.setBloodType(tbrp.getBloodType()+"");
			hm.setHeight(tbrp.getHeight()+"");
			hm.setOccupation(tbrp.getOccupation());
			hm.setPost(tbrp.getPost());
			hm.setHouseRegist(tbrp.getHouseRegist());
			hm.setServiceAddr(tbrp.getServiceAddr());
			hm.setLandLine(tbrp.getLandLine());
			hm.setActualLiveAddr(tbrp.getActualLiveAddr());
			hm.setTelephone(tbrp.getTelephone());
			hm.setQqNum(tbrp.getQqNum());
			hm.setWetChatNum(tbrp.getWeChatNum());
			hm.setImgPersonUrl(tbrp.getImgPersonUrl());
			hm.setRentDate(tbrp.getRentalTime());
			hm.setRentReason(tbrp.getRentReason());
			hm.setLiveDate(tbrp.getLiveDate());
			hm.setValid(true);
			hm.setIsRefresh(true);
			hmList.add(hm);
		}
		downObj.setHouseMemberList(hmList);
		MediaFileService mService = (MediaFileService)cxt.getBean("mediaFileService");
		List<MediaFile> mediaFileList=mService.getAll();
		
	    for(MediaFile m:mediaFileList){
	    	m.setValid(true);
	    	m.setRefresh(true);
	    	String urlStr= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+m.getRelativePathServer();
	    	m.setRelativePathServer(urlStr);
	    }
	    System.out.println("houseSize:"+hmList.size()+"\t"+hList.size());
	    System.out.println("unitSize:"+uList.size()+"\t"+umList.size());
	    
		downObj.setMediaFileList(mediaFileList);
		System.out.println("mediaFileSize:"+mediaFileList.size());
		Gson gson=new Gson();
		String gsonStr=gson.toJson(downObj);
		response.setContentType("application/json;charset=UTF-8");
		System.out.println("========"+gsonStr);
		response.getWriter().println(gsonStr);
		}catch(Exception sp){
			sp.printStackTrace();
		}
		//==================================================
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	public Unit exchange(TBUnit tb){
		Unit u = new Unit();
		u.setId(tb.getId());
		u.setuName(tb.getUname());
		u.setuAddr(tb.getUaddr());
		u.setOrgNum(tb.getOrgNum());
		u.setLegalRepresentId(tb.getLegalRepresentId());
		u.setuProperty(tb.getUproperty());
		u.setuOperateRange(tb.getUoperateRange());
		u.setRent(tb.getRent().toString());
		u.setLinkNumber(tb.getLinkNumber());
		u.setuCategory(tb.getUcategory());
		u.setSecurityPersonId(tb.getSecurityPersonId());
		u.setuPersonNum(tb.getUpersonNum().toString());
		u.setBussinessNum(tb.getBussinessNum());
		u.setRegesistMoney(tb.getRegesistMoney().toString());
		u.setRegesistTime(tb.getRegesistTime());
		u.setOpenningTime(tb.getOpenningTime());
		u.setCloseTime(tb.getCloseTime());
		u.setLandlordId(tb.getLandlordId());
		u.setLayoutDiagramUrl(tb.getLayoutDiagramUrl());
		u.setImageUrls(tb.getImageUrls());
		u.setVersion(tb.getVersion());
		return u;
	}
	public House exchangeHouse(TBHouse tbh){
		House h = new House();
		h.setId(tbh.getHid());
		h.setuName(tbh.getHname());
		h.sethBuildingNum(tbh.getHbuildingNum());
		h.sethUnitNum(tbh.getHunitNum());
		h.setRoomNumber(tbh.getRentalRoomNum()+"");
		h.setRealAddress(tbh.getRealAddress());
		h.sethFloorNum(tbh.getHfloorNum());
		h.sethStructure(tbh.getHstructure());
		h.sethPropertyRight(tbh.getHpropertyRight());
		h.sethSecurityStatus(tbh.getHsecurityStatus());
		h.setRentalTime(tbh.getRentalTime());
		h.setRentalArea(tbh.getRentalArea()+"");
		h.setRentalRoomNum(tbh.getRentalRoomNum()+"");
		h.setRentalRoomDate(tbh.getRentalRoomDate());
		h.setRentType(tbh.getRentType());
		h.setPoliceOperateArea(tbh.getPoliceOperateArea());
		h.setOperateRow(tbh.getOperateRow());
		h.setChargePoliceNum(tbh.getChargePoliceNum());
		h.setLandlordId(tbh.getLandlordId());
		h.setLayoutDiagramUrl(tbh.getLayoutDiagramUrl());
		h.setImageUrls(tbh.getImageUrls());
		h.setValid(true);
		h.setIsRefresh(true);
		return h;
	}

}
