package org.lah.AnimalBreeding.service.impl;

import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.domain.SelectSituationSow;
import org.lah.AnimalBreeding.mapper.SelectSituationSowMapper;
import org.lah.AnimalBreeding.service.SelectSituationSowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 母猪档案用户Service接口实现类
 */
@Service("SelectSituationSowService")
@Transactional
public class SelectSituationSowServiceImpl implements SelectSituationSowService {
    @Autowired
    private SelectSituationSowMapper selectSituationSowMapper;

    //分页查询母猪档案
    @Override
    public PageInfo<SelectSituationSow> findPageInfo(String AnimalNumber,Integer PigAge,String HealthCondition,String LifeCondition,String Fertility,
                                             String BreedingHistory,String IfBreedSelectObserved,String IfBreedSelect,Integer pageIndex, Integer pageSize) {
        PageInfo<SelectSituationSow> pi = new PageInfo<SelectSituationSow>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取母猪档案总条数
        Integer totalCount = selectSituationSowMapper.totalCount(AnimalNumber,PigAge);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            List<SelectSituationSow> selectSituationSowList = selectSituationSowMapper.getSelectSituationSow(AnimalNumber,PigAge,HealthCondition,LifeCondition,Fertility,
                    BreedingHistory,IfBreedSelectObserved,IfBreedSelect, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(selectSituationSowList);
        }
        return pi;
    }

    //查询所有母猪档案信息
    @Override
    public List<SelectSituationSow> getAll(){
        List<SelectSituationSow> selectSituationSowList = selectSituationSowMapper.getAll();
        return selectSituationSowList;
    }

    //修改母猪档案信息
    @Override
    public int updateSelectSituationSow(SelectSituationSow selectSituationSow) { return selectSituationSowMapper.updateSelectSituationSow(selectSituationSow); }

    //根据ID查询母猪档案信息
    @Override
    public SelectSituationSow findSelectSituationSowById (String AnimalNumber){
        SelectSituationSow selectSituationSow = selectSituationSowMapper.findSelectSituationSowById(AnimalNumber);
        return selectSituationSow;
    }


}
