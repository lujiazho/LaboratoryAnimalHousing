package org.lah.Logistics.domain;

public class Name implements java.io.Serializable {
    private Integer id;			// id
    private String name;		// 设备名称

    // 无参数构造器
    public Name() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
