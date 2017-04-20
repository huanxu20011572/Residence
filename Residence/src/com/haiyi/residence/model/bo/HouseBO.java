/**    
* @Title: TBHouse.java  
* @Package com.haiyi.residence.model  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author yanwenyan     
* @date 2015-10-24 ����10:13:25  
* @version V1.0    
*/ 
package com.haiyi.residence.model.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * ס����ϢBO��
 */
@SuppressWarnings("serial")
public class HouseBO implements Serializable {
	/**
	 * ���ӵ�ַ��Ϣ
	 */
	private String haddr;
	/**
	 * ��������
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
	private Date rentalTime;
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
	 * �汾��
	 */
	private Integer version;
	/**
	 * ���ݻ��ͻ�ͼ��ͼƬ�ֽ�����
	 */
	private byte[] layoutDiagramImage;
	/**
	 * ���ݻ���ͼƬ���ֽ������б�
	 */
	private List<byte[]> images;

	//������
	public HouseBO() {
		super();
	}
	public HouseBO(String hAddr, String hName, String hBuildingNum,
			String hUnitNum, String hFloorNum, String hRoomNum,
			String hStructure, String hPropertyRight, String hSecurityStatus,
			Date rentalTime, String rentalArea, String rentalRoomNum,
			Date rentalRoomDate, String policeOperateArea, String operateRow,
			String chargePoliceNum, String landlordId, Integer version, 
			byte[] layoutDiagramImage, List<byte[]> images) {
		super();
		this.haddr = hAddr;
		this.hname = hName;
		this.hbuildingNum = hBuildingNum;
		this.hunitNum = hUnitNum;
		this.hfloorNum = hFloorNum;
		this.hroomNum = hRoomNum;
		this.hstructure = hStructure;
		this.hpropertyRight = hPropertyRight;
		this.hsecurityStatus = hSecurityStatus;
		this.rentalTime = rentalTime;
		this.rentalArea = rentalArea;
		this.rentalRoomNum = rentalRoomNum;
		this.rentalRoomDate = rentalRoomDate;
		this.policeOperateArea = policeOperateArea;
		this.operateRow = operateRow;
		this.chargePoliceNum = chargePoliceNum;
		this.landlordId = landlordId;
		this.version = version;
		this.layoutDiagramImage = layoutDiagramImage;
		this.images = images;
	}
	public HouseBO(JSONObject jsonObject, byte[] imageByte, List<byte[]> imageByteList) {
		super();
		try {
			this.haddr = jsonObject.getString("haddr");
			this.hname = jsonObject.getString("hname");
			this.hbuildingNum = jsonObject.getString("hbuildingNum");
			this.hunitNum = jsonObject.getString("hunitNum");
			this.hfloorNum = jsonObject.getString("hfloorNum");
			this.hroomNum = jsonObject.getString("hroomNum");
			this.hstructure = jsonObject.getString("hstructure");
			this.hpropertyRight = jsonObject.getString("hpropertyRight");
			this.hsecurityStatus = jsonObject.getString("hsecurityStatus");
			this.rentalTime = new Date();
			this.rentalArea =jsonObject.getString("rentalArea");
			this.rentalRoomNum = jsonObject.getString("rentalRoomNum");
			this.rentalRoomDate = new Date();
			this.policeOperateArea = jsonObject.getString("policeOperateArea");
			this.operateRow = jsonObject.getString("operateRow");
			this.chargePoliceNum = jsonObject.getString("chargePoliceNum");
			this.landlordId = jsonObject.getString("landlordId");
			this.version = jsonObject.getInt("version");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		this.layoutDiagramImage = imageByte;
		this.images = imageByteList;
	}
	

	//get��set
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
	public Date getRentalTime() {
		return rentalTime;
	}
	public void setRentalTime(Date rentalTime) {
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
	public Date getRentalRoomDate() {
		return rentalRoomDate;
	}
	public void setRentalRoomDate(Date rentalRoomDate) {
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
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public byte[] getLayoutDiagramImage() {
		return layoutDiagramImage;
	}
	public void setLayoutDiagramImage(byte[] layoutDiagramImage) {
		this.layoutDiagramImage = layoutDiagramImage;
	}
	public List<byte[]> getImages() {
		return images;
	}
	public void setImages(List<byte[]> images) {
		this.images = images;
	}

}
