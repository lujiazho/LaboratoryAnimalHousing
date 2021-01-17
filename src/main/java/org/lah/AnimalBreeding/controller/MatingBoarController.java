package org.lah.AnimalBreeding.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalBreeding.domain.MatingBoar;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.service.MatingBoarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 处理配种种猪行为记录表相关请求
 */
@Controller
public class MatingBoarController {
    /**
     * 自动注入MatingBoarService
     * */
    @Autowired
    private MatingBoarService matingboarService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(MatingBoarController.class);

    /**
     * 分页查询配种种猪行为记录表信息
     */
    @RequestMapping(value = "/findMatingBoar")
    public String findMatingBoar(Integer ActionID,String AnimalNumber,String BehaviorStartTime,String BehaviorEndTime,
                                 String BehaviorDescription,String TreatmentPlan,String TreatmentResult, Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<MatingBoar> pi = matingboarService.findPageInfo(ActionID,AnimalNumber,BehaviorStartTime,BehaviorEndTime,
                BehaviorDescription,TreatmentPlan,TreatmentResult,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(8);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        if (AnimalNumber!=null){
            model.addAttribute("ActionID", ActionID);
        }
        return "/AnimalBreeding/ShowMatingBoar";
    }

    /**
     * 删除配种种猪行为记录表信息
     */
    @RequestMapping( "/deleteMatingBoar")
    @ResponseBody
    public String deleteStudent(Integer ActionID) {
        int s = matingboarService.deleteMatingBoar(ActionID);
        return "/AnimalBreeding/ShowMatingBoar";
    }

    /**
     * 添加配种种猪行为记录表信息
     */
    @RequestMapping(value = "/addMatingBoar" ,method = RequestMethod.POST)
    public String addMatingBoar(@ModelAttribute MatingBoar matingboar) {
        logger.info("\n\nmmd"+matingboar+"\n\n");
        int s = matingboarService.addMatingBoar(matingboar);
        return "redirect:/findMatingBoar";
    }

    /**
     * 修改配种种猪行为记录表信息
     */
    @RequestMapping(value = "/updateMatingBoar" ,method = RequestMethod.POST )
    public String updateMatingBoar( MatingBoar matingboar) {
        matingboarService.updateMatingBoar(matingboar);
        int s = matingboarService.updateMatingBoar(matingboar);
        return "redirect:/findMatingBoar";
    }

    /**
     * 根据ID查找配种种猪行为记录表信息
     */
    @RequestMapping( "/findMatingBoarById")
    public String findMatingBoarById(Integer ActionID, HttpSession session) {
        MatingBoar matingBoar= matingboarService.findMatingBoarById(ActionID);
        session.setAttribute("matingBoar",matingBoar);
        return "/AnimalBreeding/RecordMatingBoar";
    }
}
