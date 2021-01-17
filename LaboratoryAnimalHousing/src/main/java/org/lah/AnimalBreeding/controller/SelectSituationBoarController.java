package org.lah.AnimalBreeding.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalBreeding.domain.SelectSituationBoar;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.service.SelectSituationBoarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * 处理种猪档案相关请求
 */
@Controller
public class SelectSituationBoarController {
    /**
     * 自动注入SelectSituationBoarService
     * */
    @Autowired
    private SelectSituationBoarService selectSituationBoarService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(SelectSituationBoarController.class);

    /**
     * 分页查询种猪档案信息
     */
    @RequestMapping(value = "/findSelectSituationBoar")
    public String findSelectSituationBoar(String AnimalNumber,Integer PigAge,String HealthCondition,String LifeCondition,String Fertility,
                                 String BreedingHistory,String IfBreedSelectObserved,String IfBreedSelect, Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<SelectSituationBoar> pi = selectSituationBoarService.findPageInfo(AnimalNumber,PigAge,HealthCondition,LifeCondition,Fertility,
                BreedingHistory,IfBreedSelectObserved,IfBreedSelect,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(8);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        if (AnimalNumber!=null){
            model.addAttribute("AnimalNumber", AnimalNumber);
        }
        return "/AnimalBreeding/ShowSelectSituationBoar";
    }

    /**
     * 修改种猪档案信息
     */
    @RequestMapping(value = "/updateSelectSituationBoar" ,method = RequestMethod.POST )
    public String updateSelectSituationBoar( SelectSituationBoar selectSituationBoar) {
        selectSituationBoarService.updateSelectSituationBoar(selectSituationBoar);
        int s = selectSituationBoarService.updateSelectSituationBoar(selectSituationBoar);
        return "redirect:/findSelectSituationBoar";
    }

    /**
     * 根据ID查找种猪档案信息
     */
    @RequestMapping( "/findSelectSituationBoarById")
    public String findSelectSituationBoarById(String AnimalNumber, HttpSession session) {
        SelectSituationBoar selectSituationBoar= selectSituationBoarService.findSelectSituationBoarById(AnimalNumber);
        session.setAttribute("selectSituationBoar",selectSituationBoar);
        return "/AnimalBreeding/RecordSelectSituationBoar";
    }
}
