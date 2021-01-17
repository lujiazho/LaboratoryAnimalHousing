package org.lah.AnimalBreeding.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalBreeding.domain.MatingSow;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.service.MatingSowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 处理配种母猪行为记录表相关请求
 */
@Controller
public class MatingMatingController {
    /**
     * 自动注入MatingSowService
     * */
    @Autowired
    private MatingSowService matingsowService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(MatingMatingController.class);

    /**
     * 分页查询配种母猪行为记录表信息
     */
    @RequestMapping(value = "/findMatingSow")
    public String findMatingSow(Integer ActionID,String AnimalNumber,String BehaviorStartTime,String BehaviorEndTime,
                                 String BehaviorDescription,String TreatmentPlan,String TreatmentResult, Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<MatingSow> pi = matingsowService.findPageInfo(ActionID,AnimalNumber,BehaviorStartTime,BehaviorEndTime,
                BehaviorDescription,TreatmentPlan,TreatmentResult,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(8);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        if (AnimalNumber!=null){
            model.addAttribute("ActionID", ActionID);
        }
        return "/AnimalBreeding/ShowMatingSow";
    }

    /**
     * 删除配种母猪行为记录表信息
     */
    @RequestMapping( "/deleteMatingSow")
    @ResponseBody
    public String deleteStudent(Integer ActionID) {
        int s = matingsowService.deleteMatingSow(ActionID);
        return "/AnimalBreeding/ShowMatingSow";
    }

    /**
     * 添加配种母猪行为记录表信息
     */
    @RequestMapping(value = "/addMatingSow" ,method = RequestMethod.POST)
    public String addMatingSow(@ModelAttribute MatingSow matingsow) {
        logger.info("\n\nmmd"+matingsow+"\n\n");
        int s = matingsowService.addMatingSow(matingsow);
        return "redirect:/findMatingSow";
    }

    /**
     * 修改配种母猪行为记录表信息
     */
    @RequestMapping(value = "/updateMatingSow" ,method = RequestMethod.POST )
    public String updateMatingSow( MatingSow matingsow) {
        matingsowService.updateMatingSow(matingsow);
        int s = matingsowService.updateMatingSow(matingsow);
        return "redirect:/findMatingSow";
    }

    /**
     * 根据ID查找配种母猪行为记录表信息
     */
    @RequestMapping( "/findMatingSowById")
    public String findMatingSowById(Integer ActionID, HttpSession session) {
        MatingSow matingSow= matingsowService.findMatingSowById(ActionID);
        session.setAttribute("matingSow",matingSow);
        return "/AnimalBreeding/RecordMatingSow";
    }
}
