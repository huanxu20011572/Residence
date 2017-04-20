/**    
* @Title: TBLandLordAndLegalRepresent.java  
* @Package com.haiyi.residence.model  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author yanwenyan     
* @date 2015-10-24 ����10:39:04  
* @version V1.0    
*/ 
package com.haiyi.residence.model;

import java.io.Serializable;

  
/**     
 * ��Ȩ���У�2015-yanwenyan 
 * ��Ŀ���ƣ�Residence     
 *  
 * ��������  
 * �����ƣ�com.haiyi.residence.model.TBLandLordAndLegalRepresent       
 * �����ˣ�yanwenyan  
 * ����ʱ�䣺2015-10-24 ����10:39:04     
 * �޸��ˣ�  
 * �޸�ʱ�䣺2015-10-24 ����10:39:04     
 * �޸ı�ע��     
 * @version   V1.0      
 */
/**
 * �����ͼ�ͥ��Ա�������˿���Ϣ
 
 */
public class TBResidentPopulation implements Serializable {

	/**
	 * ��Ա���
	 * PK���ɲ��ԣ�32λСд��ʽ��UUID
	 */
	private String id;
	/**
	 * ���ݱ��(����ID�����)
	 */
	private String hid;
	/**
	 * ��Ա���
	 * 1 Ϊ����  2Ϊ��ͥ  
	 */
	private Integer ptype;
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
	 * ������Ƭ
	 */
	private String imgPersonUrl;
	/**
	 * ��סʱ��
	 */
	private String rentalTime;
//	/**
//	 * ��ס����ʱ��
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
	 * �����˿ڻ��ǳ�ס�˿�
	 */
	private String personType;
	/*
	 * �Ƿ���
	 */
	private int tempEndDateCheck;
	/**  
	 * @return the tempEndDateCheck  
	 */
	/**
	 *�ص��˿�(�з����¼) 
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