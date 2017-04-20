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
 * 单位员工和单位法定代表人信息
 */
public class TBUnitPopulation implements Serializable {

	/**
	 * 人员编号(主键)PK生成策略：32位小写格式的UUID
	 */
	private String id;
	/**
	 * 单位编号    单位ID的外键
	 */
	private String uid;
	/**
	 * 人员类别
	 * 1 为法定代表人  2为单位员工 3为房主
	 */
	private Integer ptype;
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
	private String roomNumber;	
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 曾用名
	 */
	private String oldName;
	/**
	 * 出生日期 格式：yyyy-MM-dd（APP端录入法人代表需要
	 */
	private String birthday;
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
	 * 血型
	 */
	private String bloodType;
	/**
	 * 身高
	 */
	private String height;
	/**
	 * 出租日期   格式：yyyy-MM-dd （APP端录入房主信息需要）
	 */
	private String rentDate;	
	/**
	 * 从业日期
	 */
	private String workDate;	
	/**
	 * 户口类别  1 农村 2 城镇（ APP端录入职工信息需要）
	 */
	private String IdType;	
	/**
	 * 居住证号
	 */
	private String residenceId;	


	/**
	 * 职业
	 */
	private String occupation;

	/**
	 * 职务
	 */
	private String post;
	/**
	 * 户籍地址
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
	 * 版本号
	 */
	private Integer version;
	/**
	 * 流动人口或是常住人口
	 */
	private String personType;
	

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

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
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

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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

	public String getRentDate() {
		return rentDate;
	}

	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public String getResidenceId() {
		return residenceId;
	}

	public void setResidenceId(String residenceId) {
		this.residenceId = residenceId;
	}

	public String getOccupation() {
		return occupation;
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getIdType() {
		return IdType;
	}

	public void setIdType(String IdType) {
		this.IdType = IdType;
	}

}
