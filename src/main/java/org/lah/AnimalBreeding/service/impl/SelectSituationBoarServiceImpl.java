package org.lah.AnimalBreeding.service.impl;

import org.lah.AnimalBreeding.domain.SelectSituationBoar;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.mapper.SelectSituationBoarMapper;
import org.lah.AnimalBreeding.service.SelectSituationBoarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 种猪档案用户Service接口实现类
 */
@Service("SelectSituationBoarService")
@Transactional
public class SelectSituationBoarServiceImpl implements SelectSituationBoarService {
    @Autowired
    private SelectSituationBoarMapper selectSituationBoarMapper;

    //分页查询种猪档案
    @Override
    public PageInfo<SelectSituationBoar> findPageInfo(String AnimalNumber,Integer PigAge,String HealthCondition,String LifeCondition,String Fertility,
                                             String BreedingHistory,String IfBreedSelectObserved,String IfBreedSelect,Integer pageIndex, Integer pageSize) {
        PageInfo<SelectSituationBoar> pi = new PageInfo<SelectSituationBoar>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取种猪档案总条数
        Integer totalCount = selectSituationBoarMapper.totalCount(AnimalNumber,PigAge);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            List<SelectSituationBoar> selectSituationBoarList = selectSituationBoarMapper.getSelectSituationBoar(AnimalNumber,PigAge,HealthCondition,LifeCondition,Fertility,
                    BreedingHistory,IfBreedSelectObserved,IfBreedSelect, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(selectSituationBoarList);
        }
        return pi;
    }

    //查询所有种猪档案信息
    @Override
    public List<SelectSituationBoar> getAll(){
        List<SelectSituationBoar> selectSituationBoarList = selectSituationBoarMapper.getAll();
        return selectSituationBoarList;
    }

    //修改种猪档案信息
    @Override
    public int updateSelectSituationBoar(SelectSituationBoar selectSituationBoar) { return selectSituationBoarMapper.updateSelectSituationBoar(selectSituationBoar); }

    //根据ID查询种猪档案信息
    @Override
    public SelectSituationBoar findSelectSituationBoarById (String AnimalNumber){
        SelectSituationBoar selectSituationBoar = selectSituationBoarMapper.findSelectSituationBoarById(AnimalNumber);
        return selectSituationBoar;
    }


}
