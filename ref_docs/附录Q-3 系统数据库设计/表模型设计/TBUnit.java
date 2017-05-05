/**    
* @Title: TBUnit.java  
* @Package com.haiyi.residence.model  
* @Description: TODO(用一句话描述该文件做什么)  
* @author yanwenyan     
* @date 2015-10-24 下午09:50:27  
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
 * 类名称：com.haiyi.residence.model.TBUnit       
 * 创建人：yanwenyan  
 * 创建时间：2015-10-24 下午09:50:27     
 * 修改人：  
 * 修改时间：2015-10-24 下午09:50:27     
 * 修改备注：     
 * @version   V1.0      
 */
/***
 * 单位信息
 */
public class TBUnit implements Serializable {

	/**
	 * 单位ID
	 * Primary Key
	 */
	private String id;
	/**
	 * 单位名称
	 */
	private String uName;
	/**
	 * 单位地址
	 */
	private String uAddr;
	/**
	 * 经营性质
	 */
	private String uProperty;
	/**
	 * 经营范围
	 */
	private String uOperateRange;
	/**
	 * 经营面积
	 */
	private Float uOperateArea;
	/**
	 * 单位类别
	 **/
	private String uCategory;
	/**
	 * 治安负责人Id
	 */
	private String securityPersonId;
	/**
	 * 从业人数
	 */
	private Integer uPersonNum;
	/**
	 * 单位联系电话(多个用,分隔开)
	 */
	private String uTelephone;
	/**
	 * 工商执照号
	 */
	private String bussinessNum;
	/**
	 * 注册资金
	 */
	private Float regesistMoney;
	/**
	 * 注册日期
	 */
	private Date regesistTime;
	/**
	 * 有效日期至
	 */
	private Date validTime;
	/**
	 * 开业时间
	 */
	private Date openningTime;
	/**
	 * 组织结构代码
	 */
	private String orgNum;
	/**
	 * 法人代表ID号
	 */
	private String legalRepresentId;
	/**
	 * 房东ID号
	 */
	private String landlordId;
	/**
	 * 单位户型图图片URL，多个图片用;分开。不存储在数据库，我们通过在PAD上传的时候
	 * 获取图片的字节流按照这个单位的ID号加"-"加数字号（从1开始)作为图片的名称
	 * 
	 */
	private String imageUrls;
	/**  
	 * @return the id  
	 */
	public String getId() {
		return id;
	}
	/**  
	 * @param id the id to set  
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**  
	 * @return the uName  
	 */
	public String getuName() {
		return uName;
	}
	/**  
	 * @param uName the uName to set  
	 */
	public void setuName(String uName) {
		this.uName = uName;
	}
	/**  
	 * @return the uAddr  
	 */
	public String getuAddr() {
		return uAddr;
	}
	/**  
	 * @param uAddr the uAddr to set  
	 */
	public void setuAddr(String uAddr) {
		this.uAddr = uAddr;
	}
	/**  
	 * @return the uProperty  
	 */
	public String getuProperty() {
		return uProperty;
	}
	/**  
	 * @param uProperty the uProperty to set  
	 */
	public void setuProperty(String uProperty) {
		this.uProperty = uProperty;
	}
	/**  
	 * @return the uOperateRange  
	 */
	public String getuOperateRange() {
		return uOperateRange;
	}
	/**  
	 * @param uOperateRange the uOperateRange to set  
	 */
	public void setuOperateRange(String uOperateRange) {
		this.uOperateRange = uOperateRange;
	}
	/**  
	 * @return the uOperateArea  
	 */
	public Float getuOperateArea() {
		return uOperateArea;
	}
	/**  
	 * @param uOperateArea the uOperateArea to set  
	 */
	public void setuOperateArea(Float uOperateArea) {
		this.uOperateArea = uOperateArea;
	}
	/**  
	 * @return the uCategory  
	 */
	public String getuCategory() {
		return uCategory;
	}
	/**  
	 * @param uCategory the uCategory to set  
	 */
	public void setuCategory(String uCategory) {
		this.uCategory = uCategory;
	}
	/**  
	 * @return the securityPersonId  
	 */
	public String getSecurityPersonId() {
		return securityPersonId;
	}
	/**  
	 * @param securityPersonId the securityPersonId to set  
	 */
	public void setSecurityPersonId(String securityPersonId) {
		this.securityPersonId = securityPersonId;
	}
	/**  
	 * @return the uPersonNum  
	 */
	public Integer getuPersonNum() {
		return uPersonNum;
	}
	/**  
	 * @param uPersonNum the uPersonNum to set  
	 */
	public void setuPersonNum(Integer uPersonNum) {
		this.uPersonNum = uPersonNum;
	}
	/**  
	 * @return the uTelephone  
	 */
	public String getuTelephone() {
		return uTelephone;
	}
	/**  
	 * @param uTelephone the uTelephone to set  
	 */
	public void setuTelephone(String uTelephone) {
		this.uTelephone = uTelephone;
	}
	/**  
	 * @return the bussinessNum  
	 */
	public String getBussinessNum() {
		return bussinessNum;
	}
	/**  
	 * @param bussinessNum the bussinessNum to set  
	 */
	public void setBussinessNum(String bussinessNum) {
		this.bussinessNum = bussinessNum;
	}
	/**  
	 * @return the regesistMoney  
	 */
	public Float getRegesistMoney() {
		return regesistMoney;
	}
	/**  
	 * @param regesistMoney the regesistMoney to set  
	 */
	public void setRegesistMoney(Float regesistMoney) {
		this.regesistMoney = regesistMoney;
	}
	/**  
	 * @return the regesistTime  
	 */
	public Date getRegesistTime() {
		return regesistTime;
	}
	/**  
	 * @param regesistTime the regesistTime to set  
	 */
	public void setRegesistTime(Date regesistTime) {
		this.regesistTime = regesistTime;
	}
	/**  
	 * @return the validTime  
	 */
	public Date getValidTime() {
		return validTime;
	}
	/**  
	 * @param validTime the validTime to set  
	 */
	public void setValidTime(Date validTime) {
		this.validTime = validTime;
	}
	/**  
	 * @return the openningTime  
	 */
	public Date getOpenningTime() {
		return openningTime;
	}
	/**  
	 * @param openningTime the openningTime to set  
	 */
	public void setOpenningTime(Date openningTime) {
		this.openningTime = openningTime;
	}
	/**  
	 * @return the orgNum  
	 */
	public String getOrgNum() {
		return orgNum;
	}
	/**  
	 * @param orgNum the orgNum to set  
	 */
	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}
	/**  
	 * @return the legalRepresentId  
	 */
	public String getLegalRepresentId() {
		return legalRepresentId;
	}
	/**  
	 * @param legalRepresentId the legalRepresentId to set  
	 */
	public void setLegalRepresentId(String legalRepresentId) {
		this.legalRepresentId = legalRepresentId;
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
