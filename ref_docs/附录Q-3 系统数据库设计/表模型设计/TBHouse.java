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
	private String hId;
	/**
	 * 房子地址信息
	 */
	private String hAddr;
	/**
	 * 房栋号
	 */
	private String hBuildingNum;
	/**
	 * 单元号
	 */
	private String hUnitNum;
	/**
	 * 楼层
	 */
	private String hFloorNum;
	/**
	 * 房间号
	 */
	private String hRoomNum;
	/**
	 * 房屋结构
	 */
	private String hStructure;
	/**
	 * 产权性质
	 */
	private String hPropertyRight;
	/**
	 * 安全状况
	 */
	private String hSecurityStatus;
	/**
	 * 出租时间
	 */
	private Date rentalTime;
	/**
	 * 出租面积
	 */
	private Float rentalArea;
	/**
	 * 出租间数
	 */
	private Integer rentalRoomNum;
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
	 * 房子图片URL，多个图片用;分开。不存储在数据库，我们通过在PAD上传的时候
	 * 获取图片的字节流按照这个单位的ID号加"-"加数字号（从1开始)作为图片的名称
	 * 
	 */
	private String imageUrls;
	/**  
	 * @return the hId  
	 */
	public String gethId() {
		return hId;
	}
	/**  
	 * @param hId the hId to set  
	 */
	public void sethId(String hId) {
		this.hId = hId;
	}
	/**  
	 * @return the hAddr  
	 */
	public String gethAddr() {
		return hAddr;
	}
	/**  
	 * @param hAddr the hAddr to set  
	 */
	public void sethAddr(String hAddr) {
		this.hAddr = hAddr;
	}
	/**  
	 * @return the hBuildingNum  
	 */
	public String gethBuildingNum() {
		return hBuildingNum;
	}
	/**  
	 * @param hBuildingNum the hBuildingNum to set  
	 */
	public void sethBuildingNum(String hBuildingNum) {
		this.hBuildingNum = hBuildingNum;
	}
	/**  
	 * @return the hUnitNum  
	 */
	public String gethUnitNum() {
		return hUnitNum;
	}
	/**  
	 * @param hUnitNum the hUnitNum to set  
	 */
	public void sethUnitNum(String hUnitNum) {
		this.hUnitNum = hUnitNum;
	}
	/**  
	 * @return the hFloorNum  
	 */
	public String gethFloorNum() {
		return hFloorNum;
	}
	/**  
	 * @param hFloorNum the hFloorNum to set  
	 */
	public void sethFloorNum(String hFloorNum) {
		this.hFloorNum = hFloorNum;
	}
	/**  
	 * @return the hRoomNum  
	 */
	public String gethRoomNum() {
		return hRoomNum;
	}
	/**  
	 * @param hRoomNum the hRoomNum to set  
	 */
	public void sethRoomNum(String hRoomNum) {
		this.hRoomNum = hRoomNum;
	}
	/**  
	 * @return the hStructure  
	 */
	public String gethStructure() {
		return hStructure;
	}
	/**  
	 * @param hStructure the hStructure to set  
	 */
	public void sethStructure(String hStructure) {
		this.hStructure = hStructure;
	}
	/**  
	 * @return the hPropertyRight  
	 */
	public String gethPropertyRight() {
		return hPropertyRight;
	}
	/**  
	 * @param hPropertyRight the hPropertyRight to set  
	 */
	public void sethPropertyRight(String hPropertyRight) {
		this.hPropertyRight = hPropertyRight;
	}
	/**  
	 * @return the hSecurityStatus  
	 */
	public String gethSecurityStatus() {
		return hSecurityStatus;
	}
	/**  
	 * @param hSecurityStatus the hSecurityStatus to set  
	 */
	public void sethSecurityStatus(String hSecurityStatus) {
		this.hSecurityStatus = hSecurityStatus;
	}
	/**  
	 * @return the rentalTime  
	 */
	public Date getRentalTime() {
		return rentalTime;
	}
	/**  
	 * @param rentalTime the rentalTime to set  
	 */
	public void setRentalTime(Date rentalTime) {
		this.rentalTime = rentalTime;
	}
	/**  
	 * @return the rentalArea  
	 */
	public Float getRentalArea() {
		return rentalArea;
	}
	/**  
	 * @param rentalArea the rentalArea to set  
	 */
	public void setRentalArea(Float rentalArea) {
		this.rentalArea = rentalArea;
	}
	/**  
	 * @return the rentalRoomNum  
	 */
	public Integer getRentalRoomNum() {
		return rentalRoomNum;
	}
	/**  
	 * @param rentalRoomNum the rentalRoomNum to set  
	 */
	public void setRentalRoomNum(Integer rentalRoomNum) {
		this.rentalRoomNum = rentalRoomNum;
	}
	/**  
	 * @return the rentalRoomDate  
	 */
	public Date getRentalRoomDate() {
		return rentalRoomDate;
	}
	/**  
	 * @param rentalRoomDate the rentalRoomDate to set  
	 */
	public void setRentalRoomDate(Date rentalRoomDate) {
		this.rentalRoomDate = rentalRoomDate;
	}
	/**  
	 * @return the policeOperateArea  
	 */
	public String getPoliceOperateArea() {
		return policeOperateArea;
	}
	/**  
	 * @param policeOperateArea the policeOperateArea to set  
	 */
	public void setPoliceOperateArea(String policeOperateArea) {
		this.policeOperateArea = policeOperateArea;
	}
	/**  
	 * @return the operateRow  
	 */
	public String getOperateRow() {
		return operateRow;
	}
	/**  
	 * @param operateRow the operateRow to set  
	 */
	public void setOperateRow(String operateRow) {
		this.operateRow = operateRow;
	}
	/**  
	 * @return the chargePoliceNum  
	 */
	public String getChargePoliceNum() {
		return chargePoliceNum;
	}
	/**  
	 * @param chargePoliceNum the chargePoliceNum to set  
	 */
	public void setChargePoliceNum(String chargePoliceNum) {
		this.chargePoliceNum = chargePoliceNum;
	}
	/**  
	 * @return the landlordId  
	 */
	public String getLandlordId() {
		return landlordId;
	}
	/**  
	 * @param landlordId the landlordId to set  
	 */
	public void setLandlordId(String landlordId) {
		this.landlordId = landlordId;
	}
	/**  
	 * @return the imageUrls  
	 */
	public String getImageUrls() {
		return imageUrls;
	}
	/**  
	 * @param imageUrls the imageUrls to set  
	 */
	public void setImageUrls(String imageUrls) {
		this.imageUrls = imageUrls;
	}
	
}
