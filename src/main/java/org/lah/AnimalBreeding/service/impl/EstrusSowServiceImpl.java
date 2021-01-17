package org.lah.AnimalBreeding.service.impl;

import org.lah.AnimalBreeding.domain.EstrusSow;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.mapper.EstrusSowMapper;
import org.lah.AnimalBreeding.service.EstrusSowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 发情母猪行为记录表用户Service接口实现类
 */
@Service("EstrusSowService")
@Transactional
public class EstrusSowServiceImpl implements EstrusSowService {
    @Autowired
    private EstrusSowMapper estrusSowMapper;

    //分页查询发情母猪行为记录表
    @Override
    public PageInfo<EstrusSow> findPageInfo(Integer ActionID,String AnimalNumber,String BehaviorStartTime,String BehaviorEndTime,
            String BehaviorDescription,String TreatmentPlan,String TreatmentResult,Integer pageIndex, Integer pageSize) {
        PageInfo<EstrusSow> pi = new PageInfo<EstrusSow>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取发情母猪行为记录表总条数
        Integer totalCount = estrusSowMapper.totalCount(ActionID,AnimalNumber,BehaviorStartTime);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            List<EstrusSow> estrusSowList = estrusSowMapper.getEstrusSow(ActionID,AnimalNumber,BehaviorStartTime,BehaviorEndTime,BehaviorDescription,TreatmentPlan,TreatmentResult, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(estrusSowList);
        }
        return pi;
    }

    //查询所有发情母猪行为记录表信息
    @Override
    public List<EstrusSow> getAll(){
        List<EstrusSow> estrusSowList = estrusSowMapper.getAll();
        return estrusSowList;
    }

    //通过编号删除发情母猪行为记录表
    @Override
    public int deleteEstrusSow(Integer ActionID) {
        return estrusSowMapper.deleteEstrusSow(ActionID);
    }

    //添加发情母猪行为记录表信息
    @Override
    public  int addEstrusSow(EstrusSow estrusSow) {
        return estrusSowMapper.addEstrusSow(estrusSow);
    }

    //修改发情母猪行为记录表信息
    @Override
    public int updateEstrusSow(EstrusSow estrusSow) { return estrusSowMapper.updateEstrusSow(estrusSow); }

    //根据ID查询发情母猪行为记录表信息
    @Override
    public EstrusSow findEstrusSowById (Integer ActionID){
        EstrusSow estrusSow = estrusSowMapper.findEstrusSowById(ActionID);
        return estrusSow;
    }


}
