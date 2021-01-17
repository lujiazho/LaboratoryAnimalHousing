package org.lah.AnimalFeed.service;

import org.lah.AnimalFeed.domain.FeedTest;
import org.lah.AnimalFeed.domain.PageInfo;

import java.util.Date;
import java.util.List;

public interface FeedTestService {


    //分页查询
    public PageInfo<FeedTest> findPageInfo(Integer FeedWaterTestNumber, Date TestDate, Integer FeedReceiveNumber, boolean IfFeedStandard, String PersonnelNumber,
                                            String FeedAppearanceTest, String FeedMyeteTest, String FeedToxinTest, Float WaterBacterialCount, Float WaterColiformCount,
                                            String AbnormalCondition, Integer pageIndex, Integer pageSize);

    public int deleteFeedTest(Integer FeedWaterTestNumber);   //删除信息
    public int addFeedTest(FeedTest feedTest);   //添加信息
    public int updateFeedTest(FeedTest feedTest); //修改信息
    public FeedTest findFeedTestById(Integer FeedWaterTestNumber);
    public List<FeedTest> getAll();

}
