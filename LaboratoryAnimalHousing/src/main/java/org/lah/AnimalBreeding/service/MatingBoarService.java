package org.lah.AnimalBreeding.service;

import org.lah.AnimalBreeding.domain.MatingBoar;
import org.lah.AnimalBreeding.domain.PageInfo;

import java.util.List;

/**
 * 配种种猪行为记录表
 */
public interface MatingBoarService {

    //分页查询配种种猪行为记录表
    public PageInfo<MatingBoar> findPageInfo(Integer ActionID, String AnimalNumber, String BehaviorStartTime, String BehaviorEndTime,
                                             String BehaviorDescription, String TreatmentPlan, String TreatmentResult, Integer pageIndex, Integer pageSize);
    public int deleteMatingBoar(Integer ActionID);          //删除配种种猪行为记录表信息
    public int addMatingBoar(MatingBoar matingBoar);        //添加配种种猪行为记录表信息
    public int updateMatingBoar(MatingBoar matingBoar);     //修改配种种猪行为记录表信息
    public MatingBoar findMatingBoarById(Integer ActionID); //根据ID查询配种种猪行为记录表信息
    public List<MatingBoar> getAll();                       //查询所有配种种猪行为记录表信息
}
