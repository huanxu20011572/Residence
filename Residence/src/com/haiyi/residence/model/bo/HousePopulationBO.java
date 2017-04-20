/**    
* @Title: TBLandLordAndLegalRepresent.java  
* @Package com.haiyi.residence.model  
* @Description: TODO(用一句话描述该文件做什么)  
* @author yanwenyan     
* @date 2015-10-24 下午10:39:04  
* @version V1.0    
*/ 
package com.haiyi.residence.model.bo;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 房主和家庭成员和流动人口信息BO类
 */
@SuppressWarnings("serial")
public class HousePopulationBO implements Serializable {
	/**
	 * 人员类别
	 * 1 为房主  2为家庭  
	 */
	private String ptype;
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
	 * 0未服 1正在服 2服期已过
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
	 * 手机
	 */
	private String telephone;
	/**
	 * 实际居住地址
	 */
	private String actualLiveAddr;
	/**
	 * QQ
	 */
	private String qqNum;
	/**
	 * 微信号
	 */
	private String weChatNum;
	/**
	 * 租住时间
	 */
	private String rentalTime;
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
	 * 个人照片的图片字节数组
	 */
	private byte[] imgPersonUrl;
	
	//构造器
	public HousePopulationBO() {
		super();
	}
	public HousePopulationBO(String ptype, String name,
			String oldName, String sex, String nation,
			String certificateNum, String birthday, String degreeEducation,
			String maritalSta, String militarySta, String tempLiveNo,
			String relation, String tempLiveDate, String bloodType,
			String height, String occupation, String post, String houseRegist,
			String serviceAddr, String landLine, String telephone, 
			String actualLiveAddr, String qqNum, String weChatNum,
			String rentDate, String rentReason, String liveDate, 
			Integer version, byte[] imgPersonUrl) {
		super();
		this.ptype = ptype;
		this.name = name;
		this.oldName = oldName;
		this.sex = sex;
		this.nation = nation;
		this.certificateNum = certificateNum;
		this.birthday = birthday;
		this.degreeEducation = degreeEducation;
		this.maritalSta = maritalSta;
		this.militarySta = militarySta;
		this.tempLiveNo = tempLiveNo;
		this.relation = relation;
		this.tempLiveDate = tempLiveDate;
		this.bloodType = bloodType;
		this.height = height;
		this.occupation = occupation;
		this.post = post;
		this.houseRegist = houseRegist;
		this.serviceAddr = serviceAddr;
		this.landLine = landLine;
		this.telephone = telephone;
		this.actualLiveAddr = actualLiveAddr;
		this.qqNum = qqNum;
		this.weChatNum = weChatNum;
		this.rentalTime = rentalTime;
		this.rentReason = rentReason;
		this.liveDate = liveDate;
		this.version = version;
		this.imgPersonUrl = imgPersonUrl;
	}
	public HousePopulationBO(JSONObject jsonObject, byte[] imageByte) {
		super();
		try {
			if ("1".equals(jsonObject.getString("ptype"))) {
				this.ptype = "房主";
			} else {
				this.ptype = "家庭";
			}
			this.name = jsonObject.getString("name");
			this.oldName = jsonObject.getString("oldName");
			this.sex = jsonObject.getString("sex");
			this.nation = jsonObject.getString("nation");
			this.certificateNum = jsonObject.getString("certificateNum");
			this.birthday = jsonObject.getString("birthday");
			this.degreeEducation = jsonObject.getString("degreeEducation");
			if ("1".equals(jsonObject.getString("maritalSta"))) {
				this.maritalSta = "已婚";
			} else if ("2".equals(jsonObject.getString("maritalSta"))) {
				this.maritalSta = "离异";
			} else {
				this.maritalSta = "未婚";
			}
			if ("1".equals(jsonObject.getString("militarySta"))) {
				this.militarySta = "正在服";
			} else if ("2".equals(jsonObject.getString("militarySta"))) {
				this.militarySta = "服期已过";
			} else {
				this.militarySta = "未服";
			}
			this.tempLiveNo = jsonObject.getString("tempLiveNo");
			this.relation = jsonObject.getString("relation");
			this.tempLiveDate = jsonObject.getString("tempLiveDate");
			this.bloodType = jsonObject.getString("bloodType");
			this.height = jsonObject.getString("height");
			this.occupation = jsonObject.getString("occupation");
			this.post = jsonObject.getString("post");
			this.houseRegist = jsonObject.getString("houseRegist");
			this.serviceAddr = jsonObject.getString("serviceAddr");
			this.landLine = jsonObject.getString("landLine");
			this.telephone = jsonObject.getString("telephone");
			this.actualLiveAddr = jsonObject.getString("actualLiveAddr");
			this.qqNum = jsonObject.getString("qqNum");
			this.weChatNum = jsonObject.getString("weChatNum");
			this.rentalTime = jsonObject.getString("rentalTime");
			this.rentReason = jsonObject.getString("rentReason");
			this.liveDate = jsonObject.getString("liveDate");
			this.version = jsonObject.getInt("version");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		this.imgPersonUrl = imageByte;
	}
	
	//get、set
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
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
	public String getSex() {
		return sex;
	}
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
	public String getMaritalSta() {
		return maritalSta;
	}
	public void setMaritalSta(String maritalSta) {
		this.maritalSta = maritalSta;
	}
	public String getMilitarySta() {
		return militarySta;
	}
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
	public String getBloodType() {
		return bloodType;
	}
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getActualLiveAddr() {
		return actualLiveAddr;
	}
	public void setActualLiveAddr(String actualLiveAddr) {
		this.actualLiveAddr = actualLiveAddr;
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
	public byte[] getImgPersonUrl() {
		return imgPersonUrl;
	}
	public void setImgPersonUrl(byte[] imgPersonUrl) {
		this.imgPersonUrl = imgPersonUrl;
	}



	
}






























