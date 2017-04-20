package com.haiyi.residence.unitpopulation.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.haiyi.residence.model.MediaFile;
import com.haiyi.residence.model.TBUnitPopulation;

public interface UnitPopulationService {
	/**
	 * ��ѯ���� ����ҳ
	 * @Description: TODO
	 * @param @param start
	 * @param @param end
	 * @param @return   
	 * @return List<TBUnitPopulation>  
	 * @throws
	 * @author luofeng
	 * @date 2015-11-22
	 */
	public List<TBUnitPopulation> getAll(int start, int end);
	
	public Integer getCount();
	/**
	 * ɾ��
	 * @Description: TODO
	 * @param @param id   
	 * @return void  
	 * @throws
	 * @author luofeng
	 * @date 2015-11-22
	 */
	public void deleteUnitPopulation(String id);


	/**
	 * �޸�
	 * @Description: TODO
	 * @param @param tb   
	 * @return void  
	 * @throws
	 * @author luofeng
	 * @date 2015-11-22
	 */
	public void updateUnitPopulation(TBUnitPopulation tb);

	/**
	 * ������ѯ(����  ���֤  �ֻ���)
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
	 * ��ѯ ���˻���
	 * @Description: TODO
	 * @param @param id
	 * @param @param uId
	 * @param @return   
	 * @return TBUnitPopulation  
	 * @throws
	 * @author luofeng
	 * @date 2015-11-22
	 */
	public TBUnitPopulation getLLUPInfo(String id);
	/**
	 * ��ѯ��λԱ��
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
	 * ��ѯ��λԱ��ͬ����Ϣ
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
	
	public void insertUnitPopulation(TBUnitPopulation tb);
	public List<TBUnitPopulation> getAllList();
	public TBUnitPopulation findByID(@Param("id")String id);
	
	public void deleteUnitPopulationByUId(@Param("uId")String uId);

}
