package org.lah.AnimalFeed.domain;



import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PaddingTest {
    private Integer PaddingTestNumber;			        // 垫料检测编号,需要自动生成//////
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date TestDate;           // 检测日期
    private Integer PaddingGetNumber;//////垫料领取编号
    private boolean IfPadStandard;//垫料是否达标
    private String PersonnelNumber;  // 检测人员编号//////
    private float PaddingBacterialCount;//单位质量垫料中细菌总数
    private float PaddingColiformCount;//单位质量垫料中大肠菌群
    private String AbnormalCondition;               // 异常情况记录
    public PaddingTest() {
        super();
    }

    public Integer getPaddingTestNumber() {
        return PaddingTestNumber;
    }

    public void setPaddingTestNumber(Integer paddingTestNumber) {
        this.PaddingTestNumber = paddingTestNumber;
    }

    public Date getTestDate() {
        return TestDate;
    }

    public void setTestDate(Date testDate) {
        this.TestDate = testDate;
    }

    public Integer getPaddingGetNumber() {
        return PaddingGetNumber;
    }

    public void setPaddingGetNumber(Integer paddingGetNumber) {
        this.PaddingGetNumber = paddingGetNumber;
    }

    public boolean isIfPadStandard() {
        return IfPadStandard;
    }

    public void setIfPadStandard(boolean ifPadStandard) {
        this.IfPadStandard = ifPadStandard;
    }

    public String getPersonnelNumber() {
        return PersonnelNumber;
    }

    public void setPersonnelNumber(String personnelNumber) {
        this.PersonnelNumber = personnelNumber;
    }

    public float getPaddingBacterialCount() {
        return PaddingBacterialCount;
    }

    public void setPaddingBacterialCount(float paddingBacterialCount) {
        this.PaddingBacterialCount = paddingBacterialCount;
    }

    public float getPaddingColiformCount() {
        return PaddingColiformCount;
    }

    public void setPaddingColiformCount(float paddingColiformCount) {
        this.PaddingColiformCount = paddingColiformCount;
    }

    public String getAbnormalCondition() {
        return AbnormalCondition;
    }

    public void setAbnormalCondition(String abnormalCondition) {
        this.AbnormalCondition = abnormalCondition;
    }

    @Override
    public String toString() {
        return "PaddingTest{" +
                "PaddingTestNumber=" + PaddingTestNumber +
                ", TestDate=" + TestDate +
                ", PaddingGetNumber=" + PaddingGetNumber +
                ", IfPadStandard=" + IfPadStandard +
                ", PersonnelNumber='" + PersonnelNumber + '\'' +
                ", PaddingBacterialCount=" + PaddingBacterialCount +
                ", PaddingColiformCount=" + PaddingColiformCount +
                ", AbnormalCondition='" + AbnormalCondition + '\'' +
                '}';
    }
}
