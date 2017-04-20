package com.haiyi.residence.manageuser.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.haiyi.residence.manageuser.dao.ManageUserDao;
import com.haiyi.residence.manageuser.service.ManageUserService;
import com.haiyi.residence.model.TBManageUser;


@Service("manageUserService")
public class ManageUserServiceImpl implements ManageUserService{

	private ManageUserDao manageUserDao;

	public ManageUserDao getManageUserDao() {
		return manageUserDao;
	}
	@Resource(name="manageUserDao")
	public void setManageUserDao(ManageUserDao manageUserDao) {
		this.manageUserDao = manageUserDao;
	}
	@Override
	public TBManageUser getManageUserByName(String uName) {
		TBManageUser tb = new TBManageUser();
		tb =   this.manageUserDao.getManageUserByName(uName);
		return tb;
	}
	@Override
	public void insertManageUser(TBManageUser tb) {
		this.manageUserDao.insertManageUser(tb);		
	}
	
	public TBManageUser checkNumber(TBManageUser tb) {
		TBManageUser mm = new TBManageUser();
		mm = this.manageUserDao.checkNumber(tb);
		return mm;
	} 
//	public TBManageUser checkNumber(String certificateNum) {
//		TBManageUser mm = new TBManageUser();
//		mm = this.manageUserDao.checkNumber(certificateNum);
//		return mm;
//	} 
	
	
	@Override
	public TBManageUser getManageUserByLogin(TBManageUser tb) {
		TBManageUser mm = new TBManageUser();
		mm = this.manageUserDao.getManageUserByLogin(tb);
		return mm;
	}
	@Override
	public void updatePass(String newpassword1, String oldpassword,String uName) {
		try {
			this.manageUserDao.updatePass(oldpassword, newpassword1,uName);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public TBManageUser checkUser(TBManageUser tb) {
		TBManageUser mm=null;
		try{
			mm = this.manageUserDao.checkUser(tb);
		}catch(Exception sp){
			sp.printStackTrace();
		}
		
		return mm;
	}
	@Override
	public List<TBManageUser> getAll(int start, int end) {
		List<TBManageUser> list  = null;
		try {
			list = this.manageUserDao.getAll(start,end);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Integer getCount() {
		int count = 0;
		count = manageUserDao.getCount();
	return count;
	}
	@Override
	public TBManageUser checkUserName(TBManageUser tb) {
		TBManageUser mm = new TBManageUser();
		mm = this.manageUserDao.checkUserName(tb);
		return mm;
	}

}
