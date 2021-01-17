package org.lah.AnimalHealth.domain;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Animal implements Serializable{
    private String id;			// id
    private String var;
    private String state;
    private String health;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;	// 接收日期
    // 无参数构造器
    public Animal() {
        super();
    }
    public void setId(String id){this.id=id;}
    public String getId(){return id;}
    public void setVar(String var){this.var=var;}
    public String getVar(){return var;}
    public void setState(String state){this.state=state;}
    public String getState(){return state;}
    public void setHealth(String health){this.health=health;}
    public String getHealth(){return health;}
    public void setDate(Date date){this.date=date;}
    public Date getDate(){return date;}
    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", var='" + var + '\'' +
                ", state='" + state + '\'' +
                ", health='" + health + '\'' +
                ", date=" + date +
                '}';
    }

}
