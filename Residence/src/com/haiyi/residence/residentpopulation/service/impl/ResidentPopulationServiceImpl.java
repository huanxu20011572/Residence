package com.haiyi.residence.residentpopulation.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.haiyi.residence.model.MiniResidentPopulation;
import com.haiyi.residence.model.PopulationStactisc;
import com.haiyi.residence.model.TBResidentPopulation;
import com.haiyi.residence.model.TBUnit;
import com.haiyi.residence.residentpopulation.dao.ResidentPopulationDao;
import com.haiyi.residence.residentpopulation.service.ResidentPopulationService;
@Service("residentPopulationService")
public class ResidentPopulationServiceImpl implements ResidentPopulationService{

	private ResidentPopulationDao residentPopulationDao;
	public ResidentPopulationDao getResidentPopulationDao() {
		return residentPopulationDao;
	}
	@Resource(name="residentPopulationDao")
	public void setResidentPopulationDao(ResidentPopulationDao residentPopulationDao) {
		this.residentPopulationDao = residentPopulationDao;
	}

	@Override
	public List<TBResidentPopulation> getAll(int start, int end) {
		List<TBResidentPopulation> list = null;
		try {
			list=residentPopulationDao.getAll(start,end);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	@Override
	public Integer getCount() {
		int count = 0;
		count = residentPopulationDao.getCount();
	return count;
	}
	
	@Override
	public void deleteResidentPopulation(String id) {
		 residentPopulationDao.deleteResidentPopulation(id);
	}
	@Override
	public TBResidentPopulation getTBResidentPopulationByID(String id) {
		return this.residentPopulationDao.getTBResidentPopulationByID(id);
	}
	@Override
	public void updateResidentPopulation(TBResidentPopulation tb) {
		try{
			this.residentPopulationDao.updateResidentPopulation(tb);		
		
		}catch(Exception e){
			
		}
	}
	@Override
	public List<TBResidentPopulation> getResidentPopulationQuery(TBResidentPopulation tb) {
		List<TBResidentPopulation> list = new ArrayList<TBResidentPopulation>();
		try {
			list = this.residentPopulationDao.getResidentPopulationQuery(tb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<TBResidentPopulation> findCriminalPersons(int start, int end) {
		// TODO Auto-generated method stub
		List<TBResidentPopulation> list = null;
		try {
			list=residentPopulationDao.findCriminalPersons(start,end);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Integer getCountCriminal() {
		// TODO Auto-generated method stub
		int count = 0;
		count = residentPopulationDao.getCountCriminal();
	return count;
	}
	@Override
	public List<TBResidentPopulation> findFlowPopulationWillExpire(@Param("tb")TBResidentPopulation tb,int start,int end) {
		// TODO Auto-generated method stub
		return residentPopulationDao.findFlowPopulationWillExpire(tb,start,end);
	}
	@Override
	public Integer findFlowPopulationnotCheckCount(TBResidentPopulation tb) {
		// TODO Auto-generated method stub
		return residentPopulationDao.findFlowPopulationnotCheckCount(tb);
	}
	@Override
	public void updateCheckStatus(TBResidentPopulation tb) {
		// TODO Auto-generated method stub
		residentPopulationDao.updateCheckStatus(tb);
	}
	@Override
	public List<TBResidentPopulation> selectHouseOwner(int pType,String hId) {
		// TODO Auto-generated method stub
		List<TBResidentPopulation> list=residentPopulationDao.selectHouseOwner(pType,hId);
		return list;
	}
	@Override
	public List<MiniResidentPopulation> findCriminalPersonsStatistics() {
		// TODO Auto-generated method stub
		return this.residentPopulationDao.findCriminalPersonsStatistics();
	}
	@Override
	public List<PopulationStactisc> findPopulationPersonsStatistics() {
		// TODO Auto-generated method stub
		return this.residentPopulationDao.findPopulationPersonsStatistics();
	}
	@Override
	public void addResidentPopulation(TBResidentPopulation residentPopulation) {
		this.residentPopulationDao.addResidentPopulation(residentPopulation);
	}
	@Override
	public List<TBResidentPopulation> getAllInfo() {
		return this.residentPopulationDao.getAllInfo();
	}
	@Override
	public void deleteResidentPopulationByHid(String hId) {
		// TODO Auto-generated method stub
		this.residentPopulationDao.deleteResidentPopulationByHid(hId);
	}
}
