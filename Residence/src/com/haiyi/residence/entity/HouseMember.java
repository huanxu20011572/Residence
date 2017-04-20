package com.haiyi.residence.entity;
public class HouseMember extends DrawBaseEntity {

    private static final long serialVersionUID = 6838888824971081481L;


    public String hId = "";
    
 
    public House house;


    public Integer pType = 0;


    public String name = "";


    public String oldName = "";


    public String sex = "";


    public String nation = "";


    public String certificateNum = "";


    public String birthday = "";


    public String degreeEducation = "";


    public String maritalSta = "";

    public String militarySta = "";


    public String tempLiveNo = "";

    public String relation = "";


    public String tempLiveDate = "";


    public String bloodType = "";

    public String height = "";


    public String occupation = "";


    public String post = "";


    public String houseRegist = "";


    public String serviceAddr = "";


    public String landLine = "";


    public String actualLiveAddr = "";


    public String telephone = "";


    public String qqNum = "";

    public String wetChatNum = "";


    public String imgPersonUrl = "";

    public String rentDate = "";


    public String rentReason = "";


    public String liveDate = "";
    

    public String personType = "";


    public String crinimal = "";
    
    private String rentalTime="";

    /**  
	 * @return the rentalTime  
	 */
	public String getRentalTime() {
		return rentalTime;
	}

	/**  
	 * @param rentalTime the rentalTime to set  
	 */
	public void setRentalTime(String rentalTime) {
		this.rentalTime = rentalTime;
	}

	public HouseMember() {
      
    }
    
    public String gethId() {
        return hId;
    }

    public void sethId(String hId) {
        this.hId = hId;
    }

    public Integer getpType() {
        return pType;
    }

    public void setpType(Integer pType) {
        this.pType = pType;
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

    public String getSex() {
        return sex;
    }

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDegreeEducation() {
        return degreeEducation;
    }

    public void setDegreeEducation(String degreeEducation) {
        this.degreeEducation = degreeEducation;
    }

    public String getMaritalSta() {
        return maritalSta;
    }

    public void setMaritalSta(String maritalSta) {
        this.maritalSta = maritalSta;
    }

    public String getMilitarySta() {
        return militarySta;
    }

    public void setMilitarySta(String militarySta) {
        this.militarySta = militarySta;
    }

    public String getTempLiveNo() {
        return tempLiveNo;
    }

    public void setTempLiveNo(String tempLiveNo) {
        this.tempLiveNo = tempLiveNo;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getTempLiveDate() {
        return tempLiveDate;
    }

    public void setTempLiveDate(String tempLiveDate) {
        this.tempLiveDate = tempLiveDate;
    }


    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
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

    public String getWetChatNum() {
        return wetChatNum;
    }

    public void setWetChatNum(String wetChatNum) {
        this.wetChatNum = wetChatNum;
    }

    public String getImgPersonUrl() {
        return imgPersonUrl;
    }

    public void setImgPersonUrl(String imgPersonUrl) {
        this.imgPersonUrl = imgPersonUrl;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public String getRentReason() {
        return rentReason;
    }

    public void setRentReason(String rentReason) {
        this.rentReason = rentReason;
    }

    public String getLiveDate() {
        return liveDate;
    }

    public void setLiveDate(String liveDate) {
        this.liveDate = liveDate;
    }

    public House getHouse() {
      return house;
    }

    public void setHouse(House house) {
      this.house = house;
    }

    public String getPersonType() {
      return personType;
    }

    public void setPersonType(String personType) {
      this.personType = personType;
    }

    public String getCrinimal() {
      return crinimal;
    }

    public void setCrinimal(String crinimal) {
      this.crinimal = crinimal;
    }
}
