package org.lah.WelfareFeeding.service.impl;

import org.apache.commons.lang.StringUtils;
import org.lah.WelfareFeeding.domain.PageResult;
import org.lah.WelfareFeeding.domain.WelfareFeedingTask;
import org.lah.WelfareFeeding.domain.WelfareFeedingTaskKey;
import org.lah.WelfareFeeding.mapper.WelfareFeedingTaskDao;
import org.lah.WelfareFeeding.service.WelfareFeedingTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WelfareFeedingTaskServiceImpl implements WelfareFeedingTaskService {
    private final WelfareFeedingTaskDao welfareFeedingTaskDao;

    @Autowired
    public WelfareFeedingTaskServiceImpl(WelfareFeedingTaskDao welfareFeedingTaskDao) {
        this.welfareFeedingTaskDao = welfareFeedingTaskDao;
    }

    @Override
    public PageResult<WelfareFeedingTask> queryByStaffing(String staffing, Integer page, Integer limit) {
        return new PageResult<>(
                0,
                "",
                welfareFeedingTaskDao.selectCount(staffing),
                welfareFeedingTaskDao.selectByStaffing(staffing, (page - 1) * limit, limit)
        );
    }

    @Override
    public WelfareFeedingTask queryByAnimalAndStaffing(String animalNumber, String staffing) {
        WelfareFeedingTaskKey key = new WelfareFeedingTaskKey();
        key.setAnimalnumber(animalNumber);
        key.setMaintenancestaff(staffing);
        return welfareFeedingTaskDao.selectByPrimaryKey(key);
    }

    @Override
    public void save(WelfareFeedingTask welfareFeedingTask) {
        if (welfareFeedingTaskDao.selectByPrimaryKey(welfareFeedingTask) == null) {
            welfareFeedingTaskDao.insert(welfareFeedingTask);
        } else {
            welfareFeedingTaskDao.updateByPrimaryKey(welfareFeedingTask);
        }
    }

    @Override
    public void saveFinishTask(String animalNumber, String staffing, String task) {
        WelfareFeedingTask welfareFeedingTask = queryByAnimalAndStaffing(animalNumber, staffing);
        if (welfareFeedingTask != null) {
            String oldTask = welfareFeedingTask.getTask();
            List<String> strings =new ArrayList<>(Arrays.asList(oldTask.split(",")));
            if (strings.remove(task)) {
                welfareFeedingTask.setTask(StringUtils.join(strings, ','));
                save(welfareFeedingTask);
            }
        }
    }
}
