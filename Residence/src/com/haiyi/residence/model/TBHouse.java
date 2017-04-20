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
	private String hid;
	/**
	 * ���ӵ�ַ��Ϣ
	 */
	private String haddr;
	/**
	 * �������� С������
	 */
	private String hname;
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
	private String hroomNum;
	/**
	 * ���ݽṹ
	 */
	private String hstructure;
	/**
	 * ��Ȩ����
	 */
	private String hpropertyRight;
	/**
	 * ��ȫ״��
	 */
	private String hsecurityStatus;
	/**
	 * ����ʱ��
	 */
	private String rentalTime;
	/**
	 * �������
	 */
	private String rentalArea;
	/**
	 * �������
	 */
	private String rentalRoomNum;
	/**
	 * ��������
	 */
	private String rentalRoomDate;
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
	 * ���ݻ��ͻ�ͼ
	 */
	private String layoutDiagramUrl;
	
	/**
	 * �汾��
	 */
	private Integer version;
	
	
	private String rentType;
	
	private String realAddress;

	public String getRentType() {
		return rentType;
	}

	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	public String getRealAddress() {
		return realAddress;
	}

	public void setRealAddress(String realAddress) {
		this.realAddress = realAddress;
	}

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getHaddr() {
		return haddr;
	}

	public void setHaddr(String haddr) {
		this.haddr = haddr;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
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

	public String getHroomNum() {
		return hroomNum;
	}

	public void setHroomNum(String hroomNum) {
		this.hroomNum = hroomNum;
	}

	public String getHstructure() {
		return hstructure;
	}

	public void setHstructure(String hstructure) {
		this.hstructure = hstructure;
	}

	public String getHpropertyRight() {
		return hpropertyRight;
	}

	public void setHpropertyRight(String hpropertyRight) {
		this.hpropertyRight = hpropertyRight;
	}

	public String getHsecurityStatus() {
		return hsecurityStatus;
	}

	public void setHsecurityStatus(String hsecurityStatus) {
		this.hsecurityStatus = hsecurityStatus;
	}

	public String getRentalTime() {
		return rentalTime;
	}

	public void setRentalTime(String rentalTime) {
		this.rentalTime = rentalTime;
	}

	

	

	/**  
	 * @return the rentalArea  
	 */
	public String getRentalArea() {
		return rentalArea;
	}

	/**  
	 * @param rentalArea the rentalArea to set  
	 */
	public void setRentalArea(String rentalArea) {
		this.rentalArea = rentalArea;
	}

	/**  
	 * @return the rentalRoomNum  
	 */
	public String getRentalRoomNum() {
		return rentalRoomNum;
	}

	/**  
	 * @param rentalRoomNum the rentalRoomNum to set  
	 */
	public void setRentalRoomNum(String rentalRoomNum) {
		this.rentalRoomNum = rentalRoomNum;
	}

	public String getRentalRoomDate() {
		return rentalRoomDate;
	}

	public void setRentalRoomDate(String rentalRoomDate) {
		this.rentalRoomDate = rentalRoomDate;
	}

	public String getPoliceOperateArea() {
		return policeOperateArea;
	}

	public void setPoliceOperateArea(String policeOperateArea) {
		this.policeOperateArea = policeOperateArea;
	}

	public String getOperateRow() {
		return operateRow;
	}

	public void setOperateRow(String operateRow) {
		this.operateRow = operateRow;
	}

	public String getChargePoliceNum() {
		return chargePoliceNum;
	}

	public void setChargePoliceNum(String chargePoliceNum) {
		this.chargePoliceNum = chargePoliceNum;
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
