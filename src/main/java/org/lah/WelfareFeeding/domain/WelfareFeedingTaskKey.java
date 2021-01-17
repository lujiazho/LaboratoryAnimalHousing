package org.lah.WelfareFeeding.domain;

import java.io.Serializable;

/**
 * 2020rg_group13_welfare_feeding_task
 */
public class WelfareFeedingTaskKey implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 保存需要添加/修改饲养方案的动物编号
     */
    private String animalnumber;
    /**
     * 维护人员
     */
    private String maintenancestaff;

    public String getAnimalnumber() {
        return animalnumber;
    }

    public void setAnimalnumber(String animalnumber) {
        this.animalnumber = animalnumber;
    }

    public String getMaintenancestaff() {
        return maintenancestaff;
    }

    public void setMaintenancestaff(String maintenancestaff) {
        this.maintenancestaff = maintenancestaff;
    }
}