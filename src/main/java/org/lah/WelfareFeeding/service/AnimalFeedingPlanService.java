package org.lah.WelfareFeeding.service;

import org.lah.WelfareFeeding.domain.AnimalFeedingPlan;

public interface AnimalFeedingPlanService {
    /**
     * 按动物编号查询动物饲养方案
     * @param animalNumber 动物编号
     * @return 饲养方案
     */
    AnimalFeedingPlan queryByAnimalNumber(String animalNumber);

    /**
     * 保存动物饲养方案
     * @param animalFeedingPlan 保存的饲养方案
     */
    String save(AnimalFeedingPlan animalFeedingPlan);
}
