package org.lah.AnimalFeed.domain;



import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PaddingClaim {
    private Integer PaddingGetNumber;			        // 垫料领取编号,需要自动生成///////////
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date GetDate;           // 领取日期
    private String PaddingType;       // 垫料类型////////
    private String PersonnelNumber;  // 领取人员编号/////////
    private Integer PaddingNumber;     // 垫料袋数
    private String AbnormalCondition;               // 异常情况记录
    public PaddingClaim() {
        super();
    }

    public Integer getPaddingGetNumber() {
        return PaddingGetNumber;
    }

    public void setPaddingGetNumber(Integer paddingGetNumber) {
        this.PaddingGetNumber = paddingGetNumber;
    }

    public Date getGetDate() {
        return GetDate;
    }

    public void setGetDate(Date getDate) {
        this.GetDate = getDate;
    }

    public String getPaddingType() {
        return PaddingType;
    }

    public void setPaddingType(String paddingType) {
        this.PaddingType = paddingType;
    }

    public String getPersonnelNumber() {
        return PersonnelNumber;
    }

    public void setPersonnelNumber(String personnelNumber) {
        this.PersonnelNumber = personnelNumber;
    }

    public Integer getPaddingNumber() {
        return PaddingNumber;
    }

    public void setPaddingNumber(Integer paddingNumber) {
        this.PaddingNumber = paddingNumber;
    }

    public String getAbnormalCondition() {
        return AbnormalCondition;
    }

    public void setAbnormalCondition(String abnormalCondition) {
        this.AbnormalCondition = abnormalCondition;
    }

    @Override
    public String toString() {
        return "PaddingClaim{" +
                "PaddingGetNumber=" + PaddingGetNumber +
                ", GetDate=" + GetDate +
                ", PaddingType='" + PaddingType + '\'' +
                ", PersonnelNumber='" + PersonnelNumber + '\'' +
                ", PaddingNumber=" + PaddingNumber +
                ", AbnormalCondition='" + AbnormalCondition + '\'' +
                '}';
    }
}
