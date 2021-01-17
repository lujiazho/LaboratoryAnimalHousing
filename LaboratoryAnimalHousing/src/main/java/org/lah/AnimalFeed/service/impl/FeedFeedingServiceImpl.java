package org.lah.AnimalFeed.service.impl;

import org.lah.AnimalFeed.domain.FeedFeeding;
import org.lah.AnimalFeed.domain.PageInfo;
import org.lah.AnimalFeed.mapper.FeedFeedingMapper;
import org.lah.AnimalFeed.service.FeedFeedingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * 用户Service接口实现类
 */
@Service("FeedFeedingService")
@Transactional
public class FeedFeedingServiceImpl implements FeedFeedingService {
    @Autowired
    private FeedFeedingMapper feedfeedingMapper;

    //分页查询
    @Override
    public PageInfo<FeedFeeding> findPageInfo(Integer FeedingNumber, Date FeedDate, String AnimalNumber, String FeedType, Integer RoomNumber,
                                              Float FeedAmount, String PersonnelNumber, String AbnormalCondition, Integer pageIndex, Integer pageSize) {
        PageInfo<FeedFeeding> pi = new PageInfo<FeedFeeding>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = feedfeedingMapper.totalCount(FeedingNumber,AnimalNumber,RoomNumber,PersonnelNumber);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<FeedFeeding> feedFeedingList =	feedfeedingMapper.getFeedFeeding(FeedingNumber,FeedDate,AnimalNumber,FeedType,RoomNumber,FeedAmount,PersonnelNumber,
                    AbnormalCondition, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(feedFeedingList);
        }
        return pi;
    }
    @Override
    public List<FeedFeeding> getAll(){
        List<FeedFeeding> feedFeedingList = feedfeedingMapper.getAll();
        return feedFeedingList;
    }

    //通过编号删除饲料领取信息
    @Override
    public int deleteFeedFeeding(Integer FeedingNumber) {
        return feedfeedingMapper.deleteFeedFeeding(FeedingNumber);
    }
    //添加信息
    @Override
    public  int addFeedFeeding(FeedFeeding feedFeeding) {
        return feedfeedingMapper.addFeedFeeding(feedFeeding);
    }
    //修改信息
    @Override
    public int updateFeedFeeding(FeedFeeding feedFeeding) { return feedfeedingMapper.updateFeedFeeding(feedFeeding); }

    @Override
    public FeedFeeding findFeedFeedingById (Integer FeedingNumber){
        FeedFeeding s = feedfeedingMapper.findFeedFeedingById(FeedingNumber);
        return  s;
    }


}
