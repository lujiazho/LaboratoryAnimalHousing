package org.lah.AnimalFeed.service.impl;

import org.lah.AnimalFeed.domain.PaddingClaim;
import org.lah.AnimalFeed.domain.PageInfo;
import org.lah.AnimalFeed.mapper.PaddingClaimMapper;
import org.lah.AnimalFeed.service.PaddingClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


/**
 * 用户Service接口实现类
 */
@Service("PaddingClaimService")
@Transactional
public class PaddingClaimServiceImpl implements PaddingClaimService {
    @Autowired
    private PaddingClaimMapper paddingclaimMapper;;

    //分页查询
    @Override
    public PageInfo<PaddingClaim> findPageInfo(Integer PaddingGetNumber, String PaddingType,
                                               String PersonnelNumber, Integer PaddingNumber, String AbnormalCondition, Integer pageIndex, Integer pageSize) {
        PageInfo<PaddingClaim> pi = new PageInfo<PaddingClaim>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = paddingclaimMapper.totalCount(PaddingGetNumber,PaddingType,PersonnelNumber);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<PaddingClaim> paddingClaimList =	paddingclaimMapper.getPaddingClaim(PaddingGetNumber,PaddingType,PersonnelNumber,PaddingNumber,
                    AbnormalCondition, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(paddingClaimList);
        }
        return pi;
    }
    @Override
    public List<PaddingClaim> getAll(){
        List<PaddingClaim> paddingClaimList = paddingclaimMapper.getAll();
        return paddingClaimList;
    }

    //通过编号删除饲料领取信息
    @Override
    public int deletePaddingClaim(Integer PaddingGetNumber) {
        return paddingclaimMapper.deletePaddingClaim(PaddingGetNumber);
    }
    //添加信息
    @Override
    public  int addPaddingClaim(PaddingClaim paddingClaim) {
        return paddingclaimMapper.addPaddingClaim(paddingClaim);
    }
    //修改信息
    @Override
    public int updatePaddingClaim(PaddingClaim paddingClaim) { return paddingclaimMapper.updatePaddingClaim(paddingClaim); }

    @Override
    public PaddingClaim findPaddingClaimById (Integer PaddingGetNumber){
        PaddingClaim s = paddingclaimMapper.findPaddingClaimById(PaddingGetNumber);
        return  s;
    }


}
