package org.lah.AnimalBreeding.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.domain.SelectResultSow;
import org.lah.AnimalBreeding.service.SelectResultSowService;
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
public class SelectResultSowController {
    /**
     * 自动注入SelectResultSowService
     * */
    @Autowired
    private SelectResultSowService SelectResultSowService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(SelectResultSowController.class);

    /**
     * 分页查询母猪档案信息
     */
    @RequestMapping(value = "/findSelectResultSow")
    public String findSelectResultSow(String AnimalNumber,Integer PigAge,String HealthCondition,String LifeCondition,String Fertility,
                                 String BreedingHistory,String IfBreedSelectObserved,String IfBreedSelect, Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<SelectResultSow> pi = SelectResultSowService.findPageInfo(AnimalNumber,PigAge,HealthCondition,LifeCondition,Fertility,BreedingHistory,IfBreedSelectObserved,IfBreedSelect,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(8);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        if (AnimalNumber!=null){
            model.addAttribute("AnimalNumber", AnimalNumber);
        }
        return "/AnimalBreeding/ShowSelectResultSow";
    }

    /**
     * 修改母猪档案信息
     */
    @RequestMapping( "/updateSelectResultSow")
    @ResponseBody
    public String updateStudent(String AnimalNumber) {
        int s = SelectResultSowService.updateSelectResultSow(AnimalNumber);
        return "/AnimalBreeding/ShowSelectResultSow";
    }

    /**
     * 根据ID查找母猪档案信息
     */
    @RequestMapping( "/findSelectResultSowById")
    public String findSelectResultSowById(String AnimalNumber, HttpSession session) {
        SelectResultSow SelectResultSow= SelectResultSowService.findSelectResultSowById(AnimalNumber);
        session.setAttribute("SelectResultSow",SelectResultSow);
        return "/AnimalBreeding/RecordSelectResultSow";
    }
}
