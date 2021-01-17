package org.lah.Logistics.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Equip implements java.io.Serializable{
    private Integer id;			        // id
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date loggingdate;           // 登记日期
    private Name equipmentname;       // 设备名称
    private Model specificationmodel;  // 设备型号
    private String equipmentnumber;     // 设备编号
    private Integer usage;               // 使用情况
    public Equip() {
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

    public Name getEquipmentname() {
        return equipmentname;
    }

    public void setEquipmentname(Name equipmentname) {
        this.equipmentname = equipmentname;
    }

    public Model getSpecificationmodel() {
        return specificationmodel;
    }

    public void setSpecificationmodel(Model specificationmodel) {
        this.specificationmodel = specificationmodel;
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
        return "Equip{" +
                "id=" + id +
                ", loggingdate=" + loggingdate +
                ", equipmentname=" + equipmentname +
                ", specificationmodel=" + specificationmodel +
                ", equipmentnumber='" + equipmentnumber + '\'' +
                ", usage=" + usage +
                '}';
    }
}
