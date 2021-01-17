package org.lah.WelfareFeeding.service;

import org.lah.WelfareFeeding.domain.PageResult;
import org.lah.WelfareFeeding.domain.WelfareFeedingTask;

public interface WelfareFeedingTaskService {
    /**
     * 根据维护人员查询任务
     *
     * @param staffing 维护人员
     * @return 任务列表
     */
    PageResult<WelfareFeedingTask> queryByStaffing(String staffing, Integer page, Integer limit);

    /**
     * 根据维护人员和动物编号查询任务
     * @param animalNumber 动物编号
     * @param staffing 维护人员
     * @return 任务
     */
    WelfareFeedingTask queryByAnimalAndStaffing(String animalNumber, String staffing);

    /**
     * 保存任务
     *
     * @param welfareFeedingTask 被保存的任务
     */
    void save(WelfareFeedingTask welfareFeedingTask);

    /**
     * 完成任务
     * @param animalNumber 动物编号
     * @param staffing 维护人员
     * @param task 完成的任务
     */
    void saveFinishTask(String animalNumber, String staffing, String task);
}
