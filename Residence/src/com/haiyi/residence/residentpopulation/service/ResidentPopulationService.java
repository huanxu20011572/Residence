package com.haiyi.residence.residentpopulation.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haiyi.residence.model.MiniResidentPopulation;
import com.haiyi.residence.model.PopulationStactisc;
import com.haiyi.residence.model.TBResidentPopulation;
import com.haiyi.residence.model.TBUnit;

public interface ResidentPopulationService {
	
	public List<TBResidentPopulation> getAll(int start, int end);
	
	public Integer getCount();
	
	public Integer getCountCriminal();
	
	public void deleteResidentPopulation(String id);
	
	public TBResidentPopulation getTBResidentPopulationByID(String id);
	
	public void updateResidentPopulation(TBResidentPopulation tb);
	
	public List<TBResidentPopulation> getResidentPopulationQuery(TBResidentPopulation tb);
	
	public List<TBResidentPopulation> findCriminalPersons(int start,int end);
	
	public List<TBResidentPopulation> findFlowPopulationWillExpire(TBResidentPopulation tb,int start,int end);
	
	public Integer findFlowPopulationnotCheckCount(TBResidentPopulation tb);
	
	public void updateCheckStatus(TBResidentPopulation tb);
	
	public List<TBResidentPopulation> selectHouseOwner(int pType,String hId);
	public List<MiniResidentPopulation> findCriminalPersonsStatistics();
	public List<PopulationStactisc> findPopulationPersonsStatistics();
	
	public void addResidentPopulation(TBResidentPopulation residentPopulation);
	
	public List<TBResidentPopulation> getAllInfo();
	
   public void deleteResidentPopulationByHid(@Param("hId")String hId);
}
