package com.haiyi.residence.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haiyi.residence.mapper.SuperMapper;
import com.haiyi.residence.model.TBHouse;
import com.haiyi.residence.model.TBResidentPopulation;

public interface HouseDao extends SuperMapper{
	
//	public String getHIdIdByHname(@Param("hName")String hName);
	
	public TBHouse getHIdByHname(TBHouse tb);
	
	public List<TBHouse> getAll(@Param(value="start")int start,@Param(value="end")int end);
	
	public Integer getCount();
	
	public void deleteHouse(String id);
	
	public List<TBHouse> houseQuery(TBHouse tb);  
	
	public void updateHouse(TBHouse tb);
	
	public List<TBHouse> getHouseInfoByHId(@Param(value="hId")String hId);
	
	public void addHouse(@Param(value = "h")TBHouse h);
	
	public List<TBHouse> getAllInfo();
	
	public TBHouse getHouseById(@Param(value = "hId")String hId);

}
