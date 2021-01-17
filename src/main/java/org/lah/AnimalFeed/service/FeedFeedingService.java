package org.lah.AnimalFeed.service;

import org.lah.AnimalFeed.domain.FeedFeeding;
import org.lah.AnimalFeed.domain.PageInfo;

import java.util.Date;
import java.util.List;

public interface FeedFeedingService {


    //分页查询
    public PageInfo<FeedFeeding> findPageInfo(Integer FeedingNumber, Date FeedDate, String AnimalNumber, String FeedType, Integer RoomNumber,
                                            Float FeedAmount, String PersonnelNumber, String AbnormalCondition, Integer pageIndex, Integer pageSize);

    public int deleteFeedFeeding(Integer FeedReceiveNumber);   //删除信息
    public int addFeedFeeding(FeedFeeding feedFeeding);   //添加信息
    public int updateFeedFeeding(FeedFeeding feedFeeding); //修改信息
    public FeedFeeding findFeedFeedingById(Integer FeedReceiveNumber);
    public List<FeedFeeding> getAll();

}
