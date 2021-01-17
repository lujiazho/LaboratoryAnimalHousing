package org.lah.WelfareFeeding.service;

import org.lah.WelfareFeeding.domain.AnimalFeedFormula;
import org.lah.WelfareFeeding.domain.PageResult;

public interface AnimalFeedFormulaService {

    /**
     * 查询所有饲料配方
     *
     * @return 所有饲料配方
     */
    PageResult<AnimalFeedFormula> queryOrderByFeedNumber(int page, int limit);

    /**
     * 按饲料编号查询
     * @param feedNumber 饲料编号
     * @return 饲料配方
     */
    AnimalFeedFormula queryByFeedNumber(String feedNumber);

    /**
     * 保存饲料配方
     * @param animalFeedFormula 保存的饲料配方
     * @return 饲料配方编号
     */
    String save(AnimalFeedFormula animalFeedFormula);
}
