package org.lah.AnimalBreeding.domain;
import java.io.Serializable;


public class ExpectantSow implements Serializable {
    private Integer ActionID;
    private String AnimalNumber;
    private String BehaviorStartTime;       // 设备型号id
    private String BehaviorEndTime;  // 设备编号
    private String BehaviorDescription;  // 设备所在动物房编号
    private String TreatmentPlan;  // 设备坐标
    private String TreatmentResult;  // 设备坐标
    public ExpectantSow() {
        super();
    }

    public Integer getActionID() {
        return ActionID;
    }

    public void setActionID(Integer ActionID) {
        this.ActionID = ActionID;
    }

    public String getAnimalNumber() {
        return AnimalNumber;
    }

    public void setAnimalNumber(String AnimalNumber) {
        this.AnimalNumber = AnimalNumber;
    }

    public String getBehaviorStartTime() {
        return BehaviorStartTime;
    }

    public void setBehaviorStartTime(String BehaviorStartTime) {
        this.BehaviorStartTime = BehaviorStartTime;
    }

    public String getBehaviorEndTime() {
        return BehaviorEndTime;
    }

    public void setBehaviorEndTime(String BehaviorEndTime) {
        this.BehaviorEndTime = BehaviorEndTime;
    }

    public String getBehaviorDescription() {
        return BehaviorDescription;
    }

    public void setBehaviorDescription(String BehaviorDescription) {
        this.BehaviorDescription = BehaviorDescription;
    }

    public String getTreatmentPlan() {
        return TreatmentPlan;
    }

    public void setTreatmentPlan(String TreatmentPlan) {
        this.TreatmentPlan = TreatmentPlan;
    }

    public String getTreatmentResult() {
        return TreatmentResult;
    }

    public void setTreatmentResult(String TreatmentResult) {
        this.TreatmentResult = TreatmentResult;
    }

    @Override
    public String toString() {
        return "ExpectantSow{" +
                "ActionId=" + ActionID +
                ", AnimalNumber=" + AnimalNumber +
                ", BehaviorStartTime=" + BehaviorStartTime +
                ", BehaviorEndTime=" + BehaviorEndTime+ '\'' +
                ", BehaviorDescription='" + BehaviorDescription + '\'' +
                ", TreatmentPlan='" + TreatmentPlan +
                ", TreatmentResult='" + TreatmentResult+ '\'' +
                '}';
    }

}
