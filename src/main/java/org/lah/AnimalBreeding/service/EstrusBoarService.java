package org.lah.AnimalBreeding.service;

import org.lah.AnimalBreeding.domain.EstrusBoar;
import org.lah.AnimalBreeding.domain.PageInfo;
import java.util.List;

/**
 * 发情种猪行为记录表
 */
public interface EstrusBoarService {

    //分页查询发情种猪行为记录表
    public PageInfo<EstrusBoar> findPageInfo(Integer ActionID,String AnimalNumber,String BehaviorStartTime,String BehaviorEndTime,
                                            String BehaviorDescription,String TreatmentPlan,String TreatmentResult,Integer pageIndex, Integer pageSize);
    public int deleteEstrusBoar(Integer ActionID);          //删除发情种猪行为记录表信息
    public int addEstrusBoar(EstrusBoar estrusBoar);        //添加发情种猪行为记录表信息
    public int updateEstrusBoar(EstrusBoar estrusBoar);     //修改发情种猪行为记录表信息
    public EstrusBoar findEstrusBoarById(Integer ActionID); //根据ID查询发情种猪行为记录表信息
    public List<EstrusBoar> getAll();                       //查询所有发情种猪行为记录表信息
}
