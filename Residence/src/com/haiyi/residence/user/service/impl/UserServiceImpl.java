/**    
* @Title: UserServiceImpl.java  
* @Package com.haiyi.residence.user.service.impl  
* @Description: TODO(��һ�仰�������ļ���ʲô)  
* @author yanwenyan     
* @date 2015-10-22 ����01:14:33  
* @version V1.0    
*/ 
package com.haiyi.residence.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.haiyi.residence.model.User;
import com.haiyi.residence.user.dao.UserDao;
import com.haiyi.residence.user.service.UserService;

  
/**     
 * ��Ȩ���У�2015-yanwenyan 
 * ��Ŀ���ƣ�Residence     
 *  
 * ��������  
 * �����ƣ�com.haiyi.residence.user.service.impl.UserServiceImpl       
 * �����ˣ�yanwenyan  
 * ����ʱ�䣺2015-10-22 ����01:14:33     
 * �޸��ˣ�  
 * �޸�ʱ�䣺2015-10-22 ����01:14:33     
 * �޸ı�ע��     
 * @version   V1.0      
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	/** 
	 * @author yanwenyan 
	 * @see com.haiyi.residence.user.service.UserService#getAll()  
	 */

	private UserDao userDao;
	/**  
	 * @return the userDao  
	 */
	public UserDao getUserDao() {
		return userDao;
	}
	/**  
	 * @param userDao the userDao to set  
	 */
	@Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		List<User> list=userDao.getAll();
		return list;
	}
	@Override
	public void insertUser(User u) {
		// TODO Auto-generated method stub
		userDao.insertUser(u);
	}

}
