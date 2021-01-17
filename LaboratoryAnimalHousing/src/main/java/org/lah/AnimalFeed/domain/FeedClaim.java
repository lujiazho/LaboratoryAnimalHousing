package org.lah.AnimalFeed.domain;



import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class FeedClaim{
    private Integer FeedReceiveNumber;			        // 饲料领取编号,需要自动生成
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date GetDate;           // 领取日期
    private String FeedType;       // 饲料类型
    private String PersonnelNumber;  // 领取人员编号
    private Integer FeedNumber;     // 饲料袋数
    private String AbnormalCondition;               // 异常情况记录
    public FeedClaim() {
        super();
    }

    public Integer getFeedReceiveNumber() {
        return FeedReceiveNumber;
    }

    public void setFeedReceiveNumber(Integer feedReceiveNumber) {
        this.FeedReceiveNumber = feedReceiveNumber;
    }

    public Date getGetDate() {
        return GetDate;
    }

    public void setGetDate(Date getDate) {
        this.GetDate = getDate;
    }

    public String getFeedType() {
        return FeedType;
    }

    public void setFeedType(String feedType) {
        this.FeedType = feedType;
    }

    public String getPersonnelNumber() {
        return PersonnelNumber;
    }

    public void setPersonnelNumber(String personnelNumber) {
        this.PersonnelNumber = personnelNumber;
    }

    public Integer getFeedNumber() {
        return FeedNumber;
    }

    public void setFeedNumber(Integer feedNumber) {
        this.FeedNumber = feedNumber;
    }

    public String getAbnormalCondition() {
        return AbnormalCondition;
    }

    public void setAbnormalCondition(String abnormalCondition) {
        this.AbnormalCondition = abnormalCondition;
    }




    @Override
    public String toString() {
        return "FeedClaim{" +
                "FeedReceiveNumber=" + FeedReceiveNumber +
                ", GetDate=" + GetDate +
                ", FeedType='" + FeedType + '\'' +
                ", PersonnelNumber='" + PersonnelNumber + '\'' +
                ", FeedNumber=" + FeedNumber +
                ", AbnormalCondition='" + AbnormalCondition + '\'' +
                '}';
    }


}
