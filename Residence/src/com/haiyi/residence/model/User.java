/**    
* @Title: User.java  
* @Package com.haiyi.residence.model  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author yanwenyan     
* @date 2015-10-22 ����01:11:47  
* @version V1.0    
*/ 
package com.haiyi.residence.model;

import java.io.Serializable;

  
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
public class User implements Serializable {

	private Integer id;
	private String name;
	private Integer age;
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
}
