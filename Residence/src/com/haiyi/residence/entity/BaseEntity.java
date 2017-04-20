package com.haiyi.residence.entity;



import java.io.Serializable;


public abstract class BaseEntity implements Serializable {

  /**
	 */
  private static final long serialVersionUID = 6337104618534280060L;


  public String id;

  public String remark;


  public Integer version;


  public Boolean valid = true;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public Boolean getValid() {
    return valid;
  }

  public void setValid(Boolean valid) {
    this.valid = valid;
  }

}
