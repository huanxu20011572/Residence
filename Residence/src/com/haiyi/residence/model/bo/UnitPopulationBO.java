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
 * 单位员工和单位法定代表人信息BO类
 */
@SuppressWarnings("serial")
public class UnitPopulationBO implements Serializable {
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
	 * 0未服 1正在服 2服期已过
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
	 * 人员类别
	 * 1 为法定代表人  2为单位员工
	 */
	private String ptype;
	/**
	 * 版本号
	 */
	private Integer version;
	/**
	 * 个人照片
	 */
	private byte[] imgPersonUrl;
	
	//构造器
	public UnitPopulationBO() {
		super();
	}
	public UnitPopulationBO(String hbuildingNum, String hunitNum, 
			String hfloorNum, String roomNumber, String name, 
			String oldName, String birthday, String sex, 
			String nation, String certificateNum, 
			String degreeEducation, String maritalSta, String militarySta,
			String bloodType, String height, String rentDate,
			String workDate, String IdType, String residenceId,
			String occupation, String post, String houseRegist,
			String serviceAddr, String landLine, String actualLiveAddr,
			String telephone, String qqNum, String weChatNum, String ptype, Integer version,
			byte[] imgPersonUrl) {
		super();
		this.ptype = ptype;
		this.hbuildingNum = hbuildingNum;
		this.hunitNum = hunitNum;
		this.hfloorNum = hfloorNum;
		this.roomNumber = roomNumber;
		this.name = name;
		this.oldName = oldName;
		this.birthday = birthday;
		this.sex = sex;
		this.nation = nation;
		this.certificateNum = certificateNum;
		this.degreeEducation = degreeEducation;
		this.maritalSta = maritalSta;
		this.militarySta = militarySta;
		this.bloodType = bloodType;
		this.height = height;
		this.rentDate = rentDate;
		this.workDate = workDate;
		this.IdType = IdType;
		this.residenceId = residenceId;
		this.occupation = occupation;
		this.post = post;
		this.houseRegist = houseRegist;
		this.serviceAddr = serviceAddr;
		this.landLine = landLine;
		this.actualLiveAddr = actualLiveAddr;
		this.telephone = telephone;
		this.qqNum = qqNum;
		this.weChatNum = weChatNum;
		this.version = version;
		this.imgPersonUrl = imgPersonUrl;
	}
	public UnitPopulationBO(JSONObject jsonObject, byte[] imageByte) {
		super();
		try {
			this.hbuildingNum = jsonObject.getString("hbuildingNum");
			this.hunitNum = jsonObject.getString("hunitNum");
			this.hfloorNum = jsonObject.getString("hfloorNum");
			this.roomNumber = jsonObject.getString("roomNumber");
			this.name = jsonObject.getString("name");
			this.oldName = jsonObject.getString("oldName");
			this.birthday = jsonObject.getString("birthday");
			this.sex = jsonObject.getString("sex");
			this.nation = jsonObject.getString("nation");
			this.certificateNum = jsonObject.getString("certificateNum");
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
			this.bloodType = jsonObject.getString("bloodType");
			this.height = jsonObject.getString("height");
			this.rentDate = jsonObject.getString("rentDate");
			this.workDate = jsonObject.getString("workDate");;
			if ("1".equals(jsonObject.getString("IdType"))) {
				this.IdType = "农村";
			} else {
				this.IdType = "城镇";
			}
			this.residenceId = jsonObject.getString("residenceId");
			this.occupation = jsonObject.getString("occupation");
			this.post = jsonObject.getString("post");
			this.houseRegist = jsonObject.getString("houseRegist");
			this.serviceAddr = jsonObject.getString("serviceAddr");
			this.landLine = jsonObject.getString("landLine");
			this.actualLiveAddr = jsonObject.getString("actualLiveAddr");
			this.telephone = jsonObject.getString("telephone");
			this.qqNum = jsonObject.getString("qqNum");
			this.weChatNum = jsonObject.getString("weChatNum");
			if ("1".equals(jsonObject.getString("ptype"))) {
				this.ptype = "法定代表人";
			} else {
				this.ptype = "单位员工";
			}
			this.version = jsonObject.getInt("version");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		this.imgPersonUrl = imageByte;
	}
	
	//get、set
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
	public String getIdType() {
		return IdType;
	}
	public void setIdType(String idType) {
		IdType = idType;
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
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
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
