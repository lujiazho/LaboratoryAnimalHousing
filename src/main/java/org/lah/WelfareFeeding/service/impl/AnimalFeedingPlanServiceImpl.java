package org.lah.WelfareFeeding.service.impl;

import org.lah.WelfareFeeding.domain.AnimalFeedingPlan;
import org.lah.WelfareFeeding.mapper.AnimalFeedingPlanDao;
import org.lah.WelfareFeeding.service.AnimalFeedingPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalFeedingPlanServiceImpl implements AnimalFeedingPlanService {

    private AnimalFeedingPlanDao animalFeedingPlanDao;

    @Autowired
    public AnimalFeedingPlanServiceImpl(AnimalFeedingPlanDao animalFeedingPlanDao) {
        this.animalFeedingPlanDao = animalFeedingPlanDao;
    }

    @Override
    public AnimalFeedingPlan queryByAnimalNumber(String animalNumber) {
        return animalFeedingPlanDao.selectByAnimalNumber(animalNumber);
    }

    @Override
    public String save(AnimalFeedingPlan animalFeedingPlan) {
        if(animalFeedingPlanDao.selectByPrimaryKey(animalFeedingPlan.getFeedingplannumber())!=null){
            animalFeedingPlanDao.updateByPrimaryKey(animalFeedingPlan);
            return animalFeedingPlan.getFeedingplannumber();
        }
        AnimalFeedingPlan oldAnimalFeedingPlan = queryByAnimalNumber(animalFeedingPlan.getAnimalnumber());
        if(oldAnimalFeedingPlan != null){
            animalFeedingPlanDao.deleteByPrimaryKey(oldAnimalFeedingPlan.getFeedingplannumber());
        }
        return animalFeedingPlanDao.insert(animalFeedingPlan);
    }
}
