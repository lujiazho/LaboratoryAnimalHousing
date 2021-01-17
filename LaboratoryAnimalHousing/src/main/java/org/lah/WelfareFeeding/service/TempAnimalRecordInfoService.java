package org.lah.WelfareFeeding.service;


import org.lah.WelfareFeeding.domain.PageResult;
import org.lah.WelfareFeeding.domain.TempAnimalrecordlnfo;

/**
 * 暂时代替动物信息类工作
 */
public interface TempAnimalRecordInfoService {
    /**
     * 分页查询
     * @param page  起始页，从1开始
     * @param limit 每页条数
     * @return 查询结果
     */
    PageResult<TempAnimalrecordlnfo> queryOrderByAnimalNumber(int page, int limit);

    /**
     * 按动物编号查询
     * @param animalNumber 动物编号
     * @return 动物记录
     */
    TempAnimalrecordlnfo queryByAnimalNumber(String animalNumber);
}
