/**    
* @Title: TBLandLordAndLegalRepresent.java  
* @Package com.haiyi.residence.model  
* @Description: TODO(用一句话描述该文件做什么)  
* @author yanwenyan     
* @date 2015-10-24 下午10:39:04  
* @version V1.0    
*/ 
package com.haiyi.residence.model;

import java.io.Serializable;

  
/**     
 * 版权所有：2015-yanwenyan 
 * 项目名称：Residence     
 *  
 * 类描述：  
 * 类名称：com.haiyi.residence.model.TBLandLordAndLegalRepresent       
 * 创建人：yanwenyan  
 * 创建时间：2015-10-24 下午10:39:04     
 * 修改人：  
 * 修改时间：2015-10-24 下午10:39:04     
 * 修改备注：     
 * @version   V1.0      
 */
/**
 * 房主和家庭成员和流动人口信息
 
 */
public class TBResidentPopulation implements Serializable {

	/**
	 * 人员编号
	 * PK生成策略：32位小写格式的UUID
	 */
	private String id;
	/**
	 * 房屋编号(房屋ID的外键)
	 */
	private String hid;
	/**
	 * 人员类别
	 * 1 为房主  2为家庭  
	 */
	private Integer ptype;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 曾用名
	 */
	private String oldName;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 民族
	 */
	private String nation;
	/**
	 * 身份证号
	 */
	private String certificateNum;
	/**
	 * 出生日期 格式：yyyy-MM-dd（APP端录入法人代表需要
	 */
	private String birthday;
	
	/**
	 * 文化程度
	 */
	private String degreeEducation;
	/**
	 * 婚姻状况
	 * 0未婚 1已婚 2 离异 
	 */
	private String maritalSta;
	/**
	 * 兵役状况
	 * 0未服 1正在服 2服起已过
	 */
	private String militarySta;
	/**
	 * 暂住编码
	 */
	private String tempLiveNo;
	/**
	 * 成员关系
	 */
	private String relation;
	/**
	 * 暂住日期
	 */
	private String tempLiveDate;
	/**
	 * 血型
	 */
	private String bloodType;
	/**
	 * 身高
	 */
	private String height;
	/**
	 * 职业
	 */
	private String occupation;

