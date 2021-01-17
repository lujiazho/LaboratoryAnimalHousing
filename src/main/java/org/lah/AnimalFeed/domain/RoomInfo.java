package org.lah.AnimalFeed.domain;


public class RoomInfo {
    private Integer RoomNumber;			        // 房间编号/////////
    private String RoomType;       // 房间类型///////////
    private Integer AccommodateNumber;     // 最多容纳动物数
    private Integer AccommodatedNumber;//已容纳动物数
    private String RoomAnomaly;               // 房间异常情况

    public Integer getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        RoomNumber = roomNumber;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String roomType) {
        RoomType = roomType;
    }

    public Integer getAccommodateNumber() {
        return AccommodateNumber;
    }

    public void setAccommodateNumber(Integer accommodateNumber) {
        AccommodateNumber = accommodateNumber;
    }

    public Integer getAccommodatedNumber() {
        return AccommodatedNumber;
    }

    public void setAccommodatedNumber(Integer accommodatedNumber) {
        AccommodatedNumber = accommodatedNumber;
    }

    public String getRoomAnomaly() {
        return RoomAnomaly;
    }

    public void setRoomAnomaly(String roomAnomaly) {
        RoomAnomaly = roomAnomaly;
    }

    @Override
    public String toString() {
        return "RoomInfo{" +
                "RoomNumber=" + RoomNumber +
                ", RoomType='" + RoomType + '\'' +
                ", AccommodateNumber=" + AccommodateNumber +
                ", AccommodatedNumber=" + AccommodatedNumber +
                ", RoomAnomaly='" + RoomAnomaly + '\'' +
                '}';
    }
}
