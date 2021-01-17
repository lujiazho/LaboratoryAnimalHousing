package org.lah.AnimalBreeding.service.impl;

import org.lah.AnimalBreeding.domain.ExpectantSow;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.mapper.ExpectantSowMapper;
import org.lah.AnimalBreeding.service.ExpectantSowService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


/**
 * 用户Service接口实现类
 */
@Service("ExpectantSowService")
@Transactional
public class ExpectantSowServiceImpl implements ExpectantSowService {
    @Autowired
    private ExpectantSowMapper eMapper;

    //分页查询
    @Override
    public PageInfo<ExpectantSow> findPageInfo(Integer ActionID, String AnimalNumber, String BehaviorStartTime, String BehaviorEndTime,
                                               String BehaviorDescription, String TreatmentPlan,String TreatmentResult,Integer pageIndex, Integer pageSize)
    {
        PageInfo<ExpectantSow> pi = new PageInfo<ExpectantSow>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = eMapper.totalCount(ActionID,AnimalNumber,BehaviorStartTime);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            List<ExpectantSow> eList =eMapper.getExpectantSow(ActionID,AnimalNumber,BehaviorStartTime,BehaviorEndTime,BehaviorDescription,TreatmentPlan,TreatmentResult, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(eList);
        }
        return pi;
    }
    @Override
    public List<ExpectantSow> getAll(){
        List<ExpectantSow> eList = eMapper.getAll();
        return eList;
    }

    //通过编号删除饲料领取信息
    @Override
    public int deleteExpectantSow(Integer ActionID) {
        return eMapper.deleteExpectantSow(ActionID);
    }
    //添加信息
    @Override
    public  int addExpectantSow(ExpectantSow expectantsow) {
        return eMapper.addExpectantSow(expectantsow);
    }
    //修改信息
    @Override
    public int updateExpectantSow(ExpectantSow expectantsow) { return eMapper.updateExpectantSow(expectantsow); }

    @Override
    public ExpectantSow findExpectantSowByAI (Integer ActionId){
        ExpectantSow s = eMapper.findExpectantSowByAI(ActionId);
        return  s;
    }
}
