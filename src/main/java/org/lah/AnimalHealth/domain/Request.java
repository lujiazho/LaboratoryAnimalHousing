package org.lah.AnimalHealth.domain;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Request implements Serializable{
    private String var;
    private String info;
    private int num;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;	// 接收日期
    public Request(){super();}
    public void setVar(String var){this.var=var;}
    public String getVar(){return var;}
    public void setInfo(String info){this.info=info;}
    public String getInfo(){return info;}
    public void setNum(int num){this.num=num;}
    public int getNum(){return num;}
    public void setDate(Date date){this.date=date;}
    public Date getDate(){return date;}
    @Override
    public String toString() {
        return "Request{" +
                "var=" + var +
                ", info='" + info + '\'' +
                ", num='" + num + '\'' +
                ", date=" + date +
                '}';
    }
}
