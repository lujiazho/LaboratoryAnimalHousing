package org.lah.AnimalBreeding.domain;
import java.io.Serializable;


public class AnimalBreed implements Serializable {
    private String RecordDate ;
    private Integer AnimalMatingNumber ;       // 设备型号id
    private String SowsNumber ;  // 设备编号
    private String SowsSituation ;  // 设备所在动物房编号
    private String BoarsNumber ;  // 设备坐标
    private String BoarsSituation ;  // 设备坐标
    public AnimalBreed() {
        super();
    }

    public String getRecordDate() {
        return RecordDate;
    }

    public void setRecordDate(String RecordDate) {
        this.RecordDate = RecordDate;
    }

    public Integer getAnimalMatingNumber() {
        return AnimalMatingNumber;
    }

    public void setAnimalMatingNumber(Integer AnimalMatingNumber) {
        this.AnimalMatingNumber = AnimalMatingNumber;
    }

    public String getSowsNumber() {
        return SowsNumber;
    }

    public void setSowsNumber(String SowsNumber) {
        this.SowsNumber = SowsNumber;
    }

    public String getSowsSituation() {
        return SowsSituation;
    }

    public void setSowsSituation(String SowsSituation) {
        this.SowsSituation = SowsSituation;
    }

    public String getBoarsSituation() {
        return BoarsSituation;
    }

    public void setBoarsSituation(String BoarsSituation) {
        this.BoarsSituation = BoarsSituation;
    }

    public String getBoarsNumber() {
        return BoarsNumber;
    }

    public void setBoarsNumber(String BoarsNumber) {
        this.BoarsNumber = BoarsNumber;
    }

    @Override
    public String toString() {
        return "AnimalBreed{" +
                "RecordDate=" + RecordDate +
                ", AnimalMatingNumber=" + AnimalMatingNumber +
                ", SowsNumber=" + SowsNumber +
                ", SowsSituation='" + SowsSituation +
                ", BoarsNumber='" + BoarsNumber +
                ", BoarsSituation='" + BoarsSituation +
                '}';
    }
}
