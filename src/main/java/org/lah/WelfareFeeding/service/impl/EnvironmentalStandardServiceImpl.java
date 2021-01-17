package org.lah.WelfareFeeding.service.impl;

import org.lah.WelfareFeeding.domain.EnvironmentalStandard;
import org.lah.WelfareFeeding.mapper.EnvironmentalStandardDao;
import org.lah.WelfareFeeding.service.EnvironmentalStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnvironmentalStandardServiceImpl implements EnvironmentalStandardService {

    private EnvironmentalStandardDao environmentalStandardDao;

    @Autowired
    public EnvironmentalStandardServiceImpl(EnvironmentalStandardDao environmentalStandardDao) {
        this.environmentalStandardDao = environmentalStandardDao;
    }

    @Override
    public String save(EnvironmentalStandard environmentalStandard) {
        if(environmentalStandardDao.selectByPrimaryKey(environmentalStandard.getEnvironmentalstandardsnumber())!=null){
            environmentalStandardDao.updateByPrimaryKey(environmentalStandard);
            return environmentalStandard.getEnvironmentalstandardsnumber();
        }
        EnvironmentalStandard oldEnvironmentalStandard = queryByAnimalNumber(environmentalStandard.getAnimalnumber());
        if(oldEnvironmentalStandard != null){
            environmentalStandardDao.deleteByPrimaryKey(oldEnvironmentalStandard.getEnvironmentalstandardsnumber());
        }
        return environmentalStandardDao.insert(environmentalStandard);

    }

    @Override
    public EnvironmentalStandard queryByAnimalNumber(String animalNumber) {
        return environmentalStandardDao.selectByAnimalNumber(animalNumber);
    }
}
