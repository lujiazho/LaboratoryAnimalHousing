package org.lah.WelfareFeeding.domain;

import java.io.Serializable;

/**
 * 2020rg_group13_animal_feed_formula
 */
public class AnimalFeedFormula implements Serializable {
    /**
     * 饲料编号
     */
    private String feednumber;

    /**
     * 配方表
     */
    private String ingredients;

    /**
     * 饲料类型
     */
    private String feedtype;

    /**
     * 保存条件
     */
    private String preservationconditions;

    /**
     * 保质期
     */
    private Double qualityguaranteeperiod;

    /**
     * 使用说明
     */
    private String instructions;

    private static final long serialVersionUID = 1L;

    public String getFeednumber() {
        return feednumber;
    }

    public void setFeednumber(String feednumber) {
        this.feednumber = feednumber;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getFeedtype() {
        return feedtype;
    }

    public void setFeedtype(String feedtype) {
        this.feedtype = feedtype;
    }

    public String getPreservationconditions() {
        return preservationconditions;
    }

    public void setPreservationconditions(String preservationconditions) {
        this.preservationconditions = preservationconditions;
    }

    public Double getQualityguaranteeperiod() {
        return qualityguaranteeperiod;
    }

    public void setQualityguaranteeperiod(Double qualityguaranteeperiod) {
        this.qualityguaranteeperiod = qualityguaranteeperiod;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}