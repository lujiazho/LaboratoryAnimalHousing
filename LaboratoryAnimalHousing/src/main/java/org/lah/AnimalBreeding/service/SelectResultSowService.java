package org.lah.AnimalBreeding.service;

import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.domain.SelectResultSow;

import java.util.List;

/**
 * 种猪档案
 */
public interface SelectResultSowService {

    //分页查询种猪档案
    public PageInfo<SelectResultSow> findPageInfo(String AnimalNumber, Integer PigAge, String HealthCondition, String LifeCondition, String Fertility, String BreedingHistory, String IfBreedSelectObserved, String IfBreedSelect, Integer pageIndex, Integer pageSize);
    public int updateSelectResultSow(String AnimalNumber);          //修改种猪档案信息
    public SelectResultSow findSelectResultSowById(String AnimalNumber); //根据ID查询种猪档案信息
    public List<SelectResultSow> getAll();                       //查询所有种猪档案信息
}
