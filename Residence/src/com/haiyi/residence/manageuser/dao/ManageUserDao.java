package com.haiyi.residence.manageuser.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haiyi.residence.mapper.SuperMapper;
import com.haiyi.residence.model.TBManageUser;

public interface ManageUserDao extends SuperMapper{

	public void insertManageUser(TBManageUser tb);
	
	public TBManageUser  getManageUserByName(String uName);
	
	public TBManageUser  checkNumber(TBManageUser tb);
//	public TBManageUser checkNumber(String certificateNum);

	//查询用户
	public TBManageUser checkUser(@Param(value="tb")TBManageUser tb);
	public TBManageUser  getManageUserByLogin(TBManageUser tb);
	//修改密码    
	public void updatePass(@Param(value="oldpassword")String oldpassword,
			@Param(value="newpassword1")String newpassword1,@Param(value="uName")String uName);
	
	//查询所有用户
	public List<TBManageUser> getAll(@Param(value="start")int start,@Param(value="end")int end);
	public Integer getCount();
	
	
	public TBManageUser  checkUserName(TBManageUser tb);

}
