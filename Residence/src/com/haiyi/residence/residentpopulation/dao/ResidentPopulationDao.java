package com.haiyi.residence.residentpopulation.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.haiyi.residence.mapper.SuperMapper;
import com.haiyi.residence.model.MiniResidentPopulation;
import com.haiyi.residence.model.PopulationStactisc;
import com.haiyi.residence.model.TBResidentPopulation;
import com.haiyi.residence.model.TBUnit;

public interface ResidentPopulationDao extends SuperMapper{
	
	public Integer getCount();
	
	public Integer getCountCriminal();
	public List<TBResidentPopulation> getAll(@Param(value="start")int start,@Param(value="end")int end);
	
	public TBResidentPopulation getTBResidentPopulationByID(String id);
	
	public void deleteResidentPopulation(String id);
	
	public void updateResidentPopulation(TBResidentPopulation tb);
	
	public List<TBResidentPopulation> getResidentPopulationQuery(@Param("tb")TBResidentPopulation tb);
	
	public List<TBResidentPopulation> findCriminalPersons(@Param(value="start")int start,@Param(value="end")int end);
	
	public List<TBResidentPopulation> findFlowPopulationWillExpire(@Param("tb")TBResidentPopulation tb,@Param(value="start")int start,@Param(value="end")int end);
	
	public Integer findFlowPopulationnotCheckCount(@Param("tb")TBResidentPopulation tb);
	
	public void updateCheckStatus(@Param("tb")TBResidentPopulation tb);
	
	public List<TBResidentPopulation> selectHouseOwner(@Param("pType")int pType,@Param("hId")String hId);
	
	public List<MiniResidentPopulation> findCriminalPersonsStatistics();
	
	public void addResidentPopulation(@Param(value = "rp")TBResidentPopulation rp);
	public List<TBResidentPopulation> getAllInfo();

	public List<PopulationStactisc> findPopulationPersonsStatistics();

	public void deleteResidentPopulationByHid(@Param("hId")String hId);
}
