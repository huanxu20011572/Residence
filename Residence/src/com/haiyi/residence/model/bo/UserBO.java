/**    
* @Title: User.java  
* @Package com.haiyi.residence.model  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author yanwenyan     
* @date 2015-10-22 ����01:11:47  
* @version V1.0    
*/ 
package com.haiyi.residence.model.bo;

import java.io.Serializable;

import com.haiyi.residence.model.User;

  
/**     
 * ��Ȩ���У�2015-yanwenyan 
 * ��Ŀ���ƣ�Residence     
 *  
 * ��������  
 * �����ƣ�com.haiyi.residence.model.User       
 * �����ˣ�yanwenyan  
 * ����ʱ�䣺2015-10-22 ����01:11:47     
 * �޸��ˣ�  
 * �޸�ʱ�䣺2015-10-22 ����01:11:47     
 * �޸ı�ע��     
 * @version   V1.0      
 */
public class UserBO implements Serializable {

	private Integer id;
	private String name;
	private Integer age;
	private byte[] imageByte;
	
	//������
	public UserBO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserBO(Integer id, String name, Integer age, byte[] imageByte) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.imageByte = imageByte;
	}
	public UserBO(User user, byte[] imageByte) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.age = user.getAge();
		this.imageByte = imageByte;
	}


	/**  
	 * @return the id  
	 */
	public Integer getId() {
		return id;
	}
	/**  
	 * @param id the id to set  
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**  
	 * @return the name  
	 */
	public String getName() {
		return name;
	}
	/**  
	 * @param name the name to set  
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**  
	 * @return the age  
	 */
	public Integer getAge() {
		return age;
	}
	/**  
	 * @param age the age to set  
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	public byte[] getImageByte() {
		return imageByte;
	}
	public void setImageByte(byte[] imageByte) {
		this.imageByte = imageByte;
	}
}
