package org.lah.AnimalBreeding.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.domain.ExpectantSow;
import org.lah.AnimalBreeding.service.ExpectantSowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.List;
/**
 * 处理设备相关请求
 */
@Controller
public class ExpectantSowController {
    /**
     * 自动注入EEquipService
     * */
    @Autowired
    private ExpectantSowService eService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(ExpectantSowController.class);
    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/seeExpectantSow")
    public String findExpectantSow(Integer ActionID, String AnimalNumber, String BehaviorStartTime, String BehaviorEndTime,
                                   String BehaviorDescription, String TreatmentPlan,String TreatmentResult,Integer pageIndex, Integer pageSize, Model model)
    {
        PageInfo<ExpectantSow> pi = eService.findPageInfo(ActionID,AnimalNumber,BehaviorStartTime, BehaviorEndTime, BehaviorDescription, TreatmentPlan,TreatmentResult,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(10);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        if (ActionID!=null && ActionID!=0)
        {
            model.addAttribute("ActionID", ActionID);
        }
        return "/AnimalBreeding/ExpectantSowInfo";
    }
    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exporteslist", method = RequestMethod.POST)
    @ResponseBody
    public List<ExpectantSow> exporteequip(){
        List<ExpectantSow> eList = eService.getAll();
        return eList;
    }
    /**
     * 删除信息
     */
    @RequestMapping( "/deleteExpectantSow")
    @ResponseBody
    public String deleteExpectantSow(Integer ActionID) {
        int s = eService.deleteExpectantSow(ActionID);
        return "/AnimalBreeding/ExpectantSowInfo";
    }

    /**
     * 添加信息
     */

    @RequestMapping(value = "/addExpectantSow" ,method = RequestMethod.POST)
    public String addExpectantSow(@ModelAttribute ExpectantSow expectantsow) {
        logger.info("\n\nmmd"+expectantsow+"\n\n");
        int s = eService.addExpectantSow(expectantsow);
        return "redirect:/seeExpectantSow";
    }

    /**
     * 修改信息
     */
    @RequestMapping(value = "/updateExpectantSow" ,method = RequestMethod.POST )
    public String updateExpectantSow(ExpectantSow expectantsow)
    {
        eService.updateExpectantSow(expectantsow);
        int s = eService.updateExpectantSow(expectantsow);
        return "redirect:/seeExpectantSow";
    }


    @RequestMapping( "/findExpectantSowByAI")
    public String findExpectantSowByAI(Integer ActionId, HttpSession session) {


        ExpectantSow expectantSow=eService.findExpectantSowByAI(ActionId);
        session.setAttribute("expectantsow",expectantSow);

        return "/AnimalBreeding/EditExpectantSow";
    }



}
