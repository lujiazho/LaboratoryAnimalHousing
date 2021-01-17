package org.lah.AnimalBreeding.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalBreeding.domain.SelectObserveBoar;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.service.SelectObserveBoarService;
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
public class SelectObserveBoarController {
    /**
     * 自动注入SelectObserveBoarService
     * */
    @Autowired
    private SelectObserveBoarService selectObserveBoarService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(SelectObserveBoarController.class);

    /**
     * 分页查询种猪档案信息
     */
    @RequestMapping(value = "/findSelectObserveBoar")
    public String findSelectObserveBoar(String AnimalNumber,Integer PigAge,String HealthCondition,String LifeCondition,String Fertility,
                                 String BreedingHistory,String IfBreedSelectObserved,String IfBreedSelect, Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<SelectObserveBoar> pi = selectObserveBoarService.findPageInfo(AnimalNumber,PigAge,HealthCondition,LifeCondition,Fertility,BreedingHistory,IfBreedSelectObserved,IfBreedSelect,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(8);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        if (AnimalNumber!=null){
            model.addAttribute("AnimalNumber", AnimalNumber);
        }
        return "/AnimalBreeding/ShowSelectObserveBoar";
    }

    /**
     * 修改种猪档案信息
     */
    @RequestMapping( "/updateSelectObserveBoar")
    @ResponseBody
    public String updateStudent(String AnimalNumber) {
        int s = selectObserveBoarService.updateSelectObserveBoar(AnimalNumber);
        return "/AnimalBreeding/ShowSelectObserveBoar";
    }

    /**
     * 根据ID查找种猪档案信息
     */
    @RequestMapping( "/findSelectObserveBoarById")
    public String findSelectObserveBoarById(String AnimalNumber, HttpSession session) {
        SelectObserveBoar selectObserveBoar= selectObserveBoarService.findSelectObserveBoarById(AnimalNumber);
        session.setAttribute("selectObserveBoar",selectObserveBoar);
        return "/AnimalBreeding/RecordSelectObserveBoar";
    }
}
