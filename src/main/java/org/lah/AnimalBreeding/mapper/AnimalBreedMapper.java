package org.lah.AnimalBreeding.mapper;

import org.apache.ibatis.annotations.*;
import org.lah.AnimalBreeding.domain.AnimalBreed;
import java.util.List;


public interface AnimalBreedMapper {

    //获取总条数
    public Integer totalCount(@Param("AnimalMatingNumber") Integer AnimalMatingNumber);
    //获取列表
    public List<AnimalBreed> getAnimalBreed(@Param("RecordDate") String RecordDate,
                                  @Param("AnimalMatingNumber")Integer AnimalMatingNumber, @Param("SowsNumber")String SowsNumber,
                                  @Param("SowsSituation")String SowsSituation, @Param("BoarsNumber")String BoarsNumber,@Param("BoarsSituation")String BoarsSituation,
                                  @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

    public int deleteAnimalBreed(Integer AnimalMatingNumber);   //删除饲料领取信息
    public int addAnimalBreed(AnimalBreed animalbreed);   //添加信息
    public int updateAnimalBreed(AnimalBreed animalbreed); //修改信息
    public AnimalBreed findAnimalBreedByAN(Integer AnimalMatingNumber);
    public List<AnimalBreed> getAll();
}
