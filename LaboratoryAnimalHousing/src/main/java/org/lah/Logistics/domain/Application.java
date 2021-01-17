package org.lah.Logistics.domain;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Application implements java.io.Serializable {
    private Integer id;			            // id
    private Name ename;                     // 设备名称
    private Model sname;                    // 设备型号
    private Integer demandnum;              // 需求数量
    private Employee employee;              // 申请人信息
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date applicationdate;           // 申请日期
    private Integer receivednum;            // 接受数量

    public Application() {
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

    public Integer getDemandnum() {
        return demandnum;
    }

    public void setDemandnum(Integer demandnum) {
        this.demandnum = demandnum;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getApplicationdate() {
        return applicationdate;
    }

    public void setApplicationdate(Date applicationdate) {
        this.applicationdate = applicationdate;
    }

    public Integer getReceivednum() {
        return receivednum;
    }

    public void setReceivednum(Integer receivednum) {
        this.receivednum = receivednum;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", ename=" + ename +
                ", sname=" + sname +
                ", demandnum=" + demandnum +
                ", employee=" + employee +
                ", applicationdate=" + applicationdate +
                ", receivednum=" + receivednum +
                '}';
    }
}
