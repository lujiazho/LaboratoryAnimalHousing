package org.lah.AnimalBreeding.mapper;

import org.apache.ibatis.annotations.Param;
import org.lah.AnimalBreeding.domain.MatingSow;

import java.util.List;

/**
 * 配种母猪行为记录表
 */
public interface MatingSowMapper {
    //获取配种母猪行为记录表总条数
    public Integer totalCount(@Param("ActionID") Integer ActionID,
                              @Param("AnimalNumber") String AnimalNumber,
                              @Param("BehaviorStartTime") String BehaviorStartTime);
    //获取配种母猪行为记录表
    public List<MatingSow> getMatingSow(@Param("ActionID") Integer ActionID,
                                          @Param("AnimalNumber") String AnimalNumber,
                                          @Param("BehaviorStartTime") String BehaviorStartTime,
                                          @Param("BehaviorEndTime") String BehaviorEndTime,
                                          @Param("BehaviorDescription") String BehaviorDescription,
                                          @Param("TreatmentPlan") String TreatmentPlan,
                                          @Param("TreatmentResult") String TreatmentResult,
                                          @Param("currentPage") Integer currentPage,
                                          @Param("pageSize") Integer pageSize);

    public int deleteMatingSow(Integer ActionID);          //删除指定ID的配种母猪行为记录表信息
    public int addMatingSow(MatingSow matingSow);        //添加配种母猪行为记录表信息
    public int updateMatingSow(MatingSow matingSow);     //修改配种母猪行为记录表信息
    public MatingSow findMatingSowById(Integer ActionID); //根据ID查询配种母猪行为记录表信息
    public List<MatingSow> getAll();                       //查询所有配种母猪行为记录表信息
}
