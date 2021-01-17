package org.lah.AnimalBreeding.service.impl;

import org.lah.AnimalBreeding.domain.EstrusBoar;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.mapper.EstrusBoarMapper;
import org.lah.AnimalBreeding.service.EstrusBoarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * 发情种猪行为记录表用户Service接口实现类
 */
@Service("EstrusBoarService")
@Transactional
public class EstrusBoarServiceImpl implements EstrusBoarService {
    @Autowired
    private EstrusBoarMapper estrusBoarMapper;

    //分页查询发情种猪行为记录表
    @Override
    public PageInfo<EstrusBoar> findPageInfo(Integer ActionID,String AnimalNumber,String BehaviorStartTime,String BehaviorEndTime,
            String BehaviorDescription,String TreatmentPlan,String TreatmentResult,Integer pageIndex, Integer pageSize) {
        PageInfo<EstrusBoar> pi = new PageInfo<EstrusBoar>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取发情种猪行为记录表总条数
        Integer totalCount = estrusBoarMapper.totalCount(ActionID,AnimalNumber,BehaviorStartTime);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            List<EstrusBoar> estrusBoarList = estrusBoarMapper.getEstrusBoar(ActionID,AnimalNumber,BehaviorStartTime,BehaviorEndTime,BehaviorDescription,TreatmentPlan,TreatmentResult, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(estrusBoarList);
        }
        return pi;
    }

    //查询所有发情种猪行为记录表信息
    @Override
    public List<EstrusBoar> getAll(){
        List<EstrusBoar> estrusBoarList = estrusBoarMapper.getAll();
        return estrusBoarList;
    }

    //通过编号删除发情种猪行为记录表
    @Override
    public int deleteEstrusBoar(Integer ActionID) {
        return estrusBoarMapper.deleteEstrusBoar(ActionID);
    }

    //添加发情种猪行为记录表信息
    @Override
    public  int addEstrusBoar(EstrusBoar estrusBoar) {
        return estrusBoarMapper.addEstrusBoar(estrusBoar);
    }

    //修改发情种猪行为记录表信息
    @Override
    public int updateEstrusBoar(EstrusBoar estrusBoar) { return estrusBoarMapper.updateEstrusBoar(estrusBoar); }

    //根据ID查询发情种猪行为记录表信息
    @Override
    public EstrusBoar findEstrusBoarById (Integer ActionID){
        EstrusBoar estrusBoar = estrusBoarMapper.findEstrusBoarById(ActionID);
        return estrusBoar;
    }


}
