package com.haiyi.residence.unit.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.haiyi.residence.model.MediaFile;
import com.haiyi.residence.model.TBUnit;
import com.haiyi.residence.model.TBUnitPopulation;
import com.haiyi.residence.unit.dao.UnitDao;
import com.haiyi.residence.unit.service.UnitService;
@Service("unitService")
public class UnitServiceImpl implements UnitService{

	private UnitDao unitDao;
	public UnitDao getUnitDao() {
		return unitDao;
	}
	@Resource(name="unitDao")
	public void setUnitDao(UnitDao unitDao) {
		this.unitDao = unitDao;
	}
	@Override
	public List<TBUnit> getAll(int start,int end) {
		List<TBUnit> list=unitDao.getAll(start,end);
		return list;
	}
	@Override
	public String getUnitIdByUname(String uName) {
		String id = unitDao.getUnitIdByUname(uName);
		return id;
	}
	@Override
	public List<TBUnit> unitQuery(TBUnit tb) {
//		TBUnit t = new TBUnit();
		List<TBUnit> list = new ArrayList<TBUnit>();
		list = unitDao.unitQuery(tb);
		return list;
	}
	@Override
	public void updateUnit(TBUnit tb) {
		try{
			this.unitDao.updateUnit(tb);		
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	@Override
	public void deleteUnit(String id) {
		this.unitDao.deleteUnit(id);		
	}
	@Override
	public Integer getCount() {
		int count = 0;
		count = unitDao.getCount();
	return count;
	}
	@Override
	public TBUnit getUnitIdById(String uId) {
		TBUnit tb = null;
		try {
			tb = this.unitDao.getUnitIdById(uId);
		} catch (Exception e) {
			e.printStackTrace();
			}
		return tb;
	}
	@Override
	public MediaFile findImages(String id) {
		// TODO Auto-generated method stub
		return this.unitDao.findImages(id);
	}
	@Override
	public void insertUnit(TBUnit tb) {
		try {
			this.unitDao.insertUnit(tb);					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<TBUnit> getAllList() {
		List<TBUnit> list=unitDao.getAllList();
		return list;
	}
}
