package org.lah.AnimalBreeding.service;

import org.apache.ibatis.annotations.Param;
import org.lah.AnimalBreeding.domain.AnimalBreed;
import org.lah.AnimalBreeding.domain.PageInfo;
import java.util.List;

public interface AnimalBreedService {

    //分页查询
    public PageInfo<AnimalBreed> findPageInfo(String RecordDate, Integer AnimalMatingNumber, String SowsNumber,
                                         String SowsSituation, String BoarsNumber,String BoarsSituation,Integer pageIndex, Integer pageSize);

    public int deleteAnimalBreed(Integer AnimalMatingNumber);   //删除信息
    public int addAnimalBreed(AnimalBreed animalbreed);   //添加信息
    public int updateAnimalBreed(AnimalBreed animalbreed); //修改信息

    public AnimalBreed findAnimalBreedByAN(Integer AnimalMatingNumber);
    public List<AnimalBreed> getAll();

}
