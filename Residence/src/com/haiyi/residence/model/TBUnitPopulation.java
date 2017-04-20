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
 * ��λԱ���͵�λ������������Ϣ
 */
public class TBUnitPopulation implements Serializable {

	/**
	 * ��Ա���(����)PK���ɲ��ԣ�32λСд��ʽ��UUID
	 */
	private String id;
	/**
	 * ��λ���    ��λID�����
	 */
	private String uid;
	/**
	 * ��Ա���
	 * 1 Ϊ����������  2Ϊ��λԱ�� 3Ϊ����
	 */
	private Integer ptype;
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
	 * ������Ƭ
	 */
	private String imgPersonUrl;

	/**
	 * �汾��
	 */
	private Integer version;
	/**
	 * �����˿ڻ��ǳ�ס�˿�
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
