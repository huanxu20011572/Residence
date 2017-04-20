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
	private String uname;
	/**
	 * 单位地址
	 */
	private String uaddr;
	/**
	 * 经营性质
	 */
	private String uproperty;
	/**
	 * 经营范围
	 */
	private String uoperateRange;
	/**
	 * 经营面积
	 */
	private String uoperateArea;
	/**
	 * 租金
	 */
	private String rent;
	/**
	 * 联系电话
	 **/
	private String LinkNumber;
	/**
	 * 单位类别
	 **/
	private String ucategory;

	/**
	 * 治安负责人Id
	 */
	private String securityPersonId;
	/**
	 * 从业人数
	 */
	private String upersonNum;
	/**
	 * 单位联系电话(多个用,分隔开)
	 */
	private String utelephone;
	/**
	 * 工商执照号
	 */
	private String bussinessNum;
	/**
	 * 注册资金
	 */
	private String regesistMoney;
	/**
	 * 注册日期
	 */
	private String regesistTime;
	/**
	 * 开业时间
	 */
	private String openningTime;
	/**
	 * 有效日期至
	 */
	private String closeTime; 
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
	 */
	private String imageUrls;
	/**
	 * 单位户型画图
	 */
	private String layoutDiagramUrl;
	/**
	 * 版本号
	 */
	private Integer version;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUaddr() {
		return uaddr;
	}
	public void setUaddr(String uaddr) {
		this.uaddr = uaddr;
	}
	public String getUproperty() {
		return uproperty;
	}
	public void setUproperty(String uproperty) {
		this.uproperty = uproperty;
	}
	public String getUoperateRange() {
		return uoperateRange;
	}
	public void setUoperateRange(String uoperateRange) {
		this.uoperateRange = uoperateRange;
	}
	
	/**  
	 * @return the uoperateArea  
	 */
	public String getUoperateArea() {
		return uoperateArea;
	}
	/**  
	 * @param uoperateArea the uoperateArea to set  
	 */
	public void setUoperateArea(String uoperateArea) {
		this.uoperateArea = uoperateArea;
	}
	/**  
	 * @return the rent  
	 */
	public String getRent() {
		return rent;
	}
	/**  
	 * @param rent the rent to set  
	 */
	public void setRent(String rent) {
		this.rent = rent;
	}
	/**  
	 * @param regesistMoney the regesistMoney to set  
	 */
	public void setRegesistMoney(String regesistMoney) {
		this.regesistMoney = regesistMoney;
	}
	public String getLinkNumber() {
		return LinkNumber;
	}
	public void setLinkNumber(String linkNumber) {
		LinkNumber = linkNumber;
	}
	public String getUcategory() {
		return ucategory;
	}
	public void setUcategory(String ucategory) {
		this.ucategory = ucategory;
	}
	public String getSecurityPersonId() {
		return securityPersonId;
	}
	public void setSecurityPersonId(String securityPersonId) {
		this.securityPersonId = securityPersonId;
	}
	
	/**  
	 * @return the upersonNum  
	 */
	public String getUpersonNum() {
		return upersonNum;
	}
	/**  
	 * @param upersonNum the upersonNum to set  
	 */
	public void setUpersonNum(String upersonNum) {
		this.upersonNum = upersonNum;
	}
	public String getUtelephone() {
		return utelephone;
	}
	public void setUtelephone(String utelephone) {
		this.utelephone = utelephone;
	}
	public String getBussinessNum() {
		return bussinessNum;
	}
	public void setBussinessNum(String bussinessNum) {
		this.bussinessNum = bussinessNum;
	}
	
	/**  
	 * @return the regesistMoney  
	 */
	public String getRegesistMoney() {
		return regesistMoney;
	}
	public String getRegesistTime() {
		return regesistTime;
	}
	public void setRegesistTime(String regesistTime) {
		this.regesistTime = regesistTime;
	}
	public String getOpenningTime() {
		return openningTime;
	}
	public void setOpenningTime(String openningTime) {
		this.openningTime = openningTime;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	public String getOrgNum() {
		return orgNum;
	}
	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}
	public String getLegalRepresentId() {
		return legalRepresentId;
	}
	public void setLegalRepresentId(String legalRepresentId) {
		this.legalRepresentId = legalRepresentId;
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
