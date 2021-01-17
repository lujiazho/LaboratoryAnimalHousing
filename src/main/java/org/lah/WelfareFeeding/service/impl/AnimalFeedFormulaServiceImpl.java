package org.lah.WelfareFeeding.service.impl;

import org.lah.WelfareFeeding.domain.AnimalFeedFormula;
import org.lah.WelfareFeeding.domain.PageResult;
import org.lah.WelfareFeeding.mapper.AnimalFeedFormulaDao;
import org.lah.WelfareFeeding.service.AnimalFeedFormulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalFeedFormulaServiceImpl implements AnimalFeedFormulaService {

    private final AnimalFeedFormulaDao animalFeedFormulaDao;

    @Autowired
    public AnimalFeedFormulaServiceImpl(AnimalFeedFormulaDao animalFeedFormulaDao) {
        this.animalFeedFormulaDao = animalFeedFormulaDao;
    }

    @Override
    public PageResult<AnimalFeedFormula> queryOrderByFeedNumber(int page, int limit) {
        return new PageResult<>(
                0,
                "",
                animalFeedFormulaDao.selectCount(),
                animalFeedFormulaDao.selectOrderByPrimaryKey((page - 1) * limit, limit)
        );
    }

    @Override
    public AnimalFeedFormula queryByFeedNumber(String feedNumber) {
        return animalFeedFormulaDao.selectByPrimaryKey(feedNumber);
    }

    @Override
    public String save(AnimalFeedFormula animalFeedFormula) {
        if (animalFeedFormulaDao.selectByPrimaryKey(animalFeedFormula.getFeednumber()) == null) {
            return animalFeedFormulaDao.insert(animalFeedFormula);
        } else {
            animalFeedFormulaDao.updateByPrimaryKey(animalFeedFormula);
            return animalFeedFormula.getFeednumber();
        }
    }
}
