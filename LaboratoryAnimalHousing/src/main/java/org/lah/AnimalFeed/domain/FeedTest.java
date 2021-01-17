package org.lah.AnimalFeed.domain;



import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class FeedTest {
    private Integer FeedWaterTestNumber;			        // 饲料饮水检测编号,需要自动生成///////11
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date TestDate;           // 检测日期
    private Integer FeedReceiveNumber;       // 饲料接收编号
    private boolean IfFeedStandard;/////饲料是否达标
    private String PersonnelNumber;  // 检测人员编号////
    private String FeedAppearanceTest;//饲料外观检测
    private String FeedMyeteTest;//饲料霉菌检测结果
    private String FeedToxinTest;//饲料毒素检测结果
    private Float WaterBacterialCount;     // 单位体积饮水中细菌总数
    private Float WaterColiformCount;     //单位体积饮水中大肠菌群
    private String AbnormalCondition;// 异常情况记录

    public Integer getFeedWaterTestNumber() {
        return FeedWaterTestNumber;
    }

    public void setFeedWaterTestNumber(Integer feedWaterTestNumber) {
        this.FeedWaterTestNumber = feedWaterTestNumber;
    }

    public Date getTestDate() {
        return TestDate;
    }

    public void setTestDate(Date testDate) {
        this.TestDate = testDate;
    }

    public Integer getFeedReceiveNumber() {
        return FeedReceiveNumber;
    }

    public void setFeedReceiveNumber(int feedReceiveNumber) {
        this.FeedReceiveNumber = feedReceiveNumber;
    }

    public boolean isIfFeedStandard() {
        return IfFeedStandard;
    }

    public void setIfFeedStandard(boolean ifFeedStandard) {
        this.IfFeedStandard = ifFeedStandard;
    }

    public String getPersonnelNumber() {
        return PersonnelNumber;
    }

    public void setPersonnelNumber(String personnelNumber) {
        this.PersonnelNumber = personnelNumber;
    }

    public String getFeedAppearanceTest() {
        return FeedAppearanceTest;
    }

    public void setFeedAppearanceTest(String feedAppearanceTest) {
        this.FeedAppearanceTest = feedAppearanceTest;
    }

    public String getFeedMyeteTest() {
        return FeedMyeteTest;
    }

    public void setFeedMyeteTest(String feedMyeteTest) {
        this.FeedMyeteTest = feedMyeteTest;
    }

    public String getFeedToxinTest() {
        return FeedToxinTest;
    }

    public void setFeedToxinTest(String feedToxinTest) {
        this.FeedToxinTest = feedToxinTest;
    }

    public Float getWaterBacterialCount() {
        return WaterBacterialCount;
    }

    public void setWaterBacterialCount(Float waterBacterialCount) {
        this.WaterBacterialCount = waterBacterialCount;
    }

    public Float getWaterColiformCount() {
        return WaterColiformCount;
    }

    public void setWaterColiformCount(Float waterColiformCount) {
        this.WaterColiformCount = waterColiformCount;
    }

    public String getAbnormalCondition() {
        return AbnormalCondition;
    }

    public void setAbnormalCondition(String abnormalCondition) {
        this.AbnormalCondition = abnormalCondition;
    }

    @Override
    public String toString() {
        return "FeedTest{" +
                "FeedWaterTestNumber=" + FeedWaterTestNumber +
                ", TestDate=" + TestDate +
                ", FeedReceiveNumber=" + FeedReceiveNumber +
                ", IfFeedStandard=" + IfFeedStandard +
                ", PersonnelNumber='" + PersonnelNumber + '\'' +
                ", FeedAppearanceTest='" + FeedAppearanceTest + '\'' +
                ", FeedMyeteTest='" + FeedMyeteTest + '\'' +
                ", FeedToxinTest='" + FeedToxinTest + '\'' +
                ", WaterBacterialCount=" + WaterBacterialCount +
                ", WaterColiformCount=" + WaterColiformCount +
                ", AbnormalCondition='" + AbnormalCondition + '\'' +
                '}';
    }
}
