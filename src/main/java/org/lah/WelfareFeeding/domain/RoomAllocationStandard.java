package org.lah.WelfareFeeding.domain;

import java.io.Serializable;

/**
 * 2020rg_group13_room_allocation_standard
 */
public class RoomAllocationStandard implements Serializable {
    private String roomallocationstandardnumber;

    private String animalnumber;

    private String staffing;

    private Double livingspacerequirements;

    private String additionalallocationrequirements;

    private static final long serialVersionUID = 1L;

    public String getRoomallocationstandardnumber() {
        return roomallocationstandardnumber;
    }

    public void setRoomallocationstandardnumber(String roomallocationstandardnumber) {
        this.roomallocationstandardnumber = roomallocationstandardnumber;
    }

    public String getAnimalnumber() {
        return animalnumber;
    }

    public void setAnimalnumber(String animalnumber) {
        this.animalnumber = animalnumber;
    }

    public String getStaffing() {
        return staffing;
    }

    public void setStaffing(String staffing) {
        this.staffing = staffing;
    }

    public Double getLivingspacerequirements() {
        return livingspacerequirements;
    }

    public void setLivingspacerequirements(Double livingspacerequirements) {
        this.livingspacerequirements = livingspacerequirements;
    }

    public String getAdditionalallocationrequirements() {
        return additionalallocationrequirements;
    }

    public void setAdditionalallocationrequirements(String additionalallocationrequirements) {
        this.additionalallocationrequirements = additionalallocationrequirements;
    }
}