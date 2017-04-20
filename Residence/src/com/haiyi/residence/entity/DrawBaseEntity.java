package com.haiyi.residence.entity;


public class DrawBaseEntity extends BaseEntity {
  
  /**
   * 
   */
  private static final long serialVersionUID = 3966753432350575177L;


  public Boolean isRefresh = false;
  

  public String extraField1 = "";
  

  public String extraField2 = "";
  

  public String extraField3 = "";
  

  public String extraField4 = "";
  


  public String extraField5 = "";
  
  public Boolean getIsRefresh() {
    return isRefresh;
  }

  public void setIsRefresh(Boolean isRefresh) {
    this.isRefresh = isRefresh;
  }

  public String getExtraField1() {
    return extraField1;
  }

  public void setExtraField1(String extraField1) {
    this.extraField1 = extraField1;
  }

  public String getExtraField2() {
    return extraField2;
  }

  public void setExtraField2(String extraField2) {
    this.extraField2 = extraField2;
  }

  public String getExtraField3() {
    return extraField3;
  }

  public void setExtraField3(String extraField3) {
    this.extraField3 = extraField3;
  }

  public String getExtraField4() {
    return extraField4;
  }

  public void setExtraField4(String extraField4) {
    this.extraField4 = extraField4;
  }

  public String getExtraField5() {
    return extraField5;
  }

  public void setExtraField5(String extraField5) {
    this.extraField5 = extraField5;
  }
}
