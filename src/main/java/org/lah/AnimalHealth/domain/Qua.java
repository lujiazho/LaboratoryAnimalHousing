package org.lah.AnimalHealth.domain;
import java.io.Serializable;
public class Qua implements Serializable{
    private String id;			// id
    private String var;
    private String info;
    private String cons;
    private String name;
    public Qua(){super();}
    public void setId(String id){this.id=id;}
    public String getId(){return id;}
    public void setVar(String var){this.var=var;}
    public String getVar(){return var;}
    public void setInfo(String info){this.info=info;}
    public String getInfo(){return info;}
    public void setCons(String cons){this.cons=cons;}
    public String getCons(){return cons;}
    public void setName(String name){this.name=name;}
    public String getName(){return name;}
    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", var='" + var + '\'' +
                ", info='" + info + '\'' +
                ", cons='" + cons + '\'' +
                ", name=" + name +
                '}';
    }
}
