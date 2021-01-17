package org.lah.AnimalBreeding.service.impl;

import org.lah.AnimalBreeding.domain.AnimalMating;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.mapper.AnimalMatingMapper;
import org.lah.AnimalBreeding.service.AnimalMatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 动物配种记录表用户Service接口实现类
 */
@Service("AnimalMatingService")
@Transactional
public class AnimalMatingServiceImpl implements AnimalMatingService {
    @Autowired
    private AnimalMatingMapper animalMatingMapper;

    //分页查询动物配种记录表
    @Override
    public PageInfo<AnimalMating> findPageInfo(Integer AnimalMatingNumber,String BoarNumber,String SowNumber,Integer RoomNumber,String MatingStartTime,
                                               String MatingEndTime,String Note,Integer pageIndex, Integer pageSize) {
        PageInfo<AnimalMating> pi = new PageInfo<AnimalMating>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取动物配种记录表总条数
        Integer totalCount = animalMatingMapper.totalCount(AnimalMatingNumber,BoarNumber,SowNumber, RoomNumber,MatingStartTime);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            List<AnimalMating> animalMatingList = animalMatingMapper.getAnimalMating(AnimalMatingNumber,BoarNumber,SowNumber, RoomNumber,MatingStartTime,MatingEndTime,Note, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(animalMatingList);
        }
        return pi;
    }

    //查询所有动物配种记录表信息
    @Override
    public List<AnimalMating> getAll(){
        List<AnimalMating> animalMatingList = animalMatingMapper.getAll();
        return animalMatingList;
    }

    //通过编号删除动物配种记录表
    @Override
    public int deleteAnimalMating(Integer AnimalMatingNumber) {
        return animalMatingMapper.deleteAnimalMating(AnimalMatingNumber);
    }

    //添加动物配种记录表信息
    @Override
    public  int addAnimalMating(AnimalMating animalMating) {
        return animalMatingMapper.addAnimalMating(animalMating);
    }

    //修改动物配种记录表信息
    @Override
    public int updateAnimalMating(AnimalMating animalMating) { return animalMatingMapper.updateAnimalMating(animalMating); }

    //根据ID查询动物配种记录表信息
    @Override
    public AnimalMating findAnimalMatingById (Integer AnimalMatingNumber){
        AnimalMating animalMating = animalMatingMapper.findAnimalMatingById(AnimalMatingNumber);
        return animalMating;
    }


}