	/**
	 * 职务
	 */
	private String post;
	/**
	 * 户籍
	 */
	private String houseRegist;
	/**
	 * 服务处所
	 */
	private String serviceAddr;
	/**
	 * 固定电话
	 */
	private String landLine;
	/**
	 * 实际居住地址
	 */
	private String actualLiveAddr;
	/**
	 * 手机
	 */
	private String telephone;
	/**
	 * QQ
	 */
	private String qqNum;
	/**
	 * 微信号
	 */
	private String weChatNum;
	/**
	 * 个人照片
	 */
	private String imgPersonUrl;
	/**
	 * 租住时间
	 */
	private String rentalTime;
//	/**
//	 * 租住到期时间
//	 */
	private String tempEndDate;
	/**  
	 * @return the tempEndDate  
	 */
	public String getTempEndDate() {
		return tempEndDate;
	}
	/**  
	 * @param tempEndDate the tempEndDate to set  
	 */
	public void setTempEndDate(String tempEndDate) {
		this.tempEndDate = tempEndDate;
	}
	/**
	 * 暂住事由
	 */
	private String rentReason;	
	/**
	 * 居住时间
	 */
	private String liveDate;	
	/**
	 * 版本号
	 */
	private Integer version;
	/**
	 * 流动人口或是常住人口
	 */
	private String personType;
	/*
	 * 是否检查
	 */
	private int tempEndDateCheck;
	/**  
	 * @return the tempEndDateCheck  
	 */
	/**
	 *重点人口(有犯罪记录) 
	 */
	private String criminal;
	
	
	/**  
	 * @return the criminal  
	 */
	public String getCriminal() {
		return criminal;
	}
	/**  
	 * @param criminal the criminal to set  
	 */
	public void setCriminal(String criminal) {
		this.criminal = criminal;
	}
	public int getTempEndDateCheck() {
		return tempEndDateCheck;
	}
	/**  
	 * @param tempEndDateCheck the tempEndDateCheck to set  
	 */
	public void setTempEndDateCheck(int tempEndDateCheck) {
		this.tempEndDateCheck = tempEndDateCheck;
	}
	/**  
	 * @return the personType  
	 */
	public String getPersonType() {
		return personType;
	}
	/**  
	 * @param personType the personType to set  
	 */
	public void setPersonType(String personType) {
		this.personType = personType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	
	/**  
	 * @return the ptype  
	 */
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOldName() {
		return oldName;
	}
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	
	
	/**  
	 * @return the sex  
	 */
	public String getSex() {
		return sex;
	}
	/**  
	 * @param sex the sex to set  
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getCertificateNum() {
		return certificateNum;
	}
	public void setCertificateNum(String certificateNum) {
		this.certificateNum = certificateNum;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getDegreeEducation() {
		return degreeEducation;
	}
	public void setDegreeEducation(String degreeEducation) {
		this.degreeEducation = degreeEducation;
	}
	
	/**  
	 * @return the maritalSta  
	 */
	public String getMaritalSta() {
		return maritalSta;
	}
	/**  
	 * @param maritalSta the maritalSta to set  
	 */
	public void setMaritalSta(String maritalSta) {
		this.maritalSta = maritalSta;
	}
	/**  
	 * @return the militarySta  
	 */
	public String getMilitarySta() {
		return militarySta;
	}
	/**  
	 * @param militarySta the militarySta to set  
	 */
	public void setMilitarySta(String militarySta) {
		this.militarySta = militarySta;
	}
	public String getTempLiveNo() {
		return tempLiveNo;
	}
	public void setTempLiveNo(String tempLiveNo) {
		this.tempLiveNo = tempLiveNo;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getTempLiveDate() {
		return tempLiveDate;
	}
	public void setTempLiveDate(String tempLiveDate) {
		this.tempLiveDate = tempLiveDate;
	}
	
	/**  
	 * @return the bloodType  
	 */
	public String getBloodType() {
		return bloodType;
	}
	/**  
	 * @param bloodType the bloodType to set  
	 */
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	
	/**  
	 * @return the height  
	 */
	public String getHeight() {
		return height;
	}
	/**  
	 * @param height the height to set  
	 */
	public void setHeight(String height) {
		this.height = height;
	}
	/**  
	 * @param ptype the ptype to set  
	 */
	
	public String getOccupation() {
		return occupation;
	}
	/**  
	 * @return the ptype  
	 */
	public Integer getPtype() {
		return ptype;
	}
	/**  
	 * @param ptype the ptype to set  
	 */
	public void setPtype(Integer ptype) {
		this.ptype = ptype;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getHouseRegist() {
		return houseRegist;
	}
	public void setHouseRegist(String houseRegist) {
		this.houseRegist = houseRegist;
	}
	public String getServiceAddr() {
		return serviceAddr;
	}
	public void setServiceAddr(String serviceAddr) {
		this.serviceAddr = serviceAddr;
	}
	public String getLandLine() {
		return landLine;
	}
	public void setLandLine(String landLine) {
		this.landLine = landLine;
	}
	public String getActualLiveAddr() {
		return actualLiveAddr;
	}
	public void setActualLiveAddr(String actualLiveAddr) {
		this.actualLiveAddr = actualLiveAddr;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	/**  
	 * @return the tempEndDate  
	 */
//	public String getTempEndDate() {
//		return tempEndDate;
//	}
//	/**  
//	 * @param tempEndDate the tempEndDate to set  
//	 */
//	public void setTempEndDate(String tempEndDate) {
//		this.tempEndDate = tempEndDate;
//	}
	public String getQqNum() {
		return qqNum;
	}
	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}
	public String getWeChatNum() {
		return weChatNum;
	}
	public void setWeChatNum(String weChatNum) {
		this.weChatNum = weChatNum;
	}
	public String getImgPersonUrl() {
		return imgPersonUrl;
	}
	public void setImgPersonUrl(String imgPersonUrl) {
		this.imgPersonUrl = imgPersonUrl;
	}
	
	
	/**  
	 * @return the rentalTime  
	 */
	public String getRentalTime() {
		return rentalTime;
	}
	/**  
	 * @param rentalTime the rentalTime to set  
	 */
	public void setRentalTime(String rentalTime) {
		this.rentalTime = rentalTime;
	}
	public String getRentReason() {
		return rentReason;
	}
	public void setRentReason(String rentReason) {
		this.rentReason = rentReason;
	}
	public String getLiveDate() {
		return liveDate;
	}
	public void setLiveDate(String liveDate) {
		this.liveDate = liveDate;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
}