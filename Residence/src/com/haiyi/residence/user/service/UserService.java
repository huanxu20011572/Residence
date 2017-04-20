/**    
* @Title: UserService.java  
* @Package com.haiyi.residence.user.service  
* @Description: TODO(用一句话描述该文件做什么)  
* @author yanwenyan     
* @date 2015-10-22 下午01:11:15  
* @version V1.0    
*/ 
package com.haiyi.residence.user.service;


import java.util.List;

import com.haiyi.residence.model.User;

  
/**     
 * 版权所有：2015-yanwenyan 
 * 项目名称：Residence     
 *  
 * 类描述：  
 * 类名称：com.haiyi.residence.user.service.UserService       
 * 创建人：yanwenyan  
 * 创建时间：2015-10-22 下午01:11:15     
 * 修改人：  
 * 修改时间：2015-10-22 下午01:11:15     
 * 修改备注：     
 * @version   V1.0      
 */

public interface UserService {

	public List<User> getAll();
	
	public void insertUser(User u);
}
