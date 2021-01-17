package org.lah.AnimalBreeding.mapper;

import org.apache.ibatis.annotations.Param;
import org.lah.AnimalBreeding.domain.SelectSituationSow;

import java.util.List;

/**
 * 母猪档案
 */
public interface SelectSituationSowMapper {
    //获取母猪档案总条数
    public Integer totalCount(@Param("AnimalNumber") String AnimalNumber,
                              @Param("PigAge") Integer PigAge);
    //获取母猪档案
    public List<SelectSituationSow> getSelectSituationSow(@Param("AnimalNumber") String AnimalNumber,
                                                            @Param("PigAge") Integer PigAge,
                                                            @Param("HealthCondition") String HealthCondition,
                                                            @Param("LifeCondition") String LifeCondition,
                                                            @Param("Fertility") String Fertility,
                                                            @Param("BreedingHistor") String BreedingHistory,
                                                            @Param("IfBreedSelectObserved") String IfBreedSelectObserved,
                                                            @Param("IfBreedSelect") String IfBreedSelect,
                                                            @Param("currentPage") Integer currentPage,
                                                            @Param("pageSize") Integer pageSize);
    public int updateSelectSituationSow(SelectSituationSow selectSituationSow);     //修改母猪档案信息
    public SelectSituationSow findSelectSituationSowById(String AnimalNumber); //根据ID查询母猪档案信息
    public List<SelectSituationSow> getAll();                       //查询所有母猪档案信息
}
