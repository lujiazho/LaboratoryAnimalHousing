package org.lah.AnimalBreeding.service.impl;

import org.lah.AnimalBreeding.domain.AnimalBreed;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.mapper.AnimalBreedMapper;
import org.lah.AnimalBreeding.service.AnimalBreedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;


/**
 * 用户Service接口实现类
 */
@Service("AnimalBreedService")
@Transactional
public class AnimalBreedServiceImpl implements AnimalBreedService {
    @Autowired
    private AnimalBreedMapper aMapper;

    //分页查询
    @Override
    public PageInfo<AnimalBreed> findPageInfo(String RecordDate, Integer AnimalMatingNumber, String SowsNumber,
                                              String SowsSituation, String BoarsNumber,String BoarsSituation ,Integer pageIndex, Integer pageSize)
    {
        PageInfo<AnimalBreed> pi = new PageInfo<AnimalBreed>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = aMapper.totalCount(AnimalMatingNumber);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            List<AnimalBreed> eequipList =aMapper.getAnimalBreed(RecordDate, AnimalMatingNumber, SowsNumber,
                    SowsSituation,BoarsNumber, BoarsSituation, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(eequipList);
        }
        return pi;
    }
    @Override
    public List<AnimalBreed> getAll(){
        List<AnimalBreed> aList = aMapper.getAll();
        return aList;
    }

    //通过编号删除饲料领取信息
    @Override
    public int deleteAnimalBreed(Integer AnimalMatingNumber) {
        return aMapper.deleteAnimalBreed(AnimalMatingNumber);
    }
    //添加信息
    @Override
    public  int addAnimalBreed(AnimalBreed animalbreed) {
        return aMapper.addAnimalBreed(animalbreed);
    }
    //修改信息
    @Override
    public int updateAnimalBreed(AnimalBreed animalbreed) { return aMapper.updateAnimalBreed(animalbreed); }

    @Override
    public AnimalBreed findAnimalBreedByAN (Integer AnimalMatingNumber){
        AnimalBreed animalbreed = aMapper.findAnimalBreedByAN(AnimalMatingNumber);
        return  animalbreed;
    }
}
