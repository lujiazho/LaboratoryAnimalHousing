package org.lah.Logistics.controller;

import net.sf.json.JSONArray;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.Commons.util.PageModel;
import org.lah.Logistics.domain.*;

import org.lah.Logistics.mapper.*;
import org.lah.Logistics.service.CleaningService;
import org.lah.Logistics.service.EquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static org.lah.Commons.LahConstants.EQUIPTABLE;
import static org.lah.Commons.LahConstants.PAGE_DEFAULT_SIZE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理设备相关请求
 */
@Controller
public class EquipController {
    /**
     * 自动注入EquipService
     * */
    @Autowired
    @Qualifier("EquipService")
    private EquipService equipService;

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

    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(EquipController.class);

    /**
     *
     * @param pageIndex
     * @param pageSize
     * @param string_loggingdate
     * @param ename_id
     * @param sname_id
     * @param equip
     * @param model
     * @return
     */
    @RequestMapping(value="/equip/selectEquip")
    public String selectEquip(Integer pageIndex, Integer pageSize,
                              String string_loggingdate, Integer ename_id, Integer sname_id,
                              @ModelAttribute Equip equip,
                              Model model){
        // 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
        this.genericAssociation(ename_id, sname_id, equip);
        // 条件查询功能实现——日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTime = null;
        try {
            // 日期格式转换
            if(string_loggingdate != null && !string_loggingdate.equals("")){
                dateTime = simpleDateFormat.parse(string_loggingdate);
                equip.setLoggingdate(dateTime);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 创建分页对象
        PageModel pageModel = new PageModel();
        // 如果参数pageIndex不为null，设置pageIndex，即显示第几页
        if(pageIndex != null){
            pageModel.setPageIndex(pageIndex);
        }
        // 当按条件查时，可以自定义pagesize为任意数，非条件查时默认为4
        if (ename_id!=null || sname_id!=null || (string_loggingdate != null && !string_loggingdate.equals(""))){
            pageModel.setPageSize(pageSize);
        }
        // 计算数据总数
        Map<String,Object> params = new HashMap<>();
        params.put("equip", equip);
        // 查询总数
        int recordCount = equipMapper.count(params);
        // 查询设备名信息，用于条件查询
        List<Name> names = equipService.findAllName();
        List<Equip> allEquips = equipService.findAllEquip();
        // 查询设备型号信息 ，用于条件查询(并使条件能保存)
        List<org.lah.Logistics.domain.Model> models = equipService.findAllModel();
        // 设置页面信息
        PageInfo<Equip> pageInfo = new PageInfo<Equip>();
        pageInfo.setPageIndex(pageIndex);
        if (ename_id!=null || sname_id!=null || (string_loggingdate != null && !string_loggingdate.equals(""))){
            pageInfo.setPageSize(pageModel.getPageSize());
        }else{
            pageInfo.setPageSize(PAGE_DEFAULT_SIZE);
        }
        pageInfo.setTotalCount(recordCount);
        pageInfo.setPageTotalCount(pageInfo.getPageTotalCount());
        // 查询设备信息
        List<Equip> equips = equipService.findEquip(equip, pageModel);
        // 自动编码用
        Integer max_id = 0;
        for (int i=0 ; i<allEquips.size() ; i++){
            String a = allEquips.get(i).getEquipmentnumber().substring(4,10);
            Integer index = Integer.parseInt(a);
            if (index>max_id){
                max_id = index;
            }
        }
        // 设置为requestScope的参数，便于在jsp中使用
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("max_id", max_id);
        model.addAttribute("equips", equips);
        model.addAttribute("names", names);
        model.addAttribute("models", models);
        model.addAttribute("pageModel", pageModel);
        // 为使得翻页时条件查询参数能保存，得以正常翻页，添加如下requestScope参数
        if ((ename_id!=null && ename_id!=0)||
                (sname_id!=null && sname_id!=0)||
                (string_loggingdate!=null && !string_loggingdate.equals(""))
        ||(equip.getUsage()!=null && equip.getUsage()!=0)){
            model.addAttribute("ename_id", ename_id);
            model.addAttribute("sname_id", sname_id);
            model.addAttribute("usage", equip.getUsage());
            model.addAttribute("string_loggingdate", string_loggingdate);
        }
        return "/Logistics/ReNew/equip_list";

    }

    /**
     *
     * @param flag flag 标记， 1表示跳转到添加页面，2表示执行添加操作
     * @param equip equip 要添加设备的对象
     * @param mv mv
     * @return
     */
    @RequestMapping(value="/equip/addEquip")
    public ModelAndView addEquip(
            String flag,
            Integer ename_id, Integer sname_id,
            @ModelAttribute Equip equip,
            ModelAndView mv){
        if(flag.equals("1")){
            // 查询职位信息
            List<Name> names = equipService.findAllName();
            // 查询部门信息
            List<org.lah.Logistics.domain.Model> models = equipService.findAllModel();
            logger.info("names: " + names);
            logger.info("models: " + models);
            // 设置Model数据
            mv.addObject("names", names);
            mv.addObject("models", models);
            // 设置跳转到添加页面
            mv.setViewName("/Logistics/AddEquip");
        }else{
            logger.info("\n\n进这里了 /equip/addEquip\n\n");
            logger.info("\n\n是什么 \n\n" + equip);
            // 判断是否有关联对象传递，如果有，创建关联对象
            this.genericAssociation(ename_id, sname_id, equip);
            // 执行添加操作
            equipService.addEquip(equip);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/equip/selectEquip");
        }
        // 返回
        return mv;
    }

    @RequestMapping( "/findEquipById")
    public String findEquipById(Integer id,HttpSession session) {
        Equip a= equipService.findEquipById(id);
        session.setAttribute("a",a);
        return "Logistics/ReNew/equip_edit";
    }

    /**
     * 修改设备信息
     */
    @RequestMapping("/updateEquip")
    public String updateEquip(Equip equip) {
        equipService.updateEquip(equip);
        return "redirect:/equip/selectEquip";
    }

    /**
     * 删除设备信息
     */
    @RequestMapping( "/deleteEquip")
    @ResponseBody
    public String deleteEquip(Integer eid) {
        int e = equipService.deleteEquip(eid);
        return "dormitory_list";
    }


    /*****************************************   关联函数   ************************************************/
    /**
     * 由于设备名字和型号在是对象关联映射，
     * 所以不能直接接收参数，需要创建Name对象和Model对象
     * */
    private void genericAssociation(Integer equipmentname_id,
                                    Integer specificationmodel_id, Equip equip){
        if(equipmentname_id != null){
            Name name = new Name();
            name.setId(equipmentname_id);
            equip.setEquipmentname(name);
        }
        if(specificationmodel_id != null){
            org.lah.Logistics.domain.Model model = new org.lah.Logistics.domain.Model();
            model.setId(specificationmodel_id);
            equip.setSpecificationmodel(model);
        }
    }

    /**
     * 由于设备名字、型号、员工在是对象关联映射，
     * 所以不能直接接收参数，需要创建Name对象和Model对象
     * */
    private void genApplicAssociation(Integer ename_id,Integer sname_id, Integer employee_id,
                                    Application application){
        if(ename_id != null){
            Name name = new Name();
            name.setId(ename_id);
            application.setEname(name);
        }
        if(sname_id != null){
            org.lah.Logistics.domain.Model model = new org.lah.Logistics.domain.Model();
            model.setId(sname_id);
            application.setSname(model);
        }
        if(employee_id != null){
            Employee employee = new Employee();
            employee.setId(employee_id);
            application.setEmployee(employee);
        }
    }

    private void genMaintenAssociation(Integer ename_id,Integer sname_id, Integer maintainer_id,
                                      Maintenance maintenance){
        if(ename_id != null){
            Name name = new Name();
            name.setId(ename_id);
            maintenance.setEname(name);
        }
        if(sname_id != null){
            org.lah.Logistics.domain.Model model = new org.lah.Logistics.domain.Model();
            model.setId(sname_id);
            maintenance.setSname(model);
        }
        if(maintainer_id != null){
            Employee maintainer = new Employee();
            maintainer.setId(maintainer_id);
            maintenance.setMaintainer(maintainer);
        }
    }

    /**
     * 查看设备名称
     * @param model
     * @param pageIndex
     * @param name
     * @return
     */
    @RequestMapping(value="/equip/selectEquipName")
    public String selectEquipName(Model model,Integer pageIndex,Integer pageSize,
                                  @ModelAttribute Name name){
        PageModel pageModel = new PageModel();
        if(pageIndex != null){
            pageModel.setPageIndex(pageIndex);
        }
        // 当按条件查时，可以自定义pagesize为任意数，非条件查时默认为4
        if ( name.getId()!=null && name.getId()!=0){
            pageModel.setPageSize(pageSize);
        }
        Map<String,Object> params = new HashMap<>();
        params.put("name", name);
        // 查询总数
        int recordCount = nameMapper.count(params);
        // 设置页面信息
        PageInfo<Name> pageInfo = new PageInfo<Name>();
        pageInfo.setPageIndex(pageIndex);
        if (name.getId()!=null && name.getId()!=0){
            pageInfo.setPageSize(pageModel.getPageSize());
        }else{
            pageInfo.setPageSize(PAGE_DEFAULT_SIZE);
        }
        pageInfo.setTotalCount(recordCount);
        pageInfo.setPageTotalCount(pageInfo.getPageTotalCount());
        // 查询设备名信息，用于模糊查询
        List<Name> allnames = equipService.findAllName();
        // 查询设备名称信息
        List<Name> names = equipService.findEquipName(name, pageModel);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("names", names);
        model.addAttribute("allnames", allnames);
        model.addAttribute("pageModel", pageModel);
        if (name.getId()!=null && name.getId()!=0){
            model.addAttribute("id", name.getId());
        }
        return "Logistics/ReNew/equipname_list";
    }

    /**
     * 扩展设备名称
     * @param flag
     * @param name
     * @param mv
     * @return
     */
    @RequestMapping(value="/equip/extendEquipName")
    public ModelAndView extendEquipName(
            String flag,
            @ModelAttribute Name name,
            ModelAndView mv){
        if(flag.equals("1")){
            // 设置跳转到添加页面
            mv.setViewName("/Logistics/ExtendEquipName");
        }else{
            // 执行添加操作
            equipService.addEquipName(name);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/equip/selectEquipName");
        }
        // 返回
        return mv;
    }

    @RequestMapping(value="/equip/selectEquipSpec")
    public String selectEquipSpec(Model model1,Integer pageIndex,Integer pageSize,
                                  @ModelAttribute org.lah.Logistics.domain.Model model){
        PageModel pageModel = new PageModel();
        if(pageIndex != null){
            pageModel.setPageIndex(pageIndex);
        }
        // 当按条件查时，可以自定义pagesize为任意数，非条件查时默认为4
        if ( model.getEid()!=null && model.getEid()!=0){
            pageModel.setPageSize(pageSize);
        }
        Map<String,Object> params = new HashMap<>();
        params.put("model", model);
        // 查询总数
        int recordCount = modelMapper.count(params);
        // 设置页面信息
        PageInfo<org.lah.Logistics.domain.Model> pageInfo = new PageInfo<org.lah.Logistics.domain.Model>();
        pageInfo.setPageIndex(pageIndex);
        if (model.getEid()!=null && model.getEid()!=0){
            pageInfo.setPageSize(pageModel.getPageSize());
        }else{
            pageInfo.setPageSize(PAGE_DEFAULT_SIZE);
        }
        pageInfo.setTotalCount(recordCount);
        pageInfo.setPageTotalCount(pageInfo.getPageTotalCount());
        // 查询设备型号(页)
        List<org.lah.Logistics.domain.Model> specs = equipService.findEquipSpec(model, pageModel);
        // 查询所有设备型号
        List<org.lah.Logistics.domain.Model> allspecs = equipService.findAllModel();
        // 查询设备名信息，用于条件查询
        List<Name> names = equipService.findAllName();
        model1.addAttribute("specs", specs);
        model1.addAttribute("allspecs", allspecs);
        model1.addAttribute("pageInfo",pageInfo);
        model1.addAttribute("names", names);
        model1.addAttribute("pageModel", pageModel);
        if (model.getEid()!=null && model.getEid()!=0){
            model1.addAttribute("eid", model.getEid());
        }
        return "Logistics/ReNew/equipspec_list";
    }

    @RequestMapping(value="/equip/extendEquipSpec")
    public ModelAndView extendEquipSpec(
            String flag,
            @ModelAttribute org.lah.Logistics.domain.Model model,
            ModelAndView mv){
        if(flag.equals("1")){
            // 设置跳转到添加页面
            mv.setViewName("/Logistics/ExtendEquipName");
        }else{
            // 执行添加操作
            equipService.addEquipSpec(model);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/equip/selectEquipSpec");
        }
        // 返回
        return mv;
    }



    /*********************************** ReNew加的 **********************************************/
    /**
     * 添加班级信息
     */
    @RequestMapping(value = "/addEquip" ,method = RequestMethod.POST)
    @ResponseBody
    public String addEquip(Integer equipmentname_id,Integer specificationmodel_id,
                           @ModelAttribute Equip equip) {
        logger.info("\n\n进这里了 /addEquip\n\n");
//        logger.info("\n\nuequip是什么\n" + uequip + "\n\n");
        logger.info("equipmentname_id:" + equipmentname_id + "specificationmodel_id:" + specificationmodel_id +"\n\n");
        logger.info("\n\nequip是什么 \n\n" + equip);
        equipService.addEquip(equip);
        return "class_list";
    }

    /*********************************** 设备申购 **********************************************/
    @RequestMapping(value="/equip/selectApplication")
    public String selectApplication(Model model1,Integer pageIndex, Integer pageSize,
                                  String string_applicationdate, Integer ename_id, Integer sname_id,
                                  @ModelAttribute Application application){
        // 条件查询功能实现——设备名、型号
        // 条件查询时判断是否有关联对象传递，如果有，创建并封装关联对象
        if (ename_id!=null && sname_id==null){
            this.genApplicAssociation(ename_id, null, null, application);
        }else if (ename_id!=null){
            this.genApplicAssociation(ename_id, sname_id, null, application);
        }
        // 条件查询功能实现——日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTime = null;
        try {
            // 日期格式转换
            if(string_applicationdate != null && !string_applicationdate.equals("")){
                dateTime = simpleDateFormat.parse(string_applicationdate);
                application.setApplicationdate(dateTime);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 翻页实现
        PageModel pageModel = new PageModel();
        if(pageIndex != null){
            pageModel.setPageIndex(pageIndex);
        }
        // 当按条件查时，可以自定义pagesize为任意数，非条件查时默认为4
        if (ename_id!=null || sname_id!=null || (string_applicationdate != null && !string_applicationdate.equals(""))){
            pageModel.setPageSize(pageSize);
        }
        // 计算数据总数
        Map<String,Object> params = new HashMap<>();
        params.put("application", application);
        int recordCount = applicationMapper.countUnfinished(params);
        // 查询未完成的申购信息
        List<Application> applications = equipService.findUnfinishedApplication(application, pageModel);
        // 设置页面信息
        PageInfo<Application> pageInfo = new PageInfo<Application>();
        pageInfo.setPageIndex(pageIndex);
        if (ename_id!=null || sname_id!=null || (string_applicationdate != null && !string_applicationdate.equals(""))){
            pageInfo.setPageSize(pageModel.getPageSize());
        }else{
            pageInfo.setPageSize(PAGE_DEFAULT_SIZE);
        }
        pageInfo.setTotalCount(recordCount);
        pageInfo.setPageTotalCount(pageInfo.getPageTotalCount());
        // 查询设备名信息，用于查询
        List<Name> names = equipService.findAllName();
        // 查询设备型号信息 ，用于条件查询(并使条件能保存)
        List<org.lah.Logistics.domain.Model> models = equipService.findAllModel();
        // 设置为requestScope的参数，便于在jsp中使用
        model1.addAttribute("pageInfo",pageInfo);
        model1.addAttribute("applications", applications);
        model1.addAttribute("names", names);
        model1.addAttribute("models", models);
        model1.addAttribute("pageModel", pageModel);
        // 为使得翻页时条件查询参数能保存，得以正常翻页，添加如下requestScope参数
        if ((ename_id!=null && ename_id!=0)||
                (sname_id!=null && sname_id!=0)||
                (string_applicationdate!=null && !string_applicationdate.equals(""))){
            model1.addAttribute("ename_id", ename_id);
            model1.addAttribute("sname_id", sname_id);
            model1.addAttribute("string_applicationdate", string_applicationdate);
        }
        return "Logistics/ReNew/application_list";
    }


    @RequestMapping(value="/equip/addApplication")
    public ModelAndView addApplication(
            String flag,
            Integer ename_id,Integer sname_id, Integer employee_id,
            @ModelAttribute Application application,
            ModelAndView mv){
        if(flag.equals("1")){

        }else{
            logger.info("\n\n进这里了 /equip/addApplication\n\n");
            logger.info("\n\n是什么 \n\n" + application);
            // 判断是否有关联对象传递，如果有，创建关联对象
            this.genApplicAssociation(ename_id, sname_id, employee_id, application);
            // 执行添加操作
            equipService.addApplication(application);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/equip/selectApplication");
        }
        // 返回
        return mv;
    }

    @RequestMapping( "/findApplicationById")
    public String findApplicationById(Integer id,HttpSession session) {
        Application a= equipService.findApplicationById(id);
        session.setAttribute("a",a);
        return "Logistics/ReNew/application_edit";
    }

    /**
     * 修改申购信息
     */
    @RequestMapping("/updateApplication")
    public String updateApplication(Integer newreceived, Application application) {
        logger.info("\n\ncontroller有没有: " + newreceived + "\n\n");
        equipService.updateApplication(newreceived, application);
        return "redirect:/equip/selectApplication";
    }

    /*********************************** 设备检修 **********************************************/
    /**
     *
     * @param model1
     * @param pageIndex
     * @param maintenance
     * @return
     */
    @RequestMapping(value="/equip/selectMaintenance")
    public String selectMaintenance(Model model1,Integer pageIndex, Integer pageSize,
                                    String string_maintenancedate, Integer ename_id, Integer sname_id,
                                    @ModelAttribute Maintenance maintenance){
        // 条件查询功能实现——设备名、型号
        // 条件查询时判断是否有关联对象传递，如果有，创建并封装关联对象
        if (ename_id!=null && sname_id==null){
            this.genMaintenAssociation(ename_id, null, null, maintenance);
        }else if (ename_id!=null){
            this.genMaintenAssociation(ename_id, sname_id, null, maintenance);
        }
        // 条件查询功能实现——日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTime = null;
        try {
            // 日期格式转换
            if(string_maintenancedate != null && !string_maintenancedate.equals("")){
                dateTime = simpleDateFormat.parse(string_maintenancedate);
                maintenance.setMaintenancedate(dateTime);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 翻页实现
        PageModel pageModel = new PageModel();
        if(pageIndex != null){
            pageModel.setPageIndex(pageIndex);
        }
        // 当按条件查时，可以自定义pagesize为任意数，非条件查时默认为4
        if (ename_id!=null || sname_id!=null || (string_maintenancedate != null && !string_maintenancedate.equals(""))){
            pageModel.setPageSize(pageSize);
        }
        // 计算数据总数
        Map<String,Object> params = new HashMap<>();
        params.put("maintenance", maintenance);
        int recordCount = maintenanceMapper.count(params);
        // 查询检修信息
        List<Maintenance> maintenances = equipService.findMaintenance(maintenance, pageModel);
        // 设置页面信息
        PageInfo<Maintenance> pageInfo = new PageInfo<Maintenance>();
        pageInfo.setPageIndex(pageIndex);
        if (ename_id!=null || sname_id!=null || (string_maintenancedate != null && !string_maintenancedate.equals(""))){
            pageInfo.setPageSize(pageModel.getPageSize());
        }else{
            pageInfo.setPageSize(PAGE_DEFAULT_SIZE);
        }
        pageInfo.setTotalCount(recordCount);
        pageInfo.setPageTotalCount(pageInfo.getPageTotalCount());
        // 查询设备名信息，用于级联搜索
        List<Name> names = equipService.findAllName();
        // 查询设备型号信息 ，用于条件查询(并使条件能保存)
        List<org.lah.Logistics.domain.Model> models = equipService.findAllModel();
        // 查询维修人员
        List<Employee> maintainers = equipService.findAllMaintainer();
        // 设置为requestScope的参数，便于在jsp中使用
        model1.addAttribute("pageInfo",pageInfo);
        model1.addAttribute("maintenances", maintenances);
        model1.addAttribute("names", names);
        model1.addAttribute("models", models);
        model1.addAttribute("maintainers", maintainers);
        model1.addAttribute("pageModel", pageModel);
        // 为使得翻页时条件查询参数能保存，得以正常翻页，添加如下requestScope参数
        if ((ename_id!=null && ename_id!=0)||
                (sname_id!=null && sname_id!=0)||
                (string_maintenancedate!=null && !string_maintenancedate.equals(""))){
            model1.addAttribute("ename_id", ename_id);
            model1.addAttribute("sname_id", sname_id);
            model1.addAttribute("string_maintenancedate", string_maintenancedate);
        }
        return "Logistics/ReNew/maintenance_list";
    }

    @RequestMapping(value="/equip/addMaintenance")
    public ModelAndView addMaintenance(
            String flag,
            Integer ename_id,Integer sname_id, Integer maintainer_id,
            @ModelAttribute Maintenance maintenance,
            ModelAndView mv){
        if(flag.equals("1")){

        }else{
            logger.info("\n\n进这里了 /equip/addMaintenance\n\n");
            logger.info("\n\n是什么 \n\n" + maintenance);
            // 判断是否有关联对象传递，如果有，创建关联对象
            this.genMaintenAssociation(ename_id, sname_id, maintainer_id, maintenance);
            // 执行添加操作
            equipService.addMaintenance(maintenance);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/equip/selectMaintenance");
        }
        // 返回
        return mv;
    }


    /*********************************** 导出 **********************************************/
    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportapplicationlist", method = RequestMethod.POST)
    @ResponseBody
    public List<Application> exportApplication(){
        // 查询全部
        List<Application> applications = equipService.getAllApplications();
        return applications;
    }

    @RequestMapping(value = "/exportmaintenancelist", method = RequestMethod.POST)
    @ResponseBody
    public List<Maintenance> exportMaintenance(){
        // 查询全部
        List<Maintenance> maintenances = equipService.getAllMaintenances();
        return maintenances;
    }

    @RequestMapping(value = "/exportequiplist", method = RequestMethod.POST)
    @ResponseBody
    public List<Equip> exportEquip(){
        // 查询全部
        List<Equip> equips = equipService.findAllEquip();
        return equips;
    }

    @RequestMapping(value = "/exportnamelist", method = RequestMethod.POST)
    @ResponseBody
    public List<Name> exportName(){
        // 查询全部
        List<Name> names = equipService.findAllName();
        return names;
    }

    @RequestMapping(value = "/exportspeclist", method = RequestMethod.POST)
    @ResponseBody
    public List<org.lah.Logistics.domain.Model> exportModel(){
        // 查询全部
        List<org.lah.Logistics.domain.Model> models = equipService.findAllModel();
        return models;
    }

}
