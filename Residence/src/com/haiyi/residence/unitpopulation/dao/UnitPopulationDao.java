package com.haiyi.residence.unitpopulation.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.haiyi.residence.mapper.SuperMapper;
import com.haiyi.residence.model.MediaFile;
import com.haiyi.residence.model.TBResidentPopulation;
import com.haiyi.residence.model.TBUnitPopulation;

public interface UnitPopulationDao extends SuperMapper{
	/**
	 * 查询所有
	 * @Description: TODO
	 * @param @param start
	 * @param @param end
	 * @param @return   
	 * @return List<TBUnitPopulation>  
	 * @throws
	 * @author luofeng
	 * @date 2015-11-22
	 */
	public List<TBUnitPopulation> getAll(@Param(value="start")int start,@Param(value="end")int end);
	
	public Integer getCount();
	/**
	 * 根据Id查询
	 * @Description: TODO
	 * @param @param id
	 * @param @return   
	 * @return TBUnitPopulation  
	 * @throws
	 * @author luofeng
	 * @date 2015-11-22
	 */
	public TBUnitPopulation getTBUnitPopulationByID(String id);
	/**
	 * 删除
	 * @Description: TODO
	 * @param @param id   
	 * @return void  
	 * @throws
	 * @author luofeng
	 * @date 2015-11-22
	 */
	public void deleteUnitPopulation(String id);
	/**
	 * 修改
	 * @Description: TODO
	 * @param @param tb   
	 * @return void  
	 * @throws
	 * @author luofeng
	 * @date 2015-11-22
	 */
	public void updateUnitPopulation(TBUnitPopulation tb);
	/**
	 * 条件查询(姓名  身份证  手机号)
	 * @Description: TODO
	 * @param @param tb
	 * @param @return   
	 * @return List<TBUnitPopulation>  
	 * @throws
	 * @author luofeng
	 * @date 2015-11-22
	 */
	public List<TBUnitPopulation> getUnitPopulationQuery(TBUnitPopulation tb);
	/**
	 * 查询 法人或房主
	 * @Description: TODO
	 * @param @param id
	 * @param @param uId
	 * @param @return   
	 * @return TBUnitPopulation  
	 * @throws
	 * @author luofeng
	 * @date 2015-11-22
	 */
	public TBUnitPopulation getLLUPInfo(@Param(value="id")String id);//,@Param(value="uId")String uId
	/**
	 * 查询单位员工
	 * @Description: TODO
	 * @param @param uId
	 * @param @return   
	 * @return List<TBUnitPopulation>  
	 * @throws
	 * @author luofeng
	 * @date 2015-11-22
	 */
	public List<TBUnitPopulation> getUnitPopulationInfo(String uId);
	/**
	 * 查询单位员工同事信息
	 * @Description: TODO
	 * @param @param uId
	 * @param @param id
	 * @param @return   
	 * @return List<TBUnitPopulation>  
	 * @throws
	 * @author luofeng
	 * @date 2015-11-24
	 */
	public List<TBUnitPopulation> getunitColleagueInfo(@Param(value="uId")String uId,@Param(value="id")String id);
	
	public MediaFile findImages(@Param("id")String id);
	
	public void insertUnitPopulation(@Param(value="tb") TBUnitPopulation tb);
	public List<TBUnitPopulation> getAllList();
	
	public TBUnitPopulation findByID(@Param("id")String id);
	
	public void deleteUnitPopulationByUId(@Param("uId") String uId);


}
