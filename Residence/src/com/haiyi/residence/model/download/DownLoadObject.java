package com.haiyi.residence.model.download;

import java.io.Serializable;
import java.util.List;

import com.haiyi.residence.entity.House;
import com.haiyi.residence.entity.HouseMember;
import com.haiyi.residence.entity.Unit;
import com.haiyi.residence.entity.UnitMember;
import com.haiyi.residence.model.MediaFile;

public class DownLoadObject implements Serializable {

	private List<House> houseList;
	private List<HouseMember> houseMemberList;
	private List<Unit> unitList;
	private List<UnitMember> unitMemberList;
	private List<MediaFile> mediaFileList;
	/**  
	 * @return the houseList  
	 */
	public List<House> getHouseList() {
		return houseList;
	}
	/**  
	 * @param houseList the houseList to set  
	 */
	public void setHouseList(List<House> houseList) {
		this.houseList = houseList;
	}
	/**  
	 * @return the houseMemberList  
	 */
	public List<HouseMember> getHouseMemberList() {
		return houseMemberList;
	}
	/**  
	 * @param houseMemberList the houseMemberList to set  
	 */
	public void setHouseMemberList(List<HouseMember> houseMemberList) {
		this.houseMemberList = houseMemberList;
	}
	
	/**  
	 * @return the mediaFileList  
	 */
	public List<MediaFile> getMediaFileList() {
		return mediaFileList;
	}
	/**  
	 * @param mediaFileList the mediaFileList to set  
	 */
	public void setMediaFileList(List<MediaFile> mediaFileList) {
		this.mediaFileList = mediaFileList;
	}
	/**  
	 * @return the unitList  
	 */
	public List<Unit> getUnitList() {
		return unitList;
	}
	/**  
	 * @param unitList the unitList to set  
	 */
	public void setUnitList(List<Unit> unitList) {
		this.unitList = unitList;
	}
	/**  
	 * @return the unitMemberList  
	 */
	public List<UnitMember> getUnitMemberList() {
		return unitMemberList;
	}
	/**  
	 * @param unitMemberList the unitMemberList to set  
	 */
	public void setUnitMemberList(List<UnitMember> unitMemberList) {
		this.unitMemberList = unitMemberList;
	}
	
	
}
