package org.lah.AnimalFeed.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalFeed.domain.PaddingReplacement;
import org.lah.AnimalFeed.domain.PageInfo;
import org.lah.AnimalFeed.service.PaddingReplacementService;
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
public class PaddingReplacementController {
    /**
     * 自动注入PaddingReplacementService
     * */
    @Autowired
    private PaddingReplacementService paddingreplacementService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(PaddingReplacementController.class);


    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findPaddingReplacement")
    public String findPaddingReplacement(Integer PaddingReplacementNumber, Integer RoomNumber,String PersonnelNumber,
                                         Integer PaddingAmount, String AbnormalCondition, Integer pageIndex, Integer pageSize, Model model) {
        PageInfo<PaddingReplacement> pi = paddingreplacementService.findPageInfo(PaddingReplacementNumber, RoomNumber, PersonnelNumber,
                PaddingAmount, AbnormalCondition,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(3);
        //pi.setTotalCount(recordCount);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        //logger.info("\n\nmmd"+pi.pageIndex+"\n\n");

        if ((PaddingReplacementNumber!=null && PaddingReplacementNumber!=0)||
                RoomNumber!=null && RoomNumber!=0||
                PersonnelNumber!=null && !PersonnelNumber.equals("")){
            model.addAttribute("PaddingReplacementNumber", PaddingReplacementNumber);
            model.addAttribute("RoomNumber", RoomNumber);
            model.addAttribute("PersonnelNumber", PersonnelNumber);
        }
        return "/AnimalFeed/ShowPaddingReplacement";
    }
    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportpaddingreplacementlist", method = RequestMethod.POST)
    @ResponseBody
    public List<PaddingReplacement> exportPaddingReplacement(){
        List<PaddingReplacement> paddingreplacementList = paddingreplacementService.getAll();
        return paddingreplacementList;
    }
    /**
     * 删除信息
     */
    @RequestMapping( "/deletePaddingReplacement")
    @ResponseBody
    public String deletePaddingReplacement(Integer PaddingReplacementNumber) {
        int s = paddingreplacementService.deletePaddingReplacement(PaddingReplacementNumber);
        return "/AnimalFeed/ShowPaddingReplacement";
    }

    /**
     * 添加信息
     */

    @RequestMapping(value = "/addPaddingReplacement" ,method = RequestMethod.POST)
    public String addPaddingReplacement(@ModelAttribute PaddingReplacement paddingreplacement) {
        logger.info("\n\nmmd"+paddingreplacement+"\n\n");
        logger.info("\n\n为什么不跳转"+"\n\n");
        int s = paddingreplacementService.addPaddingReplacement(paddingreplacement);
        return "redirect:/findPaddingReplacement";
    }

    /**
     * 修改信息
     */
    @RequestMapping(value = "/updatePaddingReplacement" ,method = RequestMethod.POST )
    public String updatePaddingReplacement( PaddingReplacement paddingreplacement) {
        paddingreplacementService.updatePaddingReplacement(paddingreplacement);
        int s = paddingreplacementService.updatePaddingReplacement(paddingreplacement);
        logger.info("\n\nmmd"+paddingreplacement+"\n\n");
        logger.info("\n\n为什么不跳转"+"\n\n");
        return "redirect:/findPaddingReplacement";
    }


    @RequestMapping( "/findPaddingReplacementById")
    public String findPaddingReplacementById(Integer PaddingReplacementNumber, HttpSession session) {

        PaddingReplacement s= paddingreplacementService.findPaddingReplacementById(PaddingReplacementNumber);
        session.setAttribute("s",s);

        return "/AnimalFeed/RecordPaddingReplacement";
    }



}
