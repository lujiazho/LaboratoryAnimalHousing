package org.lah.AnimalBreeding.service;

import org.lah.AnimalBreeding.domain.SowRecord;
import org.lah.AnimalBreeding.domain.PageInfo;

import java.util.List;

/**
 * 母猪档案
 */
public interface SowRecordService {

    //分页查询母猪档案
    public PageInfo<SowRecord> findPageInfo(String AnimalNumber, Integer PigAge, String HealthCondition, String LifeCondition, String Fertility,
                                             String BreedingHistory, String IfBreedSelectObserved, String IfBreedSelect, Integer pageIndex, Integer pageSize);
    public int updateSowRecord(SowRecord sowRecord);     //修改母猪档案信息
    public SowRecord findSowRecordById(String AnimalNumber); //根据ID查询母猪档案信息
    public List<SowRecord> getAll();                       //查询所有母猪档案信息
}
