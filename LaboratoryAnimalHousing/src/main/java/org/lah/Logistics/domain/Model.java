package org.lah.Logistics.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.Commons.util.SqlSession;
import org.lah.Logistics.controller.EquipController;
import org.lah.Logistics.mapper.EquipMapper;
import org.lah.Logistics.service.EquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

import static org.lah.Commons.LahConstants.EQUIPSPECTABLE;
import static org.lah.Commons.LahConstants.EQUIPTABLE;

public class Model implements java.io.Serializable {

//    @Autowired
//    @Qualifier("EquipService")
//    private EquipService equipService;

//    // 静态的日志类LogFactory
//    private static final Log logger = LogFactory
//            .getLog(Model.class);

    private Integer id;			// id
    private String name;		// 设备型号
    private Integer eid;        // 对应设备编号

    // 无参数构造器
    public Model() {
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

    public Integer getEid() {
        return eid;
    }

//    public String getEname(Integer id) {
////        logger.info("\n\n\n\n进来没有吗的\n: ");
//        logger.info("\n传进来的id是什么几把: " + id + "\n\n");
////        logger.info("\n再次获取eid吗的: " + eid + "\n\n");
//        Equip equip = equipService.findEquipById(id);
//
//        logger.info("\n\n\n\n尼玛的设备呢: " + equip);
//        return equip.getEquipmentname().getName();
//    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", eid=" + eid +
                '}';
    }
}
