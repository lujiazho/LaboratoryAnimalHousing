package org.lah.AnimalFeed.service;

import org.lah.AnimalFeed.domain.Room;
import org.lah.AnimalFeed.domain.PageInfo;

import java.util.List;

public interface RoomService {


    //分页查询
    public PageInfo<Room> findPageInfo(Integer RoomNumber, String AnimalNumber,
                                       boolean IfLeave, String LeaveReason, Integer pageIndex, Integer pageSize);

    public int deleteRoom(String AnimalNumber);   //删除信息
    public int addRoom(Room room);   //添加信息
    public int updateRoom(Room room); //修改信息
    public Room findRoomById(String AnimalNumber);
    public List<Room> getAll();

}
