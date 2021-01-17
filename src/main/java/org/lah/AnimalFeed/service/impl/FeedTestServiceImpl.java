package org.lah.AnimalFeed.service.impl;

import org.lah.AnimalFeed.domain.FeedTest;
import org.lah.AnimalFeed.domain.PageInfo;
import org.lah.AnimalFeed.mapper.FeedTestMapper;
import org.lah.AnimalFeed.service.FeedTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * 用户Service接口实现类
 */
@Service("FeedTestService")
@Transactional
public class FeedTestServiceImpl implements FeedTestService {
    @Autowired
    private FeedTestMapper feedtestMapper;

    //分页查询
    @Override
    public PageInfo<FeedTest> findPageInfo(Integer FeedWaterTestNumber, Date TestDate, Integer FeedReceiveNumber, boolean IfFeedStandard, String PersonnelNumber,
                                           String FeedAppearanceTest, String FeedMyeteTest, String FeedToxinTest, Float WaterBacterialCount, Float WaterColiformCount,
                                           String AbnormalCondition, Integer pageIndex, Integer pageSize) {
        PageInfo<FeedTest> pi = new PageInfo<FeedTest>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = feedtestMapper.totalCount(FeedWaterTestNumber,PersonnelNumber);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<FeedTest> feedTestList =	feedtestMapper.getFeedTest(FeedWaterTestNumber,TestDate,FeedWaterTestNumber,IfFeedStandard,
                    PersonnelNumber,FeedAppearanceTest,FeedMyeteTest,FeedToxinTest,WaterBacterialCount,WaterColiformCount,
                    AbnormalCondition, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(feedTestList);
        }
        return pi;
    }
    @Override
    public List<FeedTest> getAll(){
        List<FeedTest> feedTestList = feedtestMapper.getAll();
        return feedTestList;
    }

    //通过编号删除饲料领取信息
    @Override
    public int deleteFeedTest(Integer FeedWaterTestNumber) {
        return feedtestMapper.deleteFeedTest(FeedWaterTestNumber);
    }
    //添加信息
    @Override
    public  int addFeedTest(FeedTest feedTest) {
        return feedtestMapper.addFeedTest(feedTest);
    }
    //修改信息
    @Override
    public int updateFeedTest(FeedTest feedTest) { return feedtestMapper.updateFeedTest(feedTest); }

    @Override
    public FeedTest findFeedTestById (Integer FeedWaterTestNumber){
        FeedTest s = feedtestMapper.findFeedTestById(FeedWaterTestNumber);
        return  s;
    }


}
