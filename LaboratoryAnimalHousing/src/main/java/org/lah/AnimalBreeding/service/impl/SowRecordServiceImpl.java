package org.lah.AnimalBreeding.service.impl;

import org.lah.AnimalBreeding.domain.SowRecord;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.mapper.SowRecordMapper;
import org.lah.AnimalBreeding.service.SowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 母猪档案用户Service接口实现类
 */
@Service("SowRecordService")
@Transactional
public class SowRecordServiceImpl implements SowRecordService {
    @Autowired
    private SowRecordMapper sowRecordMapper;

    //分页查询母猪档案
    @Override
    public PageInfo<SowRecord> findPageInfo(String AnimalNumber,Integer PigAge,String HealthCondition,String LifeCondition,String Fertility,
                                             String BreedingHistory,String IfBreedSelectObserved,String IfBreedSelect,Integer pageIndex, Integer pageSize) {
        PageInfo<SowRecord> pi = new PageInfo<SowRecord>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取母猪档案总条数
        Integer totalCount = sowRecordMapper.totalCount(AnimalNumber,PigAge);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            List<SowRecord> sowRecordList = sowRecordMapper.getSowRecord(AnimalNumber,PigAge,HealthCondition,LifeCondition,Fertility,
                    BreedingHistory,IfBreedSelectObserved,IfBreedSelect, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(sowRecordList);
        }
        return pi;
    }

    //查询所有母猪档案信息
    @Override
    public List<SowRecord> getAll(){
        List<SowRecord> sowRecordList = sowRecordMapper.getAll();
        return sowRecordList;
    }

    //修改母猪档案信息
    @Override
    public int updateSowRecord(SowRecord sowRecord) { return sowRecordMapper.updateSowRecord(sowRecord); }

    //根据ID查询母猪档案信息
    @Override
    public SowRecord findSowRecordById (String AnimalNumber){
        SowRecord sowRecord = sowRecordMapper.findSowRecordById(AnimalNumber);
        return sowRecord;
    }


}
