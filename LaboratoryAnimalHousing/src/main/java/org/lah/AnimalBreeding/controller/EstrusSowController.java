package org.lah.AnimalBreeding.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalBreeding.domain.EstrusSow;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.service.EstrusSowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 处理发情母猪行为记录表相关请求
 */
@Controller
public class EstrusSowController {
    /**
     * 自动注入EstrusSowService
     * */
    @Autowired
    private EstrusSowService estrusSowService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(EstrusSowController.class);

    /**
     * 分页查询发情母猪行为记录表信息
     */
    @RequestMapping(value = "/findEstrusSow")
    public String findEstrusSow(Integer ActionID,String AnimalNumber,String BehaviorStartTime,String BehaviorEndTime,
                                 String BehaviorDescription,String TreatmentPlan,String TreatmentResult, Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<EstrusSow> pi = estrusSowService.findPageInfo(ActionID,AnimalNumber,BehaviorStartTime,BehaviorEndTime,
                BehaviorDescription,TreatmentPlan,TreatmentResult,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(8);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        if (AnimalNumber!=null){
            model.addAttribute("ActionID", ActionID);
        }
        return "/AnimalBreeding/ShowEstrusSow";
    }

    /**
     * 删除发情母猪行为记录表信息
     */
    @RequestMapping( "/deleteEstrusSow")
    @ResponseBody
    public String deleteStudent(Integer ActionID) {
        int s = estrusSowService.deleteEstrusSow(ActionID);
        return "/AnimalBreeding/ShowEstrusSow";
    }

    /**
     * 添加发情母猪行为记录表信息
     */
    @RequestMapping(value = "/addEstrusSow" ,method = RequestMethod.POST)
    public String addEstrusSow(@ModelAttribute EstrusSow estrusSow) {
        logger.info("\n\nmmd"+estrusSow+"\n\n");
        int s = estrusSowService.addEstrusSow(estrusSow);
        return "redirect:/findEstrusSow";
    }

    /**
     * 修改发情母猪行为记录表信息
     */
    @RequestMapping(value = "/updateEstrusSow" ,method = RequestMethod.POST )
    public String updateEstrusSow( EstrusSow estrusSow) {
        estrusSowService.updateEstrusSow(estrusSow);
        int s = estrusSowService.updateEstrusSow(estrusSow);
        return "redirect:/findEstrusSow";
    }

    /**
     * 根据ID查找发情母猪行为记录表信息
     */
    @RequestMapping( "/findEstrusSowById")
    public String findEstrusSowById(Integer ActionID, HttpSession session) {
        EstrusSow estrusSow= estrusSowService.findEstrusSowById(ActionID);
        session.setAttribute("estrusSow",estrusSow);
        return "/AnimalBreeding/RecordEstrusSow";
    }
}
