package org.lah.AnimalBreeding.mapper;

import org.apache.ibatis.annotations.Param;
import org.lah.AnimalBreeding.domain.SelectSituationBoar;

import java.util.List;

/**
 * 种猪档案
 */
public interface SelectSituationBoarMapper {
    //获取种猪档案总条数
    public Integer totalCount(@Param("AnimalNumber") String AnimalNumber,
                              @Param("PigAge") Integer PigAge);
    //获取种猪档案
    public List<SelectSituationBoar> getSelectSituationBoar(@Param("AnimalNumber") String AnimalNumber,
                                          @Param("PigAge") Integer PigAge,
                                          @Param("HealthCondition") String HealthCondition,
                                          @Param("LifeCondition") String LifeCondition,
                                          @Param("Fertility") String Fertility,
                                          @Param("BreedingHistor") String BreedingHistory,
                                          @Param("IfBreedSelectObserved") String IfBreedSelectObserved,
                                          @Param("IfBreedSelect") String IfBreedSelect,
                                          @Param("currentPage") Integer currentPage,
                                          @Param("pageSize") Integer pageSize);
    public int updateSelectSituationBoar(SelectSituationBoar selectSituationBoar);     //修改种猪档案信息
    public SelectSituationBoar findSelectSituationBoarById(String AnimalNumber); //根据ID查询种猪档案信息
    public List<SelectSituationBoar> getAll();                       //查询所有种猪档案信息
}
