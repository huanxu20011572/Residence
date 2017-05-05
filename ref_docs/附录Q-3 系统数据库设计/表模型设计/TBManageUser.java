/**    
* @Title: TBManageUser.java  
* @Package com.haiyi.residence.model  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author yanwenyan     
* @date 2015-10-27 ����02:18:31  
* @version V1.0    
*/ 
package com.haiyi.residence.model;

import java.io.Serializable;

  
/**     
 * ��Ȩ���У�2015-yanwenyan 
 * ��Ŀ���ƣ�Residence     
 *  
 * ��������  
 * �����ƣ�com.haiyi.residence.model.TBManageUser       
 * �����ˣ�yanwenyan  
 * ����ʱ�䣺2015-10-27 ����02:18:31     
 * �޸��ˣ�  
 * �޸�ʱ�䣺2015-10-27 ����02:18:31     
 * �޸ı�ע��     
 * @version   V1.0      
 */
/**
 * ������Ա��Ϣ��
 */
public class TBManageUser implements Serializable {

	/**
	 * ������ԱID
	 */
	private String id;
	/**
	 * ������Ա����	
	 */
	private String uName;
	/**
	 * ������Ա����
	 */
	private String password;
	/**
	 * ֤������
	 */
	private String certificateType;
	/**
	 * ֤������
	 */
	private String certificateNum;
	/**
	 * �ֻ���
	 */
	private String telephone;
	/**
	 * email����
	 */
	private String email;
	/**
	 * QQ��
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
