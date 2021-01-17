package org.lah.AnimalBreeding.service.impl;

import org.lah.AnimalBreeding.domain.SelectObserveBoar;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.mapper.SelectObserveBoarMapper;
import org.lah.AnimalBreeding.service.SelectObserveBoarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 种猪档案用户Service接口实现类
 */
@Service("SelectObserveBoarService")
@Transactional
public class SelectObserveBoarServiceImpl implements SelectObserveBoarService {
    @Autowired
    private SelectObserveBoarMapper selectObserveBoarMapper;

    //分页查询种猪档案
    @Override
    public PageInfo<SelectObserveBoar> findPageInfo(String AnimalNumber,Integer PigAge,String HealthCondition,String LifeCondition,String Fertility,
                                             String BreedingHistory,String IfBreedSelectObserved,String IfBreedSelect,Integer pageIndex, Integer pageSize) {
        PageInfo<SelectObserveBoar> pi = new PageInfo<SelectObserveBoar>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取种猪档案总条数
        Integer totalCount = selectObserveBoarMapper.totalCount(AnimalNumber,PigAge,HealthCondition,LifeCondition,Fertility,BreedingHistory,IfBreedSelectObserved,IfBreedSelect);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            List<SelectObserveBoar> selectObserveBoarList = selectObserveBoarMapper.getSelectObserveBoar(AnimalNumber,PigAge,HealthCondition,LifeCondition,Fertility,
                    BreedingHistory,IfBreedSelectObserved,IfBreedSelect, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(selectObserveBoarList);
        }
        return pi;
    }

    //查询所有种猪档案信息
    @Override
    public List<SelectObserveBoar> getAll(){
        List<SelectObserveBoar> selectObserveBoarList = selectObserveBoarMapper.getAll();
        return selectObserveBoarList;
    }

    //通过编号修改种猪档案
    @Override
    public int updateSelectObserveBoar(String AnimalNumber) {
        return selectObserveBoarMapper.updateSelectObserveBoar(AnimalNumber);
    }

    //根据ID查询种猪档案信息
    @Override
    public SelectObserveBoar findSelectObserveBoarById (String AnimalNumber){
        SelectObserveBoar selectObserveBoar = selectObserveBoarMapper.findSelectObserveBoarById(AnimalNumber);
        return selectObserveBoar;
    }
}
