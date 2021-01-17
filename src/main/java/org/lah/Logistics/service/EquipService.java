package org.lah.Logistics.service;

import org.lah.Commons.util.PageModel;
import org.lah.Logistics.domain.*;

import java.util.Date;
import java.util.List;

public interface EquipService {
    /**
     * 添加新设备
     * @param equip
     */
    void addEquip(Equip equip);

    /**
     * 查找设备
     * @param equip
     * @param pageModel
     * @return
     */
    List<Equip> findEquip(Equip equip, PageModel pageModel);

    Equip findEquipById(Integer id);

    int updateEquip(Equip equip);

    int deleteEquip(Integer eid);

    List<Equip> findAllEquip();

    /*********************************** 设备名 **********************************************/
    /**
     * 获得所有设备名
     * @return
     */
    List<Name> findAllName();

    /**
     * 获得所有型号
     * @return
     */
    List<Model> findAllModel();

    List<Name> findEquipName(Name name,PageModel pageModel);

    List<Model> findEquipSpec(Model model,PageModel pageModel);

    void addEquipName(Name name);

    void addEquipSpec(Model model);


    /*********************************** 设备申购 **********************************************/
    // 查询全部
    List<Application> findApplication(Application application, PageModel pageModel);

    // 查询未完成订单
    List<Application> findUnfinishedApplication(Application application, PageModel pageModel);

    void addApplication(Application application);

    Application findApplicationById(Integer a_id);

    int updateApplication(Integer newreceived, Application application); //修改申购信息
    // 导出
    List<Application> getAllApplications();

    /*********************************** 设备检修 **********************************************/
    // 查询全部
    List<Maintenance> findMaintenance(Maintenance maintenance, PageModel pageModel);

    void addMaintenance(Maintenance maintenance);

    List<Equip> selectByEidSid(String eid, String sid);

    List<Employee> findAllMaintainer();
    // 导出
    List<Maintenance> getAllMaintenances();
}
