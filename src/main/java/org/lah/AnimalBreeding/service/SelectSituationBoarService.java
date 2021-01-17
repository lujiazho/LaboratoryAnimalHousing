package org.lah.AnimalBreeding.service;

import org.lah.AnimalBreeding.domain.SelectSituationBoar;
import org.lah.AnimalBreeding.domain.PageInfo;

import java.util.List;

/**
 * 种猪档案
 */
public interface SelectSituationBoarService {

    //分页查询种猪档案
    public PageInfo<SelectSituationBoar> findPageInfo(String AnimalNumber, Integer PigAge, String HealthCondition, String LifeCondition, String Fertility,
                                             String BreedingHistory, String IfBreedSelectObserved, String IfBreedSelect, Integer pageIndex, Integer pageSize);
    public int updateSelectSituationBoar(SelectSituationBoar selectSituationBoar);     //修改种猪档案信息
    public SelectSituationBoar findSelectSituationBoarById(String AnimalNumber); //根据ID查询种猪档案信息
    public List<SelectSituationBoar> getAll();                       //查询所有种猪档案信息
}
