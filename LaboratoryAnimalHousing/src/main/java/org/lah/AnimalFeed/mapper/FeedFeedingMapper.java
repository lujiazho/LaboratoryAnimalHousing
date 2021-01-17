package org.lah.AnimalFeed.mapper;

import org.apache.ibatis.annotations.Param;
import org.lah.AnimalFeed.domain.FeedFeeding;

import java.util.Date;
import java.util.List;


public interface FeedFeedingMapper {


    //获取总条数
    public Integer totalCount(@Param("FeedingNumber") Integer FeedingNumber, @Param("AnimalNumber") String AnimalNumber,
                              @Param("RoomNumber") Integer RoomNumber,@Param("PersonnelNumber") String PersonnelNumber);
    //获取列表
    public List<FeedFeeding> getFeedFeeding(@Param("FeedingNumber") Integer FeedingNumber, @Param("FeedDate")Date FeedDate,@Param("AnimalNumber")String AnimalNumber,
                                        @Param("FeedType") String FeedType, @Param("RoomNumber")Integer RoomNumber,@Param("FeedAmount")Float FeedAmount,@Param("PersonnelNumber") String PersonnelNumber, @Param("AbnormalCondition") String AbnormalCondition,
                                        @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    public int deleteFeedFeeding(Integer FeedingNumber);   //删除饲料领取信息
    public int addFeedFeeding(FeedFeeding feedFeeding);   //添加信息
    public int updateFeedFeeding(FeedFeeding feedFeeding); //修改信息
    public FeedFeeding findFeedFeedingById(Integer FeedingNumber);
    public List<FeedFeeding> getAll();
}
