package org.lah.AnimalBreeding.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.domain.SelectResultBoar;
import org.lah.AnimalBreeding.service.SelectResultBoarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 处理种猪档案相关请求
 */
@Controller
public class SelectResultBoarController {
    /**
     * 自动注入SelectResultBoarService
     * */
    @Autowired
    private SelectResultBoarService SelectResultBoarService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(SelectResultBoarController.class);

    /**
     * 分页查询种猪档案信息
     */
    @RequestMapping(value = "/findSelectResultBoar")
    public String findSelectResultBoar(String AnimalNumber,Integer PigAge,String HealthCondition,String LifeCondition,String Fertility,
                                 String BreedingHistory,String IfBreedSelectObserved,String IfBreedSelect, Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<SelectResultBoar> pi = SelectResultBoarService.findPageInfo(AnimalNumber,PigAge,HealthCondition,LifeCondition,Fertility,BreedingHistory,IfBreedSelectObserved,IfBreedSelect,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(8);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        if (AnimalNumber!=null){
            model.addAttribute("AnimalNumber", AnimalNumber);
        }
        return "/AnimalBreeding/ShowSelectResultBoar";
    }

    /**
     * 修改种猪档案信息
     */
    @RequestMapping( "/updateSelectResultBoar")
    @ResponseBody
    public String updateStudent(String AnimalNumber) {
        int s = SelectResultBoarService.updateSelectResultBoar(AnimalNumber);
        return "/AnimalBreeding/ShowSelectResultBoar";
    }

    /**
     * 根据ID查找种猪档案信息
     */
    @RequestMapping( "/findSelectResultBoarById")
    public String findSelectResultBoarById(String AnimalNumber, HttpSession session) {
        SelectResultBoar SelectResultBoar= SelectResultBoarService.findSelectResultBoarById(AnimalNumber);
        session.setAttribute("SelectResultBoar",SelectResultBoar);
        return "/AnimalBreeding/RecordSelectResultBoar";
    }
}
