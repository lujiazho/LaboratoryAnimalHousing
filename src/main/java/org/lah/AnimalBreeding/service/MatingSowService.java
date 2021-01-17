package org.lah.AnimalBreeding.service;

import org.lah.AnimalBreeding.domain.MatingSow;
import org.lah.AnimalBreeding.domain.PageInfo;

import java.util.List;

/**
 * 配种母猪行为记录表
 */
public interface MatingSowService {

    //分页查询配种母猪行为记录表
    public PageInfo<MatingSow> findPageInfo(Integer ActionID, String AnimalNumber, String BehaviorStartTime, String BehaviorEndTime,
                                             String BehaviorDescription, String TreatmentPlan, String TreatmentResult, Integer pageIndex, Integer pageSize);
    public int deleteMatingSow(Integer ActionID);          //删除配种母猪行为记录表信息
    public int addMatingSow(MatingSow matingSow);        //添加配种母猪行为记录表信息
    public int updateMatingSow(MatingSow matingSow);     //修改配种母猪行为记录表信息
    public MatingSow findMatingSowById(Integer ActionID); //根据ID查询配种母猪行为记录表信息
    public List<MatingSow> getAll();                       //查询所有配种母猪行为记录表信息
}
