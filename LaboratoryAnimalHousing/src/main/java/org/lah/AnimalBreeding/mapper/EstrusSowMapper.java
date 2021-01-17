package org.lah.AnimalBreeding.mapper;

import org.apache.ibatis.annotations.Param;
import org.lah.AnimalBreeding.domain.EstrusSow;

import java.util.List;

/**
 * 发情母猪行为记录表
 */
public interface EstrusSowMapper {
    //获取发情母猪行为记录表总条数
    public Integer totalCount(@Param("ActionID") Integer ActionID,
                              @Param("AnimalNumber") String AnimalNumber,
                              @Param("BehaviorStartTime") String BehaviorStartTime);
    //获取发情母猪行为记录表
    public List<EstrusSow> getEstrusSow(@Param("ActionID") Integer ActionID,
                                          @Param("AnimalNumber") String AnimalNumber,
                                          @Param("BehaviorStartTime") String BehaviorStartTime,
                                          @Param("BehaviorEndTime") String BehaviorEndTime,
                                          @Param("BehaviorDescription") String BehaviorDescription,
                                          @Param("TreatmentPlan") String TreatmentPlan,
                                          @Param("TreatmentResult") String TreatmentResult,
                                          @Param("currentPage") Integer currentPage,
                                          @Param("pageSize") Integer pageSize);

    public int deleteEstrusSow(Integer ActionID);          //删除指定ID的发情母猪行为记录表信息
    public int addEstrusSow(EstrusSow estrusSow);        //添加发情母猪行为记录表信息
    public int updateEstrusSow(EstrusSow estrusSow);     //修改发情母猪行为记录表信息
    public EstrusSow findEstrusSowById(Integer ActionID); //根据ID查询发情母猪行为记录表信息
    public List<EstrusSow> getAll();                       //查询所有发情母猪行为记录表信息
}
