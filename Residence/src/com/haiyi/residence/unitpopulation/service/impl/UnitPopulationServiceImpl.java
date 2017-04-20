package com.haiyi.residence.unitpopulation.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.haiyi.residence.model.MediaFile;
import com.haiyi.residence.model.TBResidentPopulation;
import com.haiyi.residence.model.TBUnitPopulation;
import com.haiyi.residence.unitpopulation.dao.UnitPopulationDao;
import com.haiyi.residence.unitpopulation.service.UnitPopulationService;
@Service("unitPopulationService")
public class UnitPopulationServiceImpl implements UnitPopulationService{

	private UnitPopulationDao unitPopulationDao;
	
	public UnitPopulationDao getUnitPopulationDao() {
		return unitPopulationDao;
	}
	@Resource(name="unitPopulationDao")
	public void setUnitPopulationDao(UnitPopulationDao unitPopulationDao) {
		this.unitPopulationDao = unitPopulationDao;
	}

	@Override
	public List<TBUnitPopulation> getAll(int start, int end) {
		List<TBUnitPopulation> list=unitPopulationDao.getAll(start,end);
		return list;
	}
	@Override
	public void deleteUnitPopulation(String id) {
		unitPopulationDao.deleteUnitPopulation(id);		
	}
	@Override
	public List<TBUnitPopulation> getUnitPopulationQuery(TBUnitPopulation tb) {
		List<TBUnitPopulation> list = new ArrayList<TBUnitPopulation>();
		list = this.unitPopulationDao.getUnitPopulationQuery(tb);
		return list;
	}
	@Override
	public void updateUnitPopulation(TBUnitPopulation tb) {
		try{
			this.unitPopulationDao.updateUnitPopulation(tb);		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public Integer getCount() {
		int count = 0;
		count = unitPopulationDao.getCount();
	return count;
	}
	@Override
	public TBUnitPopulation getLLUPInfo(String id) {
		TBUnitPopulation tb = null;
		try {
			tb = this.unitPopulationDao.getLLUPInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tb;
	}
	@Override
	public List<TBUnitPopulation> getUnitPopulationInfo(String uId) {
		List<TBUnitPopulation> list =null;
		try {
			list = this.unitPopulationDao.getUnitPopulationInfo(uId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<TBUnitPopulation> getunitColleagueInfo(String uId, String id) {
		List<TBUnitPopulation> list =null;
		try {
			list = this.unitPopulationDao.getunitColleagueInfo(uId, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public MediaFile findImages(String id) {
		// TODO Auto-generated method stub
		return this.unitPopulationDao.findImages(id);
	}
	@Override
	public void insertUnitPopulation(TBUnitPopulation tb) {
		try {
			this.unitPopulationDao.insertUnitPopulation(tb);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	@Override
	public List<TBUnitPopulation> getAllList() {
		List<TBUnitPopulation> list=unitPopulationDao.getAllList();
		return list;
	}
	@Override
	public TBUnitPopulation findByID(String id) {
		// TODO Auto-generated method stub
		return this.unitPopulationDao.findByID(id);
	}
	@Override
	public void deleteUnitPopulationByUId(String uId) {
		// TODO Auto-generated method stub
		this.unitPopulationDao.deleteUnitPopulationByUId(uId);
	}
	


}
