package org.lah.AnimalBreeding.service;

import org.lah.AnimalBreeding.domain.EstrusSow;
import org.lah.AnimalBreeding.domain.PageInfo;

import java.util.List;

/**
 * 发情母猪行为记录表
 */
public interface EstrusSowService {

    //分页查询发情母猪行为记录表
    public PageInfo<EstrusSow> findPageInfo(Integer ActionID, String AnimalNumber, String BehaviorStartTime, String BehaviorEndTime,
                                             String BehaviorDescription, String TreatmentPlan, String TreatmentResult, Integer pageIndex, Integer pageSize);
    public int deleteEstrusSow(Integer ActionID);          //删除发情母猪行为记录表信息
    public int addEstrusSow(EstrusSow estrusSow);        //添加发情母猪行为记录表信息
    public int updateEstrusSow(EstrusSow estrusSow);     //修改发情母猪行为记录表信息
    public EstrusSow findEstrusSowById(Integer ActionID); //根据ID查询发情母猪行为记录表信息
    public List<EstrusSow> getAll();                       //查询所有发情母猪行为记录表信息
}
