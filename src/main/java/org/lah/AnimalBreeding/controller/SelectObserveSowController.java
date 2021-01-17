package org.lah.AnimalBreeding.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.domain.SelectObserveSow;
import org.lah.AnimalBreeding.service.SelectObserveSowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 处理母猪档案相关请求
 */
@Controller
public class SelectObserveSowController {
    /**
     * 自动注入SelectObserveSowService
     * */
    @Autowired
    private SelectObserveSowService selectObserveSowService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(SelectObserveSowController.class);

    /**
     * 分页查询母猪档案信息
     */
    @RequestMapping(value = "/findSelectObserveSow")
    public String findSelectObserveSow(String AnimalNumber,Integer PigAge,String HealthCondition,String LifeCondition,String Fertility,
                                 String BreedingHistory,String IfBreedSelectObserved,String IfBreedSelect, Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<SelectObserveSow> pi = selectObserveSowService.findPageInfo(AnimalNumber,PigAge,HealthCondition,LifeCondition,Fertility,BreedingHistory,IfBreedSelectObserved,IfBreedSelect,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(8);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        if (AnimalNumber!=null){
            model.addAttribute("AnimalNumber", AnimalNumber);
        }
        return "/AnimalBreeding/ShowSelectObserveSow";
    }

    /**
     * 修改母猪档案信息
     */
    @RequestMapping( "/updateSelectObserveSow")
    @ResponseBody
    public String updateStudent(String AnimalNumber) {
        int s = selectObserveSowService.updateSelectObserveSow(AnimalNumber);
        return "/AnimalBreeding/ShowSelectObserveSow";
    }

    /**
     * 根据ID查找母猪档案信息
     */
    @RequestMapping( "/findSelectObserveSowById")
    public String findSelectObserveSowById(String AnimalNumber, HttpSession session) {
        SelectObserveSow selectObserveSow= selectObserveSowService.findSelectObserveSowById(AnimalNumber);
        session.setAttribute("selectObserveSow",selectObserveSow);
        return "/AnimalBreeding/RecordSelectObserveSow";
    }
}
