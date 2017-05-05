/**    
* @Title: TBManageUser.java  
* @Package com.haiyi.residence.model  
* @Description: TODO(用一句话描述该文件做什么)  
* @author yanwenyan     
* @date 2015-10-27 下午02:18:31  
* @version V1.0    
*/ 
package com.haiyi.residence.model;

import java.io.Serializable;

  
/**     
 * 版权所有：2015-yanwenyan 
 * 项目名称：Residence     
 *  
 * 类描述：  
 * 类名称：com.haiyi.residence.model.TBManageUser       
 * 创建人：yanwenyan  
 * 创建时间：2015-10-27 下午02:18:31     
 * 修改人：  
 * 修改时间：2015-10-27 下午02:18:31     
 * 修改备注：     
 * @version   V1.0      
 */
/**
 * 管理人员信息表
 */
public class TBManageUser implements Serializable {

	/**
	 * 管理人员ID
	 */
	private String id;
	/**
	 * 管理人员姓名	
	 */
	private String uName;
	/**
	 * 管理人员密码
	 */
	private String password;
	/**
	 * 证件类型
	 */
	private String certificateType;
	/**
	 * 证件号码
	 */
	private String certificateNum;
	/**
	 * 手机号
	 */
	private String telephone;
	/**
	 * email邮箱
	 */
	private String email;
	/**
	 * QQ号
	 */
	private String qqNum;
	/**  
	 * @return the id  
	 */
	public String getId() {
		return id;
	}
	/**  
	 * @param id the id to set  
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**  
	 * @return the uName  
	 */
	public String getuName() {
		return uName;
	}
	/**  
	 * @param uName the uName to set  
	 */
	public void setuName(String uName) {
		this.uName = uName;
	}
	/**  
	 * @return the password  
	 */
	public String getPassword() {
		return password;
	}
	/**  
	 * @param password the password to set  
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**  
	 * @return the certificateType  
	 */
	public String getCertificateType() {
		return certificateType;
	}
	/**  
	 * @param certificateType the certificateType to set  
	 */
	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}
	/**  
	 * @return the certificateNum  
	 */
	public String getCertificateNum() {
		return certificateNum;
	}
	/**  
	 * @param certificateNum the certificateNum to set  
	 */
	public void setCertificateNum(String certificateNum) {
		this.certificateNum = certificateNum;
	}
	/**  
	 * @return the telephone  
	 */
	public String getTelephone() {
		return telephone;
	}
	/**  
	 * @param telephone the telephone to set  
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**  
	 * @return the email  
	 */
	public String getEmail() {
		return email;
	}
	/**  
	 * @param email the email to set  
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**  
	 * @return the qqNum  
	 */
	public String getQqNum() {
		return qqNum;
	}
	/**  
	 * @param qqNum the qqNum to set  
	 */
	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}
	
}
