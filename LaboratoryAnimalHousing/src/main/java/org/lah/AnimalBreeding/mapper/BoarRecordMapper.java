package org.lah.AnimalBreeding.mapper;

import org.apache.ibatis.annotations.Param;
import org.lah.AnimalBreeding.domain.BoarRecord;

import java.util.List;

/**
 * 种猪档案
 */
public interface BoarRecordMapper {
    //获取种猪档案总条数
    public Integer totalCount(@Param("AnimalNumber")String AnimalNumber,
                              @Param("PigAge")Integer PigAge);
    //获取种猪档案
    public List<BoarRecord> getBoarRecord(@Param("AnimalNumber")String AnimalNumber,
                                          @Param("PigAge")Integer PigAge,
                                          @Param("HealthCondition")String HealthCondition,
                                          @Param("LifeCondition")String LifeCondition,
                                          @Param("Fertility")String Fertility,
                                          @Param("BreedingHistor")String BreedingHistory,
                                          @Param("IfBreedSelectObserved")String IfBreedSelectObserved,
                                          @Param("IfBreedSelect")String IfBreedSelect,
                                          @Param("currentPage") Integer currentPage,
                                          @Param("pageSize") Integer pageSize);
    public int updateBoarRecord(BoarRecord boarRecord);     //修改种猪档案信息
    public BoarRecord findBoarRecordById(String AnimalNumber); //根据ID查询种猪档案信息
    public List<BoarRecord> getAll();                       //查询所有种猪档案信息
}
