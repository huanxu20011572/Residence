/**    
* @Title: User.java  
* @Package com.haiyi.residence.model  
* @Description: TODO(用一句话描述该文件做什么)  
* @author yanwenyan     
* @date 2015-10-22 下午01:11:47  
* @version V1.0    
*/ 
package com.haiyi.residence.model;

import java.io.Serializable;

  
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
