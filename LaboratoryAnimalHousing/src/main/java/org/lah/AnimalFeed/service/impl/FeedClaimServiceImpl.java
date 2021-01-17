package org.lah.AnimalFeed.service.impl;

import org.lah.AnimalFeed.domain.FeedClaim;
import org.lah.AnimalFeed.domain.PageInfo;
import org.lah.AnimalFeed.mapper.FeedClaimMapper;
import org.lah.AnimalFeed.service.FeedClaimService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import java.util.List;


/**
 * 用户Service接口实现类
 */
@Service("FeedClaimService")
@Transactional
public class FeedClaimServiceImpl implements FeedClaimService {
    @Autowired
    private FeedClaimMapper feedclaimMapper;

    //分页查询
    @Override
    public PageInfo<FeedClaim> findPageInfo(Integer FeedReceiveNumber,Date GetDate, String FeedType,
                                            String PersonnelNumber, Integer FeedNumber, String AbnormalCondition,Integer pageIndex, Integer pageSize) {
        PageInfo<FeedClaim> pi = new PageInfo<FeedClaim>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = feedclaimMapper.totalCount(FeedReceiveNumber, GetDate,FeedType,PersonnelNumber);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<FeedClaim> feedClaimList =	feedclaimMapper.getFeedClaim(FeedReceiveNumber,GetDate,FeedType,PersonnelNumber,FeedNumber,
                    AbnormalCondition, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(feedClaimList);
        }
        return pi;
    }
    @Override
    public List<FeedClaim> getAll(){
        List<FeedClaim> feedClaimList = feedclaimMapper.getAll();
        return feedClaimList;
    }

    //通过编号删除饲料领取信息
    @Override
    public int deleteFeedClaim(Integer FeedReceiveNumber) {
        return feedclaimMapper.deleteFeedClaim(FeedReceiveNumber);
    }
    //添加信息
    @Override
    public  int addFeedClaim(FeedClaim feedClaim) {
        return feedclaimMapper.addFeedClaim(feedClaim);
    }
    //修改信息
    @Override
    public int updateFeedClaim(FeedClaim feedClaim) { return feedclaimMapper.updateFeedClaim(feedClaim); }

    @Override
    public FeedClaim findFeedClaimById (Integer FeedReceiveNumber){
        FeedClaim s = feedclaimMapper.findFeedClaimById(FeedReceiveNumber);
        return  s;
    }


}
