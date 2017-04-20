/**    
* @Title: TBHouse.java  
* @Package com.haiyi.residence.model  
* @Description: TODO(用一句话描述该文件做什么)  
* @author yanwenyan     
* @date 2015-10-24 下午10:13:25  
* @version V1.0    
*/ 
package com.haiyi.residence.model.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 住房信息BO类
 */
@SuppressWarnings("serial")
public class HouseBO implements Serializable {
	/**
	 * 房子地址信息
	 */
	private String haddr;
	/**
	 * 房屋名称
	 */
	private String hname;
	/**
	 * 房栋号
	 */
	private String hbuildingNum;
	/**
	 * 单元号
	 */
	private String hunitNum;
	/**
	 * 楼层
	 */
	private String hfloorNum;
	/**
	 * 房间号
	 */
	private String hroomNum;
	/**
	 * 房屋结构
	 */
	private String hstructure;
	/**
	 * 产权性质
	 */
	private String hpropertyRight;
	/**
	 * 安全状况
	 */
	private String hsecurityStatus;
	/**
	 * 出租时间
	 */
	private Date rentalTime;
	/**
	 * 出租面积
	 */
	private String rentalArea;
	/**
	 * 出租间数
	 */
	private String rentalRoomNum;
	/**
	 * 出租日期
	 */
	private Date rentalRoomDate;
	/**
	 * 警务负责区
	 */
	private String policeOperateArea;
	/**
	 * 委组
	 */
	private String operateRow;
	/**
	 * 责任区民警编号
	 */
	private String chargePoliceNum;
	/**
	 * 房主ID号
	 */
	private String landlordId;
	/**
	 * 版本号
	 */
	private Integer version;
	/**
	 * 房屋户型画图的图片字节数组
	 */
	private byte[] layoutDiagramImage;
	/**
	 * 房屋户型图片的字节数组列表
	 */
	private List<byte[]> images;

