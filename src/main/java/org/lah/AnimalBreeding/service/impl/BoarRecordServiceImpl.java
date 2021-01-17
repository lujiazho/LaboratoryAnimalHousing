package org.lah.AnimalBreeding.service.impl;

import org.lah.AnimalBreeding.domain.BoarRecord;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.mapper.BoarRecordMapper;
import org.lah.AnimalBreeding.service.BoarRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 种猪档案用户Service接口实现类
 */
@Service("BoarRecordService")
@Transactional
public class BoarRecordServiceImpl implements BoarRecordService {
    @Autowired
    private BoarRecordMapper boarRecordMapper;

    //分页查询种猪档案
    @Override
    public PageInfo<BoarRecord> findPageInfo(String AnimalNumber,Integer PigAge,String HealthCondition,String LifeCondition,String Fertility,
                                             String BreedingHistory,String IfBreedSelectObserved,String IfBreedSelect,Integer pageIndex, Integer pageSize) {
        PageInfo<BoarRecord> pi = new PageInfo<BoarRecord>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取种猪档案总条数
        Integer totalCount = boarRecordMapper.totalCount(AnimalNumber,PigAge);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            List<BoarRecord> boarRecordList = boarRecordMapper.getBoarRecord(AnimalNumber,PigAge,HealthCondition,LifeCondition,Fertility,
                    BreedingHistory,IfBreedSelectObserved,IfBreedSelect, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(boarRecordList);
        }
        return pi;
    }

    //查询所有种猪档案信息
    @Override
    public List<BoarRecord> getAll(){
        List<BoarRecord> boarRecordList = boarRecordMapper.getAll();
        return boarRecordList;
    }

    //修改种猪档案信息
    @Override
    public int updateBoarRecord(BoarRecord boarRecord) { return boarRecordMapper.updateBoarRecord(boarRecord); }

    //根据ID查询种猪档案信息
    @Override
    public BoarRecord findBoarRecordById (String AnimalNumber){
        BoarRecord boarRecord = boarRecordMapper.findBoarRecordById(AnimalNumber);
        return boarRecord;
    }


}
