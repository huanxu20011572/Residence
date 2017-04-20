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
	private String uname;
	/**
	 * ��λ��ַ
	 */
	private String uaddr;
	/**
	 * ��Ӫ����
	 */
	private String uproperty;
	/**
	 * ��Ӫ��Χ
	 */
	private String uoperateRange;
	/**
	 * ��Ӫ���
	 */
	private String uoperateArea;
	/**
	 * ���
	 */
	private String rent;
	/**
	 * ��ϵ�绰
	 **/
	private String LinkNumber;
	/**
	 * ��λ���
	 **/
	private String ucategory;

	/**
	 * �ΰ�������Id
	 */
	private String securityPersonId;
	/**
	 * ��ҵ����
	 */
	private String upersonNum;
	/**
	 * ��λ��ϵ�绰(�����,�ָ���)
	 */
	private String utelephone;
	/**
	 * ����ִ�պ�
	 */
	private String bussinessNum;
	/**
	 * ע���ʽ�
	 */
	private String regesistMoney;
	/**
	 * ע������
	 */
	private String regesistTime;
	/**
	 * ��ҵʱ��
	 */
	private String openningTime;
	/**
	 * ��Ч������
	 */
	private String closeTime; 
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
	 */
	private String imageUrls;
	/**
	 * ��λ���ͻ�ͼ
	 */
	private String layoutDiagramUrl;
	/**
	 * �汾��
	 */
	private Integer version;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUaddr() {
		return uaddr;
	}
	public void setUaddr(String uaddr) {
		this.uaddr = uaddr;
	}
	public String getUproperty() {
		return uproperty;
	}
	public void setUproperty(String uproperty) {
		this.uproperty = uproperty;
	}
	public String getUoperateRange() {
		return uoperateRange;
	}
	public void setUoperateRange(String uoperateRange) {
		this.uoperateRange = uoperateRange;
	}
	
	/**  
	 * @return the uoperateArea  
	 */
	public String getUoperateArea() {
		return uoperateArea;
	}
	/**  
	 * @param uoperateArea the uoperateArea to set  
	 */
	public void setUoperateArea(String uoperateArea) {
		this.uoperateArea = uoperateArea;
	}
	/**  
	 * @return the rent  
	 */
	public String getRent() {
		return rent;
	}
	/**  
	 * @param rent the rent to set  
	 */
	public void setRent(String rent) {
		this.rent = rent;
	}
	/**  
	 * @param regesistMoney the regesistMoney to set  
	 */
	public void setRegesistMoney(String regesistMoney) {
		this.regesistMoney = regesistMoney;
	}
	public String getLinkNumber() {
		return LinkNumber;
	}
	public void setLinkNumber(String linkNumber) {
		LinkNumber = linkNumber;
	}
	public String getUcategory() {
		return ucategory;
	}
	public void setUcategory(String ucategory) {
		this.ucategory = ucategory;
	}
	public String getSecurityPersonId() {
		return securityPersonId;
	}
	public void setSecurityPersonId(String securityPersonId) {
		this.securityPersonId = securityPersonId;
	}
	
	/**  
	 * @return the upersonNum  
	 */
	public String getUpersonNum() {
		return upersonNum;
	}
	/**  
	 * @param upersonNum the upersonNum to set  
	 */
	public void setUpersonNum(String upersonNum) {
		this.upersonNum = upersonNum;
	}
	public String getUtelephone() {
		return utelephone;
	}
	public void setUtelephone(String utelephone) {
		this.utelephone = utelephone;
	}
	public String getBussinessNum() {
		return bussinessNum;
	}
	public void setBussinessNum(String bussinessNum) {
		this.bussinessNum = bussinessNum;
	}
	
	/**  
	 * @return the regesistMoney  
	 */
	public String getRegesistMoney() {
		return regesistMoney;
	}
	public String getRegesistTime() {
		return regesistTime;
	}
	public void setRegesistTime(String regesistTime) {
		this.regesistTime = regesistTime;
	}
	public String getOpenningTime() {
		return openningTime;
	}
	public void setOpenningTime(String openningTime) {
		this.openningTime = openningTime;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	public String getOrgNum() {
		return orgNum;
	}
	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}
	public String getLegalRepresentId() {
		return legalRepresentId;
	}
	public void setLegalRepresentId(String legalRepresentId) {
		this.legalRepresentId = legalRepresentId;
	}
	public String getLandlordId() {
		return landlordId;
	}
	public void setLandlordId(String landlordId) {
		this.landlordId = landlordId;
	}
	public String getImageUrls() {
		return imageUrls;
	}
	public void setImageUrls(String imageUrls) {
		this.imageUrls = imageUrls;
	}
	public String getLayoutDiagramUrl() {
		return layoutDiagramUrl;
	}
	public void setLayoutDiagramUrl(String layoutDiagramUrl) {
		this.layoutDiagramUrl = layoutDiagramUrl;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}

	
}
