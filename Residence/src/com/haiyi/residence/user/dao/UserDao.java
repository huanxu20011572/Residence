/**    
* @Title: UserDao.java  
* @Package com.haiyi.residence.user.dao  
* @Description: TODO(用一句话描述该文件做什么)  
* @author yanwenyan     
* @date 2015-10-22 下午01:14:58  
* @version V1.0    
*/ 
package com.haiyi.residence.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.haiyi.residence.mapper.SuperMapper;
import com.haiyi.residence.model.User;

  
/**     
 * 版权所有：2015-yanwenyan 
 * 项目名称：Residence     
 *  
 * 类描述：  
 * 类名称：com.haiyi.residence.user.dao.UserDao       
 * 创建人：yanwenyan  
 * 创建时间：2015-10-22 下午01:14:58     
 * 修改人：  
 * 修改时间：2015-10-22 下午01:14:58     
 * 修改备注：     
 * @version   V1.0      
 */
public interface UserDao extends SuperMapper {

	public List<User> getAll();
	public void insertUser(User u);
}
