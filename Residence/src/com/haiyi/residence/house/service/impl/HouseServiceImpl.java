package com.haiyi.residence.house.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.haiyi.residence.entity.House;
import com.haiyi.residence.house.dao.HouseDao;
import com.haiyi.residence.house.service.HouseService;
import com.haiyi.residence.model.TBHouse;
import com.haiyi.residence.model.TBResidentPopulation;
import com.haiyi.residence.model.TBUnit;
@Service("houseService")
public class HouseServiceImpl implements HouseService{

	private HouseDao houseDao;

	public HouseDao getHouseDao() {
		return houseDao;
	}
	@Resource(name="houseDao")
	public void setHouseDao(HouseDao houseDao) {
		this.houseDao = houseDao;
	}
//	@Override
//	public String getHIdIdByHname(String hName) {
//		String id = houseDao.getHIdIdByHname(hName);
//		return id;
//	}
	@Override
	public TBHouse getHIdByHname(TBHouse tb) {
		TBHouse t = new TBHouse();
		try {
			t = this.houseDao.getHIdByHname(tb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	@Override
	public List<TBHouse> getAll(int start, int end) {
		List<TBHouse> list=houseDao.getAll(start,end);
		return list;
	}
	@Override
	public void deleteHouse(String id) {
		houseDao.deleteHouse(id);
	}
	@Override
	public List<TBHouse> houseQuery(TBHouse tb) {
		List<TBHouse> list = new ArrayList<TBHouse>();
		list = this.houseDao.houseQuery(tb);
		return list;
	}
	@Override
	public void updateHouse(TBHouse tb) {
		try {
			this.houseDao.updateHouse(tb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public Integer getCount() {
		int count = 0;
		count = houseDao.getCount();
	return count;
	}
	@Override
	public List<TBHouse> getHouseInfoByHId(String hId) {
		// TODO Auto-generated method stub
		List<TBHouse> list=this.houseDao.getHouseInfoByHId(hId);
		return list;
	}
	@Override
	public void addHouse(TBHouse house) {
		this.houseDao.addHouse(house);
	}
	@Override
	public List<TBHouse> getAllInfo() {
		return this.houseDao.getAllInfo();
	}
	@Override
	public TBHouse getHouseById(String id) {
		// TODO Auto-generated method stub
		return this.houseDao.getHouseById(id);
	}
	

}
