package org.lah.AnimalFeed.domain;



import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Room {
    private Integer RoomNumber;			        // 房间编号/////////
    private String AnimalNumber;           // 动物编号/////////
    private boolean IfLeave;//是否暂离
    private String LeaveReason;//暂离原因

    public Integer getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.RoomNumber = roomNumber;
    }

    public String getAnimalNumber() {
        return AnimalNumber;
    }

    public void setAnimalNumber(String animalNumber) {
        this.AnimalNumber = animalNumber;
    }

    public boolean isIfLeave() {
        return IfLeave;
    }

    public void setIfLeave(boolean ifLeave) {
        this.IfLeave = ifLeave;
    }

    public String getLeaveReason() {
        return LeaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.LeaveReason = leaveReason;
    }

    @Override
    public String toString() {
        return "Room{" +
                "RoomNumber=" + RoomNumber +
                ", AnimalNumber='" + AnimalNumber + '\'' +
                ", IfLeave=" + IfLeave +
                ", LeaveReason='" + LeaveReason + '\'' +
                '}';
    }
}
