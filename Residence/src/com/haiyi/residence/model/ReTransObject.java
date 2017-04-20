package com.haiyi.residence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReTransObject implements Serializable {

	private String resultCode;
	private String resultMsg;
	private List<ReTransBaseObject> unitList=new ArrayList();
	private List<ReTransBaseObject> unitMemeberList=new ArrayList();
	private List<ReTransBaseObject> houseList=new ArrayList();
	private List<ReTransBaseObject> houseMemberList=new ArrayList();
	private List<ReTransBaseObject> mediaFileList=new ArrayList();
	
	/**  
	 * @return the resultCode  
	 */
	public String getResultCode() {
		return resultCode;
	}
	/**  
	 * @param resultCode the resultCode to set  
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	
	/**  
	 * @return the resultMsg  
	 */
	public String getResultMsg() {
		return resultMsg;
	}
	/**  
	 * @param resultMsg the resultMsg to set  
	 */
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	/**  
	 * @return the unitList  
	 */
	public List<ReTransBaseObject> getUnitList() {
		return unitList;
	}
	/**  
	 * @param unitList the unitList to set  
	 */
	public void setUnitList(List<ReTransBaseObject> unitList) {
		this.unitList = unitList;
	}
	/**  
	 * @return the unitMemeberList  
	 */
	public List<ReTransBaseObject> getUnitMemeberList() {
		return unitMemeberList;
	}
	/**  
	 * @param unitMemeberList the unitMemeberList to set  
	 */
	public void setUnitMemeberList(List<ReTransBaseObject> unitMemeberList) {
		this.unitMemeberList = unitMemeberList;
	}
	/**  
	 * @return the houseList  
	 */
	public List<ReTransBaseObject> getHouseList() {
		return houseList;
	}
	/**  
	 * @param houseList the houseList to set  
	 */
	public void setHouseList(List<ReTransBaseObject> houseList) {
		this.houseList = houseList;
	}
	/**  
	 * @return the houseMemberList  
	 */
	public List<ReTransBaseObject> getHouseMemberList() {
		return houseMemberList;
	}
	/**  
	 * @param houseMemberList the houseMemberList to set  
	 */
	public void setHouseMemberList(List<ReTransBaseObject> houseMemberList) {
		this.houseMemberList = houseMemberList;
	}
	/**  
	 * @return the mediaFileList  
	 */
	public List<ReTransBaseObject> getMediaFileList() {
		return mediaFileList;
	}
	/**  
	 * @param mediaFileList the mediaFileList to set  
	 */
	public void setMediaFileList(List<ReTransBaseObject> mediaFileList) {
		this.mediaFileList = mediaFileList;
	}
	
	
}
