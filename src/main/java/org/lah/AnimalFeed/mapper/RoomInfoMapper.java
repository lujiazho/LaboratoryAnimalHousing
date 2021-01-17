package org.lah.AnimalFeed.mapper;

import org.apache.ibatis.annotations.Param;
import org.lah.AnimalFeed.domain.RoomInfo;

import java.util.List;


public interface RoomInfoMapper {


    //获取总条数
    public Integer totalCount(@Param("RoomNumber") Integer RoomNumber, @Param("RoomType") String RoomType);
    //获取列表
    public List<RoomInfo> getRoomInfo(@Param("RoomNumber") Integer RoomNumber,
                              @Param("RoomType") String RoomType, @Param("AccommodateNumber") Integer AccommodateNumber,
                              @Param("AccommodatedNumber") Integer AccommodatedNumber, @Param("RoomAnomaly") String RoomAnomaly,
                              @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    public int deleteRoomInfo(Integer RoomNumber);   //删除饲料领取信息
    public int addRoomInfo(RoomInfo roomInfo);   //添加信息
    public int updateRoomInfo(RoomInfo roomInfo); //修改信息
    public RoomInfo findRoomInfoById(Integer RoomNumber);
    public List<RoomInfo> getAll();
}
