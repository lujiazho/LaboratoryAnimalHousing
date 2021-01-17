package org.lah.AnimalFeed.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalFeed.domain.PaddingClaim;
import org.lah.AnimalFeed.domain.PageInfo;
import org.lah.AnimalFeed.service.PaddingClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


/**
 * 处理设备相关请求
 */
@Controller
public class PaddingClaimController {
    /**
     * 自动注入PaddingClaimService
     * */
    @Autowired
    private PaddingClaimService paddingclaimService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(PaddingClaimController.class);


    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findPaddingClaim")
    public String findPaddingClaim(Integer PaddingGetNumber, Date GetDate,String PaddingType, String PersonnelNumber,
                                   Integer PaddingNumber, String AbnormalCondition, Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<PaddingClaim> pi = paddingclaimService.findPageInfo(PaddingGetNumber, PaddingType, PersonnelNumber,
                PaddingNumber, AbnormalCondition,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(3);
        //pi.setTotalCount(recordCount);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        //logger.info("\n\nmmd"+pi.pageIndex+"\n\n");

        if ((PaddingGetNumber!=null && PaddingGetNumber!=0)||
                PaddingType!=null && !PaddingType.equals("")||
                PersonnelNumber!=null && !PersonnelNumber.equals("")){
            model.addAttribute("PaddingGetNumber", PaddingGetNumber);
            model.addAttribute("PaddingType", PaddingType);
            model.addAttribute("PersonnelNumber", PersonnelNumber);
        }
        return "/AnimalFeed/ShowPaddingClaim";
    }
    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportpaddingclaimlist", method = RequestMethod.POST)
    @ResponseBody
    public List<PaddingClaim> exportPaddingClaim(){
        List<PaddingClaim> paddingclaimList = paddingclaimService.getAll();
        return paddingclaimList;
    }
    /**
     * 删除信息
     */
    @RequestMapping( "/deletePaddingClaim")
    @ResponseBody
    public String deletePaddingClaim(Integer PaddingGetNumber) {
        int s = paddingclaimService.deletePaddingClaim(PaddingGetNumber);
        return "/AnimalFeed/ShowPaddingClaim";
    }

    /**
     * 添加信息
     */

    @RequestMapping(value = "/addPaddingClaim" ,method = RequestMethod.POST)
    public String addPaddingClaim(@ModelAttribute PaddingClaim paddingclaim) {
        logger.info("\n\nmmd"+paddingclaim+"\n\n");
        logger.info("\n\n为什么不跳转"+"\n\n");
        int s = paddingclaimService.addPaddingClaim(paddingclaim);
        return "redirect:/findPaddingClaim";
    }

    /**
     * 修改信息
     */
    @RequestMapping(value = "/updatePaddingClaim" ,method = RequestMethod.POST )
    public String updatePaddingClaim( PaddingClaim paddingclaim) {
        paddingclaimService.updatePaddingClaim(paddingclaim);
        int s = paddingclaimService.updatePaddingClaim(paddingclaim);
        logger.info("\n\nmmd"+paddingclaim+"\n\n");
        logger.info("\n\n为什么不跳转"+"\n\n");
        return "redirect:/findPaddingClaim";
    }


    @RequestMapping( "/findPaddingClaimById")
    public String findPaddingClaimById(Integer PaddingGetNumber, HttpSession session) {

        PaddingClaim s= paddingclaimService.findPaddingClaimById(PaddingGetNumber);
        session.setAttribute("s",s);

        return "/AnimalFeed/RecordPaddingClaim";
    }



}
