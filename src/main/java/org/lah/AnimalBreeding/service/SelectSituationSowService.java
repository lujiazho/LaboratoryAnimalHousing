package org.lah.AnimalBreeding.service;

import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.domain.SelectSituationSow;

import java.util.List;

/**
 * 种猪档案
 */
public interface SelectSituationSowService {

    //分页查询种猪档案
    public PageInfo<SelectSituationSow> findPageInfo(String AnimalNumber, Integer PigAge, String HealthCondition, String LifeCondition, String Fertility,
                                                      String BreedingHistory, String IfBreedSelectObserved, String IfBreedSelect, Integer pageIndex, Integer pageSize);
    public int updateSelectSituationSow(SelectSituationSow selectSituationSow);     //修改种猪档案信息
    public SelectSituationSow findSelectSituationSowById(String AnimalNumber); //根据ID查询种猪档案信息
    public List<SelectSituationSow> getAll();                       //查询所有种猪档案信息
}
