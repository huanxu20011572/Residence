/**    
* @Title: TBHouse.java  
* @Package com.haiyi.residence.model  
* @Description: TODO(用一句话描述该文件做什么)  
* @author yanwenyan     
* @date 2015-10-24 下午10:13:25  
* @version V1.0    
*/ 
package com.haiyi.residence.model;

import java.io.Serializable;
import java.util.Date;

  
/**     
 * 版权所有：2015-yanwenyan 
 * 项目名称：Residence     
 *  
 * 类描述：  
 * 类名称：com.haiyi.residence.model.TBHouse       
 * 创建人：yanwenyan  
 * 创建时间：2015-10-24 下午10:13:25     
 * 修改人：  
 * 修改时间：2015-10-24 下午10:13:25     
 * 修改备注：     
 * @version   V1.0      
 */
/**
 * 住房信息
 */
public class TBHouse implements Serializable {

	/**
	 * 房屋信息ID号
	 * Primary Key
	 */
	private String hid;
	/**
	 * 房子地址信息
	 */
	private String haddr;
	/**
	 * 房屋名称 小区名称
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
	private String rentalTime;
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
	private String rentalRoomDate;
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
	 * 房子图片URL，多个图片用;分开。不存储在数据库，我们通过在PAD上传的时候
	 * 获取图片的字节流按照这个单位的ID号加"-"加数字号（从1开始)作为图片的名称
	 * 
	 */
	private String imageUrls;
	
	/**
	 * 房屋户型画图
	 */
	private String layoutDiagramUrl;
	
	/**
	 * 版本号
	 */
	private Integer version;
	
	
	private String rentType;
	
	private String realAddress;

	public String getRentType() {
		return rentType;
	}

	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	public String getRealAddress() {
		return realAddress;
	}

	public void setRealAddress(String realAddress) {
		this.realAddress = realAddress;
	}

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

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

	public String getRentalTime() {
		return rentalTime;
	}

	public void setRentalTime(String rentalTime) {
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

	public String getRentalRoomDate() {
		return rentalRoomDate;
	}

	public void setRentalRoomDate(String rentalRoomDate) {
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

	public String getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(String imageUrls) {
		this.imageUrls = imageUrls;
	}

	public String getLayoutDiagramUrl() {
		return layoutDiagramUrl;
	}

	public void setLayoutDiagramUrl(String layoutDiagramUrl) {
		this.layoutDiagramUrl = layoutDiagramUrl;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}


}
