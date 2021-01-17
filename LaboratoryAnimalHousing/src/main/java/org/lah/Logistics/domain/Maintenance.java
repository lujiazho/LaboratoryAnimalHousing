package org.lah.Logistics.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Maintenance implements java.io.Serializable {
    private Integer id;			            // id
    private Name ename;			            // 设备名称
    private Model sname;			        // 设备型号
    private String enumber;			        // 设备编号
    private String maintenanceresult;       // 检修结果
    private Employee maintainer;            // 检修人信息
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date maintenancedate;           // 检修日期

    public Maintenance() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Name getEname() {
        return ename;
    }

    public void setEname(Name ename) {
        this.ename = ename;
    }

    public Model getSname() {
        return sname;
    }

    public void setSname(Model sname) {
        this.sname = sname;
    }

    public String getEnumber() {
        return enumber;
    }

    public void setEnumber(String enumber) {
        this.enumber = enumber;
    }

    public String getMaintenanceresult() {
        return maintenanceresult;
    }

    public void setMaintenanceresult(String maintenanceresult) {
        this.maintenanceresult = maintenanceresult;
    }

    public Employee getMaintainer() {
        return maintainer;
    }

    public void setMaintainer(Employee maintainer) {
        this.maintainer = maintainer;
    }

    public Date getMaintenancedate() {
        return maintenancedate;
    }

    public void setMaintenancedate(Date maintenancedate) {
        this.maintenancedate = maintenancedate;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "id=" + id +
                ", ename=" + ename +
                ", sname=" + sname +
                ", enumber='" + enumber + '\'' +
                ", maintenanceresult='" + maintenanceresult + '\'' +
                ", maintainer=" + maintainer +
                ", maintenancedate=" + maintenancedate +
                '}';
    }
}
