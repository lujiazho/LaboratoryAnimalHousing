package org.lah.AnimalFeed.mapper;

import org.apache.ibatis.annotations.Param;
import org.lah.AnimalFeed.domain.Room;

import java.util.List;


public interface RoomMapper {


    //获取总条数
    public Integer totalCount(@Param("RoomNumber") Integer RoomNumber, @Param("AnimalNumber") String AnimalNumber);
    //获取列表
    public List<Room> getRoom(@Param("RoomNumber") Integer RoomNumber, @Param("AnimalNumber") String AnimalNumber,
                              @Param("IfLeave")boolean IfLeave, @Param("LeaveReason")String LeaveReason,
                              @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    public int deleteRoom(String AnimalNumber);   //删除饲料领取信息
    public int addRoom(Room room);   //添加信息
    public int updateRoom(Room room); //修改信息
    public Room findRoomById(String AnimalNumber);
    public List<Room> getAll();
}
