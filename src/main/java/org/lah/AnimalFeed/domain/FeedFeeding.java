package org.lah.AnimalFeed.domain;



import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class FeedFeeding {
    private Integer FeedingNumber;			        // 饲料投喂编号,需要自动生成/////
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date FeedDate;           // 投喂日期
    private String AnimalNumber;       // 动物编号/////
    private String FeedType;  // 饲料类型
    private Integer RoomNumber;     // 投喂房间号/////
    private Float FeedAmount;//饲料数量
    private String PersonnelNumber;///////投喂人员编号
    private String AbnormalCondition;               // 异常情况记录
    public FeedFeeding() {
        super();
    }

    public Integer getFeedingNumber() {
        return FeedingNumber;
    }

    public void setFeedingNumber(Integer feedingNumber) {
        this.FeedingNumber = feedingNumber;
    }

    public Date getFeedDate() {
        return FeedDate;
    }

    public void setFeedDate(Date feedDate) {
        this.FeedDate = feedDate;
    }

    public String getAnimalNumber() {
        return AnimalNumber;
    }

    public void setAnimalNumber(String animalNumber) {
        this.AnimalNumber = animalNumber;
    }

    public String getFeedType() {
        return FeedType;
    }

    public void setFeedType(String feedType) {
        this.FeedType = feedType;
    }

    public Integer getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.RoomNumber = roomNumber;
    }

    public Float getFeedAmount() {
        return FeedAmount;
    }

    public void setFeedAmount(Float feedAmount) {
        this.FeedAmount = feedAmount;
    }

    public String getPersonnelNumber() {
        return PersonnelNumber;
    }

    public void setPersonnelNumber(String personnelNumber) {
        this.PersonnelNumber = personnelNumber;
    }

    public String getAbnormalCondition() {
        return AbnormalCondition;
    }

    public void setAbnormalCondition(String abnormalCondition) {
        this.AbnormalCondition = abnormalCondition;
    }

    @Override
    public String toString() {
        return "FeedFeeding{" +
                "FeedingNumber=" + FeedingNumber +
                ", FeedDate=" + FeedDate +
                ", AnimalNumber='" + AnimalNumber + '\'' +
                ", FeedType='" + FeedType + '\'' +
                ", RoomNumber=" + RoomNumber +
                ", FeedAmount=" + FeedAmount +
                ", PersonnelNumber='" + PersonnelNumber + '\'' +
                ", AbnormalCondition='" + AbnormalCondition + '\'' +
                '}';
    }
}
