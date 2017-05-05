/**    
* @Title: TBUnit.java  
* @Package com.haiyi.residence.model  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author yanwenyan     
* @date 2015-10-24 ����09:50:27  
* @version V1.0    
*/ 
package com.haiyi.residence.model;

import java.io.Serializable;
import java.util.Date;

  
/**     
 * ��Ȩ���У�2015-yanwenyan 
 * ��Ŀ���ƣ�Residence     
 *  
 * ��������  
 * �����ƣ�com.haiyi.residence.model.TBUnit       
 * �����ˣ�yanwenyan  
 * ����ʱ�䣺2015-10-24 ����09:50:27     
 * �޸��ˣ�  
 * �޸�ʱ�䣺2015-10-24 ����09:50:27     
 * �޸ı�ע��     
 * @version   V1.0      
 */
/***
 * ��λ��Ϣ
 */
public class TBUnit implements Serializable {

	/**
	 * ��λID
	 * Primary Key
	 */
	private String id;
	/**
	 * ��λ����
	 */
	private String uName;
	/**
	 * ��λ��ַ
	 */
	private String uAddr;
	/**
	 * ��Ӫ����
	 */
	private String uProperty;
	/**
	 * ��Ӫ��Χ
	 */
	private String uOperateRange;
	/**
	 * ��Ӫ���
	 */
	private Float uOperateArea;
	/**
	 * ��λ���
	 **/
	private String uCategory;
	/**
	 * �ΰ�������Id
	 */
	private String securityPersonId;
	/**
	 * ��ҵ����
	 */
	private Integer uPersonNum;
	/**
	 * ��λ��ϵ�绰(�����,�ָ���)
	 */
	private String uTelephone;
	/**
	 * ����ִ�պ�
	 */
	private String bussinessNum;
	/**
	 * ע���ʽ�
	 */
	private Float regesistMoney;
	/**
	 * ע������
	 */
	private Date regesistTime;
	/**
	 * ��Ч������
	 */
	private Date validTime;
	/**
	 * ��ҵʱ��
	 */
	private Date openningTime;
	/**
	 * ��֯�ṹ����
	 */
	private String orgNum;
	/**
	 * ���˴���ID��
	 */
	private String legalRepresentId;
	/**
	 * ����ID��
	 */
	private String landlordId;
	/**
	 * ��λ����ͼͼƬURL�����ͼƬ��;�ֿ������洢�����ݿ⣬����ͨ����PAD�ϴ���ʱ��
	 * ��ȡͼƬ���ֽ������������λ��ID�ż�"-"�����ֺţ���1��ʼ)��ΪͼƬ������
	 * 
	 */
	private String imageUrls;
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
	 * @return the uName  
	 */
	public String getuName() {
		return uName;
	}
	/**  
	 * @param uName the uName to set  
	 */
	public void setuName(String uName) {
		this.uName = uName;
	}
	/**  
	 * @return the uAddr  
	 */
	public String getuAddr() {
		return uAddr;
	}
	/**  
	 * @param uAddr the uAddr to set  
	 */
	public void setuAddr(String uAddr) {
		this.uAddr = uAddr;
	}
	/**  
	 * @return the uProperty  
	 */
	public String getuProperty() {
		return uProperty;
	}
	/**  
	 * @param uProperty the uProperty to set  
	 */
	public void setuProperty(String uProperty) {
		this.uProperty = uProperty;
	}
	/**  
	 * @return the uOperateRange  
	 */
	public String getuOperateRange() {
		return uOperateRange;
	}
	/**  
	 * @param uOperateRange the uOperateRange to set  
	 */
	public void setuOperateRange(String uOperateRange) {
		this.uOperateRange = uOperateRange;
	}
	/**  
	 * @return the uOperateArea  
	 */
	public Float getuOperateArea() {
		return uOperateArea;
	}
	/**  
	 * @param uOperateArea the uOperateArea to set  
	 */
	public void setuOperateArea(Float uOperateArea) {
		this.uOperateArea = uOperateArea;
	}
	/**  
	 * @return the uCategory  
	 */
	public String getuCategory() {
		return uCategory;
	}
	/**  
	 * @param uCategory the uCategory to set  
	 */
	public void setuCategory(String uCategory) {
		this.uCategory = uCategory;
	}
	/**  
	 * @return the securityPersonId  
	 */
	public String getSecurityPersonId() {
		return securityPersonId;
	}
	/**  
	 * @param securityPersonId the securityPersonId to set  
	 */
	public void setSecurityPersonId(String securityPersonId) {
		this.securityPersonId = securityPersonId;
	}
	/**  
	 * @return the uPersonNum  
	 */
	public Integer getuPersonNum() {
		return uPersonNum;
	}
	/**  
	 * @param uPersonNum the uPersonNum to set  
	 */
	public void setuPersonNum(Integer uPersonNum) {
		this.uPersonNum = uPersonNum;
	}
	/**  
	 * @return the uTelephone  
	 */
	public String getuTelephone() {
		return uTelephone;
	}
	/**  
	 * @param uTelephone the uTelephone to set  
	 */
	public void setuTelephone(String uTelephone) {
		this.uTelephone = uTelephone;
	}
	/**  
	 * @return the bussinessNum  
	 */
	public String getBussinessNum() {
		return bussinessNum;
	}
	/**  
	 * @param bussinessNum the bussinessNum to set  
	 */
	public void setBussinessNum(String bussinessNum) {
		this.bussinessNum = bussinessNum;
	}
	/**  
	 * @return the regesistMoney  
	 */
	public Float getRegesistMoney() {
		return regesistMoney;
	}
	/**  
	 * @param regesistMoney the regesistMoney to set  
	 */
	public void setRegesistMoney(Float regesistMoney) {
		this.regesistMoney = regesistMoney;
	}
	/**  
	 * @return the regesistTime  
	 */
	public Date getRegesistTime() {
		return regesistTime;
	}
	/**  
	 * @param regesistTime the regesistTime to set  
	 */
	public void setRegesistTime(Date regesistTime) {
		this.regesistTime = regesistTime;
	}
	/**  
	 * @return the validTime  
	 */
	public Date getValidTime() {
		return validTime;
	}
	/**  
	 * @param validTime the validTime to set  
	 */
	public void setValidTime(Date validTime) {
		this.validTime = validTime;
	}
	/**  
	 * @return the openningTime  
	 */
	public Date getOpenningTime() {
		return openningTime;
	}
	/**  
	 * @param openningTime the openningTime to set  
	 */
	public void setOpenningTime(Date openningTime) {
		this.openningTime = openningTime;
	}
	/**  
	 * @return the orgNum  
	 */
	public String getOrgNum() {
		return orgNum;
	}
	/**  
	 * @param orgNum the orgNum to set  
	 */
	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}
	/**  
	 * @return the legalRepresentId  
	 */
	public String getLegalRepresentId() {
		return legalRepresentId;
	}
	/**  
	 * @param legalRepresentId the legalRepresentId to set  
	 */
	public void setLegalRepresentId(String legalRepresentId) {
		this.legalRepresentId = legalRepresentId;
	}
	/**  
	 * @return the landlordId  
	 */
	public String getLandlordId() {
		return landlordId;
	}
	/**  
	 * @param landlordId the landlordId to set  
	 */
	public void setLandlordId(String landlordId) {
		this.landlordId = landlordId;
	}
	/**  
	 * @return the imageUrls  
	 */
	public String getImageUrls() {
		return imageUrls;
	}
	/**  
	 * @param imageUrls the imageUrls to set  
	 */
	public void setImageUrls(String imageUrls) {
		this.imageUrls = imageUrls;
	}
	
}
