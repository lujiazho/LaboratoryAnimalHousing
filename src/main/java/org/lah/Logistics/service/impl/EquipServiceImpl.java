package org.lah.Logistics.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.Commons.util.PageModel;
import org.lah.Logistics.controller.EquipController;
import org.lah.Logistics.domain.*;
import org.lah.Logistics.mapper.*;
import org.lah.Logistics.service.EquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT)
@Service("EquipService")
public class EquipServiceImpl implements EquipService {
    @Autowired
    private EquipMapper equipMapper;
    @Autowired
    private NameMapper nameMapper;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ApplicationMapper applicationMapper;
    @Autowired
    private MaintenanceMapper maintenanceMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(EquipServiceImpl.class);
    @Override
    public void addEquip(Equip equip){
        equipMapper.save(equip);
    }

    @Transactional(readOnly=true)
    @Override
    public List<Equip> findEquip(Equip equip, PageModel pageModel) {
        /** 当前需要分页的总数据条数  */
        Map<String,Object> params = new HashMap<>();
        params.put("equip", equip);
        int recordCount = equipMapper.count(params);
        pageModel.setRecordCount(recordCount);
        if(recordCount > 0){
            /** 开始分页查询数据：查询第几页的数据 */
            params.put("pageModel", pageModel);
        }
        List<Equip> equips = equipMapper.selectByPage(params);

        return equips;
    }

    @Override
    public Equip findEquipById(Integer id){
        Equip e = equipMapper.findEquipById(id);
        return e;
    }

    @Override
    public int updateEquip(Equip equip) {
        return equipMapper.updateEquip(equip.getUsage(), equip.getId());
    }

    //通过id删除设备信息
    @Override
    public int deleteEquip(Integer eid) {
        return equipMapper.deleteEquip(eid);
    }

    // 编码用
    @Transactional(readOnly=true)
    @Override
    public List<Equip> findAllEquip() {
        return equipMapper.getAll();
    }

    /*****************设备名接口实现*************************************/
    /**
     * HrmService接口findAllJob方法实现
     * @see { HrmService }
     * */
    @Transactional(readOnly=true)
    @Override
    public List<Name> findAllName() {
        return nameMapper.selectAllName();
    }

    /*****************设备型号接口实现*************************************/
    @Transactional(readOnly=true)
    @Override
    public List<Model> findAllModel() {
        return modelMapper.selectAllModel();
    }

    @Transactional(readOnly=true)
    @Override
    public List<Name> findEquipName(Name name, PageModel pageModel) {
        /** 当前需要分页的总数据条数  */
        Map<String,Object> params = new HashMap<>();
        params.put("name", name);
        int recordCount = nameMapper.count(params);
        pageModel.setRecordCount(recordCount);

        if(recordCount > 0){
            /** 开始分页查询数据：查询第几页的数据 */
            params.put("pageModel", pageModel);
        }

        List<Name> names = nameMapper.selectByPage(params);

        return names;
    }

    @Transactional(readOnly=true)
    @Override
    public List<Model> findEquipSpec(Model model, PageModel pageModel) {
        /** 当前需要分页的总数据条数  */
        Map<String,Object> params = new HashMap<>();
        params.put("model", model);
        int recordCount = modelMapper.count(params);
        pageModel.setRecordCount(recordCount);

        if(recordCount > 0){
            /** 开始分页查询数据：查询第几页的数据 */
            params.put("pageModel", pageModel);
        }

        List<Model> specs = modelMapper.selectByPage(params);

        return specs;
    }

    @Override
    public void addEquipSpec(Model model) {
        modelMapper.save(model);
    }

    @Override
    public void addEquipName(Name name) {
        nameMapper.save(name);
    }




    /*********************************** 设备申购 **********************************************/
    /**
     * 查询全部订单
     * @param application
     * @param pageModel
     * @return
     */
    @Transactional(readOnly=true)
    @Override
    public List<Application> findApplication(Application application, PageModel pageModel) {
        /** 当前需要分页的总数据条数  */
        Map<String,Object> params = new HashMap<>();
        params.put("application", application);
        int recordCount = applicationMapper.count(params);
        pageModel.setRecordCount(recordCount);

        if(recordCount > 0){
            /** 开始分页查询数据：查询第几页的数据 */
            params.put("pageModel", pageModel);
        }

        List<Application> applications = applicationMapper.selectByPage(params);

        return applications;
    }

    /**
     * 查询未完成
     * @param application
     * @param pageModel
     * @return
     */
    @Transactional(readOnly=true)
    @Override
    public List<Application> findUnfinishedApplication(Application application, PageModel pageModel) {
        /** 当前需要分页的总数据条数  */
        Map<String,Object> params = new HashMap<>();
        params.put("application", application);
        int recordCount = applicationMapper.countUnfinished(params);
        pageModel.setRecordCount(recordCount);

        if(recordCount > 0){
            /** 开始分页查询数据：查询第几页的数据 */
            params.put("pageModel", pageModel);
        }

        List<Application> applications = applicationMapper.selectByPageUnfinished(params);

        return applications;
    }

    @Override
    public void addApplication(Application application) {
        applicationMapper.save(application);
    }

    @Override
    public Application findApplicationById (Integer a_id){
        Application a = applicationMapper.findApplicationById(a_id);
        return a;
    }

    @Override
    public int updateApplication(Integer newreceived, Application application) {
        logger.info("\n\nserviceImpl有没有newreceived: " + newreceived+ "\n\n");
        logger.info("\n\nserviceImpl有没有Receivednum: " + application.getReceivednum() + " " + "\n\n");
        int sum = newreceived + application.getReceivednum();
        logger.info("\n\nserviceImpl有没有sum: " + sum + "\n\n");
        logger.info("\n\nserviceImpl有没有id: " + application.getId() + "\n\n");
        return applicationMapper.updateApplication(sum, application.getId());
    }

    public List<Application> getAllApplications(){
        List<Application> applications = applicationMapper.getAll();
        return applications;
    }

    /*********************************** 设备检修 **********************************************/
    @Transactional(readOnly=true)
    @Override
    public List<Maintenance> findMaintenance(Maintenance maintenance, PageModel pageModel) {
        /** 当前需要分页的总数据条数  */
        Map<String,Object> params = new HashMap<>();
        params.put("maintenance", maintenance);
        int recordCount = maintenanceMapper.count(params);
        pageModel.setRecordCount(recordCount);

        if(recordCount > 0){
            /** 开始分页查询数据：查询第几页的数据 */
            params.put("pageModel", pageModel);
        }

        List<Maintenance> maintenances = maintenanceMapper.selectByPage(params);

        return maintenances;
    }

    @Override
    public void addMaintenance(Maintenance maintenance) {
        maintenanceMapper.save(maintenance);
    }

    @Override
    public List<Equip> selectByEidSid(String eid, String sid){
        logger.info("\n\n去你妈的个八字eid: " + eid +" sid: "+sid+ "\n\n");
        return equipMapper.selectByEidSid(eid, sid);
    }

    @Transactional(readOnly=true)
    @Override
    public List<Employee> findAllMaintainer() {
        return employeeMapper.findAllMaintainer();
    }

    public List<Maintenance> getAllMaintenances(){
        List<Maintenance> maintenances = maintenanceMapper.getAll();
        return maintenances;
    }
}
