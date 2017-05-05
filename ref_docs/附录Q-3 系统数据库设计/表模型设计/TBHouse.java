/**    
* @Title: TBHouse.java  
* @Package com.haiyi.residence.model  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author yanwenyan     
* @date 2015-10-24 ����10:13:25  
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
 * �����ƣ�com.haiyi.residence.model.TBHouse       
 * �����ˣ�yanwenyan  
 * ����ʱ�䣺2015-10-24 ����10:13:25     
 * �޸��ˣ�  
 * �޸�ʱ�䣺2015-10-24 ����10:13:25     
 * �޸ı�ע��     
 * @version   V1.0      
 */
/**
 * ס����Ϣ
 */
public class TBHouse implements Serializable {

	/**
	 * ������ϢID��
	 * Primary Key
	 */
	private String hId;
	/**
	 * ���ӵ�ַ��Ϣ
	 */
	private String hAddr;
	/**
	 * ������
	 */
	private String hBuildingNum;
	/**
	 * ��Ԫ��
	 */
	private String hUnitNum;
	/**
	 * ¥��
	 */
	private String hFloorNum;
	/**
	 * �����
	 */
	private String hRoomNum;
	/**
	 * ���ݽṹ
	 */
	private String hStructure;
	/**
	 * ��Ȩ����
	 */
	private String hPropertyRight;
	/**
	 * ��ȫ״��
	 */
	private String hSecurityStatus;
	/**
	 * ����ʱ��
	 */
	private Date rentalTime;
	/**
	 * �������
	 */
	private Float rentalArea;
	/**
	 * �������
	 */
	private Integer rentalRoomNum;
	/**
	 * ��������
	 */
	private Date rentalRoomDate;
	/**
	 * ��������
	 */
	private String policeOperateArea;
	/**
	 * ί��
	 */
	private String operateRow;
	/**
	 * �������񾯱��
	 */
	private String chargePoliceNum;
	/**
	 * ����ID��
	 */
	private String landlordId;
	/**
	 * ����ͼƬURL�����ͼƬ��;�ֿ������洢�����ݿ⣬����ͨ����PAD�ϴ���ʱ��
	 * ��ȡͼƬ���ֽ������������λ��ID�ż�"-"�����ֺţ���1��ʼ)��ΪͼƬ������
	 * 
	 */
	private String imageUrls;
	/**  
	 * @return the hId  
	 */
	public String gethId() {
		return hId;
	}
	/**  
	 * @param hId the hId to set  
	 */
	public void sethId(String hId) {
		this.hId = hId;
	}
	/**  
	 * @return the hAddr  
	 */
	public String gethAddr() {
		return hAddr;
	}
	/**  
	 * @param hAddr the hAddr to set  
	 */
	public void sethAddr(String hAddr) {
		this.hAddr = hAddr;
	}
	/**  
	 * @return the hBuildingNum  
	 */
	public String gethBuildingNum() {
		return hBuildingNum;
	}
	/**  
	 * @param hBuildingNum the hBuildingNum to set  
	 */
	public void sethBuildingNum(String hBuildingNum) {
		this.hBuildingNum = hBuildingNum;
	}
	/**  
	 * @return the hUnitNum  
	 */
	public String gethUnitNum() {
		return hUnitNum;
	}
	/**  
	 * @param hUnitNum the hUnitNum to set  
	 */
	public void sethUnitNum(String hUnitNum) {
		this.hUnitNum = hUnitNum;
	}
	/**  
	 * @return the hFloorNum  
	 */
	public String gethFloorNum() {
		return hFloorNum;
	}
	/**  
	 * @param hFloorNum the hFloorNum to set  
	 */
	public void sethFloorNum(String hFloorNum) {
		this.hFloorNum = hFloorNum;
	}
	/**  
	 * @return the hRoomNum  
	 */
	public String gethRoomNum() {
		return hRoomNum;
	}
	/**  
	 * @param hRoomNum the hRoomNum to set  
	 */
	public void sethRoomNum(String hRoomNum) {
		this.hRoomNum = hRoomNum;
	}
	/**  
	 * @return the hStructure  
	 */
	public String gethStructure() {
		return hStructure;
	}
	/**  
	 * @param hStructure the hStructure to set  
	 */
	public void sethStructure(String hStructure) {
		this.hStructure = hStructure;
	}
	/**  
	 * @return the hPropertyRight  
	 */
	public String gethPropertyRight() {
		return hPropertyRight;
	}
	/**  
	 * @param hPropertyRight the hPropertyRight to set  
	 */
	public void sethPropertyRight(String hPropertyRight) {
		this.hPropertyRight = hPropertyRight;
	}
	/**  
	 * @return the hSecurityStatus  
	 */
	public String gethSecurityStatus() {
		return hSecurityStatus;
	}
	/**  
	 * @param hSecurityStatus the hSecurityStatus to set  
	 */
	public void sethSecurityStatus(String hSecurityStatus) {
		this.hSecurityStatus = hSecurityStatus;
	}
	/**  
	 * @return the rentalTime  
	 */
	public Date getRentalTime() {
		return rentalTime;
	}
	/**  
	 * @param rentalTime the rentalTime to set  
	 */
	public void setRentalTime(Date rentalTime) {
		this.rentalTime = rentalTime;
	}
	/**  
	 * @return the rentalArea  
	 */
	public Float getRentalArea() {
		return rentalArea;
	}
	/**  
	 * @param rentalArea the rentalArea to set  
	 */
	public void setRentalArea(Float rentalArea) {
		this.rentalArea = rentalArea;
	}
	/**  
	 * @return the rentalRoomNum  
	 */
	public Integer getRentalRoomNum() {
		return rentalRoomNum;
	}
	/**  
	 * @param rentalRoomNum the rentalRoomNum to set  
	 */
	public void setRentalRoomNum(Integer rentalRoomNum) {
		this.rentalRoomNum = rentalRoomNum;
	}
	/**  
	 * @return the rentalRoomDate  
	 */
	public Date getRentalRoomDate() {
		return rentalRoomDate;
	}
	/**  
	 * @param rentalRoomDate the rentalRoomDate to set  
	 */
	public void setRentalRoomDate(Date rentalRoomDate) {
		this.rentalRoomDate = rentalRoomDate;
	}
	/**  
	 * @return the policeOperateArea  
	 */
	public String getPoliceOperateArea() {
		return policeOperateArea;
	}
	/**  
	 * @param policeOperateArea the policeOperateArea to set  
	 */
	public void setPoliceOperateArea(String policeOperateArea) {
		this.policeOperateArea = policeOperateArea;
	}
	/**  
	 * @return the operateRow  
	 */
	public String getOperateRow() {
		return operateRow;
	}
	/**  
	 * @param operateRow the operateRow to set  
	 */
	public void setOperateRow(String operateRow) {
		this.operateRow = operateRow;
	}
	/**  
	 * @return the chargePoliceNum  
	 */
	public String getChargePoliceNum() {
		return chargePoliceNum;
	}
	/**  
	 * @param chargePoliceNum the chargePoliceNum to set  
	 */
	public void setChargePoliceNum(String chargePoliceNum) {
		this.chargePoliceNum = chargePoliceNum;
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
