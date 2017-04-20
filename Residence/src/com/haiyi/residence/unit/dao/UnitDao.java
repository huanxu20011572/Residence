package com.haiyi.residence.unit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haiyi.residence.model.MediaFile;
import com.haiyi.residence.mapper.SuperMapper;
import com.haiyi.residence.model.TBUnit;
import com.haiyi.residence.model.TBUnitPopulation;

public interface UnitDao extends SuperMapper{
	public List<TBUnit> getAll(@Param(value="start")int start,@Param(value="end")int end);
	
	public Integer getCount();
	
	public String getUnitIdByUname(@Param("uName")String uName);
	
	public List<TBUnit> unitQuery(TBUnit tb); 
	
	public TBUnit getUnitIdById(@Param("uId")String uId); 	
	
	public void deleteUnit(String id);
	
	public void updateUnit(TBUnit tb);
	
	public MediaFile findImages(@Param("id")String id);
	
	public void insertUnit(@Param("tb")TBUnit tb);
	public List<TBUnit> getAllList();
}



