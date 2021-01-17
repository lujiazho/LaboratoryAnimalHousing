package org.lah.AnimalBreeding.service;

import org.lah.AnimalBreeding.domain.BoarRecord;
import org.lah.AnimalBreeding.domain.PageInfo;

import java.util.List;

/**
 * 种猪档案
 */
public interface BoarRecordService {

    //分页查询种猪档案
    public PageInfo<BoarRecord> findPageInfo(String AnimalNumber,Integer PigAge,String HealthCondition,String LifeCondition,String Fertility,
                                             String BreedingHistory,String IfBreedSelectObserved,String IfBreedSelect, Integer pageIndex, Integer pageSize);
    public int updateBoarRecord(BoarRecord boarRecord);     //修改种猪档案信息
    public BoarRecord findBoarRecordById(String AnimalNumber); //根据ID查询种猪档案信息
    public List<BoarRecord> getAll();                       //查询所有种猪档案信息
}
