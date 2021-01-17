package org.lah.AnimalBreeding.service.impl;

import org.lah.AnimalBreeding.domain.MatingSow;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.mapper.MatingSowMapper;
import org.lah.AnimalBreeding.service.MatingSowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 配种母猪行为记录表用户Service接口实现类
 */
@Service("MatingSowService")
@Transactional
public class MatingSowServiceImpl implements MatingSowService {
    @Autowired
    private MatingSowMapper matingSowMapper;

    //分页查询配种母猪行为记录表
    @Override
    public PageInfo<MatingSow> findPageInfo(Integer ActionID,String AnimalNumber,String BehaviorStartTime,String BehaviorEndTime,
            String BehaviorDescription,String TreatmentPlan,String TreatmentResult,Integer pageIndex, Integer pageSize) {
        PageInfo<MatingSow> pi = new PageInfo<MatingSow>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取配种母猪行为记录表总条数
        Integer totalCount = matingSowMapper.totalCount(ActionID,AnimalNumber,BehaviorStartTime);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            List<MatingSow> matingSowList = matingSowMapper.getMatingSow(ActionID,AnimalNumber,BehaviorStartTime,BehaviorEndTime,BehaviorDescription,TreatmentPlan,TreatmentResult, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(matingSowList);
        }
        return pi;
    }

    //查询所有配种母猪行为记录表信息
    @Override
    public List<MatingSow> getAll(){
        List<MatingSow> matingSowList = matingSowMapper.getAll();
        return matingSowList;
    }

    //通过编号删除配种母猪行为记录表
    @Override
    public int deleteMatingSow(Integer ActionID) {
        return matingSowMapper.deleteMatingSow(ActionID);
    }

    //添加配种母猪行为记录表信息
    @Override
    public  int addMatingSow(MatingSow matingSow) {
        return matingSowMapper.addMatingSow(matingSow);
    }

    //修改配种母猪行为记录表信息
    @Override
    public int updateMatingSow(MatingSow matingSow) { return matingSowMapper.updateMatingSow(matingSow); }

    //根据ID查询配种母猪行为记录表信息
    @Override
    public MatingSow findMatingSowById (Integer ActionID){
        MatingSow matingSow = matingSowMapper.findMatingSowById(ActionID);
        return matingSow;
    }


}
