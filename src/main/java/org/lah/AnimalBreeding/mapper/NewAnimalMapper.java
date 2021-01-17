package org.lah.AnimalBreeding.mapper;

import org.apache.ibatis.annotations.*;
import org.lah.AnimalBreeding.domain.NewAnimal;
import java.util.List;


public interface NewAnimalMapper {

    //获取总条数
    public Integer totalCount(@Param("AnimalNumber") String AnimalNumber);
    //获取列表
    public List<NewAnimal> getNewAnimal(@Param("AnimalNumber") String AnimalNumber,
                                  @Param("RecordDate")String RecordDate, @Param("AnimalSex")String AnimalSex,
                                  @Param("IncineratorPerson")String IncineratorPerson, @Param("BroodChamber")String BroodChamber,
                                  @Param("SowNumber")String SowNumber, @Param("HealthCondition")String HealthCondition,
                                  @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

    public int deleteNewAnimal(String AnimalNumber);   //删除饲料领取信息
    public int addNewAnimal(NewAnimal newanimal);   //添加信息
    public int updateNewAnimal(NewAnimal newanimal); //修改信息
    public NewAnimal findNewAnimalByAN(String AnimalNumber);
    public List<NewAnimal> getAll();
}
