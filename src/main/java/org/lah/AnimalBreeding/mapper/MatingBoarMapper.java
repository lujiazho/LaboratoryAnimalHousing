package org.lah.AnimalBreeding.mapper;

import org.apache.ibatis.annotations.Param;
import org.lah.AnimalBreeding.domain.MatingBoar;

import java.util.List;

/**
 * 配种种猪行为记录表
 */
public interface MatingBoarMapper {
    //获取配种种猪行为记录表总条数
    public Integer totalCount(@Param("ActionID") Integer ActionID,
                              @Param("AnimalNumber") String AnimalNumber,
                              @Param("BehaviorStartTime") String BehaviorStartTime);
    //获取配种种猪行为记录表
    public List<MatingBoar> getMatingBoar(@Param("ActionID") Integer ActionID,
                                          @Param("AnimalNumber") String AnimalNumber,
                                          @Param("BehaviorStartTime") String BehaviorStartTime,
                                          @Param("BehaviorEndTime") String BehaviorEndTime,
                                          @Param("BehaviorDescription") String BehaviorDescription,
                                          @Param("TreatmentPlan") String TreatmentPlan,
                                          @Param("TreatmentResult") String TreatmentResult,
                                          @Param("currentPage") Integer currentPage,
                                          @Param("pageSize") Integer pageSize);

    public int deleteMatingBoar(Integer ActionID);          //删除指定ID的配种种猪行为记录表信息
    public int addMatingBoar(MatingBoar matingBoar);        //添加配种种猪行为记录表信息
    public int updateMatingBoar(MatingBoar matingBoar);     //修改配种种猪行为记录表信息
    public MatingBoar findMatingBoarById(Integer ActionID); //根据ID查询配种种猪行为记录表信息
    public List<MatingBoar> getAll();                       //查询所有配种种猪行为记录表信息
}
