package org.lah.AnimalFeed.service;

import org.lah.AnimalFeed.domain.FeedClaim;
import org.lah.AnimalFeed.domain.PageInfo;
import org.lah.Commons.util.PageModel;


import java.util.Date;
import java.util.List;

public interface FeedClaimService {


    //分页查询
    public PageInfo<FeedClaim> findPageInfo(Integer FeedReceiveNumber, Date GetDate,String FeedType, String PersonnelNumber,
                                            Integer FeedNumber, String AbnormalCondition, Integer pageIndex, Integer pageSize);

    public int deleteFeedClaim(Integer FeedReceiveNumber);   //删除信息
    public int addFeedClaim(FeedClaim feedClaim);   //添加信息
    public int updateFeedClaim(FeedClaim feedClaim); //修改信息
    public FeedClaim findFeedClaimById(Integer FeedReceiveNumber);
    public List<FeedClaim> getAll();

}
