package org.lah.AnimalBreeding.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalBreeding.domain.BoarRecord;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.service.BoarRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 处理种猪档案相关请求
 */
@Controller
public class BoarRecordController {
    /**
     * 自动注入BoarRecordService
     * */
    @Autowired
    private BoarRecordService boarrecordService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(BoarRecordController.class);

    /**
     * 分页查询种猪档案信息
     */
    @RequestMapping(value = "/findBoarRecord")
    public String findBoarRecord(String AnimalNumber,Integer PigAge,String HealthCondition,String LifeCondition,String Fertility,
                                 String BreedingHistory,String IfBreedSelectObserved,String IfBreedSelect, Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<BoarRecord> pi = boarrecordService.findPageInfo(AnimalNumber,PigAge,HealthCondition,LifeCondition,Fertility,
                BreedingHistory,IfBreedSelectObserved,IfBreedSelect,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(8);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        if (AnimalNumber!=null){
            model.addAttribute("AnimalNumber", AnimalNumber);
        }
        return "/AnimalBreeding/ShowBoarRecord";
    }

    /**
     * 修改种猪档案信息
     */
    @RequestMapping(value = "/updateBoarRecord" ,method = RequestMethod.POST )
    public String updateBoarRecord( BoarRecord boarrecord) {
        boarrecordService.updateBoarRecord(boarrecord);
        int s = boarrecordService.updateBoarRecord(boarrecord);
        return "redirect:/findBoarRecord";
    }

    /**
     * 根据ID查找种猪档案信息
     */
    @RequestMapping( "/findBoarRecordById")
    public String findBoarRecordById(String AnimalNumber, HttpSession session) {
        BoarRecord boarRecord= boarrecordService.findBoarRecordById(AnimalNumber);
        session.setAttribute("boarRecord",boarRecord);
        return "/AnimalBreeding/RecordBoarRecord";
    }
}
