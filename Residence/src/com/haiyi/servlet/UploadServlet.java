package com.haiyi.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.context.ApplicationContext;

import com.google.gson.Gson;
import com.haiyi.residence.entity.House;
import com.haiyi.residence.entity.HouseMember;
import com.haiyi.residence.entity.Unit;
import com.haiyi.residence.entity.UnitMember;
import com.haiyi.residence.house.service.HouseService;
import com.haiyi.residence.mediafile.service.MediaFileService;
import com.haiyi.residence.model.MediaFile;
import com.haiyi.residence.model.ReTransBaseObject;
import com.haiyi.residence.model.ReTransObject;
import com.haiyi.residence.model.TBHouse;
import com.haiyi.residence.model.TBResidentPopulation;
import com.haiyi.residence.model.TBUnit;
import com.haiyi.residence.model.TBUnitPopulation;
import com.haiyi.residence.residentpopulation.service.ResidentPopulationService;
import com.haiyi.residence.unit.service.UnitService;
import com.haiyi.residence.unitpopulation.service.UnitPopulationService;
import com.haiyi.residence.util.SpringContext;

public class UploadServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public UploadServlet() {
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
    @SuppressWarnings({ "unchecked", "deprecation" })
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        File file1 = null,file2=null;
        String description1 = null,description2 = null;
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
		ApplicationContext cxt=SpringContext.getApplicationContext();
		UnitService unitService=(UnitService) cxt.getBean("unitService"); 
		UnitPopulationService unitPopulationService=(UnitPopulationService) cxt.getBean("unitPopulationService");
		HouseService houseService=(HouseService) cxt.getBean("houseService");
		ResidentPopulationService residentPopulationService=(ResidentPopulationService) cxt.getBean("residentPopulationService");
		
		MediaFileService MediaFileService=(MediaFileService) cxt.getBean("mediaFileService");
		
        Gson gson2 = new Gson();
		Type unitMemberTy =new com.google.gson.reflect.TypeToken<List<UnitMember>>(){}.getType();     
		
  		Type houseMemberTy =new com.google.gson.reflect.TypeToken<List<HouseMember>>(){}.getType();
  		
