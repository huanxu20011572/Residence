package com.haiyi.residence.model;


public class MediaFile  {



    public String id;
	

	/**  
	 * @return the remark  
	 */
	public String getRemark() {
		return remark;
	}

	/**  
	 * @param remark the remark to set  
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**  
	 * @return the version  
	 */
	public Integer getVersion() {
		return version;
	}

	/**  
	 * @param version the version to set  
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**  
	 * @return the valid  
	 */
	public Boolean getValid() {
		return valid;
	}

	/**  
	 * @param valid the valid to set  
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}



	public String remark;
	

	public Integer version;
	

	public Boolean valid;
	public String modeId = "";
	
	public String source = "";
	

	public String fileName = "";
	

	public String physicalName = "";
	

	public String relativePathServer = "";
	

	public String relativePathApp = "";


	public Long length = 0L;
	
	private boolean isRefresh;
	



	/**  
	 * @return the isRefresh  
	 */
	public boolean isRefresh() {
		return isRefresh;
	}

	/**  
	 * @param isRefresh the isRefresh to set  
	 */
	public void setRefresh(boolean isRefresh) {
		this.isRefresh = isRefresh;
	}



	/*
	 * 0为单位
	 * 1为房子
	 */
	private int type;

	/**  
	 * @return the type  
	 */
	public int getType() {
		return type;
	}

	/**  
	 * @param type the type to set  
	 */
	public void setType(int type) {
		this.type = type;
	}

	public MediaFile() {
	  
    }
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModeId() {
		return modeId;
	}

	public void setModeId(String modeId) {
		this.modeId = modeId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPhysicalName() {
		return physicalName;
	}

	public void setPhysicalName(String physicalName) {
		this.physicalName = physicalName;
	}

	public String getRelativePathServer() {
		return relativePathServer;
	}

	public void setRelativePathServer(String relativePathServer) {
		this.relativePathServer = relativePathServer;
	}

	public String getRelativePathApp() {
		return relativePathApp;
	}

	public void setRelativePathApp(String relativePathApp) {
		this.relativePathApp = relativePathApp;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

}
