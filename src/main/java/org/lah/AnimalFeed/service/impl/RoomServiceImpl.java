package org.lah.AnimalFeed.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalFeed.controller.RoomController;
import org.lah.AnimalFeed.domain.Room;
import org.lah.AnimalFeed.domain.PageInfo;
import org.lah.AnimalFeed.mapper.RoomMapper;
import org.lah.AnimalFeed.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 用户Service接口实现类
 */
@Service("RoomService")
@Transactional
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(RoomController.class);
    //分页查询
    @Override
    public PageInfo<Room> findPageInfo(Integer RoomNumber, String AnimalNumber,
                                       boolean IfLeave, String LeaveReason,Integer pageIndex, Integer pageSize) {
        PageInfo<Room> pi = new PageInfo<Room>();
        pi.setPageIndex(pageIndex);
        pi.setPageSize(pageSize);
        //获取总条数
        Integer totalCount = roomMapper.totalCount(RoomNumber, AnimalNumber);
        if (totalCount>0){
            pi.setTotalCount(totalCount);
            //每一页显示信息数
            //currentPage = (pageIndex-1)*pageSize  当前页码数减1*最大条数=开始行数
            List<Room> roomList =	roomMapper.getRoom(RoomNumber, AnimalNumber,IfLeave,
                    LeaveReason,  (pi.getPageIndex()-1)*pi.getPageSize(),pi.getPageSize());
            pi.setList(roomList);
        }
        return pi;
    }
    @Override
    public List<Room> getAll(){
        List<Room> roomList = roomMapper.getAll();
        return roomList;
    }

    //通过编号删除饲料领取信息
    @Override
    public int deleteRoom(String AnimalNumber) {
        return roomMapper.deleteRoom(AnimalNumber);
    }
    //添加信息
    @Override
    public  int addRoom(Room room) {
        return roomMapper.addRoom(room);
    }
    //修改信息
    @Override
    public int updateRoom(Room room) { return roomMapper.updateRoom(room); }

    @Override
    public Room findRoomById (String AnimalNumber){
        logger.info("\n\nmmd"+AnimalNumber+"\n\n");
        Room s = roomMapper.findRoomById(AnimalNumber);
        return  s;
    }


}
