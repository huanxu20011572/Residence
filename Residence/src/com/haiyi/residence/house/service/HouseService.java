package com.haiyi.residence.house.service;

import java.util.List;

import com.haiyi.residence.entity.House;
import com.haiyi.residence.model.TBHouse;

public interface HouseService {

//	public String getHIdIdByHname(@Param("hName")String hName);
	public TBHouse getHIdByHname(TBHouse tb);
	
	public List<TBHouse> getAll(int start,int end);
	
	public Integer getCount();
	
	public void deleteHouse(String id);

	public List<TBHouse> houseQuery(TBHouse tb);
	
	public void updateHouse(TBHouse tb);
	
	public List<TBHouse> getHouseInfoByHId(String hId);
	
	public void addHouse(TBHouse house);
	public List<TBHouse> getAllInfo();
	
	public TBHouse getHouseById(String id);
	
}
