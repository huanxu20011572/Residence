package com.haiyi.residence.unit.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haiyi.residence.model.MediaFile;
import com.haiyi.residence.model.TBUnit;

public interface UnitService {
	public List<TBUnit> getAll(int start,int end);
	
	public Integer getCount();
	
	public String getUnitIdByUname(String uName);
	
	public List<TBUnit> unitQuery(TBUnit tb);
	
	public void deleteUnit(String id);
	
	public void updateUnit(TBUnit tb);
	
	public TBUnit getUnitIdById(String uId);
	
	public MediaFile findImages(@Param("id")String id);
	
	public void insertUnit(TBUnit tb);
	
	public List<TBUnit> getAllList();


}
