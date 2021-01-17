package org.lah.AnimalBreeding.service;

import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.domain.SelectResultBoar;

import java.util.List;

/**
 * 种猪档案
 */
public interface SelectResultBoarService {

    //分页查询种猪档案
    public PageInfo<SelectResultBoar> findPageInfo(String AnimalNumber, Integer PigAge, String HealthCondition, String LifeCondition, String Fertility, String BreedingHistory, String IfBreedSelectObserved, String IfBreedSelect, Integer pageIndex, Integer pageSize);
    public int updateSelectResultBoar(String AnimalNumber);          //修改种猪档案信息
    public SelectResultBoar findSelectResultBoarById(String AnimalNumber); //根据ID查询种猪档案信息
    public List<SelectResultBoar> getAll();                       //查询所有种猪档案信息
}
