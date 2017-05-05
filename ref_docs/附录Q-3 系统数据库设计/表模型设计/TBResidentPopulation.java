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
 * ���������͵�λ������������Ϣ
 */
public class TBResidentPopulation implements Serializable {

	/**
	 * ��Ա���
	 */
	private String id;
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
	private Character sex;
	/**
	 * ����
	 */
	private String nation;
	/**
	 * ���֤��
	 */
	private String idNumber;
	/**
	 * �Ļ��̶�
	 */
	private String degreeEducation;
	/**
	 * ����״��
	 * 0δ�� 1�ѻ� 2 ���� 
	 */
	private Character maritalSta;
	/**
	 * ����״��
	 * 0δ�� 1���ڷ� 2�����ѹ�
	 */
	private Character militarySta;
	/**
	 * Ѫ��
	 * 
	 */
	private Character bloodType;
	/**
	 * ���
	 */
	private Float height;
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
	 * ��Ա���
	 * 1 Ϊ����  2Ϊ��ͥ�˿�  3Ϊ�����˿�
	 */
	private Integer pType;
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
	 * @return the name  
	 */
	public String getName() {
		return name;
	}
	/**  
	 * @param name the name to set  
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**  
	 * @return the oldName  
	 */
	public String getOldName() {
		return oldName;
	}
	/**  
	 * @param oldName the oldName to set  
	 */
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	/**  
	 * @return the sex  
	 */
	public Character getSex() {
		return sex;
	}
	/**  
	 * @param sex the sex to set  
	 */
	public void setSex(Character sex) {
		this.sex = sex;
	}
	/**  
	 * @return the nation  
	 */
	public String getNation() {
		return nation;
	}
	/**  
	 * @param nation the nation to set  
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}
	/**  
	 * @return the idNumber  
	 */
	public String getIdNumber() {
		return idNumber;
	}
	/**  
	 * @param idNumber the idNumber to set  
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	/**  
	 * @return the degreeEducation  
	 */
	public String getDegreeEducation() {
		return degreeEducation;
	}
	/**  
	 * @param degreeEducation the degreeEducation to set  
	 */
	public void setDegreeEducation(String degreeEducation) {
		this.degreeEducation = degreeEducation;
	}
	/**  
	 * @return the maritalSta  
	 */
	public Character getMaritalSta() {
		return maritalSta;
	}
	/**  
	 * @param maritalSta the maritalSta to set  
	 */
	public void setMaritalSta(Character maritalSta) {
		this.maritalSta = maritalSta;
	}
	/**  
	 * @return the militarySta  
	 */
	public Character getMilitarySta() {
		return militarySta;
	}
	/**  
	 * @param militarySta the militarySta to set  
	 */
	public void setMilitarySta(Character militarySta) {
		this.militarySta = militarySta;
	}
	/**  
	 * @return the bloodType  
	 */
	public Character getBloodType() {
		return bloodType;
	}
	/**  
	 * @param bloodType the bloodType to set  
	 */
	public void setBloodType(Character bloodType) {
		this.bloodType = bloodType;
	}
	/**  
	 * @return the height  
	 */
	public Float getHeight() {
		return height;
	}
	/**  
	 * @param height the height to set  
	 */
	public void setHeight(Float height) {
		this.height = height;
	}
	/**  
	 * @return the occupation  
	 */
	public String getOccupation() {
		return occupation;
	}
	/**  
	 * @param occupation the occupation to set  
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	/**  
	 * @return the post  
	 */
	public String getPost() {
		return post;
	}
	/**  
	 * @param post the post to set  
	 */
	public void setPost(String post) {
		this.post = post;
	}
	/**  
	 * @return the houseRegist  
	 */
	public String getHouseRegist() {
		return houseRegist;
	}
	/**  
	 * @param houseRegist the houseRegist to set  
	 */
	public void setHouseRegist(String houseRegist) {
		this.houseRegist = houseRegist;
	}
	/**  
	 * @return the serviceAddr  
	 */
	public String getServiceAddr() {
		return serviceAddr;
	}
	/**  
	 * @param serviceAddr the serviceAddr to set  
	 */
	public void setServiceAddr(String serviceAddr) {
		this.serviceAddr = serviceAddr;
	}
	/**  
	 * @return the pType  
	 */
	public Integer getpType() {
		return pType;
	}
	/**  
	 * @param pType the pType to set  
	 */
	public void setpType(Integer pType) {
		this.pType = pType;
	}
	/**  
	 * @return the landLine  
	 */
	public String getLandLine() {
		return landLine;
	}
	/**  
	 * @param landLine the landLine to set  
	 */
	public void setLandLine(String landLine) {
		this.landLine = landLine;
	}
	/**  
	 * @return the actualLiveAddr  
	 */
	public String getActualLiveAddr() {
		return actualLiveAddr;
	}
	/**  
	 * @param actualLiveAddr the actualLiveAddr to set  
	 */
	public void setActualLiveAddr(String actualLiveAddr) {
		this.actualLiveAddr = actualLiveAddr;
	}
	/**  
	 * @return the telephone  
	 */
	public String getTelephone() {
		return telephone;
	}
	/**  
	 * @param telephone the telephone to set  
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**  
	 * @return the qqNum  
	 */
	public String getQqNum() {
		return qqNum;
	}
	/**  
	 * @param qqNum the qqNum to set  
	 */
	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}
	/**  
	 * @return the weChatNum  
	 */
	public String getWeChatNum() {
		return weChatNum;
	}
	/**  
	 * @param weChatNum the weChatNum to set  
	 */
	public void setWeChatNum(String weChatNum) {
		this.weChatNum = weChatNum;
	}
	/**  
	 * @return the imgPersonUrl  
	 */
	public String getImgPersonUrl() {
		return imgPersonUrl;
	}
	/**  
	 * @param imgPersonUrl the imgPersonUrl to set  
	 */
	public void setImgPersonUrl(String imgPersonUrl) {
		this.imgPersonUrl = imgPersonUrl;
	}
	
}
