package org.lah.WelfareFeeding.service.impl;

import org.lah.WelfareFeeding.domain.PageResult;
import org.lah.WelfareFeeding.domain.TempAnimalrecordlnfo;
import org.lah.WelfareFeeding.mapper.TempAnimalrecordlnfoDao;
import org.lah.WelfareFeeding.service.TempAnimalRecordInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TempAnimalRecordInfoServiceImpl implements TempAnimalRecordInfoService {
    private TempAnimalrecordlnfoDao tempAnimalrecordlnfoDao;

    @Autowired
    public TempAnimalRecordInfoServiceImpl(TempAnimalrecordlnfoDao tempAnimalrecordlnfoDao) {
        this.tempAnimalrecordlnfoDao = tempAnimalrecordlnfoDao;
    }

    @Override
    public PageResult<TempAnimalrecordlnfo> queryOrderByAnimalNumber(int page, int limit) {
        return new PageResult<>(
                0,
                "",
                tempAnimalrecordlnfoDao.selectCount(),
                tempAnimalrecordlnfoDao.selectOrderByPrimaryKey((page - 1) * limit, limit)
        );
    }

    @Override
    public TempAnimalrecordlnfo queryByAnimalNumber(String animalNumber) {
        return tempAnimalrecordlnfoDao.selectByPrimaryKey(animalNumber);
    }
}
