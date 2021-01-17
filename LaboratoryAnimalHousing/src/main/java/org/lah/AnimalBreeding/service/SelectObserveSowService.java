package org.lah.AnimalBreeding.service;

import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.domain.SelectObserveSow;

import java.util.List;

/**
 * 母猪档案
 */
public interface SelectObserveSowService {

    //分页查询母猪档案
    public PageInfo<SelectObserveSow> findPageInfo(String AnimalNumber, Integer PigAge, String HealthCondition, String LifeCondition, String Fertility, String BreedingHistory, String IfBreedSelectObserved, String IfBreedSelect, Integer pageIndex, Integer pageSize);
    public int updateSelectObserveSow(String AnimalNumber);          //修改母猪档案信息
    public SelectObserveSow findSelectObserveSowById(String AnimalNumber); //根据ID查询母猪档案信息
    public List<SelectObserveSow> getAll();                       //查询所有母猪档案信息
}
