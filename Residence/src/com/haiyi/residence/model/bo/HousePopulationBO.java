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
 * �����ͼ�ͥ��Ա�������˿���ϢBO��
 */
@SuppressWarnings("serial")
public class HousePopulationBO implements Serializable {
	/**
	 * ��Ա���
	 * 1 Ϊ����  2Ϊ��ͥ  
	 */
	private String ptype;
	/**
	 * ����
	 */
	private String name;
	/**
	 * ������
	 */
	private String oldName;
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
	 * �������� ��ʽ��yyyy-MM-dd��APP��¼�뷨�˴�����Ҫ
	 */
	private String birthday;
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
	 * ��ס����
	 */
	private String tempLiveNo;
	/**
	 * ��Ա��ϵ
	 */
	private String relation;
	/**
	 * ��ס����
	 */
	private String tempLiveDate;
	/**
	 * Ѫ��
	 */
	private String bloodType;
	/**
	 * ���
	 */
	private String height;
	/**
	 * ְҵ
	 */
	private String occupation;

	/**
	 * ְ��
	 */
	private String post;
	/**
	 * ����
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
	 * �ֻ�
	 */
	private String telephone;
	/**
	 * ʵ�ʾ�ס��ַ
	 */
	private String actualLiveAddr;
	/**
	 * QQ
	 */
	private String qqNum;
	/**
	 * ΢�ź�
	 */
	private String weChatNum;
	/**
	 * ��סʱ��
	 */
	private String rentalTime;
	/**
	 * ��ס����
	 */
	private String rentReason;	
	/**
	 * ��סʱ��
	 */
	private String liveDate;	
	/**
	 * �汾��
	 */
	private Integer version;
	/**
	 * ������Ƭ��ͼƬ�ֽ�����
	 */
	private byte[] imgPersonUrl;
	
	//������
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
				this.ptype = "����";
			} else {
				this.ptype = "��ͥ";
			}
			this.name = jsonObject.getString("name");
			this.oldName = jsonObject.getString("oldName");
			this.sex = jsonObject.getString("sex");
			this.nation = jsonObject.getString("nation");
			this.certificateNum = jsonObject.getString("certificateNum");
			this.birthday = jsonObject.getString("birthday");
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
	
	//get��set
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






























