package org.lah.AnimalFeed.mapper;

import org.apache.ibatis.annotations.Param;
import org.lah.AnimalFeed.domain.FeedTest;

import java.util.Date;
import java.util.List;


public interface FeedTestMapper {


    //获取总条数
    public Integer totalCount(@Param("FeedWaterTestNumber") Integer FeedWaterTestNumber, @Param("PersonnelNumber") String PersonnelNumber);
    //获取列表
    public List<FeedTest> getFeedTest(@Param("FeedWaterTestNumber") Integer FeedWaterTestNumber,@Param("TestDate") Date TestDate,
                                        @Param("FeedReceiveNumber") Integer FeedReceiveNumber, @Param("IfFeedStandard") boolean IfFeedStandard, @Param("PersonnelNumber") String PersonnelNumber, @Param("FeedAppearanceTest") String FeedAppearanceTest,
                                        @Param("FeedMyeteTest") String FeedMyeteTest, @Param("FeedToxinTest") String FeedToxinTest, @Param("WaterBacterialCount") Float WaterBacterialCount,
                                        @Param("WaterColiformCount") Float WaterColiformCount, @Param("AbnormalCondition") String AbnormalCondition,
                                        @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    public int deleteFeedTest(Integer FeedWaterTestNumber);   //删除饲料领取信息
    public int addFeedTest(FeedTest feedTest);   //添加信息
    public int updateFeedTest(FeedTest feedTest); //修改信息
    public FeedTest findFeedTestById(Integer FeedWaterTestNumber);
    public List<FeedTest> getAll();
}
