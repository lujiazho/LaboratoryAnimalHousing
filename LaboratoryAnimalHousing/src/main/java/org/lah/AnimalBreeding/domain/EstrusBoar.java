package org.lah.AnimalBreeding.domain;

/**
 * 发情种猪行为记录表类
 */
public class EstrusBoar {
    private Integer ActionID;           //行为编码
    private String AnimalNumber;        //动物编号
    private String BehaviorStartTime;   //行为开始时间
    private String BehaviorEndTime;     //行为结束时间
    private String BehaviorDescription; //行为描述
    private String TreatmentPlan;       //处理方案
    private String TreatmentResult;     //处理结果

    public EstrusBoar() {
        super();
    }

    public Integer getActionID() {
        return ActionID;
    }

    public void setActionID(Integer actionID) {
        ActionID = actionID;
    }

    public String getAnimalNumber() {
        return AnimalNumber;
    }

    public void setAnimalNumber(String animalNumber) {
        this.AnimalNumber = animalNumber;
    }

    public String getBehaviorStartTime() {
        return BehaviorStartTime;
    }

    public void setBehaviorStartTime(String behaviorStartTime) {
        this.BehaviorStartTime = behaviorStartTime;
    }

    public String getBehaviorEndTime() {
        return BehaviorEndTime;
    }

    public void setBehaviorEndTime(String behaviorEndTime) {
        this.BehaviorEndTime = behaviorEndTime;
    }

    public String getBehaviorDescription() {
        return BehaviorDescription;
    }

    public void setBehaviorDescription(String behaviorDescription) {
        this.BehaviorDescription = behaviorDescription;
    }

    public String getTreatmentPlan() {
        return TreatmentPlan;
    }

    public void setTreatmentPlan(String treatmentPlan) {
        this.TreatmentPlan = treatmentPlan;
    }

    public String getTreatmentResult() {
        return TreatmentResult;
    }

    public void setTreatmentResult(String treatmentResult) {
        this.TreatmentResult = treatmentResult;
    }

    @Override
    public String toString() {
        return "EstrusBoar{" +
                "ActionID=" + ActionID +
                ", AnimalNumber=" + AnimalNumber +
                ", BehaviorStartTime=" + BehaviorStartTime +
                ", BehaviorEndTime'" + BehaviorEndTime + '\'' +
                ", BehaviorDescription='" + BehaviorDescription + '\'' +
                ", TreatmentPlan=" + TreatmentPlan +
                ", TreatmentResult='" + TreatmentResult + '\'' +
                '}';
    }
}
