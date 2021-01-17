package org.lah.AnimalBreeding.service;

import org.lah.AnimalBreeding.domain.SelectObserveBoar;
import org.lah.AnimalBreeding.domain.PageInfo;

import java.util.List;

/**
 * 种猪档案
 */
public interface SelectObserveBoarService {

    //分页查询种猪档案
    public PageInfo<SelectObserveBoar> findPageInfo(String AnimalNumber, Integer PigAge, String HealthCondition, String LifeCondition, String Fertility,String BreedingHistory, String IfBreedSelectObserved, String IfBreedSelect, Integer pageIndex, Integer pageSize);
    public int updateSelectObserveBoar(String AnimalNumber);          //修改种猪档案信息
    public SelectObserveBoar findSelectObserveBoarById(String AnimalNumber); //根据ID查询种猪档案信息
    public List<SelectObserveBoar> getAll();                       //查询所有种猪档案信息
}
