/**    
* @Title: TBLandLordAndLegalRepresent.java  
* @Package com.haiyi.residence.model  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author yanwenyan     
* @date 2015-10-24 ����10:39:04  
* @version V1.0    
*/ 
package com.haiyi.residence.model.bo;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * ��λԱ���͵�λ������������ϢBO��
 */
@SuppressWarnings("serial")
public class UnitPopulationBO implements Serializable {
	/**
	 * ������
	 */
	private String hbuildingNum;
	/**
	 * ��Ԫ��
	 */
	private String hunitNum;
	/**
	 * ¥��
	 */
	private String hfloorNum;
	/**
	 * �����
	 */
	private String roomNumber;	
	/**
	 * ����
	 */
	private String name;
	/**
	 * ������
	 */
	private String oldName;
	/**
	 * �������� ��ʽ��yyyy-MM-dd��APP��¼�뷨�˴�����Ҫ
	 */
	private String birthday;
	/**
	 * �Ա�
	 */
	private String sex;
	/**
	 * ����
	 */
	private String nation;
	/**
	 * ���֤��
	 */
	private String certificateNum;
	/**
	 * �Ļ��̶�
	 */
	private String degreeEducation;
	/**
	 * ����״��
	 * 0δ�� 1�ѻ� 2 ���� 
	 */
	private String maritalSta;
	/**
	 * ����״��
	 * 0δ�� 1���ڷ� 2�����ѹ�
	 */
	private String militarySta;
	/**
	 * Ѫ��
	 */
	private String bloodType;
	/**
	 * ���
	 */
	private String height;
	/**
	 * ��������   ��ʽ��yyyy-MM-dd ��APP��¼�뷿����Ϣ��Ҫ��
	 */
	private String rentDate;	
	/**
	 * ��ҵ����
	 */
	private String workDate;	
	/**
	 * �������  1 ũ�� 2 ���� APP��¼��ְ����Ϣ��Ҫ��
	 */
	private String IdType;
	/**
	 * ��ס֤��
	 */
	private String residenceId;	
	/**
	 * ְҵ
	 */
	private String occupation;
	/**
	 * ְ��
	 */
	private String post;
	/**
	 * ������ַ
	 */
	private String houseRegist;
	/**
	 * ������
	 */
	private String serviceAddr;
	/**
	 * �̶��绰
	 */
	private String landLine;
	/**
	 * ʵ�ʾ�ס��ַ
	 */
	private String actualLiveAddr;
	/**
	 * �ֻ�
	 */
	private String telephone;
	/**
	 * QQ
	 */
	private String qqNum;
	/**
	 * ΢�ź�
	 */
	private String weChatNum;
	/**
	 * ��Ա���
	 * 1 Ϊ����������  2Ϊ��λԱ��
	 */
	private String ptype;
	/**
	 * �汾��
	 */
	private Integer version;
	/**
	 * ������Ƭ
	 */
	private byte[] imgPersonUrl;
	
	//������
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
				this.maritalSta = "�ѻ�";
			} else if ("2".equals(jsonObject.getString("maritalSta"))) {
				this.maritalSta = "����";
			} else {
				this.maritalSta = "δ��";
			}
			if ("1".equals(jsonObject.getString("militarySta"))) {
				this.militarySta = "���ڷ�";
			} else if ("2".equals(jsonObject.getString("militarySta"))) {
				this.militarySta = "�����ѹ�";
			} else {
				this.militarySta = "δ��";
			}
			this.bloodType = jsonObject.getString("bloodType");
			this.height = jsonObject.getString("height");
			this.rentDate = jsonObject.getString("rentDate");
			this.workDate = jsonObject.getString("workDate");;
			if ("1".equals(jsonObject.getString("IdType"))) {
				this.IdType = "ũ��";
			} else {
				this.IdType = "����";
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
				this.ptype = "����������";
			} else {
				this.ptype = "��λԱ��";
			}
			this.version = jsonObject.getInt("version");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		this.imgPersonUrl = imageByte;
	}
	
	//get��set
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
