/**    
* @Title: User.java  
* @Package com.haiyi.residence.model  
* @Description: TODO(用一句话描述该文件做什么)  
* @author yanwenyan     
* @date 2015-10-22 下午01:11:47  
* @version V1.0    
*/ 
package com.haiyi.residence.model.bo;

import java.io.Serializable;

import com.haiyi.residence.model.User;

  
/**     
 * 版权所有：2015-yanwenyan 
 * 项目名称：Residence     
 *  
 * 类描述：  
 * 类名称：com.haiyi.residence.model.User       
 * 创建人：yanwenyan  
 * 创建时间：2015-10-22 下午01:11:47     
 * 修改人：  
 * 修改时间：2015-10-22 下午01:11:47     
 * 修改备注：     
 * @version   V1.0      
 */
public class UserBO implements Serializable {

	private Integer id;
	private String name;
	private Integer age;
	private byte[] imageByte;
	
	//构造器
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
