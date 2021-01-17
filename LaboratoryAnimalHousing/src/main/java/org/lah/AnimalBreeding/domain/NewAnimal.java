package org.lah.AnimalBreeding.domain;
import java.io.Serializable;


public class NewAnimal implements Serializable {
    private String AnimalNumber;
    private String RecordDate;       // 设备型号id
    private String AnimalSex;  // 设备编号
    private String IncineratorPerson;  // 设备所在动物房编号
    private String BroodChamber;  // 设备坐标
    private String SowNumber;       // 设备型号id
    private String HealthCondition;  // 设备所在动物房编号
    public NewAnimal() {
        super();
    }

    public String getAnimalNumber() {
        return AnimalNumber;
    }

    public void setAnimalNumber(String AnimalNumber) {
        this.AnimalNumber = AnimalNumber;
    }

    public String getRecordDate() {
        return RecordDate;
    }

    public void setRecordDate(String RecordDate) {
        this.RecordDate = RecordDate;
    }

    public String getAnimalSex() {
        return AnimalSex;
    }

    public void setAnimalSex(String AnimalSex) {
        this.AnimalSex = AnimalSex;
    }

    public String getIncineratorPerson() {
        return IncineratorPerson;
    }

    public void setIncineratorPerson(String IncineratorPerson) {
        this.IncineratorPerson = IncineratorPerson;
    }

    public String getBroodChamber() {
        return BroodChamber;
    }

    public void setBroodChamber(String BroodChamber) {
        this.BroodChamber = BroodChamber;
    }

    public String getSowNumber() {
        return SowNumber;
    }

    public void setSowNumber(String SowNumber) {
        this.SowNumber = SowNumber;
    }

    public String getHealthCondition() {
        return HealthCondition;
    }

    public void setHealthCondition(String HealthCondition) {
        this.HealthCondition = HealthCondition;
    }

    @Override
    public String toString() {
        return "EEquip{" +
                "AnimalNumber=" + AnimalNumber +
                ", RecordDate=" + RecordDate +
                ", AnimalSex=" + AnimalSex +
                ", IncineratorPerson='" + IncineratorPerson +
                ", BroodChamber='" + BroodChamber +
                ", SowNumber='" + SowNumber +
                ", HealthCondition='" + HealthCondition +
                '}';
    }
}
