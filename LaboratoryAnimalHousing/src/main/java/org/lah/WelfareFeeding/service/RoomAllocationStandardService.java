package org.lah.WelfareFeeding.service;

import org.lah.WelfareFeeding.domain.RoomAllocationStandard;

public interface RoomAllocationStandardService {
    /**
     * 保存房间分配标准
     * @param roomAllocationStandard 被保存的房间分配标准
     */
    String save(RoomAllocationStandard roomAllocationStandard);

    /**
     * 按动物编号查询环境标准
     * @param animalNumber 动物编号
     * @return 环境标准
     */
    RoomAllocationStandard queryByAnimalNumber(String animalNumber);
}
