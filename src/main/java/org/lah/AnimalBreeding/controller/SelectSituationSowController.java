package org.lah.AnimalBreeding.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.domain.SelectSituationSow;
import org.lah.AnimalBreeding.service.SelectSituationSowService;
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
public class SelectSituationSowController {
    /**
     * 自动注入SelectSituationSowService
     * */
    @Autowired
    private SelectSituationSowService selectSituationSowService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(SelectSituationSowController.class);

    /**
     * 分页查询母猪档案信息
     */
    @RequestMapping(value = "/findSelectSituationSow")
    public String findSelectSituationSow(String AnimalNumber,Integer PigAge,String HealthCondition,String LifeCondition,String Fertility,
                                 String BreedingHistory,String IfBreedSelectObserved,String IfBreedSelect, Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<SelectSituationSow> pi = selectSituationSowService.findPageInfo(AnimalNumber,PigAge,HealthCondition,LifeCondition,Fertility,
                BreedingHistory,IfBreedSelectObserved,IfBreedSelect,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(8);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        if (AnimalNumber!=null){
            model.addAttribute("AnimalNumber", AnimalNumber);
        }
        return "/AnimalBreeding/ShowSelectSituationSow";
    }

    /**
     * 修改母猪档案信息
     */
    @RequestMapping(value = "/updateSelectSituationSow" ,method = RequestMethod.POST )
    public String updateSelectSituationSow( SelectSituationSow selectSituationSow) {
        selectSituationSowService.updateSelectSituationSow(selectSituationSow);
        int s = selectSituationSowService.updateSelectSituationSow(selectSituationSow);
        return "redirect:/findSelectSituationSow";
    }

    /**
     * 根据ID查找母猪档案信息
     */
    @RequestMapping( "/findSelectSituationSowById")
    public String findSelectSituationSowById(String AnimalNumber, HttpSession session) {
        SelectSituationSow selectSituationSow= selectSituationSowService.findSelectSituationSowById(AnimalNumber);
        session.setAttribute("selectSituationSow",selectSituationSow);
        return "/AnimalBreeding/RecordSelectSituationSow";
    }
}
