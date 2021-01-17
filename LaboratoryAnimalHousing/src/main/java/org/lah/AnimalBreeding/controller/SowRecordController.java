package org.lah.AnimalBreeding.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalBreeding.domain.SowRecord;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.service.SowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * 处理母猪档案相关请求
 */
@Controller
public class SowRecordController {
    /**
     * 自动注入SowRecordService
     * */
    @Autowired
    private SowRecordService sowrecordService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(SowRecordController.class);

    /**
     * 分页查询母猪档案信息
     */
    @RequestMapping(value = "/findSowRecord")
    public String findSowRecord(String AnimalNumber,Integer PigAge,String HealthCondition,String LifeCondition,String Fertility,
                                 String BreedingHistory,String IfBreedSelectObserved,String IfBreedSelect, Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<SowRecord> pi = sowrecordService.findPageInfo(AnimalNumber,PigAge,HealthCondition,LifeCondition,Fertility,
                BreedingHistory,IfBreedSelectObserved,IfBreedSelect,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(8);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        if (AnimalNumber!=null){
            model.addAttribute("AnimalNumber", AnimalNumber);
        }
        return "/AnimalBreeding/ShowSowRecord";
    }

    /**
     * 修改母猪档案信息
     */
    @RequestMapping(value = "/updateSowRecord" ,method = RequestMethod.POST )
    public String updateSowRecord( SowRecord sowrecord) {
        sowrecordService.updateSowRecord(sowrecord);
        int s = sowrecordService.updateSowRecord(sowrecord);
        return "redirect:/findSowRecord";
    }

    /**
     * 根据ID查找母猪档案信息
     */
    @RequestMapping( "/findSowRecordById")
    public String findSowRecordById(String AnimalNumber, HttpSession session) {
        SowRecord sowRecord= sowrecordService.findSowRecordById(AnimalNumber);
        session.setAttribute("sowRecord",sowRecord);
        return "/AnimalBreeding/RecordSowRecord";
    }
}
