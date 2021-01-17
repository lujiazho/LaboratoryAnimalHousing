package org.lah.WelfareFeeding.domain;

import java.io.Serializable;

/**
 * 2020rg_group13_animal_feeding_plan
 */
public class AnimalFeedingPlan implements Serializable {
    /**
     * 饲养方案编号
     */
    private String feedingplannumber;

    /**
     * 动物编号
     */
    private String animalnumber;

    /**
     * 饲料编号
     */
    private String feednumber;

    /**
     * 编制人员
     */
    private String staffing;

    /**
     * 饲料用量
     */
    private Double feeddosage;

    /**
     * 饮水用量
     */
    private Double waterconsumption;

    /**
     * 建议通风时间	
     */
    private Double recommendedventilationtime;

    /**
     * 更换垫料时间
     */
    private Double paddingreplacingtime;

    private static final long serialVersionUID = 1L;

    public String getFeedingplannumber() {
        return feedingplannumber;
    }

    public void setFeedingplannumber(String feedingplannumber) {
        this.feedingplannumber = feedingplannumber;
    }

    public String getAnimalnumber() {
        return animalnumber;
    }

    public void setAnimalnumber(String animalnumber) {
        this.animalnumber = animalnumber;
    }

    public String getFeednumber() {
        return feednumber;
    }

    public void setFeednumber(String feednumber) {
        this.feednumber = feednumber;
    }

    public String getStaffing() {
        return staffing;
    }

    public void setStaffing(String staffing) {
        this.staffing = staffing;
    }

    public Double getFeeddosage() {
        return feeddosage;
    }

    public void setFeeddosage(Double feeddosage) {
        this.feeddosage = feeddosage;
    }

    public Double getWaterconsumption() {
        return waterconsumption;
    }

    public void setWaterconsumption(Double waterconsumption) {
        this.waterconsumption = waterconsumption;
    }

    public Double getRecommendedventilationtime() {
        return recommendedventilationtime;
    }

    public void setRecommendedventilationtime(Double recommendedventilationtime) {
        this.recommendedventilationtime = recommendedventilationtime;
    }

    public Double getPaddingreplacingtime() {
        return paddingreplacingtime;
    }

    public void setPaddingreplacingtime(Double paddingreplacingtime) {
        this.paddingreplacingtime = paddingreplacingtime;
    }
}