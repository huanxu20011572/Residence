/**    
* @Title: TBUnit.java  
* @Package com.haiyi.residence.model  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author yanwenyan     
* @date 2015-10-24 ����09:50:27  
* @version V1.0    
*/ 
package com.haiyi.residence.model.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

/***
 * ��λ��ϢBO��
 */
@SuppressWarnings("serial")
public class UnitBO implements Serializable {
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
	private String linkNumber;
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
	 * �汾��
	 */
	private Integer version;
	/**
	 * ��λ���ͻ�ͼ
	 */
	private byte[] layoutDiagramUrl;
	/**
	 * ��λ����ͼƬ���ֽ������б�
	 */
	private List<byte[]> imageUrls;
	
	//������
	public UnitBO() {
		super();
	}
	public UnitBO(String uname, String uaddr, String uproperty,
			String uoperateRange, String uoperateArea, String rent,
			String linkNumber, String ucategory, String securityPersonId,
			String upersonNum, String utelephone, String bussinessNum,
			String regesistMoney, String regesistTime, String openningTime,
			String closeTime, String orgNum, String legalRepresentId,
			String landlordId, Integer version, 
			byte[] layoutDiagramUrl, List<byte[]> imageUrls) {
		super();
		this.uname = uname;
		this.uaddr = uaddr;
		this.uproperty = uproperty;
		this.uoperateRange = uoperateRange;
		this.uoperateArea = uoperateArea;
		this.rent = rent;
		this.linkNumber = linkNumber;
		this.ucategory = ucategory;
		this.securityPersonId = securityPersonId;
		this.upersonNum = upersonNum;
		this.utelephone = utelephone;
		this.bussinessNum = bussinessNum;
		this.regesistMoney = regesistMoney;
		this.regesistTime = regesistTime;
		this.openningTime = openningTime;
		this.closeTime = closeTime;
		this.orgNum = orgNum;
		this.legalRepresentId = legalRepresentId;
		this.landlordId = landlordId;
		this.version = version;
		this.layoutDiagramUrl = layoutDiagramUrl;
		this.imageUrls = imageUrls;
	}

	public UnitBO(JSONObject jsonObject, byte[] imageByte, List<byte[]> imageByteList) {
		super();
		try {
			this.uname = jsonObject.getString("uname");
			this.uaddr = jsonObject.getString("uaddr");
			this.uproperty = jsonObject.getString("uproperty");
			this.uoperateRange = jsonObject.getString("uoperateRange");
			this.uoperateArea = jsonObject.getString("uoperateArea");
			this.rent = jsonObject.getString("rent");
			this.linkNumber = jsonObject.getString("LinkNumber");
			this.ucategory = jsonObject.getString("ucategory");
			this.securityPersonId = jsonObject.getString("securityPersonId");
			this.upersonNum = jsonObject.getString("upersonNum");
			this.utelephone = "";
			this.bussinessNum = jsonObject.getString("bussinessNum");
			this.regesistMoney = jsonObject.getString("regesistMoney");
			
			this.regesistTime = jsonObject.getString("regesistTime");
			this.openningTime = jsonObject.getString("openningTime");
			this.closeTime = jsonObject.getString("closeTime");			
			
			this.orgNum = jsonObject.getString("orgNum");
			this.legalRepresentId = jsonObject.getString("legalRepresentId");
			this.landlordId = jsonObject.getString("landlordId");
			this.version = jsonObject.getInt("version");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		this.layoutDiagramUrl = imageByte;
		this.imageUrls = imageByteList;
	}
	
	//get��set
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
	
	public String getLinkNumber() {
		return linkNumber;
	}
	public void setLinkNumber(String linkNumber) {
		this.linkNumber = linkNumber;
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
	 * @return the regesistMoney  
	 */
	public String getRegesistMoney() {
		return regesistMoney;
	}
	/**  
	 * @param regesistMoney the regesistMoney to set  
	 */
	public void setRegesistMoney(String regesistMoney) {
		this.regesistMoney = regesistMoney;
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
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public byte[] getLayoutDiagramUrl() {
		return layoutDiagramUrl;
	}
	public void setLayoutDiagramUrl(byte[] layoutDiagramUrl) {
		this.layoutDiagramUrl = layoutDiagramUrl;
	}
	public List<byte[]> getImageUrls() {
		return imageUrls;
	}
	public void setImageUrls(List<byte[]> imageUrls) {
		this.imageUrls = imageUrls;
	}
	



}
