package org.lah.AnimalBreeding.service.impl;

import org.lah.AnimalBreeding.domain.MatingBoar;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.mapper.MatingBoarMapper;
import org.lah.AnimalBreeding.service.MatingBoarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 配种种猪行为记录表用户Service接口实现类
 */
@Service("MatingBoarService")
@Transactional
public class MatingBoarServiceImpl implements MatingBoarService {
    @Autowired
    private MatingBoarMapper matingBoarMapper;

    //分页查询配种种猪行为记录表
    @Override
    public PageInfo<MatingBoar> findPageInfo(Integer ActionID,String AnimalNumber,String BehaviorStartTime,String BehaviorEndTime,
            String BehaviorDescription,String TreatmentPlan,String TreatmentResult,Integer pageIndex, Integer pageSize) {
        PageInfo<MatingBoar> pi = new PageInfo<MatingBoar>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取配种种猪行为记录表总条数
        Integer totalCount = matingBoarMapper.totalCount(ActionID,AnimalNumber,BehaviorStartTime);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            List<MatingBoar> matingBoarList = matingBoarMapper.getMatingBoar(ActionID,AnimalNumber,BehaviorStartTime,BehaviorEndTime,BehaviorDescription,TreatmentPlan,TreatmentResult, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(matingBoarList);
        }
        return pi;
    }

    //查询所有配种种猪行为记录表信息
    @Override
    public List<MatingBoar> getAll(){
        List<MatingBoar> matingBoarList = matingBoarMapper.getAll();
        return matingBoarList;
    }

    //通过编号删除配种种猪行为记录表
    @Override
    public int deleteMatingBoar(Integer ActionID) {
        return matingBoarMapper.deleteMatingBoar(ActionID);
    }

    //添加配种种猪行为记录表信息
    @Override
    public  int addMatingBoar(MatingBoar matingBoar) {
        return matingBoarMapper.addMatingBoar(matingBoar);
    }

    //修改配种种猪行为记录表信息
    @Override
    public int updateMatingBoar(MatingBoar matingBoar) { return matingBoarMapper.updateMatingBoar(matingBoar); }

    //根据ID查询配种种猪行为记录表信息
    @Override
    public MatingBoar findMatingBoarById (Integer ActionID){
        MatingBoar matingBoar = matingBoarMapper.findMatingBoarById(ActionID);
        return matingBoar;
    }


}
