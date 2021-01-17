package org.lah.AnimalBreeding.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.lah.AnimalBreeding.domain.ExpectantSow;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ExpectantSowMapper {


    //获取总条数
    public Integer totalCount(@Param("ActionID") Integer ActionID,
                              @Param("AnimalNumber") String AnimalNumber,
                              @Param("BehaviorStartTime") String BehaviorStartTime);
    //获取列表
    public List<ExpectantSow> getExpectantSow(@Param("ActionID") Integer ActionID, @Param("AnimalNumber") String AnimalNumber, @Param("BehaviorStartTime") String BehaviorStartTime,
                                              @Param("BehaviorEndTime") String BehaviorEndTime, @Param("BehaviorDescription") String BehaviorDescription, @Param("TreatmentPlan") String TreatmentPlan,
                                              @Param("TreatmentResult") String TreatmentResult, @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

    public int deleteExpectantSow(Integer ActionID);   //删除饲料领取信息
    public int addExpectantSow(ExpectantSow epectantsow);   //添加信息
    public int updateExpectantSow(ExpectantSow epectantsow); //修改信息
    public ExpectantSow findExpectantSowByAI(Integer ActionID);
    public List<ExpectantSow> getAll();
}
