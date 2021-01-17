package org.lah.AnimalBreeding.service.impl;

import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.domain.SelectResultSow;
import org.lah.AnimalBreeding.mapper.SelectResultSowMapper;
import org.lah.AnimalBreeding.service.SelectResultSowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 母猪档案用户Service接口实现类
 */
@Service("SelectResultSowService")
@Transactional
public class SelectResultSowServiceImpl implements SelectResultSowService {
    @Autowired
    private SelectResultSowMapper selectResultSowMapper;

    //分页查询母猪档案
    @Override
    public PageInfo<SelectResultSow> findPageInfo(String AnimalNumber,Integer PigAge,String HealthCondition,String LifeCondition,String Fertility,
                                             String BreedingHistory,String IfBreedSelectObserved,String IfBreedSelect,Integer pageIndex, Integer pageSize) {
        PageInfo<SelectResultSow> pi = new PageInfo<SelectResultSow>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取母猪档案总条数
        Integer totalCount = selectResultSowMapper.totalCount(AnimalNumber,PigAge,HealthCondition,LifeCondition,Fertility,BreedingHistory,IfBreedSelectObserved,IfBreedSelect);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            List<SelectResultSow> selectResultSowList = selectResultSowMapper.getSelectResultSow(AnimalNumber,PigAge,HealthCondition,LifeCondition,Fertility,
                    BreedingHistory,IfBreedSelectObserved,IfBreedSelect, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(selectResultSowList);
        }
        return pi;
    }

    //查询所有母猪档案信息
    @Override
    public List<SelectResultSow> getAll(){
        List<SelectResultSow> selectResultSowList = selectResultSowMapper.getAll();
        return selectResultSowList;
    }

    //通过编号修改母猪档案
    @Override
    public int updateSelectResultSow(String AnimalNumber) {
        return selectResultSowMapper.updateSelectResultSow(AnimalNumber);
    }

    //根据ID查询母猪档案信息
    @Override
    public SelectResultSow findSelectResultSowById (String AnimalNumber){
        SelectResultSow selectResultSow = selectResultSowMapper.findSelectResultSowById(AnimalNumber);
        return selectResultSow;
    }
}
