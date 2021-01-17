package org.lah.WelfareFeeding.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 2020rg_group13_welfare_feeding_task
 */
public class WelfareFeedingTask extends WelfareFeedingTaskKey implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 保存动物需要新的饲养方案/制定标准的状态
     */
    private String task;

    private Date lastupdated;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(Date lastupdated) {
        this.lastupdated = lastupdated;
    }
}