package org.lah.AnimalBreeding.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalBreeding.domain.EstrusBoar;
import org.lah.AnimalBreeding.domain.PageInfo;
import org.lah.AnimalBreeding.service.EstrusBoarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;

/**
 * 处理发情种猪行为记录表相关请求
 */
@Controller
public class EstrusBoarController {
    /**
     * 自动注入EstrusBoarService
     * */
    @Autowired
    private EstrusBoarService estrusboarService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(EstrusBoarController.class);

    /**
     * 分页查询发情种猪行为记录表信息
     */
    @RequestMapping(value = "/findEstrusBoar")
    public String findEstrusBoar(Integer ActionID,String AnimalNumber,String BehaviorStartTime,String BehaviorEndTime,
                                 String BehaviorDescription,String TreatmentPlan,String TreatmentResult, Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<EstrusBoar> pi = estrusboarService.findPageInfo(ActionID,AnimalNumber,BehaviorStartTime,BehaviorEndTime,
                BehaviorDescription,TreatmentPlan,TreatmentResult,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(8);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        if (AnimalNumber!=null){
            model.addAttribute("ActionID", ActionID);
        }
        return "/AnimalBreeding/ShowEstrusBoar";
    }

    /**
     * 删除发情种猪行为记录表信息
     */
    @RequestMapping( "/deleteEstrusBoar")
    @ResponseBody
    public String deleteStudent(Integer ActionID) {
        int s = estrusboarService.deleteEstrusBoar(ActionID);
        return "/AnimalBreeding/ShowEstrusBoar";
    }

    /**
     * 添加发情种猪行为记录表信息
     */
    @RequestMapping(value = "/addEstrusBoar" ,method = RequestMethod.POST)
    public String addEstrusBoar(@ModelAttribute EstrusBoar estrusboar) {
        logger.info("\n\nmmd"+estrusboar+"\n\n");
        int s = estrusboarService.addEstrusBoar(estrusboar);
        return "redirect:/findEstrusBoar";
    }

    /**
     * 修改发情种猪行为记录表信息
     */
    @RequestMapping(value = "/updateEstrusBoar" ,method = RequestMethod.POST )
    public String updateEstrusBoar( EstrusBoar estrusboar) {
        estrusboarService.updateEstrusBoar(estrusboar);
        int s = estrusboarService.updateEstrusBoar(estrusboar);
        return "redirect:/findEstrusBoar";
    }

    /**
     * 根据ID查找发情种猪行为记录表信息
     */
    @RequestMapping( "/findEstrusBoarById")
    public String findEstrusBoarById(Integer ActionID, HttpSession session) {
        EstrusBoar estrusBoar= estrusboarService.findEstrusBoarById(ActionID);
        session.setAttribute("estrusBoar",estrusBoar);
        return "/AnimalBreeding/RecordEstrusBoar";
    }
}
