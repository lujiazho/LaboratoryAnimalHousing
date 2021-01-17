package org.lah.Logistics.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class EquipLikeDB {
    private Integer id;			        // id
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date loggingdate;           // 登记日期
    private Integer equipmentname_id;       // 设备名称
    private Integer specificationmodel_id;  // 设备型号
    private String equipmentnumber;     // 设备编号
    private Integer usage;               // 使用情况
    public EquipLikeDB() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLoggingdate() {
        return loggingdate;
    }

    public void setLoggingdate(Date loggingdate) {
        this.loggingdate = loggingdate;
    }

    public Integer getEquipmentname_id() {
        return equipmentname_id;
    }

    public void setEquipmentname_id(Integer equipmentname_id) {
        this.equipmentname_id = equipmentname_id;
    }

    public Integer getSpecificationmodel_id() {
        return specificationmodel_id;
    }

    public void setSpecificationmodel_id(Integer specificationmodel_id) {
        this.specificationmodel_id = specificationmodel_id;
    }

    public String getEquipmentnumber() {
        return equipmentnumber;
    }

    public void setEquipmentnumber(String equipmentnumber) {
        this.equipmentnumber = equipmentnumber;
    }

    public Integer getUsage() {
        return usage;
    }

    public void setUsage(Integer usage) {
        this.usage = usage;
    }

    @Override
    public String toString() {
        return "EquipLikeDB{" +
                "id=" + id +
                ", loggingdate=" + loggingdate +
                ", equipmentname_id=" + equipmentname_id +
                ", specificationmodel_id=" + specificationmodel_id +
                ", equipmentnumber='" + equipmentnumber + '\'' +
                ", usage=" + usage +
                '}';
    }
}
