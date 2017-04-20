package com.haiyi.residence.entity;



public class MediaFile extends DrawBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3439135654476049237L;


	public String modeId = "";

	public String source = "";
	

	public String fileName = "";
	

	public String physicalName = "";
	

	public String relativePathServer = "";
	

	public String relativePathApp = "";


	public Long length = 0L;

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
