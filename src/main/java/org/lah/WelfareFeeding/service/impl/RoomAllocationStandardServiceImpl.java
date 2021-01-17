package org.lah.WelfareFeeding.service.impl;

import org.lah.WelfareFeeding.domain.RoomAllocationStandard;
import org.lah.WelfareFeeding.mapper.RoomAllocationStandardDao;
import org.lah.WelfareFeeding.service.RoomAllocationStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomAllocationStandardServiceImpl implements RoomAllocationStandardService {

    private RoomAllocationStandardDao roomAllocationStandardDao;

    @Autowired
    public RoomAllocationStandardServiceImpl(RoomAllocationStandardDao roomAllocationStandardDao) {
        this.roomAllocationStandardDao = roomAllocationStandardDao;
    }

    @Override
    public String save(RoomAllocationStandard roomAllocationStandard) {
        if(roomAllocationStandardDao.selectByPrimaryKey(roomAllocationStandard.getAnimalnumber()) != null){
            roomAllocationStandardDao.updateByPrimaryKey(roomAllocationStandard);
            return roomAllocationStandard.getRoomallocationstandardnumber();
        }
        RoomAllocationStandard oldRoomAllocationStandard = queryByAnimalNumber(roomAllocationStandard.getAnimalnumber());
        if(oldRoomAllocationStandard != null){
            roomAllocationStandardDao.deleteByPrimaryKey(oldRoomAllocationStandard.getRoomallocationstandardnumber());
        }
        return roomAllocationStandardDao.insert(roomAllocationStandard);
    }

    @Override
    public RoomAllocationStandard queryByAnimalNumber(String animalNumber) {
        return roomAllocationStandardDao.selectByAnimalNumber(animalNumber);
    }
}
