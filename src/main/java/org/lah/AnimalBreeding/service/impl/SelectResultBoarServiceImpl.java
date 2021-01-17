package org.lah.AnimalBreeding.service.impl;

import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.domain.SelectResultBoar;
import org.lah.AnimalBreeding.mapper.SelectResultBoarMapper;
import org.lah.AnimalBreeding.service.SelectResultBoarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 种猪档案用户Service接口实现类
 */
@Service("SelectResultBoarService")
@Transactional
public class SelectResultBoarServiceImpl implements SelectResultBoarService {
    @Autowired
    private SelectResultBoarMapper selectResultBoarMapper;

    //分页查询种猪档案
    @Override
    public PageInfo<SelectResultBoar> findPageInfo(String AnimalNumber,Integer PigAge,String HealthCondition,String LifeCondition,String Fertility,
                                             String BreedingHistory,String IfBreedSelectObserved,String IfBreedSelect,Integer pageIndex, Integer pageSize) {
        PageInfo<SelectResultBoar> pi = new PageInfo<SelectResultBoar>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取种猪档案总条数
        Integer totalCount = selectResultBoarMapper.totalCount(AnimalNumber,PigAge,HealthCondition,LifeCondition,Fertility,BreedingHistory,IfBreedSelectObserved,IfBreedSelect);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            List<SelectResultBoar> selectResultBoarList = selectResultBoarMapper.getSelectResultBoar(AnimalNumber,PigAge,HealthCondition,LifeCondition,Fertility,
                    BreedingHistory,IfBreedSelectObserved,IfBreedSelect, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(selectResultBoarList);
        }
        return pi;
    }

    //查询所有种猪档案信息
    @Override
    public List<SelectResultBoar> getAll(){
        List<SelectResultBoar> selectResultBoarList = selectResultBoarMapper.getAll();
        return selectResultBoarList;
    }

    //通过编号修改种猪档案
    @Override
    public int updateSelectResultBoar(String AnimalNumber) {
        return selectResultBoarMapper.updateSelectResultBoar(AnimalNumber);
    }

    //根据ID查询种猪档案信息
    @Override
    public SelectResultBoar findSelectResultBoarById (String AnimalNumber){
        SelectResultBoar selectResultBoar = selectResultBoarMapper.findSelectResultBoarById(AnimalNumber);
        return selectResultBoar;
    }
}
