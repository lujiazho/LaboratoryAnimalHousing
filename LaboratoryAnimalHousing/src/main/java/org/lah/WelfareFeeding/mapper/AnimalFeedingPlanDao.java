package org.lah.WelfareFeeding.mapper;

import org.lah.WelfareFeeding.domain.AnimalFeedingPlan;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalFeedingPlanDao {
    int deleteByPrimaryKey(String feedingplannumber);

    String insert(AnimalFeedingPlan record);

    int insertSelective(AnimalFeedingPlan record);

    AnimalFeedingPlan selectByPrimaryKey(String feedingplannumber);

    AnimalFeedingPlan selectByAnimalNumber(String animalnumber);

    int updateByPrimaryKeySelective(AnimalFeedingPlan record);

    int updateByPrimaryKey(AnimalFeedingPlan record);
}