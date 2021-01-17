package org.lah.AnimalBreeding.mapper;

import org.apache.ibatis.annotations.Param;
import org.lah.AnimalBreeding.domain.AnimalMating;

import java.util.List;

/**
 * 动物配种记录表
 */
public interface AnimalMatingMapper {
    //获取动物配种记录表总条数
    public Integer totalCount(@Param("AnimalMatingNumber") Integer AnimalMatingNumber,
                              @Param("BoarNumber") String BoarNumber,
                              @Param("SowNumber") String SowNumber,
                              @Param("RoomNumber") Integer RoomNumber,
                              @Param("MatingStartTime") String MatingStartTime);
    //获取动物配种记录表
    public List<AnimalMating> getAnimalMating(@Param("AnimalMatingNumber") Integer AnimalMatingNumber,
                                          @Param("BoarNumber") String BoarNumber,
                                          @Param("SowNumber") String SowNumber,
                                          @Param("RoomNumber") Integer RoomNumber,
                                          @Param("MatingStartTime") String MatingStartTime,
                                          @Param("MatingEndTime") String MatingEndTime,
                                          @Param("Note") String Note,
                                          @Param("currentPage") Integer currentPage,
                                          @Param("pageSize") Integer pageSize);

    public int deleteAnimalMating(Integer AnimalMatingNumber);          //删除指定ID的动物配种记录表信息
    public int addAnimalMating(AnimalMating animalMating);        //添加动物配种记录表信息
    public int updateAnimalMating(AnimalMating animalMating);     //修改动物配种记录表信息
    public AnimalMating findAnimalMatingById(Integer AnimalMatingNumber); //根据ID查询动物配种记录表信息
    public List<AnimalMating> getAll();                       //查询所有动物配种记录表信息
}
