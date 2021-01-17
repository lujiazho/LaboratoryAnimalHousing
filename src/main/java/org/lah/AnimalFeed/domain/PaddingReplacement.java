package org.lah.AnimalFeed.domain;



import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PaddingReplacement {
    private Integer PaddingReplacementNumber;			        // 垫料更换编号,需要自动生成///
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date ReplacementDate;           // 更换日期
    private Integer RoomNumber;       // 房间编号////
    private String PersonnelNumber;  // 更换人员编号////
    private Integer PaddingAmount;     // 垫料数量
    private String AbnormalCondition;               // 异常情况记录
    public PaddingReplacement() {
        super();
    }

    public Integer getPaddingReplacementNumber() {
        return PaddingReplacementNumber;
    }

    public void setPaddingReplacementNumber(Integer paddingReplacementNumber) {
        this.PaddingReplacementNumber = paddingReplacementNumber;
    }

    public Date getReplacementDate() {
        return ReplacementDate;
    }

    public void setReplacementDate(Date replacementDate) {
        this.ReplacementDate = replacementDate;
    }

    public Integer getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.RoomNumber = roomNumber;
    }

    public String getPersonnelNumber() {
        return PersonnelNumber;
    }

    public void setPersonnelNumber(String personnelNumber) {
        this.PersonnelNumber = personnelNumber;
    }

    public Integer getPaddingAmount() {
        return PaddingAmount;
    }

    public void setPaddingAmount(Integer paddingAmount) {
        this.PaddingAmount = paddingAmount;
    }

    public String getAbnormalCondition() {
        return AbnormalCondition;
    }

    public void setAbnormalCondition(String abnormalCondition) {
        this.AbnormalCondition = abnormalCondition;
    }

    @Override
    public String toString() {
        return "PaddingReplacement{" +
                "PaddingReplacementNumber=" + PaddingReplacementNumber +
                ", ReplacementDate=" + ReplacementDate +
                ", RoomNumber=" + RoomNumber +
                ", PersonnelNumber='" + PersonnelNumber + '\'' +
                ", PaddingAmount=" + PaddingAmount +
                ", AbnormalCondition='" + AbnormalCondition + '\'' +
                '}';
    }
}
