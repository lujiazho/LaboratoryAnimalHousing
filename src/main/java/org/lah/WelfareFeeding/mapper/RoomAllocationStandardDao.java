package org.lah.WelfareFeeding.mapper;

import org.lah.WelfareFeeding.domain.RoomAllocationStandard;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomAllocationStandardDao {
    int deleteByPrimaryKey(String roomallocationstandardnumber);

    String insert(RoomAllocationStandard record);

    int insertSelective(RoomAllocationStandard record);

    RoomAllocationStandard selectByPrimaryKey(String roomallocationstandardnumber);

    RoomAllocationStandard selectByAnimalNumber(String animalnumber);

    int updateByPrimaryKeySelective(RoomAllocationStandard record);

    int updateByPrimaryKey(RoomAllocationStandard record);
}