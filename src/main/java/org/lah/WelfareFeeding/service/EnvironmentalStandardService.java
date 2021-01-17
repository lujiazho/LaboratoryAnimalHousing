package org.lah.WelfareFeeding.service;

import org.lah.WelfareFeeding.domain.EnvironmentalStandard;

public interface EnvironmentalStandardService {
    /**
     * 保存环境标准
     * @param environmentalStandard 被保存的环境标准
     */
    String save(EnvironmentalStandard environmentalStandard);

    /**
     * 按动物编号查询环境标准
     * @param animalNumber 动物编号
     * @return 环境标准
     */
    EnvironmentalStandard queryByAnimalNumber(String animalNumber);
}
