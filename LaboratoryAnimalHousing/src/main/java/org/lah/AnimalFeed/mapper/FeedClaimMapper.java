package org.lah.AnimalFeed.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.lah.AnimalFeed.domain.FeedClaim;


import java.util.Date;
import java.util.List;
import java.util.Map;


public interface FeedClaimMapper {


    //获取总条数
    public Integer totalCount(@Param("FeedReceiveNumber") Integer FeedReceiveNumber,@Param("GetDate") Date GetDate,
                              @Param("FeedType")String FeedType, @Param("PersonnelNumber")String PersonnelNumber);
    //获取列表
    public List<FeedClaim> getFeedClaim(@Param("FeedReceiveNumber") Integer FeedReceiveNumber,@Param("GetDate") Date GetDate,
                                        @Param("FeedType")String FeedType, @Param("PersonnelNumber")String PersonnelNumber, @Param("FeedNumber")Integer FeedNumber, @Param("AbnormalCondition")String AbnormalCondition,
                                        @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

    public int deleteFeedClaim(Integer FeedReceiveNumber);   //删除饲料领取信息
    public int addFeedClaim(FeedClaim feedClaim);   //添加信息
    public int updateFeedClaim(FeedClaim feedClaim); //修改信息
    public FeedClaim findFeedClaimById(Integer FeedReceiveNumber);
    public List<FeedClaim> getAll();
}
