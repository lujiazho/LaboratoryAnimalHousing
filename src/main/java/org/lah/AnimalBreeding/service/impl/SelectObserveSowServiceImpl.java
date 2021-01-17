package org.lah.AnimalBreeding.service.impl;

import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.domain.SelectObserveSow;
import org.lah.AnimalBreeding.mapper.SelectObserveSowMapper;
import org.lah.AnimalBreeding.service.SelectObserveSowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 母猪档案用户Service接口实现类
 */
@Service("SelectObserveSowService")
@Transactional
public class SelectObserveSowServiceImpl implements SelectObserveSowService {
    @Autowired
    private SelectObserveSowMapper selectObserveSowMapper;

    //分页查询母猪档案
    @Override
    public PageInfo<SelectObserveSow> findPageInfo(String AnimalNumber,Integer PigAge,String HealthCondition,String LifeCondition,String Fertility,
                                             String BreedingHistory,String IfBreedSelectObserved,String IfBreedSelect,Integer pageIndex, Integer pageSize) {
        PageInfo<SelectObserveSow> pi = new PageInfo<SelectObserveSow>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取母猪档案总条数
        Integer totalCount = selectObserveSowMapper.totalCount(AnimalNumber,PigAge,HealthCondition,LifeCondition,Fertility,BreedingHistory,IfBreedSelectObserved,IfBreedSelect);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            List<SelectObserveSow> selectObserveSowList = selectObserveSowMapper.getSelectObserveSow(AnimalNumber,PigAge,HealthCondition,LifeCondition,Fertility,
                    BreedingHistory,IfBreedSelectObserved,IfBreedSelect, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(selectObserveSowList);
        }
        return pi;
    }

    //查询所有母猪档案信息
    @Override
    public List<SelectObserveSow> getAll(){
        List<SelectObserveSow> selectObserveSowList = selectObserveSowMapper.getAll();
        return selectObserveSowList;
    }

    //通过编号修改母猪档案
    @Override
    public int updateSelectObserveSow(String AnimalNumber) {
        return selectObserveSowMapper.updateSelectObserveSow(AnimalNumber);
    }

    //根据ID查询母猪档案信息
    @Override
    public SelectObserveSow findSelectObserveSowById (String AnimalNumber){
        SelectObserveSow selectObserveSow = selectObserveSowMapper.findSelectObserveSowById(AnimalNumber);
        return selectObserveSow;
    }
}
