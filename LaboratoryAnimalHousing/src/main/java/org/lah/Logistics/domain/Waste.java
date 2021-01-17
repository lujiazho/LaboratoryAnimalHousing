package org.lah.Logistics.domain;
import java.io.Serializable;
import java.util.Date;

public class Waste implements Serializable {
    private Integer id;			// id
    private Date loggingdate;
    private Double wasteweight;
    private Integer recycable;
    private Integer wastetype;
    public Waste() {
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

    public Double getWasteweight() {
        return wasteweight;
    }

    public void setWasteweight(Double wasteweight) {
        this.wasteweight = wasteweight;
    }

    public Integer getRecycable() {
        return recycable;
    }

    public void setRecycable(Integer recycable) {
        this.recycable = recycable;
    }

    public Integer getWastetype() {
        return wastetype;
    }

    public void setWastetype(Integer wastetype) {
        this.wastetype = wastetype;
    }

    //    @Override
//    public String toString() {
//        return "Waste [id=" + id + ", LoggingDate=" + loggingdate + ", WasteWeight=" + wasteweight + ", Recycable="
//                + recycable + ", WasteType=" + wastetype + "]";
//    }
    @Override
    public String toString() {
        return "Waste{" +
                "id=" + id +
                ", loggingdate=" + loggingdate +
                ", wasteweight=" + wasteweight +
                ", recycable='" + recycable + '\'' +
                ", wastetype='" + wastetype + '\'' +
                '}';
    }
}
