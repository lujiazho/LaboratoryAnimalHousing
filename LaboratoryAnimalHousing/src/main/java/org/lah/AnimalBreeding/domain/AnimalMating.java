package org.lah.AnimalBreeding.domain;

/**
 * 动物配种记录表类
 */
public class AnimalMating {
    private Integer AnimalMatingNumber;        //动物编号
    private String BoarNumber;   //行为开始时间
    private String SowNumber;     //行为结束时间
    private Integer RoomNumber;           //行为编码
    private String MatingStartTime; //行为描述
    private String MatingEndTime;       //处理方案
    private String Note;     //处理结果
    public AnimalMating() {
        super();
    }

    public Integer getAnimalMatingNumber() {
        return AnimalMatingNumber;
    }

    public void setAnimalMatingNumber(Integer animalMatingNumber) {
        AnimalMatingNumber = animalMatingNumber;
    }

    public String getBoarNumber() {
        return BoarNumber;
    }

    public void setBoarNumber(String boarNumber) {
        BoarNumber = boarNumber;
    }

    public String getSowNumber() {
        return SowNumber;
    }

    public void setSowNumber(String sowNumber) {
        SowNumber = sowNumber;
    }

    public Integer getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        RoomNumber = roomNumber;
    }

    public String getMatingStartTime() {
        return MatingStartTime;
    }

    public void setMatingStartTime(String matingStartTime) {
        MatingStartTime = matingStartTime;
    }

    public String getMatingEndTime() {
        return MatingEndTime;
    }

    public void setMatingEndTime(String matingEndTime) {
        MatingEndTime = matingEndTime;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    @Override
    public String toString() {
        return "AnimalMating{" +
                "AnimalMatingNumber='" + AnimalMatingNumber + '\'' +
                ", BoarNumber='" + BoarNumber + '\'' +
                ", SowNumber='" + SowNumber + '\'' +
                ", RoomNumber=" + RoomNumber +
                ", MatingStartTime='" + MatingStartTime + '\'' +
                ", MatingEndTime='" + MatingEndTime + '\'' +
                ", Note='" + Note + '\'' +
                '}';
    }
}
