package org.lah.AnimalFeed.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalFeed.controller.RoomController;
import org.lah.AnimalFeed.domain.PageInfo;
import org.lah.AnimalFeed.domain.RoomInfo;
import org.lah.AnimalFeed.mapper.RoomInfoMapper;
import org.lah.AnimalFeed.mapper.RoomMapper;
import org.lah.AnimalFeed.service.RoomInfoService;
import org.lah.AnimalFeed.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 用户Service接口实现类
 */
@Service("RoomInfoService")
@Transactional
public class RoomInfoServiceImpl implements RoomInfoService {
    @Autowired
    private RoomInfoMapper roomInfoMapper;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(RoomController.class);
    //分页查询
    @Override
    public PageInfo<RoomInfo> findPageInfo(Integer RoomNumber,  String RoomType,Integer AccommodateNumber,Integer AccommodatedNumber,
                                       String RoomAnomaly,Integer pageIndex, Integer pageSize) {
        PageInfo<RoomInfo> pi = new PageInfo<RoomInfo>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = roomInfoMapper.totalCount(RoomNumber,RoomType);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<RoomInfo> roomInfoList =	roomInfoMapper.getRoomInfo(RoomNumber,RoomType, AccommodateNumber,AccommodatedNumber,
                     RoomAnomaly, (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(roomInfoList);
        }
        return pi;
    }
    @Override
    public List<RoomInfo> getAll(){
        List<RoomInfo> roomInfoList = roomInfoMapper.getAll();
        return roomInfoList;
    }

    //通过编号删除饲料领取信息
    @Override
    public int deleteRoomInfo(Integer RoomNumber) {
        return roomInfoMapper.deleteRoomInfo(RoomNumber);
    }
    //添加信息
    @Override
    public  int addRoomInfo(RoomInfo roomInfo) {
        return roomInfoMapper.addRoomInfo(roomInfo);
    }
    //修改信息
    @Override
    public int updateRoomInfo(RoomInfo roomInfo) { return roomInfoMapper.updateRoomInfo(roomInfo); }

    @Override
    public RoomInfo findRoomInfoById (Integer RoomNumber){
        logger.info("\n\nmmd"+RoomNumber+"\n\n");
        RoomInfo s = roomInfoMapper.findRoomInfoById(RoomNumber);
        return  s;
    }


}
