/**    
* @Title: UserService.java  
* @Package com.haiyi.residence.user.service  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author yanwenyan     
* @date 2015-10-22 ����01:11:15  
* @version V1.0    
*/ 
package com.haiyi.residence.user.service;


import java.util.List;

import com.haiyi.residence.model.User;

  
/**     
 * ��Ȩ���У�2015-yanwenyan 
 * ��Ŀ���ƣ�Residence     
 *  
 * ��������  
 * �����ƣ�com.haiyi.residence.user.service.UserService       
 * �����ˣ�yanwenyan  
 * ����ʱ�䣺2015-10-22 ����01:11:15     
 * �޸��ˣ�  
 * �޸�ʱ�䣺2015-10-22 ����01:11:15     
 * �޸ı�ע��     
 * @version   V1.0      
 */

public interface UserService {

	public List<User> getAll();
	
	public void insertUser(User u);
}
