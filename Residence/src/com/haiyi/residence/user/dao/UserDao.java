/**    
* @Title: UserDao.java  
* @Package com.haiyi.residence.user.dao  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author yanwenyan     
* @date 2015-10-22 ����01:14:58  
* @version V1.0    
*/ 
package com.haiyi.residence.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.haiyi.residence.mapper.SuperMapper;
import com.haiyi.residence.model.User;

  
/**     
 * ��Ȩ���У�2015-yanwenyan 
 * ��Ŀ���ƣ�Residence     
 *  
 * ��������  
 * �����ƣ�com.haiyi.residence.user.dao.UserDao       
 * �����ˣ�yanwenyan  
 * ����ʱ�䣺2015-10-22 ����01:14:58     
 * �޸��ˣ�  
 * �޸�ʱ�䣺2015-10-22 ����01:14:58     
 * �޸ı�ע��     
 * @version   V1.0      
 */
public interface UserDao extends SuperMapper {

	public List<User> getAll();
	public void insertUser(User u);
}
