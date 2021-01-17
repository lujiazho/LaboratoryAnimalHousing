package org.lah.AnimalBreeding.service;

import org.lah.AnimalBreeding.domain.AnimalMating;
import org.lah.AnimalBreeding.domain.PageInfo;

import java.util.List;

/**
 * 动物配种记录表
 */
public interface AnimalMatingService {

    //分页查询动物配种记录表
    public PageInfo<AnimalMating> findPageInfo(Integer AnimalMatingNumber,String BoarNumber,String SowNumber,Integer RoomNumber,String MatingStartTime,
                                               String MatingEndTime,String Note, Integer pageIndex, Integer pageSize);
    public int deleteAnimalMating(Integer AnimalMatingNumber);          //删除动物配种记录表信息
    public int addAnimalMating(AnimalMating animalMating);        //添加动物配种记录表信息
    public int updateAnimalMating(AnimalMating animalMating);     //修改动物配种记录表信息
    public AnimalMating findAnimalMatingById(Integer AnimalMatingNumber); //根据ID查询动物配种记录表信息
    public List<AnimalMating> getAll();                       //查询所有动物配种记录表信息
}
