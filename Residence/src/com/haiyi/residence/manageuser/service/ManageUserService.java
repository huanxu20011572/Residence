package com.haiyi.residence.manageuser.service;

import java.util.List;

import com.haiyi.residence.model.TBManageUser;

public interface ManageUserService {

	public void insertManageUser(TBManageUser tb);
	
	public TBManageUser  getManageUserByName(String uName);
	
	public TBManageUser checkNumber(TBManageUser tb);
//	public TBManageUser checkNumber(String certificateNum);
	public TBManageUser checkUser(TBManageUser tb);
	public TBManageUser  getManageUserByLogin(TBManageUser tb);
	public void updatePass(String newpassword1,String oldpassword,String uName);
	
	//查询所有用户
	public List<TBManageUser> getAll(int start, int end);
	public Integer getCount();
	
	public TBManageUser checkUserName(TBManageUser tb);

}