  		Type MediaFileTy =new com.google.gson.reflect.TypeToken<List<MediaFile>>(){}.getType();
  		ReTransObject reo=new ReTransObject();
  		reo.setResultCode("200");
  		reo.setResultMsg("插入成功");
        DiskFileUpload diskFileUpload = new DiskFileUpload();
        try{
            List<FileItem> list = diskFileUpload.parseRequest(request);
            for(FileItem fileItem : list){
                if(fileItem.isFormField()){
                	 description1 =fileItem.getString("UTF-8");
                	 if(fileItem.getFieldName().equals("unit")){              
                		 
                		 Unit u = gson2.fromJson(description1,Unit.class);
                		 TBUnit tb = new TBUnit();
                		 tb.setBussinessNum(u.getBussinessNum());
                		 tb.setCloseTime(u.getCloseTime());
                		 tb.setImageUrls(u.getImageUrls());
                		 tb.setLandlordId(u.getLandlordId());
                		                		 
                		 String layout = "";
                		 String[] str = u.getLayoutDiagramUrl().split(";");
                    		 for (int i = 0; i < str.length; i++) {              			 
     							if("null".equals(str[i])==false ){
    								layout = str[i]+";";
     								if(i==str.length-1){
     									layout = str[i];
     								}
     							}
     						}           				            			             		 
                		 tb.setLayoutDiagramUrl(layout);
                		 tb.setLegalRepresentId(u.getLegalRepresentId());
                		 tb.setLinkNumber(u.getLinkNumber());
                		 tb.setOpenningTime(u.getOpenningTime());
                		 tb.setOrgNum(u.getOrgNum());
                		 tb.setRegesistMoney(u.getRegesistMoney());
                		 tb.setRegesistTime(u.getRegesistTime());
                		 tb.setRent(u.getRent());
                		 tb.setSecurityPersonId(u.getSecurityPersonId());
                		 tb.setUaddr(u.getuAddr());
                		 tb.setUcategory(u.getuCategory());
                		 tb.setUname(u.getuName());
                		 tb.setUoperateRange(u.getuOperateRange());
                		 tb.setUoperateArea(u.getuOperateArea());
                		 tb.setUpersonNum(u.getuPersonNum());
                		 tb.setUproperty(u.getuProperty());              		 
                		 tb.setVersion(u.getVersion());
                		 tb.setId(u.getId());
                		 //入库操作
                		 //检查有没有这个ID
                		 TBUnit tt=unitService.getUnitIdById(tb.getId());
                		 if(tt==null){
                			 unitService.insertUnit(tb);
                		 }
                		 ReTransBaseObject o=new ReTransBaseObject();
                		 o.setId(u.getId());
                		 o.setStatus(true);
                		 o.setMessage("插入成功");
                		 reo.getUnitList().add(o);
                	 }else if(fileItem.getFieldName().equals("dataType")){
                		 
                	 }else if(fileItem.getFieldName().equals("unitMemberList")){
                		 List<UnitMember> members=gson2.fromJson(description1, unitMemberTy);
                		 TBUnitPopulation tb=new TBUnitPopulation();
                		 for(UnitMember m:members){
                			 tb.setId(m.getId());
                			 tb.setActualLiveAddr(m.getActualLiveAddr());
                			 tb.setBirthday(m.getBirthday());
                			 tb.setBloodType(m.getBloodType());
                			 tb.setCertificateNum(m.getCertificateNum());
                			 tb.setDegreeEducation(m.getDegreeEducation());
                			 tb.setHbuildingNum(m.gethBuildingNum());
                			 tb.setHeight(m.getHeight());
                			 tb.setHfloorNum(m.gethFloorNum());
                			 tb.setHouseRegist(m.getHouseRegist());
                			 tb.setHunitNum(m.gethUnitNum());
                			 tb.setIdType(m.getIdType());
                			 //tb.setImgPersonUrl(m.getImgPersonUrl());
                			 tb.setLandLine(m.getLandLine());
                			 tb.setMaritalSta(m.getMaritalSta());
                			 tb.setMilitarySta(m.getMilitarySta());
                			 tb.setName(m.getName());
                			 tb.setNation(m.getNation());
                			 tb.setOccupation(m.getOccupation());
                			 tb.setOldName(m.getOldName());
                			 //tb.setPersonType(m.getpType());
                			 tb.setPost(m.getPost());
                			 tb.setPtype(m.getpType());
                			 tb.setQqNum(m.getQqNum());
                			 tb.setRentDate(m.getRentDate());
                			 tb.setResidenceId(m.getResidenceId());
                			 tb.setRoomNumber(m.getRoomNumber());
                			 tb.setServiceAddr(m.getServiceAddr());
                			 tb.setSex(m.getSex());
                			 tb.setTelephone(m.getTelephone());
                			 tb.setImgPersonUrl(m.getImgPersonUrl());
                			 tb.setUid(m.getUnit().getId());
                			 tb.setVersion(m.getVersion());
                			 tb.setWeChatNum(m.getWetChatNum());
                			 tb.setWorkDate(m.getWorkDate());
                			//此处写入库操作
                			 //检查库是否有
                			 TBUnitPopulation tp=unitPopulationService.findByID(tb.getId());
                			 if(tp==null){
                				 unitPopulationService.insertUnitPopulation(tb);
                			 }
                			 ReTransBaseObject o=new ReTransBaseObject();
                    		 o.setId(m.getId());
                    		 o.setStatus(true);
                    		 o.setMessage("插入成功");
                    		 reo.getUnitMemeberList().add(o);
                		 }	                		 
                		 
                	 }else if(fileItem.getFieldName().equals("house")){
                		 House h=gson2.fromJson(description1,House.class);
                		 TBHouse tb=new TBHouse();
                		 tb.setHid(h.getId());
                		 tb.setHaddr(h.getRealAddress());
                		 tb.setRealAddress(h.getRealAddress());
                		 tb.setRentType(h.getRentType());
                		 tb.setHname(h.getuName());
                		 tb.setHbuildingNum(h.gethBuildingNum());
                		 tb.setHunitNum(h.gethUnitNum());
                		 tb.setHroomNum(h.getRentalRoomNum());
                		 tb.setHfloorNum(h.gethFloorNum());
                		 tb.setHstructure(h.gethStructure());
                		 tb.setHpropertyRight(h.gethPropertyRight());
                		 tb.setHsecurityStatus(h.gethSecurityStatus());
                		 tb.setRentalTime(h.getRentalTime());
                		 tb.setRentalArea(h.getRentalArea());
                		 tb.setRentalRoomNum(h.getRentalRoomNum());
                		 tb.setRentalRoomDate(h.getRentalRoomDate());
                		 tb.setPoliceOperateArea(h.getPoliceOperateArea());
                		 tb.setOperateRow(h.getOperateRow());
                		 tb.setChargePoliceNum(h.getChargePoliceNum());
                		 tb.setLandlordId(h.getLandlordId());
                		 tb.setImageUrls(h.getImageUrls());
                		 tb.setLayoutDiagramUrl(h.getLayoutDiagramUrl());
                		 tb.setVersion(h.getVersion());
                		 //检查入库操作
                		 List<TBHouse> hlist=houseService.getHouseInfoByHId(tb.getHid());
                		 if(hlist.size()==0||hlist==null){
                			 houseService.addHouse(tb);
                		 }
            			 ReTransBaseObject o=new ReTransBaseObject();
                		 o.setId(h.getId());
                		 o.setStatus(true);
                		 o.setMessage("插入成功");
                		 reo.getHouseList().add(o);
                	 }else if(fileItem.getFieldName().equals("houseMemberList")){
                		 List<HouseMember> members=gson2.fromJson(description1, houseMemberTy);
                		 for (HouseMember m : members) {
							TBResidentPopulation tb = new TBResidentPopulation();
							tb.setId(m.getId());
							tb.setHid(m.getHouse().getId());
							tb.setPtype(m.getpType());
							tb.setName(m.getName());
							tb.setOldName(m.getOldName());
	               			tb.setSex(m.getSex());
	               			tb.setNation(m.getNation());
	               			tb.setCertificateNum(m.getCertificateNum());
	               			tb.setBirthday(m.getBirthday());
	               			tb.setDegreeEducation(m.getDegreeEducation());
	               			tb.setMaritalSta(m.getMaritalSta());
	               			tb.setMilitarySta(m.getMilitarySta());
	               			tb.setTempLiveNo(m.getTempLiveNo());
	               			tb.setRelation(m.getRelation());
	               			tb.setTempEndDateCheck(0);//0未检查
	               			tb.setTempLiveDate(m.getTempLiveDate());
	               			tb.setBloodType(m.getBloodType());
	               			tb.setHeight(m.getHeight());
	               			tb.setOccupation(m.getOccupation());
	               			tb.setPost(m.getPost());
	               			tb.setHouseRegist(m.getHouseRegist());
	               			tb.setServiceAddr(m.getServiceAddr());
	               			tb.setLandLine(m.getLandLine());
	               			tb.setActualLiveAddr(m.getActualLiveAddr());
	               			tb.setTelephone(m.getTelephone());
	               			tb.setQqNum(m.getQqNum());
	               			tb.setWeChatNum(m.getWetChatNum());
	               			tb.setImgPersonUrl(m.getImgPersonUrl());
	               			tb.setRentReason(m.getRentReason());
	               			tb.setLiveDate(m.getLiveDate());
	               			tb.setVersion(m.getVersion());
	               			tb.setPersonType(m.getPersonType());
	               			tb.setCriminal(m.getCrinimal());
	               			tb.setRentalTime(m.getRentalTime());  
	               			tb.setTempEndDateCheck(0);
	               			//check in database
	               			TBResidentPopulation tp=residentPopulationService.getTBResidentPopulationByID(tb.getId());
	               			if(tp==null){
	               				residentPopulationService.addResidentPopulation(tb);
	               			}
							 ReTransBaseObject o=new ReTransBaseObject();
	                		 o.setId(m.getId());
	                		 o.setStatus(true);
	                		 o.setMessage("插入成功");
	                		 reo.getHouseMemberList().add(o);
						}              		 
                	 }
                	// String str= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ request.getContextPath() + "/";
                	 
                }else{
                			
//                	 //获取扩展名
                    String ext = fileItem.getName().substring(fileItem.getName().lastIndexOf("."), fileItem.getName().length());
                    String fileName = System.currentTimeMillis() + ext;
                    String physicalName=this.getRenameImgName(fileItem.getName());
                    File remoteFile = new File(new String(fileItem.getName().getBytes(),"UTF-8"));
                    File  dirFile = new File(this.getServletContext().getRealPath("image"),physicalName);
                    if (!dirFile.exists())
                    {
                      dirFile.getParentFile().mkdirs();
                    }
                    try {
						fileItem.write(dirFile);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String[] splitStr=fileItem.getFieldName().split("_");
					if(splitStr.length>1){
						
						String urlStr= request.getContextPath() + "/image/"+physicalName;
						this.insertMediaFile(fileItem.getFieldName(), fileName, physicalName, fileItem.getSize(),urlStr,reo);
					}
                    out.flush();
                   }
                    
                }
            String resStr=new Gson().toJson(reo);
            System.out.println(resStr+"================");
            response.setContentType("application/json;charset=UTF-8");
            out.println(resStr);
               
           // }
        }catch(FileUploadException e){}
    }
    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
        // Put your code here
    }
    public boolean isNumeric(String str){ 
 	   Pattern pattern = Pattern.compile("[0-9.]*"); 
 	   Matcher isNum = pattern.matcher(str);
 	   if( !isNum.matches() ){
 	       return false; 
 	   } 
 	   return true; 
 	}
    public String getRenameImgName(String fileName){
    	String uuid=UUID.randomUUID().toString();
    	String[]stb=uuid.split("-");
		String newStr=stb[0]+stb[1]+stb[2]+stb[3]+stb[4];
		newStr+=fileName;
		return newStr;
    }
    public void insertMediaFile(String mediaFileStr,String fileName,String physicalName,Long length,String urlStr,ReTransObject reo){
    	String[] splitStr=mediaFileStr.split("_");
    	if(splitStr.length>1){
    		ApplicationContext cxt=SpringContext.getApplicationContext();
    		MediaFileService MediaFileService=(MediaFileService) cxt.getBean("mediaFileService");
    		UnitService unitService=(UnitService) cxt.getBean("unitService"); 
    		String id=splitStr[1];
    		String modeId=splitStr[2];
    		String source=splitStr[3];
    		String relativePathApp=splitStr[4];
    		MediaFile m=new MediaFile();
    		m.setId(id);
    		m.setModeId(modeId);
    		m.setFileName(fileName);
    		m.setSource(source);
    		m.setLength(length);
    		m.setPhysicalName(physicalName);
    		m.setRefresh(true);
    		m.setRelativePathServer(urlStr);
    		m.setRemark("");
    		m.setRelativePathApp(relativePathApp);
    		m.setValid(true);
    		m.setVersion(0);
    		MediaFile mm=unitService.findImages(id);
    		if(mm==null){
    			MediaFileService.addMediaFile(m);
    		}
			 ReTransBaseObject o=new ReTransBaseObject();
    		 o.setId(m.getId());
    		 o.setStatus(true);
    		 o.setMessage("插入成功");
    		 reo.getMediaFileList().add(o);
    	}
    }
   

}