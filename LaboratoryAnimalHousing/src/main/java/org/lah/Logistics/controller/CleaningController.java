package org.lah.Logistics.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.Commons.controller.login;
import org.lah.Commons.util.PageModel;
import org.lah.Logistics.domain.PageInfo;
import org.lah.Logistics.mapper.MaintenanceMapper;
import org.lah.Logistics.mapper.WasteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.lah.Logistics.service.CleaningService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.lah.Logistics.domain.Waste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.lah.Commons.LahConstants.PAGE_DEFAULT_SIZE;

/*
    处理保洁相关请求
 */
@Controller
public class CleaningController {
    /**
     * 自动注入CleaningService
     * */
    @Autowired
    @Qualifier("CleaningService")
    private CleaningService cleanService;

    @Autowired
    private WasteMapper wasteMapper;

    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(CleaningController.class);

    /**
     * 处理查询请求
     * @param pageIndex 请求的是第几页
     * @param waste 模糊查询参数
     * @param model model
     * */
    @RequestMapping(value="/waste/selectWaste")
    public String selectWaste(Integer pageIndex,Integer pageSize,
                              String string_wastedate,@ModelAttribute Waste waste,
                             Model model){
        // 条件查询功能实现——日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTime = null;
        try {
            // 日期格式转换
            if(string_wastedate != null && !string_wastedate.equals("")){
                dateTime = simpleDateFormat.parse(string_wastedate);
                waste.setLoggingdate(dateTime);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 创建分页对象
        PageModel pageModel = new PageModel();
        if(pageIndex != null){
            pageModel.setPageIndex(pageIndex);
        }
        // 当按条件查时，可以自定义pagesize为任意数，非条件查时默认为4
        if ((waste.getWastetype()!=null&&waste.getWastetype()!=0)||
                (waste.getRecycable()!=null&&waste.getRecycable()!=0)||
                (string_wastedate != null && !string_wastedate.equals(""))){
            pageModel.setPageSize(pageSize);
        }
        Map<String,Object> params = new HashMap<>();
        params.put("waste", waste);
        // 查询总数
        int recordCount = wasteMapper.count(params);
        // 查询垃圾信息
        List<Waste> wastes = cleanService.findWaste(waste, pageModel);
        // 设置页面信息
        PageInfo<org.lah.Logistics.domain.Model> pageInfo = new PageInfo<org.lah.Logistics.domain.Model>();
        pageInfo.setPageIndex(pageIndex);
        if ((waste.getWastetype()!=null&&waste.getWastetype()!=0)||
                (waste.getRecycable()!=null&&waste.getRecycable()!=0)||
                (string_wastedate != null && !string_wastedate.equals(""))){
            pageInfo.setPageSize(pageModel.getPageSize());
        }else{
            pageInfo.setPageSize(PAGE_DEFAULT_SIZE);
        }
        pageInfo.setTotalCount(recordCount);
        pageInfo.setPageTotalCount(pageInfo.getPageTotalCount());
        // 设置为requestScope的参数，便于在jsp中使用
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("wastes", wastes);
        model.addAttribute("pageModel", pageModel);
        // 为使得翻页时条件查询参数能保存，得以正常翻页，添加如下requestScope参数
        if ((waste.getRecycable()!=null && waste.getRecycable()!=0)||
                (waste.getWastetype()!=null && waste.getWastetype()!=0)||
                (string_wastedate!=null && !string_wastedate.equals(""))){
            model.addAttribute("recyc", waste.getRecycable());
            model.addAttribute("type", waste.getWastetype());
            model.addAttribute("string_wastedate", string_wastedate);
        }
        return "/Logistics/ReNew/waste_list";

    }

    /**
     * 添加垃圾信息
     * @param flag
     * @param waste
     * @param mv
     * @return
     */
    @RequestMapping(value="/waste/addWaste")
    public ModelAndView addWaste(
            String flag,
            @ModelAttribute Waste waste,
            ModelAndView mv){
        if(flag.equals("1")){
            // 设置跳转到添加页面
            mv.setViewName("/Logistics/AddWaste");
        }else{
            // 执行添加操作
            cleanService.addWaste(waste);
            // 设置客户端跳转到查询请求
            mv.setViewName("redirect:/waste/selectWaste");
        }
        // 返回
        return mv;
    }


    @RequestMapping(value = "/exportwastelist", method = RequestMethod.POST)
    @ResponseBody
    public List<Waste> exportWaste(){
        logger.info("进来");
        // 查询全部
        List<Waste> wastes = cleanService.getAllWaste();
        logger.info("\n\nwastes: "+wastes+"\n\n");
        return wastes;
    }
}
