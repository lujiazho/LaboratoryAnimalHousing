package org.lah.AnimalBreeding.mapper;

import org.apache.ibatis.annotations.Param;
import org.lah.AnimalBreeding.domain.EstrusBoar;
import java.util.List;
/**
 * 发情种猪行为记录表
 */
public interface EstrusBoarMapper {
    //获取发情种猪行为记录表总条数
    public Integer totalCount(@Param("ActionID") Integer ActionID,
                              @Param("AnimalNumber") String AnimalNumber,
                              @Param("BehaviorStartTime") String BehaviorStartTime);
    //获取发情种猪行为记录表
    public List<EstrusBoar> getEstrusBoar(@Param("ActionID") Integer ActionID,
                                         @Param("AnimalNumber") String AnimalNumber,
                                         @Param("BehaviorStartTime") String BehaviorStartTime,
                                         @Param("BehaviorEndTime") String BehaviorEndTime,
                                         @Param("BehaviorDescription") String BehaviorDescription,
                                         @Param("TreatmentPlan") String TreatmentPlan,
                                         @Param("TreatmentResult") String TreatmentResult,
                                         @Param("currentPage")Integer currentPage,
                                         @Param("pageSize")Integer pageSize);

    public int deleteEstrusBoar(Integer ActionID);          //删除指定ID的发情种猪行为记录表信息
    public int addEstrusBoar(EstrusBoar estrusBoar);        //添加发情种猪行为记录表信息
    public int updateEstrusBoar(EstrusBoar estrusBoar);     //修改发情种猪行为记录表信息
    public EstrusBoar findEstrusBoarById(Integer ActionID); //根据ID查询发情种猪行为记录表信息
    public List<EstrusBoar> getAll();                       //查询所有发情种猪行为记录表信息
}
