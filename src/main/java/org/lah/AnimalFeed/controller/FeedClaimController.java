package org.lah.AnimalFeed.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lah.AnimalFeed.domain.FeedClaim;
import org.lah.AnimalFeed.domain.PageInfo;
import org.lah.AnimalFeed.service.FeedClaimService;
import org.lah.Commons.util.PageModel;
import org.lah.Logistics.controller.EquipController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * 处理设备相关请求
 */
@Controller
public class FeedClaimController {
    /**
     * 自动注入FeedClaimService
     * */
    @Autowired
    private FeedClaimService feedclaimService;
    // 静态的日志类LogFactory
    private static final Log logger = LogFactory
            .getLog(FeedClaimController.class);


    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findFeedClaim")
    public String findFeedClaim(Integer FeedReceiveNumber, String string_Date,Date GetDate,String FeedType, String PersonnelNumber,
                                Integer FeedNumber, String AbnormalCondition,Integer pageIndex, Integer pageSize, Model model,FeedClaim feedclaim) {
        // 条件查询功能实现——日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTime = null;
        try {
            // 日期格式转换
            if(string_Date != null && !string_Date.equals("")){
                dateTime = simpleDateFormat.parse(string_Date);
                feedclaim.setGetDate(dateTime);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        PageInfo<FeedClaim> pi = feedclaimService.findPageInfo(FeedReceiveNumber,feedclaim.getGetDate(),FeedType, PersonnelNumber,
                FeedNumber, AbnormalCondition,pageIndex,pageSize);
        pi.setPageIndex(pageIndex);
        pi.setPageSize(3);
        //pi.setTotalCount(recordCount);
        pi.setPageTotalCount(pi.getPageTotalCount());
        model.addAttribute("pi", pi);
        //logger.info("\n\nmmd"+pi.pageIndex+"\n\n");

        if ((FeedReceiveNumber!=null && FeedReceiveNumber!=0)||
                FeedType!=null && !FeedType.equals("")||
                PersonnelNumber!=null && !PersonnelNumber.equals("")){
            model.addAttribute("FeedReceiveNumber", FeedReceiveNumber);
            model.addAttribute("FeedType", FeedType);
            model.addAttribute("PersonnelNumber", PersonnelNumber);
            model.addAttribute("string_GetDate", string_Date);
        }
        return "/AnimalFeed/ShowFeedClaim";
    }
    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportfeedclaimlist", method = RequestMethod.POST)
    @ResponseBody
    public List<FeedClaim> exportFeedClaim(){
        List<FeedClaim> feedclaimList = feedclaimService.getAll();
        return feedclaimList;
    }
    /**
     * 删除信息
     */
    @RequestMapping( "/deleteFeedClaim")
    @ResponseBody
    public String deleteFeedClaim(Integer FeedReceiveNumber) {
        int s = feedclaimService.deleteFeedClaim(FeedReceiveNumber);
        return "/AnimalFeed/ShowFeedClaim";
    }

    /**
     * 添加信息
     */

    @RequestMapping(value = "/addFeedClaim" ,method = RequestMethod.POST)
    public String addFeedClaim(@ModelAttribute FeedClaim feedclaim) {
        logger.info("\n\nmmd"+feedclaim+"\n\n");
        logger.info("\n\n为什么不跳转"+"\n\n");
        int s = feedclaimService.addFeedClaim(feedclaim);
        return "redirect:/findFeedClaim";
    }

    /**
     * 修改信息
     */
    @RequestMapping(value = "/updateFeedClaim" ,method = RequestMethod.POST )
    public String updateFeedClaim( FeedClaim feedclaim) {
        feedclaimService.updateFeedClaim(feedclaim);
        int s = feedclaimService.updateFeedClaim(feedclaim);
        logger.info("\n\nmmd"+feedclaim+"\n\n");
        logger.info("\n\n为什么不跳转"+"\n\n");
        return "redirect:/findFeedClaim";
    }


    @RequestMapping( "/findFeedClaimById")
    public String findFeedClaimById(Integer FeedReceiveNumber, HttpSession session) {

        FeedClaim s= feedclaimService.findFeedClaimById(FeedReceiveNumber);
        session.setAttribute("s",s);

        return "/AnimalFeed/RecordFeedClaim";
    }



}