	//构造器
	public HouseBO() {
		super();
	}
	public HouseBO(String hAddr, String hName, String hBuildingNum,
			String hUnitNum, String hFloorNum, String hRoomNum,
			String hStructure, String hPropertyRight, String hSecurityStatus,
			Date rentalTime, String rentalArea, String rentalRoomNum,
			Date rentalRoomDate, String policeOperateArea, String operateRow,
			String chargePoliceNum, String landlordId, Integer version, 
			byte[] layoutDiagramImage, List<byte[]> images) {
		super();
		this.haddr = hAddr;
		this.hname = hName;
		this.hbuildingNum = hBuildingNum;
		this.hunitNum = hUnitNum;
		this.hfloorNum = hFloorNum;
		this.hroomNum = hRoomNum;
		this.hstructure = hStructure;
		this.hpropertyRight = hPropertyRight;
		this.hsecurityStatus = hSecurityStatus;
		this.rentalTime = rentalTime;
		this.rentalArea = rentalArea;
		this.rentalRoomNum = rentalRoomNum;
		this.rentalRoomDate = rentalRoomDate;
		this.policeOperateArea = policeOperateArea;
		this.operateRow = operateRow;
		this.chargePoliceNum = chargePoliceNum;
		this.landlordId = landlordId;
		this.version = version;
		this.layoutDiagramImage = layoutDiagramImage;
		this.images = images;
	}
	public HouseBO(JSONObject jsonObject, byte[] imageByte, List<byte[]> imageByteList) {
		super();
		try {
			this.haddr = jsonObject.getString("haddr");
			this.hname = jsonObject.getString("hname");
			this.hbuildingNum = jsonObject.getString("hbuildingNum");
			this.hunitNum = jsonObject.getString("hunitNum");
			this.hfloorNum = jsonObject.getString("hfloorNum");
			this.hroomNum = jsonObject.getString("hroomNum");
			this.hstructure = jsonObject.getString("hstructure");
			this.hpropertyRight = jsonObject.getString("hpropertyRight");
			this.hsecurityStatus = jsonObject.getString("hsecurityStatus");
			this.rentalTime = new Date();
			this.rentalArea =jsonObject.getString("rentalArea");
			this.rentalRoomNum = jsonObject.getString("rentalRoomNum");
			this.rentalRoomDate = new Date();
			this.policeOperateArea = jsonObject.getString("policeOperateArea");
			this.operateRow = jsonObject.getString("operateRow");
			this.chargePoliceNum = jsonObject.getString("chargePoliceNum");
			this.landlordId = jsonObject.getString("landlordId");
			this.version = jsonObject.getInt("version");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		this.layoutDiagramImage = imageByte;
		this.images = imageByteList;
	}
	

	//get、set
	public String getHaddr() {
		return haddr;
	}
	public void setHaddr(String haddr) {
		this.haddr = haddr;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getHbuildingNum() {
		return hbuildingNum;
	}
	public void setHbuildingNum(String hbuildingNum) {
		this.hbuildingNum = hbuildingNum;
	}
	public String getHunitNum() {
		return hunitNum;
	}
	public void setHunitNum(String hunitNum) {
		this.hunitNum = hunitNum;
	}
	public String getHfloorNum() {
		return hfloorNum;
	}
	public void setHfloorNum(String hfloorNum) {
		this.hfloorNum = hfloorNum;
	}
	public String getHroomNum() {
		return hroomNum;
	}
	public void setHroomNum(String hroomNum) {
		this.hroomNum = hroomNum;
	}
	public String getHstructure() {
		return hstructure;
	}
	public void setHstructure(String hstructure) {
		this.hstructure = hstructure;
	}
	public String getHpropertyRight() {
		return hpropertyRight;
	}
	public void setHpropertyRight(String hpropertyRight) {
		this.hpropertyRight = hpropertyRight;
	}
	public String getHsecurityStatus() {
		return hsecurityStatus;
	}
	public void setHsecurityStatus(String hsecurityStatus) {
		this.hsecurityStatus = hsecurityStatus;
	}
	public Date getRentalTime() {
		return rentalTime;
	}
	public void setRentalTime(Date rentalTime) {
		this.rentalTime = rentalTime;
	}
	
	/**  
	 * @return the rentalArea  
	 */
	public String getRentalArea() {
		return rentalArea;
	}
	/**  
	 * @param rentalArea the rentalArea to set  
	 */
	public void setRentalArea(String rentalArea) {
		this.rentalArea = rentalArea;
	}
	
	/**  
	 * @return the rentalRoomNum  
	 */
	public String getRentalRoomNum() {
		return rentalRoomNum;
	}
	/**  
	 * @param rentalRoomNum the rentalRoomNum to set  
	 */
	public void setRentalRoomNum(String rentalRoomNum) {
		this.rentalRoomNum = rentalRoomNum;
	}
	public Date getRentalRoomDate() {
		return rentalRoomDate;
	}
	public void setRentalRoomDate(Date rentalRoomDate) {
		this.rentalRoomDate = rentalRoomDate;
	}
	public String getPoliceOperateArea() {
		return policeOperateArea;
	}
	public void setPoliceOperateArea(String policeOperateArea) {
		this.policeOperateArea = policeOperateArea;
	}
	public String getOperateRow() {
		return operateRow;
	}
	public void setOperateRow(String operateRow) {
		this.operateRow = operateRow;
	}
	public String getChargePoliceNum() {
		return chargePoliceNum;
	}
	public void setChargePoliceNum(String chargePoliceNum) {
		this.chargePoliceNum = chargePoliceNum;
	}
	public String getLandlordId() {
		return landlordId;
	}
	public void setLandlordId(String landlordId) {
		this.landlordId = landlordId;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public byte[] getLayoutDiagramImage() {
		return layoutDiagramImage;
	}
	public void setLayoutDiagramImage(byte[] layoutDiagramImage) {
		this.layoutDiagramImage = layoutDiagramImage;
	}
	public List<byte[]> getImages() {
		return images;
	}
	public void setImages(List<byte[]> images) {
		this.images = images;
	}

}
