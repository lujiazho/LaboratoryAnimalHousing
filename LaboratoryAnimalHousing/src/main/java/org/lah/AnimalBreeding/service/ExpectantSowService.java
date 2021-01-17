package org.lah.AnimalBreeding.service;

import org.lah.AnimalBreeding.domain.ExpectantSow;
import org.lah.AnimalBreeding.domain.PageInfo;

import java.util.List;

public interface ExpectantSowService {
    //分页查询
    public PageInfo<ExpectantSow> findPageInfo(Integer ActionID, String AnimalNumber, String BehaviorStartTime, String BehaviorEndTime, String BehaviorDescription,
                                               String TreatmentPlan, String TreatmentResult,Integer pageIndex, Integer pageSize);
    public int deleteExpectantSow(Integer ActionID);   //删除信息
    public int addExpectantSow(ExpectantSow expectantsow);   //添加信息
    public int updateExpectantSow(ExpectantSow expectantsow); //修改信息
    public ExpectantSow findExpectantSowByAI(Integer ActionId);
    public List<ExpectantSow> getAll();

}
