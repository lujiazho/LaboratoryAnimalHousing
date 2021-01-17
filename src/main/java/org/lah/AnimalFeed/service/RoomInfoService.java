package org.lah.AnimalFeed.service;

import org.lah.AnimalFeed.domain.PageInfo;
import org.lah.AnimalFeed.domain.RoomInfo;

import java.util.List;

public interface RoomInfoService {


    //分页查询
    public PageInfo<RoomInfo> findPageInfo(Integer RoomNumber, String RoomType, Integer AccommodateNumber, Integer AccommodatedNumber,
                                      String RoomAnomaly, Integer pageIndex, Integer pageSize);

    public int deleteRoomInfo(Integer RoomNumber);   //删除信息
    public int addRoomInfo(RoomInfo roomInfo);   //添加信息
    public int updateRoomInfo(RoomInfo roomInfo); //修改信息
    public RoomInfo findRoomInfoById(Integer RoomNumber);
    public List<RoomInfo> getAll();

}
